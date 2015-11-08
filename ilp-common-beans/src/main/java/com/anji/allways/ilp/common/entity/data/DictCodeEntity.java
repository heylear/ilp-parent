package com.anji.allways.ilp.common.entity.data;

import com.anji.allways.ilp.common.entity.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by heylear on 15/11/5.
 */
@Entity
@Cacheable
@Table(name = "tt_dict_code")
@IdClass(DictCodeEntity.DictKey.class)
public class DictCodeEntity implements BaseEntity {
    /**
     * 类型代码
     */
    @Id
    @Column(name = "dict_type")
    Integer dictType;

    /**
     * 字典代码
     */
    @Id
    @Column(name = "dict_code")
    Integer dictCode;

    /**
     * 地点名称
     */
    @Column(name = "dict_name")
    String dictName;

    /**
     * 字典描述
     */
    @Column(name = "dict_desc")
    String dictDesc;

    /**
     * 排序：数字越小越靠前
     */
    @Column(name = "order_id")
    Integer orderId;

    /**
     * 状态：0，无效；1，有效；
     */
    @Column(name = "status")
    Integer status;

    public Integer getDictType() {
        return dictType;
    }

    public void setDictType(Integer dictType) {
        this.dictType = dictType;
    }

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public Integer getCreateUser() {
        return null;
    }

    @Override
    public void setCreateUser(Integer createUser) {

    }

    @Override
    public Date getCreateTime() {
        return null;
    }

    @Override
    public void setCreateTime(Date createTime) {

    }

    @Override
    public Integer getUpdateUser() {
        return null;
    }

    @Override
    public void setUpdateUser(Integer updateUser) {

    }

    @Override
    public Date getUpdateTime() {
        return null;
    }

    @Override
    public void setUpdateTime(Date updateTime) {

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

    public static class DictKey implements Serializable {
        Integer dictType;

        Integer dictCode;
    }

}
