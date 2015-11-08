package com.anji.allways.ilp.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by heylear on 15/11/7.
 */
public interface BaseEntity extends Serializable {

    Integer getCreateUser();

    void setCreateUser(Integer createUser);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    Integer getUpdateUser();

    void setUpdateUser(Integer updateUser);

    Date getUpdateTime();

    void setUpdateTime(Date updateTime);

    Integer getDeleteMark();

    void setDeleteMark(Integer deleteMark);

    Integer getPidMark();

    void setPidMark(Integer pidMark);

}
