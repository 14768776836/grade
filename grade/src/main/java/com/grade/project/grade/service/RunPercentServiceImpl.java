package com.grade.project.grade.service;

import com.grade.project.grade.mapper.GradeRunPercentMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.GradeRunPercent;
import com.grade.project.grade.model.GradeRunPercentExample;
import com.grade.project.grade.model.User;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RunPercentServiceImpl implements RunPercentService {

    @Autowired
    private GradeRunPercentMapper gradeRunPercentMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public GradeRunPercent findDataByUserId(Integer userId) {
        GradeRunPercentExample gradeRunPercentExample = new GradeRunPercentExample();
        gradeRunPercentExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        List<GradeRunPercent> listRun = gradeRunPercentMapper.selectByExample(gradeRunPercentExample);
        if (listRun.size() > 0) {
            return listRun.get(0);
        }
        return null;
    }

    @Override
    public int addRunPercent(GradeRunPercent gradeRunPercent) {
        // 在添加的时候先判断该代理是否已经存在正常使用的分润数据，如果有就不能添加，此时应该是修改分润数据的而不是新增
        GradeRunPercentExample gradeRunPercentExample = new GradeRunPercentExample();
        gradeRunPercentExample.createCriteria().andUserIdEqualTo(gradeRunPercent.getUserId()).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        List<GradeRunPercent> listRun = gradeRunPercentMapper.selectByExample(gradeRunPercentExample);
        if (listRun.size() != 0) return 0;    //该代理创建了多条的分润数据

        // 获取代理的邀请码,可以新增和修改分润数据的都只可能是代理
        User grade = userMapper.selectByPrimaryKey(gradeRunPercent.getUserId());
        gradeRunPercent.setExtensionCode(grade.getExtensionCode());

        gradeRunPercent.setIsDel(StatusUtils.IS_DEL_0);
        return gradeRunPercentMapper.insertSelective(gradeRunPercent);
    }

    @Override
    public int updateRun(GradeRunPercent gradeRunPercent) {
        gradeRunPercent.setGmtModified(new Date());
        return gradeRunPercentMapper.updateByPrimaryKeySelective(gradeRunPercent);
    }

    @Override
    public int updIsDel(GradeRunPercent gradeRunPercent) {
        gradeRunPercent.setIsDel(StatusUtils.IS_DEL_1);
        gradeRunPercent.setGmtModified(new Date());
        return gradeRunPercentMapper.updateByPrimaryKeySelective(gradeRunPercent);
    }

    @Override
    public int addOrUpdateRunPercent(GradeRunPercent gradeRunPercent) {
        int result = 0;
        if (gradeRunPercent.getId() == null) {
            result = addRunPercent(gradeRunPercent);
        } else {
            result = updateRun(gradeRunPercent);
        }

        return result;
    }
}
