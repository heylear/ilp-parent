package com.anji.allways.ilp.repo.api;

import com.anji.allways.ilp.common.beans.QueryResult;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.LinkedHashMap;

/**
 * Created by heylear on 15/11/7.
 */
@NoRepositoryBean
public interface GenericRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
    /**
     * 设置query的参数
     *
     * @param query       查询对象
     * @param queryParams 参数
     */

    void setQueryParams(Query query, Object[] queryParams);


    /**
     * 组装ORDER BY 语句
     *
     * @param orderby
     * @return
     */

    String buildOrderby(LinkedHashMap<String, String> orderby);


    /**
     * 获取实体名
     *
     * @param entityClass
     * @return
     */

    String getEntityName(Class<T> entityClass);


    /**
     * jpql语句查询
     *
     * @param entityClass
     * @param whereJpql
     * @param queryParams
     * @param orderby
     * @param pageable
     * @return
     */

    QueryResult<T> getScrollDataByJpql(Class<T> entityClass, String whereJpql, Object[] queryParams,

                                       LinkedHashMap<String, String> orderby, Pageable pageable);


    /**
     * sql语句查询
     *
     * @param sql
     * @param queryParams
     * @param pageable
     * @return
     */

    QueryResult<T> getScrollDataBySql(String sql, Object[] queryParams, Pageable pageable);
}
