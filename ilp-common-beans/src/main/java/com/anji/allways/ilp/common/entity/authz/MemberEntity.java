package com.anji.allways.ilp.common.entity.authz;

import com.anji.allways.ilp.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by heylear on 15/11/7.
 */
@Entity
@Table(name = "tt_member")
public class MemberEntity implements BaseEntity {
    /**
     * 注册客户信息表ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Integer memberId;

    /**
     * 手机号，同时作为登录用户名
     */
    @Column(name = "mobile_num")
    String mobileNum;

    /**
     * 用户登录名
     */
    @Column(name = "login_name")
    String loginName;

    /**
     * 密码
     */
    @Column(name = "passwd")
    String passwd;

    /**
     * 电子邮件
     */
    @Column(name = "email")
    String email;

    /**
     * 用户姓名
     */
    @Column(name = "user_name")
    String userName;

    /**
     * 证件类型
     */
    @Column(name = "id_type")
    Integer idType;

    /**
     * 证件号码
     */
    @Column(name = "id_num")
    String idNum;

    /**
     * 用户类型：1微信用户，2APP用户，3都是
     */
    @Column(name = "user_type")
    Integer userType;

    /**
     * APP注册日期
     */
    @Column(name = "register_date")
    Date registerDate;

    /**
     * 联系电话
     */
    @Column(name = "contact_pone")
    String contactPone;

    /**
     * 微信账号
     */
    @Column(name = "wechat_name")
    String wechatName;

    /**
     * 微信ID
     */
    @Column(name = "wechat_id")
    String wechatId;

    /**
     * 微信注册日期
     */
    @Column(name = "wechat_time")
    Date wechatTime;

    /**
     * 创建人id
     */
    @Column(name = "create_user")
    Integer createUser;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    Date createTime;

    /**
     * 更新人id
     */
    @Column(name = "update_user")
    Integer updateUser;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    Date updateTime;

    /**
     * 删除标记：0未删除，1已删除
     */
    @Column(name = "delete_mark")
    Integer deleteMark;

    /**
     * 归档标记：0未归档，1已归档
     */
    @Column(name = "pid_mark")
    Integer pidMark;

    /**
     * 企业ID：如果是商户用户则本字段不为0
     */
    @Column(name = "company_id")
    Integer companyId;

    /**
     * 注册来源--1:Android 2:IOS
     */
    @Column(name = "user_from")
    String userFrom;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getContactPone() {
        return contactPone;
    }

    public void setContactPone(String contactPone) {
        this.contactPone = contactPone;
    }

    public String getWechatName() {
        return wechatName;
    }

    public void setWechatName(String wechatName) {
        this.wechatName = wechatName;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public Date getWechatTime() {
        return wechatTime;
    }

    public void setWechatTime(Date wechatTime) {
        this.wechatTime = wechatTime;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }
}
