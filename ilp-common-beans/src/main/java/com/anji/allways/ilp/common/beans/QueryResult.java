package com.anji.allways.ilp.common.beans;

import java.util.List;

/**
 * Created by heylear on 15/11/7.
 */
public class QueryResult<T> {
    /**
     * 查询结果集
     */
    private List<T> resultList;

    /**
     * 总记录数
     */
    private Long totalRecord;


    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }
}
