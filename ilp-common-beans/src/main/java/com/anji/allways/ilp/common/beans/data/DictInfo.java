package com.anji.allways.ilp.common.beans.data;

import java.io.Serializable;

/**
 * Created by heylear on 15/11/7.
 */
public class DictInfo implements Serializable {
    /**类型代码*/
    Integer	dictType;

    /**字典代码*/
    Integer	dictCode;

    /**地点名称*/
    String	dictName;

    /**字典描述*/
    String	dictDesc;

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
}
