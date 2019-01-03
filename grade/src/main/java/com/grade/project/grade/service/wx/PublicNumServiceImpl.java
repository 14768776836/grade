package com.grade.project.grade.service.wx;

import com.grade.project.grade.mapper.vo.PublicNumVoMapper;
import com.grade.project.grade.model.vo.PublicNumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicNumServiceImpl implements PublicNumService {

    @Autowired
    private PublicNumVoMapper publicNumVoMapper;
    @Override
    public List<PublicNumVo> getPublicNumList(Integer userId) {
        return publicNumVoMapper.getPublicNumList(userId);
    }
}
