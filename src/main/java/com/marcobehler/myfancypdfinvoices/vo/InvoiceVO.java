package com.marcobehler.myfancypdfinvoices.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoiceVO {

    @JsonProperty("user_id")
    private String userId;

    private Integer amount;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
