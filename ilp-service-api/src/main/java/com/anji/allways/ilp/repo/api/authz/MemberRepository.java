package com.anji.allways.ilp.repo.api.authz;

import com.anji.allways.ilp.common.entity.authz.MemberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by heylear on 15/11/7.
 */
@NoRepositoryBean
public interface MemberRepository extends CrudRepository<MemberEntity, Integer> {
    MemberEntity findMemberByMobileNum(String mobileNum);
}
