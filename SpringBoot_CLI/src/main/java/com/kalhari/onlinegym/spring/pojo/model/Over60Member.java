package com.kalhari.onlinegym.spring.pojo.model;

import com.kalhari.onlinegym.spring.date.Date;

public class Over60Member extends DefaultMember {
    private int age;
    private String nicNo;

    public Over60Member(){}

    public Over60Member(String membershipNo, String name, Date startMembershipDate, String gender, String mobileNo, int age, String nicNo) {
        super(membershipNo, name, startMembershipDate, gender, mobileNo);
        this.age = age;
        this.nicNo = nicNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    @Override
    public String getMembershipNo() {
        return super.getMembershipNo();
    }

    @Override
    public void setMembershipNo(String membershipNo) {
        super.setMembershipNo(membershipNo);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public Date getStartMembershipDate() {
        return super.getStartMembershipDate();
    }

    @Override
    public void setStartMembershipDate(Date startMembershipDate) {
        super.setStartMembershipDate(startMembershipDate);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public String getMobileNo() {
        return super.getMobileNo();
    }

    @Override
    public void setMobileNo(String mobileNo) {
        super.setMobileNo(mobileNo);
    }

    @Override
    public void print() {
        System.out.println("Membership No:" + super.getMembershipNo() + ", " +
                "Name:" + super.getName() + ", " +
                "Membership Start Date:" + super.getStartMembershipDate() + ", " +
                "Member Type:Over60 Member");
    }

    @Override
    public String toString() {
        return  "Over60Member{" +
                "age=" + age +
                ", nicNo='" + nicNo + '\'' +
                '}';
    }
}
