package com.grade.project.grade.service;

import com.grade.project.grade.mapper.ShopHistoryMapper;
import com.grade.project.grade.mapper.UserMapper;
import com.grade.project.grade.model.UserWithBLOBs;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShopHistoryServiceImpl implements ShopHistoryService {

    @Autowired
    ShopHistoryMapper shopHistoryMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String , Object> sumLevelShop(Integer userId , String startTime, String endTime) {
        Map<String,Object> dataMap = new HashMap<>();
        UserWithBLOBs generalAgent = userMapper.selectByPrimaryKey(userId);
        if(generalAgent.getParentCode() == null && generalAgent.getUserStatus() == 0){
            dataMap.put("sumLevelShop",shopHistoryMapper.sumLevelShop(generalAgent.getExtensionCode(),startTime,endTime));
            dataMap.put("success",true);
        }else {
            dataMap.put("success",false);
            dataMap.put("msg",StatusUtils.FIND_ERROR_MSG_EXCEPTION);
        }

        return dataMap;
    }
}
