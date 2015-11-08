package com.anji.allways.ilp.common.beans.data;

/**
 * Created by heylear on 15/11/5.
 */
public class RegionInfo {

    /**区域名称*/
    String	regionName;

    /**父级区域代码*/
    String	parentId;

    /**区域类型 国家	10441001 省市	10441002 地区	10441003 区县	10441004*/
    Integer	regionType;

    /**拼音首字母*/
    String	pinyin;

    /**拼音全拼*/
    String	quanpin;

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getRegionType() {
        return regionType;
    }

    public void setRegionType(Integer regionType) {
        this.regionType = regionType;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getQuanpin() {
        return quanpin;
    }

    public void setQuanpin(String quanpin) {
        this.quanpin = quanpin;
    }
}
