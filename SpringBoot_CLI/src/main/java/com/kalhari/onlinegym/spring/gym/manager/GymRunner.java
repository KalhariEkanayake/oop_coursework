package com.kalhari.onlinegym.spring.gym.manager;

import com.kalhari.onlinegym.spring.gym.manager.MyGymManager;
import com.kalhari.onlinegym.spring.pojo.model.DefaultMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class GymRunner implements CommandLineRunner {

    @Autowired
    MyGymManager myGymManager;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n***** Welcome to the Online Gym Management System *****");
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n Please Select a Option Number...");
            System.out.println("1) Add a new Member");
            System.out.println("2) Delete a Member");
            System.out.println("3) Print and ordering List Member");
            System.out.println("4) Save Members Details in a File");
            System.out.println("5) Open GUI");
            System.out.println("6) Exit");
            System.out.print(">>>");

            try {
                option = sc.nextInt();
                switch (option) {
                case 1:
                    System.out.println("You have selected the option to Add New Members.");
                    myGymManager.addNewMember();
                    break;

                case 2:
                    System.out.println("You have selected the option to Delete Members.");
                    System.out.println("This action will delete all details of the member from the system.\n");
                    System.out.println("Enter the Membership N0:");
                    System.out.print(">>>");
                    String membershipNo = myGymManager.getMemberShipNo();
                    myGymManager.deleteMember(membershipNo);
                    break;

                case 3:
                    System.out.println("You have selected the option to Print and ordering List Member.\n");
                    List<DefaultMember> list = MyGymManager.getMemberList().values().stream()
                            .sorted(Comparator.comparing(DefaultMember::getName)).collect(Collectors.toList());
                    list.forEach(defaultMember -> myGymManager.printSortMemberList(defaultMember));
                    break;

                case 4:
                    System.out.println("You have selected the option to Save Member Details in a File.");
                    myGymManager.saveToFile();
                    break;

                case 5:
                    System.out.println("You have selected the option to Open GUI (Graphical User Interface).");
                    System.out.println("\n Click here => http://localhost:4200");
                    break;

                case 6:
                    System.out.println("Exited the Program. Thank You!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Selection!!! Please Re enter...");
                }
            } catch (Exception e) {
                System.out.println("Please enter valid option number!!!");
            }
            sc.nextLine();
        } while (option >= 1 || option <= 6);
    }
}
