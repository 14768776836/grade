package com.grade.project.grade.service;

import com.grade.project.grade.model.PlayUser;

import java.util.List;

public interface UserService {
    List<PlayUser> selectUsers(String username);
}
