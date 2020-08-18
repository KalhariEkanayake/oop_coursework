package com.kalhari.onlinegym.spring.pojo.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kalhari.onlinegym.spring.date.CustomSerializer;
import com.kalhari.onlinegym.spring.date.Date;

public class DefaultMember {
    private String membershipNo;
    private String name;
    @JsonSerialize(using = CustomSerializer.class)
    private Date startMembershipDate;
    private String gender;
    private String mobileNo;

    public DefaultMember(){}

    public DefaultMember(String membershipNo, String name, Date startMembershipDate, String gender, String mobileNo) {
        this.membershipNo = membershipNo;
        this.name = name;
        this.startMembershipDate = startMembershipDate;
        this.gender = gender;
        this.mobileNo = mobileNo;
    }

    public String getMembershipNo() {
        return membershipNo;
    }

    public void setMembershipNo(String membershipNo) {
        this.membershipNo = membershipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartMembershipDate() {
        return startMembershipDate;
    }

    public void setStartMembershipDate(Date startMembershipDate) {
        this.startMembershipDate = startMembershipDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void print() {
        System.out.println("Membership No:" + this.membershipNo + ", " +
                "Name:" + this.name + ", " +
                "Membership Start Date:" + this.startMembershipDate + ", " +
                "Member Type:Default Member");
    }

    @Override
    public String toString() {
        return "DefaultMember{" +
                "membershipNo='" + membershipNo + '\'' +
                ", name='" + name + '\'' +
                ", startMembershipDate=" + startMembershipDate +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                '}';
    }
}
