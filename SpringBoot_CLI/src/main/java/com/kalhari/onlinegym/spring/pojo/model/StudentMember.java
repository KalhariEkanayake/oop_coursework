package com.kalhari.onlinegym.spring.pojo.model;

import com.kalhari.onlinegym.spring.date.Date;

public class StudentMember extends DefaultMember {
    private String schoolName;
    private int grade;

    public StudentMember(){}

    public StudentMember(String membershipNo, String name, Date startMembershipDate, String gender, String mobileNo, String schoolName, int grade) {
        super(membershipNo, name, startMembershipDate, gender, mobileNo);
        this.schoolName = schoolName;
        this.grade = grade;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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
                "Member Type:Student Member");
    }

    @Override
    public String toString() {
        return "StudentMember{" +
                "schoolName='" + schoolName + '\'' +
                ", grade=" + grade +
                '}';
    }
}
