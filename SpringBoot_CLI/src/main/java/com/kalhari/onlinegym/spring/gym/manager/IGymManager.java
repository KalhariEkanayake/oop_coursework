package com.kalhari.onlinegym.spring.gym.manager;

import com.kalhari.onlinegym.spring.pojo.model.DefaultMember;

import java.io.IOException;

public interface IGymManager {
    public void addNewMember();
    public void deleteMember(String membershipNo) throws IOException;
    public void printSortMemberList(DefaultMember defaultMember);
    public void saveToFile() throws IOException;
}
