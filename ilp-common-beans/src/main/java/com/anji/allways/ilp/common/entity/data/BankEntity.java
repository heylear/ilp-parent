package com.anji.allways.ilp.common.entity.data;

import com.anji.allways.ilp.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by heylear on 15/11/5.
 */
@Entity
@Cacheable
@Table(name = "tm_bank")
public class BankEntity implements BaseEntity {
    /**支付支持的银行ID*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bank_id")
    Integer	bankId;

    /**银行英文缩写*/
    @Column(name = "bank_code")
    String	bankCode;

    /**银行名称*/
    @Column(name = "bank_name")
    String	bankName;

    /**类型：1借记卡/2贷记卡*/
    @Column(name = "bank_type")
    Integer	bankType;

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
    Date updateTime;

    /**删除标记：0未删除，1已删除*/
    @Column(name = "delete_mark")
    Integer	deleteMark;

    /**归档标记：0未归档，1已归档*/
    @Column(name = "pid_mark")
    Integer	pidMark;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Integer getBankType() {
        return bankType;
    }

    public void setBankType(Integer bankType) {
        this.bankType = bankType;
    }

    @Override
    public Integer getCreateUser() {
        return createUser;
    }

    @Override
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

    @Override
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
        return deleteMark;
    }

    @Override
    public void setDeleteMark(Integer deleteMark) {
        this.deleteMark = deleteMark;
    }

    @Override
    public Integer getPidMark() {
        return pidMark;
    }

    @Override
    public void setPidMark(Integer pidMark) {
        this.pidMark = pidMark;
    }
}
