package com.grade.project.grade.service;

import java.util.Map;

/**
 * 消费记录service
 */
public interface ShopHistoryService {

    /**
     * 总代理获取本分支下的所有消费总和
     * @param userId
     * @return
     */
    Map<String , Object> sumLevelShop(Integer userId , String startTime, String endTime);
}
