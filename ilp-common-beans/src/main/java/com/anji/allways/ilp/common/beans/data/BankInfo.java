package com.anji.allways.ilp.common.beans.data;

/**
 * Created by heylear on 15/11/6.
 */
public class BankInfo {

    String	bankCode;

    String	bankName;

    Integer	bankType;

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
}
