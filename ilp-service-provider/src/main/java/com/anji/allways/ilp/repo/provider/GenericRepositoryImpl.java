package com.anji.allways.ilp.repo.provider;

import com.anji.allways.ilp.common.beans.QueryResult;
import com.anji.allways.ilp.common.constant.Constants;
import com.anji.allways.ilp.repo.api.GenericRepository;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * {@link GenericRepository}接口实现类，并在{@link SimpleJpaRepository}基础上扩展。
 *
 * @param <T>  ORM对象
 * @param <ID> 主键ID
 * @author heylear
 */
@NoRepositoryBean
public class GenericRepositoryImpl<T, ID extends Serializable> extends
        SimpleJpaRepository<T, ID> implements GenericRepository<T, ID> {

    protected Logger logger = Logger.getLogger(GenericRepositoryImpl.class);

    private final EntityManager em;

    /**
     * 构造函数
     *
     * @param entityInformation
     * @param entityManager
     */
    public GenericRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.em = entityManager;
    }

    /**
     * 构造函数
     *
     * @param domainClass
     * @param em
     */
    public GenericRepositoryImpl(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getMetadata(domainClass, em), em);
    }

    @Override
    public List<T> findAll() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getDomainClass());

        Root<T> root = criteriaQuery.from(getDomainClass());


        try {
            criteriaQuery.where(criteriaBuilder.equal(root.get("deleteMark"), 0), criteriaBuilder.equal(root.get("pidMark"), 0));
        } catch (Exception e) {
            logger.warn(getEntityName(getDomainClass()) + " has no property deleteMark or pidMark!");
        }

        Query query = em.createQuery(criteriaQuery);

        query.setHint(Constants.ORG_HIBERNATE_CACHEABLE, isCacheable());

        return query.getResultList();
    }

    @Override
    public void setQueryParams(Query query, Object[] queryParams) {

        if (null != queryParams && queryParams.length != 0) {
            for (int i = 0; i < queryParams.length; i++) {
                query.setParameter(i + 1, queryParams[i]);
            }
        }
    }

    @Override
    public String buildOrderby(LinkedHashMap<String, String> orderby) {
        StringBuffer orderbyql = new StringBuffer("");
        if (orderby != null && orderby.size() > 0) {
            orderbyql.append(" order by ");
            for (String key : orderby.keySet()) {
                orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
            }
            orderbyql.deleteCharAt(orderbyql.length() - 1);
        }
        return orderbyql.toString();
    }

    @Override
    public String getEntityName(Class<T> entityClass) {
        String entityname = entityClass.getSimpleName();
        Entity entity = entityClass.getAnnotation(Entity.class);
        if (entity.name() != null && !"".equals(entity.name())) {
            entityname = entity.name();
        }
        return entityname;
    }

    @Override
    public QueryResult<T> getScrollDataByJpql(Class<T> entityClass, String whereJpql, Object[] queryParams,
                                              LinkedHashMap<String, String> orderby, Pageable pageable) {

        QueryResult<T> qr = new QueryResult<T>();
        String entityname = getEntityName(entityClass);
        String sql = "select o from " + entityname + " o ";
        String sqlWhere = whereJpql == null ? "" : "where " + whereJpql;
        Query query = em.createQuery(sql + sqlWhere + buildOrderby(orderby));

        setQueryParams(query, queryParams);
        if (pageable.getPageNumber() != -1 && pageable.getPageSize() != -1)
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        qr.setResultList(query.getResultList());

        query = em.createQuery("select count(" + getCountField(entityClass) + ") from " + entityname + " o " + sqlWhere);
        setQueryParams(query, queryParams);
        qr.setTotalRecord((Long) query.getSingleResult());

        return qr;
    }

    @Override
    public QueryResult<T> getScrollDataBySql(String sql, Object[] queryParams, Pageable pageable) {
        //查询记录数
        QueryResult<T> qr = new QueryResult<T>();
        Query query = em.createNativeQuery(sql);
        setQueryParams(query, queryParams);
        if (pageable.getPageNumber() != -1 && pageable.getPageSize() != -1)
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize()).setMaxResults(pageable.getPageSize());
        qr.setResultList(query.getResultList());

        //
        String from = getFromClause(sql);
        //查询总记录数
        query = em.createQuery("select count(1) " + from);
        setQueryParams(query, queryParams);
        qr.setTotalRecord((Long) query.getSingleResult());
        return qr;
    }

    private String getCountField(Class<T> clazz) {
        String out = "o";
        try {
            PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
            for (PropertyDescriptor propertydesc : propertyDescriptors) {
                Method method = propertydesc.getReadMethod();
                if (method != null && method.isAnnotationPresent(EmbeddedId.class)) {
                    PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
                    out = "o." + propertydesc.getName() + "." + (!ps[1].getName().equals("class") ? ps[1].getName() : ps[0].getName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    /**
     * 从sql中找出from子句
     *
     * @param sql
     * @return
     */
    private String getFromClause(String sql) {
        String sql2 = sql.toLowerCase();
        int index = sql2.indexOf(" from ");
        if (index < 0) {
            return null;
        } else {
            int i1 = sql2.lastIndexOf(" order by ");
            int i2 = sql2.lastIndexOf(" group by ");

            if (i1 >= 0 && i2 >= 0) {
                return sql.substring(index, i1 > i2 ? i2 : i1);
            } else if (i1 >= 0) {
                return sql.substring(index, i1);
            } else if (i2 >= 0) {
                return sql.substring(index, i2);
            } else {
                return sql.substring(index);
            }
        }
    }

    protected String buildJpsql() {
        return String.format("select t from %s t", this.getEntityName(this.getDomainClass()));
    }

    protected boolean isCacheable() {
        return this.getDomainClass().getAnnotation(Cacheable.class) != null;
    }
}

