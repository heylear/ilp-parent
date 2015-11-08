package com.anji.allways.ilp.common.entity.data;

import com.anji.allways.ilp.common.entity.BaseEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by heylear on 15/11/5.
 */
@Entity
@Cacheable
@Table(name = "tm_region")
public class RegionEntity implements BaseEntity {
    /**
     * 区域代码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    String regionId;

    /**区域名称*/
    @Column(name = "region_name")
    String	regionName;

    /**父级区域代码*/
    @Column(name = "parent_id")
    String	parentId;

    /**状态 10011001 有效 10011002 无效*/
    @Column(name = "status")
    Integer	status;

    /**区域类型 国家	10441001 省市	10441002 地区	10441003 区县	10441004*/
    @Column(name = "region_type")
    Integer	regionType;

    /**拼音首字母*/
    @Column(name = "pinyin")
    String	pinyin;

    /**拼音全拼*/
    @Column(name = "quanpin")
    String	quanpin;

    /**备注*/
    @Column(name = "memo")
    String	memo;

    /**创建人id*/
    @Column(name = "create_user")
    Integer	createUser;

    /**创建时间*/
    @Column(name = "create_time")
    Date	createTime;

    /**更新人id*/
    @Column(name = "update_user")
    Integer	updateUser;

    /**更新时间*/
    @Column(name = "update_time")
    Date	updateTime;

    /**出发地省份状态:0启用/1禁用*/
    @Column(name = "region_status")
    Integer	regionStatus;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public Integer getDeleteMark() {
        return null;
    }

    @Override
    public void setDeleteMark(Integer deleteMark) {

    }

    @Override
    public Integer getPidMark() {
        return null;
    }

    @Override
    public void setPidMark(Integer pidMark) {

    }

    public Integer getRegionStatus() {
        return regionStatus;
    }

    public void setRegionStatus(Integer regionStatus) {
        this.regionStatus = regionStatus;
    }
}
