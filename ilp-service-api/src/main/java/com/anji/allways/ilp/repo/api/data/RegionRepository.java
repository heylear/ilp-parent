package com.anji.allways.ilp.repo.api.data;

import com.anji.allways.ilp.common.entity.data.RegionEntity;
import com.anji.allways.ilp.repo.api.GenericRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

import static com.anji.allways.ilp.common.constant.Constants.ORG_HIBERNATE_CACHEABLE;
import static com.anji.allways.ilp.common.constant.Constants.TRUE;

/**
 * Created by heylear on 15/11/7.
 */
public interface RegionRepository extends GenericRepository<RegionEntity, Integer> {
}
