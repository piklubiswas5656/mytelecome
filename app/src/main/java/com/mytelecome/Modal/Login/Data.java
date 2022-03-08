package com.mytelecome.Modal.Login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("woner_phone")
    @Expose
    private String wonerPhone;
    @SerializedName("woner_email")
    @Expose
    private String wonerEmail;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("pass_change_key")
    @Expose
    private String passChangeKey;
    @SerializedName("expiry_date")
    @Expose
    private String expiryDate;
    @SerializedName("payable_amount")
    @Expose
    private String payableAmount;
    @SerializedName("date_time")
    @Expose
    private String dateTime;
    @SerializedName("to_expire")
    @Expose
    private ToExpire toExpire;
    @SerializedName("is_expired")
    @Expose
    private Boolean isExpired;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("shop_name")
    @Expose
    private String shopName;
    @SerializedName("shop_email")
    @Expose
    private String shopEmail;
    @SerializedName("shop_mobile")
    @Expose
    private String shopMobile;
    @SerializedName("shop_address")
    @Expose
    private String shopAddress;
    @SerializedName("logo")
    @Expose
    private String logo;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getWonerPhone() {
        return wonerPhone;
    }

    public void setWonerPhone(String wonerPhone) {
        this.wonerPhone = wonerPhone;
    }

    public String getWonerEmail() {
        return wonerEmail;
    }

    public void setWonerEmail(String wonerEmail) {
        this.wonerEmail = wonerEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassChangeKey() {
        return passChangeKey;
    }

    public void setPassChangeKey(String passChangeKey) {
        this.passChangeKey = passChangeKey;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public ToExpire getToExpire() {
        return toExpire;
    }

    public void setToExpire(ToExpire toExpire) {
        this.toExpire = toExpire;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopMobile() {
        return shopMobile;
    }

    public void setShopMobile(String shopMobile) {
        this.shopMobile = shopMobile;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}

