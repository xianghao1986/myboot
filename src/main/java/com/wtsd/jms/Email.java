package com.wtsd.jms;

import java.io.Serializable;

/**
 * Created by xianghao on 2017/6/1.
 */
public class Email implements Serializable {
    private String address;

    private String content;

    public Email(String address, String content) {
        this.address = address;
        this.content = content;
    }

    public Email(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.wtsd.jms.Email{");
        sb.append("address='").append(address).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
