package com.grade.project.grade.service.wx;

import com.grade.project.grade.mapper.GradeAccountMapper;
import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.GradeAccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MchServiceImpl implements MchService {
    @Autowired
    private GradeAccountMapper gradeAccountMapper;
    @Override
    public List<GradeAccount> getMchList(Integer userId) {
        GradeAccountExample gradeAccountExample = new GradeAccountExample();
        gradeAccountExample.createCriteria().andUserIdEqualTo(userId);
        return gradeAccountMapper.selectByExample(gradeAccountExample);
    }

    @Override
    public int saveMchMessage(GradeAccount gradeAccount) {
        gradeAccount.setGmtModified(new Date());
        return gradeAccountMapper.insertSelective(gradeAccount);
    }

    @Override
    public int delMch(Integer id) {
        return gradeAccountMapper.deleteByPrimaryKey(id);
    }
}
