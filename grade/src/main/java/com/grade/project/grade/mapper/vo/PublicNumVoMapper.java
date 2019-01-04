package com.grade.project.grade.mapper.vo;

import com.grade.project.grade.model.vo.PublicNumVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublicNumVoMapper {

    /**
     * 查询公众号列表
     * @param userId 用户id
     * @return
     */
    List<PublicNumVo> getPublicNumList(Integer userId);

    /**
     * 获取当前用户未认证的公众号列表
     * @param parentUserId
     * @param userId
     * @return
     */
    List<PublicNumVo> getNoBindPublicNumList(@Param("parentUserId") Integer parentUserId, @Param("userId") Integer userId);
}
