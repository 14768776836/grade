package com.grade.project.grade.service;

import com.grade.project.grade.mapper.PlayUserMapper;
import com.grade.project.grade.model.PlayUser;
import com.grade.project.grade.model.PlayUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PlayUserMapper playUserMapper;

    @Override
    public List<PlayUser> selectUsers(String userName) {
        PlayUserExample playUser = new PlayUserExample();
        playUser.createCriteria().andUsernameLike("%"+userName+"%");
        return playUserMapper.selectByExample(playUser);
    }
}
