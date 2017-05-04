package com.hzmc.weixin.pay.payment.wrapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillRequestWrapper extends BaseSettings {

    @JsonProperty("bill_date")
    private String date;

    @JsonProperty("bill_type")
    private String type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
