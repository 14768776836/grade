package com.grade.project.grade.service;

import com.grade.project.grade.mapper.GradeRunPercentMapper;
import com.grade.project.grade.model.GradeRunPercent;
import com.grade.project.grade.model.GradeRunPercentExample;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RunPercentServiceImpl implements RunPercentService {

    @Autowired
    private GradeRunPercentMapper gradeRunPercentMapper;

    @Override
    public GradeRunPercent findDataByUserId(Integer userId) {
        GradeRunPercentExample gradeRunPercentExample = new GradeRunPercentExample();
        gradeRunPercentExample.createCriteria().andUserIdEqualTo(userId).andIsDelEqualTo(StatusUtils.IS_DEL_0);
        List<GradeRunPercent> listRun = gradeRunPercentMapper.selectByExample(gradeRunPercentExample);
        if(listRun.size() > 0){
            return listRun.get(0);
        }
        return null;
    }

    @Override
    public int addRunPercent(GradeRunPercent gradeRunPercent) {
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
}
