package com.anji.allways.ilp.repo.provider;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by heylear on 15/11/7.
 */
public class DefaultRepositoryFactory extends JpaRepositoryFactory {

    private final EntityManager entityManager;

    public DefaultRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
        Assert.notNull(entityManager);
        this.entityManager = entityManager;

    }

    @Override
    protected <T, ID extends Serializable> SimpleJpaRepository<T, ID> getTargetRepository(RepositoryMetadata metadata, EntityManager entityManager) {
        JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(metadata.getDomainType());
        return new GenericRepositoryImpl(entityInformation, entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {

        return GenericRepositoryImpl.class;
    }

}
