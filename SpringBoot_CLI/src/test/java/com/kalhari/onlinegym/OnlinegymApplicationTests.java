package com.kalhari.onlinegym;

import com.kalhari.onlinegym.spring.date.Date;
import com.kalhari.onlinegym.spring.gym.manager.MyGymManager;
import com.kalhari.onlinegym.spring.pojo.model.DefaultMember;
import com.kalhari.onlinegym.spring.pojo.model.Over60Member;
import com.kalhari.onlinegym.spring.pojo.model.StudentMember;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(classes = TestApplicationConfiguration.class)
class OnlinegymApplicationTests {

    @Autowired
    private MyGymManager myGymManager;

    public void cleanUp() {
        MyGymManager.getMemberList().clear();
    }

    @Test
    void contextLoads() {
    }

    @Test
    public void testAddDefaultMember() {
        MyGymManager.getMemberList().clear();
        String membershipNo = "1";
        String name = "Kalhari";
        Date startMembershipDate = new Date(27, 07, 2020);
        String gender = "f";
        String mobileNo = "0384576878";
        myGymManager.addDefaultMember(membershipNo, name, startMembershipDate , gender, mobileNo);
        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
        Assert.assertNotNull(memberList);
        Assert.assertEquals(1, memberList.size());
        DefaultMember defaultMember = memberList.get(membershipNo);
        Assert.assertEquals(membershipNo, defaultMember.getMembershipNo());
        Assert.assertEquals(name, defaultMember.getName());
        Assert.assertEquals(startMembershipDate, defaultMember.getStartMembershipDate());
        Assert.assertEquals(gender, defaultMember.getGender());
        Assert.assertEquals(mobileNo, defaultMember.getMobileNo());
    }

    @Test
    public void testAddStudentMember() {
        MyGymManager.getMemberList().clear();
        String membershipNo = "2";
        String name = "Chathumini";
        Date startMembershipDate = new Date(27, 07, 2020);
        String gender = "f";
        String mobileNo = "0384576569";
        String schoolName = "Taxila Central College";
        int grade = 12;
        myGymManager.addStudentMember(membershipNo, name, startMembershipDate , gender, mobileNo, schoolName, grade);
        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
        Assert.assertNotNull(memberList);
        Assert.assertEquals(1, memberList.size());
        StudentMember studentMember = (StudentMember) memberList.get(membershipNo);
        Assert.assertEquals(membershipNo, studentMember.getMembershipNo());
        Assert.assertEquals(name, studentMember.getName());
        Assert.assertEquals(startMembershipDate, studentMember.getStartMembershipDate());
        Assert.assertEquals(gender, studentMember.getGender());
        Assert.assertEquals(mobileNo, studentMember.getMobileNo());
        Assert.assertEquals(schoolName, studentMember.getSchoolName());
        Assert.assertEquals(grade, studentMember.getGrade());
    }

    @Test
    public void testAddOver60Member() {
        MyGymManager.getMemberList().clear();
        String membershipNo = "3";
        String name = "Vijitha";
        Date startMembershipDate = new Date(27, 07, 2020);
        String gender = "m";
        String mobileNo = "0284575569";
        int age = 62;
        String nicNo = "595711394V";
        myGymManager.addOver60Member(membershipNo, name, startMembershipDate , gender, mobileNo, age, nicNo);
        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
        Assert.assertNotNull(memberList);
        Assert.assertEquals(1, memberList.size());
        Over60Member over60Member = (Over60Member) memberList.get(membershipNo);
        Assert.assertEquals(membershipNo, over60Member.getMembershipNo());
        Assert.assertEquals(name, over60Member.getName());
        Assert.assertEquals(startMembershipDate, over60Member.getStartMembershipDate());
        Assert.assertEquals(gender, over60Member.getGender());
        Assert.assertEquals(mobileNo, over60Member.getMobileNo());
        Assert.assertEquals(age, over60Member.getAge());
        Assert.assertEquals(nicNo, over60Member.getNicNo());
    }

//    @Test
//    public void testDeleteMember() throws IOException {
//        String membershipNo = "1";
//        //myGymManager.deleteMember();
//        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
//        Assert.assertNotNull(memberList);
//        Assert.assertEquals(1, memberList.size());
//        DefaultMember defaultMember = (DefaultMember) memberList.get(membershipNo);
//        Assert.assertEquals(membershipNo, defaultMember.getMembershipNo());
//        Date startMembershipDate = new Date(27, 07, 2020);
//        myGymManager.addDefaultMember("1", "Kalhari", startMembershipDate , "f", "0384576878");
//        myGymManager.addStudentMember("2", "Chathumini", startMembershipDate , "f", "0384576569", "Taxila Central College", 12);
//        myGymManager.addOver60Member("3", "Vijitha", startMembershipDate , "m", "0284575569", 62, "595711394V");
//        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
//        Assert.assertNotNull(memberList);
//        Assert.assertEquals(3, memberList.size());
//        myGymManager.deleteMember("1");
//    }

