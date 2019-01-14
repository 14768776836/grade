package com.grade.project.grade.mapper.vo;

import com.grade.project.grade.model.User;
import com.grade.project.grade.model.vo.GradeOrderVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 */
public interface OrderVoMapper {

    /**
     * 根据用户数据查询下级玩家列表
     * @param uParentList
     * @return
     */
    List<User> getChildrenList(List<User> uParentList);

    /**
     * 查询充值总金额
     * @param uList
     * @return
     */
    BigDecimal countChildrenPay(@Param("uList") List<User> uList, @Param("startTime")String startTime,@Param("endTime")String endTime);

    /**
     * 查询所有有效的总代理设置的商户数据
     * @return
     */
    List<GradeOrderVo> getIsTrueMchUser();

    /**
     * 查询总代理所有下属子级
     * @param parentCode
     * @return
     */
    List<User> getAllChildrenList(String parentCode);
}
