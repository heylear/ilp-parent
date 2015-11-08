package com.anji.allways.ilp.service.api.data;

import com.anji.allways.ilp.common.beans.data.BankInfo;
import com.anji.allways.ilp.common.beans.data.DictInfo;
import com.anji.allways.ilp.common.beans.data.RegionInfo;

import java.util.List;

/**
 * 1. 此接口提供车好运平台基础数据服务
 * 2. 此接口并不提供对基础数据的修改
 * 3. 此接口的所有数据都来自缓存，如需刷新缓存，请先调用purge方法
 */
public interface BaseDataService {
    /**
     * 获取有效支付银行列表,分为储蓄卡和信用卡
     * @return
     */
    List<BankInfo> getPayBankList();

    /**
     * 获取所有地区列表
     * @return
     */
    List<RegionInfo> getRegionList();

    /**
     * 获取所有数据字典
     * @return
     */
    List<DictInfo> getDictCodeList();
}