    @Test
    public void testPrintSortMemberList() {
        Date startMembershipDate = new Date(27, 07, 2020);
        myGymManager.addDefaultMember("1", "Kalhari", startMembershipDate , "f", "0384576878");
        myGymManager.addStudentMember("2", "Chathumini", startMembershipDate , "f", "0384576569", "Taxila Central College", 12);
        myGymManager.addOver60Member("3", "Vijitha", startMembershipDate , "m", "0284575569", 62, "595711394V");
        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
        Assert.assertNotNull(memberList);
        Assert.assertEquals(3, memberList.size());
        myGymManager.printSortMemberList(memberList.get("1"));
        myGymManager.printSortMemberList(memberList.get("2"));
        myGymManager.printSortMemberList(memberList.get("3"));
    }

    @Test
    public void testSaveToFile() throws IOException {
        Date startMembershipDate = new Date(27, 07, 2020);
        myGymManager.addDefaultMember("1", "Kalhari", startMembershipDate , "f", "0384576878");
        myGymManager.addStudentMember("2", "Chathumini", startMembershipDate , "f", "0384576569", "Taxila Central College", 12);
        myGymManager.addOver60Member("3", "Vijitha", startMembershipDate , "m", "0284575569", 62, "595711394V");
        HashMap<String, DefaultMember> memberList = MyGymManager.getMemberList();
        Assert.assertNotNull(memberList);
        Assert.assertEquals(3, memberList.size());
        myGymManager.saveToFile();
    }

    @Test
    public void testGetMembershipNo() {
        String membershipNo = "1";
        DefaultMember defaultMember = new DefaultMember();
        defaultMember.setMembershipNo("1");
        Assert.assertEquals(membershipNo, defaultMember.getMembershipNo());

        StudentMember studentMember = new StudentMember();
        studentMember.setMembershipNo("1");
        Assert.assertEquals(membershipNo, studentMember.getMembershipNo());

        Over60Member over60Member = new Over60Member();
        over60Member.setMembershipNo("1");
        Assert.assertEquals(membershipNo, over60Member.getMembershipNo());
    }

    @Test
    public void testGetName() {
        String name = "Kalhari";
        DefaultMember defaultMember = new DefaultMember();
        defaultMember.setName("Kalhari");
        Assert.assertEquals(name, defaultMember.getName());

        StudentMember studentMember = new StudentMember();
        studentMember.setName("Kalhari");
        Assert.assertEquals(name, studentMember.getName());

        Over60Member over60Member = new Over60Member();
        over60Member.setName("Kalhari");
        Assert.assertEquals(name, over60Member.getName());
    }

//    @Test
//    public void testStartMembershipDate() {
//        Date startMembershipDate = new Date(27, 07, 2020);
//        DefaultMember defaultMember = new DefaultMember();
//        defaultMember.setStartMembershipDate(27, 07, 2020);
//        Assert.assertEquals(startMembershipDate, defaultMember.getStartMembershipDate());
//
//        StudentMember studentMember = new StudentMember();
//        studentMember.setStartMembershipDate(27, 07, 2020);
//        Assert.assertEquals(startMembershipDate, studentMember.getStartMembershipDate());
//
//        Over60Member over60Member = new Over60Member();
//        Assert.assertEquals(startMembershipDate, over60Member.getStartMembershipDate());
//    }

    @Test
    public void testGetGender() {
        String gender = "m";
        DefaultMember defaultMember = new DefaultMember();
        defaultMember.setGender("m");
        Assert.assertEquals(gender, defaultMember.getGender());

        StudentMember studentMember = new StudentMember();
        studentMember.setGender("m");
        Assert.assertEquals(gender, studentMember.getGender());

        Over60Member over60Member = new Over60Member();
        over60Member.setGender("m");
        Assert.assertEquals(gender, over60Member.getGender());
    }

    @Test
    public void testGetMobileNo() {
        String mobileNo = "0284575569";
        DefaultMember defaultMember = new DefaultMember();
        defaultMember.setMobileNo("0284575569");
        Assert.assertEquals(mobileNo, defaultMember.getMobileNo());

        StudentMember studentMember = new StudentMember();
        studentMember.setMobileNo("0284575569");
        Assert.assertEquals(mobileNo, studentMember.getMobileNo());

        Over60Member over60Member = new Over60Member();
        over60Member.setMobileNo("0284575569");
        Assert.assertEquals(mobileNo, over60Member.getMobileNo());
    }

    @Test
    public void testGetSchoolName() {
        String schoolName = "Taxila Central College";
        StudentMember studentMember = new StudentMember();
        studentMember.setSchoolName("Taxila Central College");
        Assert.assertEquals(schoolName, studentMember.getSchoolName());
    }

    @Test
    public void testGetGrade() {
        int grade = 12;
        StudentMember studentMember = new StudentMember();
        studentMember.setGrade(12);
        Assert.assertEquals(grade, studentMember.getGrade());
    }

    @Test
    public void testGetAge() {
        int age = 62;
        Over60Member over60Member = new Over60Member();
        over60Member.setAge(62);
        Assert.assertEquals(age, over60Member.getAge());
    }

    @Test
    public void testGetNicNo() {
        String nicNo = "595711394V";
        Over60Member over60Member = new Over60Member();
        over60Member.setNicNo("595711394V");
        Assert.assertEquals(nicNo, over60Member.getNicNo());
    }
}
