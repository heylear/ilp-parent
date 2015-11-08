package com.anji.allways.ilp.service.provider.data;

import com.anji.allways.ilp.common.beans.data.BankInfo;
import com.anji.allways.ilp.common.beans.data.DictInfo;
import com.anji.allways.ilp.common.beans.data.RegionInfo;
import com.anji.allways.ilp.common.utils.EntityUtil;
import com.anji.allways.ilp.repo.api.data.BankRepository;
import com.anji.allways.ilp.repo.api.data.DictCodeRepository;
import com.anji.allways.ilp.repo.api.data.RegionRepository;
import com.anji.allways.ilp.service.api.data.BaseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heylear on 15/11/7.
 */
@Service
public class BaseDataServiceImpl implements BaseDataService {

    @Autowired
    DictCodeRepository dictCodeRepository;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    RegionRepository regionRepository;

    /**
     * 获取有效支付银行列表,分为储蓄卡和信用卡
     *
     * @return
     */
    @Override
    public List<BankInfo> getPayBankList() {
        return EntityUtil.copy(bankRepository.findAll(), BankInfo.class);
    }

    /**
     * 获取所有地区列表
     *
     * @return
     */
    @Override
    public List<RegionInfo> getRegionList() {
        return EntityUtil.copy(regionRepository.findAll(), RegionInfo.class);
    }

    /**
     * 获取所有数据字典
     *
     * @return
     */
    @Override
    public List<DictInfo> getDictCodeList() {
        return EntityUtil.copy(dictCodeRepository.findAll(), DictInfo.class);
    }
}
