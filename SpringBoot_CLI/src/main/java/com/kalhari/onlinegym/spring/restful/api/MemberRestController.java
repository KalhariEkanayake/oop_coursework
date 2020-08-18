package com.kalhari.onlinegym.spring.restful.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kalhari.onlinegym.spring.pojo.model.DefaultMember;
import com.kalhari.onlinegym.spring.gym.manager.MyGymManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberRestController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/members")
    @ExceptionHandler
    public List<DefaultMember> getAllMembers() {
        return new ArrayList<>(MyGymManager.memberList.values());
    }
}
