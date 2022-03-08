package com.mytelecome.Modal.Login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ToExpire {

    @SerializedName("days")
    @Expose
    private Integer days;
    @SerializedName("months")
    @Expose
    private Integer months;
    @SerializedName("years")
    @Expose
    private Integer years;
    @SerializedName("hours")
    @Expose
    private Integer hours;
    @SerializedName("minute")
    @Expose
    private Integer minute;
    @SerializedName("second")
    @Expose
    private Integer second;
    @SerializedName("total_days")
    @Expose
    private Integer totalDays;

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(Integer totalDays) {
        this.totalDays = totalDays;
    }

}
