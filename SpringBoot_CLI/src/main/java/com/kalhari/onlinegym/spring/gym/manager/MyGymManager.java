package com.kalhari.onlinegym.spring.gym.manager;

import com.kalhari.onlinegym.spring.date.Date;
import com.kalhari.onlinegym.spring.pojo.model.DefaultMember;
import com.kalhari.onlinegym.spring.pojo.model.Over60Member;
import com.kalhari.onlinegym.spring.pojo.model.StudentMember;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MyGymManager implements IGymManager {
    public static Scanner scan = new Scanner(System.in);
    private static final int MAX_COUNT = 100;
    private static int memberCount = 0;

    public static HashMap<String, DefaultMember> memberList = new HashMap();

    @Override
    public void addNewMember() {
        if (memberCount <= MAX_COUNT) {
            int subOption = 0;
            System.out.println("\nPlease Select the relevant Member Type :");
            System.out.println("1) Default Member");
            System.out.println("2) Student Member");
            System.out.println("3) Over60 Member");
            System.out.print(">>>");

            try {
                subOption = scan.nextInt();
                switch (subOption) {
                    case 1:
                        System.out.println("You have selected the option to Add a New Default Member.");
                        createDefaultMember();
                        break;

                    case 2:
                        System.out.println("You have selected the option to Add a New Student Member.");
                        createStudentMember();
                        break;

                    case 3:
                        System.out.println("You have selected the option to Add a New Over60 Member.");
                        createOver60Member();
                        break;

                    default:
                        System.out.println("Please enter valid option number!!!");
                }
            } catch (Exception e) {
//                System.out.println(e);
//                e.printStackTrace();
                System.out.println("Invalid Selection!!! Please Re enter...");
            }
            scan.nextLine();
        } else {
            System.out.println("You cannot add more members.\n Member List full with 100 members..!!!");
        }
    }

    private void createDefaultMember() throws IOException {
        System.out.println("Enter the Membership N0:");
        String membershipNo = getMemberShipNo();

        System.out.println("Enter the Name:");
        String name = getName();

        System.out.println("Enter the Start Membership Date: (dd-mm-yyyy ex: 23-07-2020)");
        com.kalhari.onlinegym.spring.date.Date startMembershipDate = getStartMembershipDate();

        System.out.println("Enter the Gender: (Type F or M)");
        String gender = getGender();

        System.out.println("Enter the Mobile N0: (10 digits number ex: 0252274689)");
        String mobileNo = getMobileNo();

        addDefaultMember(membershipNo, name, startMembershipDate, gender, mobileNo);
    }

    public void addDefaultMember(String membershipNo, String name, com.kalhari.onlinegym.spring.date.Date startMembershipDate, String gender, String mobileNo) {
        DefaultMember defaultMember = new DefaultMember(membershipNo, name, startMembershipDate, gender, mobileNo);
        insertMemberToMap(defaultMember);
        memberCount++;
        System.out.println("Available Member Space " + (MAX_COUNT - memberCount));
    }

    private void insertMemberToMap(DefaultMember defaultMember) {
        memberList.put(defaultMember.getMembershipNo(), defaultMember);
    }

    private void createStudentMember() throws IOException {
        System.out.println("Enter the Membership N0:");
        String membershipNo = getMemberShipNo();

        System.out.println("Enter the Name:");
        String name = getName();

        System.out.println("Enter the Start Membership Date: (dd-mm-yyyy ex: 23-07-2020)");
        com.kalhari.onlinegym.spring.date.Date startMembershipDate = getStartMembershipDate();

        System.out.println("Enter the Gender: (Type F or M)");
        String gender = getGender();

        System.out.println("Enter the Mobile N0: (10 digits number ex: 0252274689)");
        String mobileNo = getMobileNo();

        System.out.println("Enter the School Name:");
        String schoolName = getSchoolName();

        System.out.println("Enter the Grade: (Grade 8-13 student only)");
        int grade = getGrade();

        addStudentMember(membershipNo, name, startMembershipDate, gender, mobileNo, schoolName, grade);
    }

    public void addStudentMember(String membershipNo, String name, com.kalhari.onlinegym.spring.date.Date startMembershipDate, String gender, String mobileNo, String schoolName, int grade) {
        StudentMember studentMember = new StudentMember(membershipNo, name, startMembershipDate, gender, mobileNo, schoolName, grade);
        insertMemberToMap(studentMember);
        memberCount++;
        System.out.println("Available Member Space " + (MAX_COUNT - memberCount));
    }

    private void insertMemberToMap(StudentMember studentMember) {
        memberList.put(studentMember.getMembershipNo(), studentMember);
    }

    private void createOver60Member() throws IOException {
        System.out.println("Enter the Membership N0:");
        String membershipNo = getMemberShipNo();

        System.out.println("Enter the Name:");
        String name = getName();

        System.out.println("Enter the Start Membership Date: (dd-mm-yyyy ex: 23-07-2020)");
        com.kalhari.onlinegym.spring.date.Date startMembershipDate = getStartMembershipDate();

        System.out.println("Enter the Gender: (Type F or M)");
        String gender = getGender();

        System.out.println("Enter the Mobile N0: (10 digits number ex: 0252274689)");
        String mobileNo = getMobileNo();

        System.out.println("Enter the Age: (should be 60-80)");
        int age = getAge();

        System.out.println("Enter the NIC No: (ex: 111222333V)");
        String nicNo = getNicNo();

        addOver60Member(membershipNo, name, startMembershipDate, gender, mobileNo, age, nicNo);
    }

    public void addOver60Member(String membershipNo, String name, com.kalhari.onlinegym.spring.date.Date startMembershipDate, String gender, String mobileNo, int age, String nicNo) {
        Over60Member over60Member = new Over60Member(membershipNo, name, startMembershipDate, gender, mobileNo, age, nicNo);
        insertMemberToMap(over60Member);
        memberCount++;
        System.out.println("Available Member Space " + (MAX_COUNT - memberCount));
    }

    private void insertMemberToMap(Over60Member over60Member) {
        memberList.put(over60Member.getMembershipNo(), over60Member);
    }

    public String getMemberShipNo() {
        Scanner scan = new Scanner(System.in);
        String membershipNo;
            do {
                membershipNo = scan.nextLine();
                if (!membershipNo.matches("[0-9]+")){
                    System.out.println("Not a valid Membership Number! Please Re enter correctly..");
                } else if ((memberList.containsKey(membershipNo))) {
                    System.out.println("Already exits a Member! Re enter..");
                    membershipNo = scan.nextLine();
                }
            } while (!membershipNo.matches("[0-9]+"));
        return membershipNo;
    }

    private String getName() {
        Scanner scan = new Scanner(System.in);
        String name;
        do {
            name = scan.nextLine();
            if (!name.matches("[a-zA-Z ]+")) {
                System.out.println("Please enter correct name!!");
            }
        } while (!name.matches("[a-zA-Z ]+"));
        return name;
    }

    private com.kalhari.onlinegym.spring.date.Date getStartMembershipDate() {
        Scanner scan = new Scanner(System.in);
        com.kalhari.onlinegym.spring.date.Date startMembershipDate = null;
        StringTokenizer stringTokenizer;
        String date;

        do {
            date = scan.nextLine();
            stringTokenizer = new StringTokenizer(date, "-");
            if (stringTokenizer.countTokens() != 3) {
                System.out.println("Please enter correct date!!");
                continue;
            }
            int day = Integer.parseInt(stringTokenizer.nextToken());
            int month = Integer.parseInt(stringTokenizer.nextToken());
            int year = Integer.parseInt(stringTokenizer.nextToken());
            startMembershipDate = new Date(day, month, year);
            stringTokenizer = null;
         } while (stringTokenizer != null);
        return startMembershipDate;

    }

    private String getGender() {
        Scanner sc3 = new Scanner(System.in);
        String gender;
        do {
            gender = sc3.nextLine();
            if (!gender.matches("[f,F,m,M]+")) {
                System.out.println("Unknown !!! please enter properly...");
            }
        } while (!gender.matches("[f,F,m,M]+"));
        return gender;
    }

    private String getMobileNo() {
        Scanner sc = new Scanner(System.in);
        String mobileNo;
        mobileNo = "Enter the Mobile No:";
        do {
            mobileNo = sc.nextLine();
            if (!mobileNo.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$")) {
                System.out.println("Please enter correct phone number!!");
            }
        } while (!mobileNo.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$"));
        return mobileNo;
    }

    private String getSchoolName() {
        Scanner scan = new Scanner(System.in);
        String schoolName;
        do {
            schoolName = scan.nextLine();
            if (!schoolName.matches("[a-zA-Z ]+")) {
                System.out.println("Please enter the School Name correctly..");
            }
        } while (!schoolName.matches("[a-zA-Z ]+"));
        return schoolName;
    }

    private int getGrade() {
        Scanner scan = new Scanner(System.in);
        int grade = 0;
        do {
            while (!scan.hasNextInt()) {    //Prevent string input crashing the program.
                System.out.println("That's not a number!..Please Re enter..");
                scan.next();
            }
            grade = scan.nextInt();    //Set the number.
            if (grade < 8 || grade > 13)      //If the number is outside range print an error message.
                System.out.println("Not a valid School Grade! Please Re enter correctly..");
        } while (grade < 8 || grade > 13);
        return grade;
    }

    private int getAge() {
        Scanner scan = new Scanner(System.in);
        int age = 0;
        do {
            while (!scan.hasNextInt()) {     //Prevent string input crashing the program.
                System.out.println("That's not a number!..Please Re enter..");
                scan.next();
            }
            age = scan.nextInt();   //Set the number.
            if (age < 60 || age > 80)   //If the number is outside range print an error message.
                System.out.println("Not a valid Age! Please Re enter correctly..");
        } while (age < 60 || age > 80);
        return age;
    }

    private String getNicNo() {
        Scanner scan = new Scanner(System.in);
        String nicNo;
        do {
            nicNo = scan.nextLine();
            if (!nicNo.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{3}\\-?[V]$")) {
                System.out.println("Please enter the valid NIC No!!! (ex:111222333V)");
            }
        } while (!nicNo.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{3}\\-?[V]$"));
        return nicNo;
    }

    @Override
    public void deleteMember(String membershipNo) throws IOException {

        if (memberList.isEmpty()) {
            System.out.println("It's an Empty List... There is NO member details find to delete...!");
        } else {

            Scanner scan = new Scanner(System.in);
            System.out.println("Are you sure that you need to delete this member record?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            System.out.print(">>>");
            int answer = scan.nextInt();
            if (answer == 1) {

                DefaultMember member = memberList.get(membershipNo);
                if (member != null) {
                    String memberType;
                    if (member instanceof Over60Member) {
                        memberType = "Over60 member";
                    } else if (member instanceof StudentMember) {
                        memberType = "Student member";
                    } else {
                        memberType = "Default member";
                    }
                    memberList.remove(membershipNo);
                    memberCount--;
                    System.out.println("A Member has been removed of the type " + memberType + ". Available Member Space " + (MAX_COUNT - memberCount) + ".");
                    saveToFile();
                } else {
                    System.out.println("No member found with the Membership No " + membershipNo);
                }
            }
        }
    }

    @Override
    public void printSortMemberList(DefaultMember defaultMember) {
        if (defaultMember == null) {
            System.out.println("No member details to print...!");
        } else {
            defaultMember.print();
        }
    }

    @Override
    public void saveToFile() throws IOException {

        if (memberList.isEmpty()) {
            System.out.println("But it's an Empty List... Please Add member details before you saving to the file...!");
        } else {
            try {

            BufferedWriter bw = new BufferedWriter(new FileWriter("AllMemberDetails.txt"));

            for (DefaultMember defaultMember : memberList.values()) {
                if (defaultMember instanceof Over60Member) {
                    Over60Member over60Member = (Over60Member) defaultMember;
                    bw.write(over60Member.getMembershipNo() + "," + over60Member.getName() + "," + over60Member.getGender() + "," + over60Member.getMobileNo() + "," + over60Member.getAge() + "," + over60Member.getNicNo());
                    bw.flush();
                    bw.newLine();
                } else if (defaultMember instanceof StudentMember) {
                    StudentMember studentMember = (StudentMember) defaultMember;
                    bw.write(studentMember.getMembershipNo() + "," + studentMember.getName() + "," + studentMember.getGender() + "," + studentMember.getMobileNo() + "," + studentMember.getSchoolName() + "," + studentMember.getGrade());
                    bw.flush();
                    bw.newLine();
                } else {
                    bw.write(defaultMember.getMembershipNo() + "," + defaultMember.getName() + "," + defaultMember.getGender() + "," + defaultMember.getMobileNo());
                    bw.flush();
                    bw.newLine();
                }
            }

            bw.close();
            System.out.println("\t All information SAVED Successfully!!");

        } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static HashMap<String, DefaultMember> getMemberList() {
        return memberList;
    }
}