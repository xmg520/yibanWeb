package com.mxz.yiban.pojo;

public class Member {


    private Integer id;
    private String account;
    private String passwd;
    private String name;
    private String city;
    private Integer isupload;

    public Member(Integer id, String account, String passwd, String name, String city, Integer isupload) {
        this.id = id;
        this.account = account;
        this.passwd = passwd;
        this.name = name;
        this.city = city;
        this.isupload = isupload;
    }

    public Member() {
    }

    public Integer getIsupload() {
        return isupload;
    }

    public void setIsupload(Integer isupload) {
        this.isupload = isupload;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
