package com.grade.project.grade.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.mapper.GradeAccountMapper;
import com.grade.project.grade.model.GradeAccount;
import com.grade.project.grade.model.GradeAccountExample;
import com.grade.project.grade.service.wx.MchService;
import com.grade.project.grade.util.FileUtil;
import com.grade.project.grade.util.StatusUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.grade.project.grade.util.CommonUtils.result2Map;

@RestController
@RequestMapping(value = "/wxMch")
public class MchController {

    @Autowired
    private MchService mchService;
    @Autowired
    GradeAccountMapper gradeAccountMapper;

    /**
     * wxMch/getMchList
     * 查询设置过的商户列表
     *
     * @param userId 总代理用户id
     * @return
     */
    @RequestMapping(value = "/getMchList")
    @ResponseBody
    public Map<String, Object> getMchList(Integer userId) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            if (userId != null && userId > 0) {
                dataMap.put("mchList", mchService.getMchList(userId));
                dataMap.put("success", true);
            } else {
                dataMap.put("success", false);
                dataMap.put("msg", StatusUtils.DATA_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.DATA_ERROR_MSG_EXCEPTION);
        }
        return dataMap;
    }


    /**
     * wxMch/delMch
     * 删除商户/公众号等信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delMch")
    @ResponseBody
    public Map<String, Object> delMch(Integer id) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            int result = mchService.delMch(id);
            dataMap = result2Map(result, StatusUtils.DEL_ERROR_MSG_EXCEPTION);
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.DEL_ERROR_MSG_EXCEPTION);
        }
        return dataMap;
    }

    /**
     * wxMch/codeMchNum
     * 总代理校验商户是否设置成功
     *
     * @param request
     * @param gradeAccount 转账商户信息及公众号信息
     * @return
     */
    @RequestMapping(value = "/codeMchNum")
    @ResponseBody
    public Map<String, Object> codeMchNum(HttpServletRequest request, GradeAccount gradeAccount) {
        Map<String, Object> dataMap = new HashMap<>();
        try {
            BigDecimal amount = new BigDecimal("1.00");
            String desc = "商户可使用";
            dataMap = mchService.payMchToUser(request, gradeAccount, amount, desc,gradeAccount.getUserId());
            boolean success = (Boolean) dataMap.get("success");
            if (success) {
                // 这里是保证每个总代理只可以有一条正常使用的account数据（status = 1）
                GradeAccountExample example = new GradeAccountExample();
                // 获取该总代理之前设置的所有的商户信息
                example.createCriteria().andUserIdEqualTo(gradeAccount.getUserId()).andStatusEqualTo(1);
                List<GradeAccount> accounts = gradeAccountMapper.selectByExample(example);
                if(accounts != null && accounts.size() > 0){
                    GradeAccount account = accounts.get(0);
                    account.setStatus(0);
                    gradeAccountMapper.updateByPrimaryKeySelective(account);
                }
                gradeAccount.setStatus(1);
//                gradeAccountMapper.updateByPrimaryKeySelective(gradeAccount);

                int result = mchService.saveMchMessage(gradeAccount);
                dataMap = result2Map(result, StatusUtils.SETTING_ERROR_MSG_EXCEPTION);
            }
        } catch (Exception e) {
            e.printStackTrace();
            dataMap.put("success", false);
            dataMap.put("msg", StatusUtils.ERROR_MSG);
        }
        return dataMap;
    }

    //处理文件上传
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file, @RequestParam("appId") String appId) throws Exception {

        String fileName = appId + file.getOriginalFilename();  //文件名字（包含文件类型）

        Map<String, Object> dataMap = new HashMap<>();
        //文件存放路径
//        System.getProperty("user.dir") + "/src/main/resources/playback/1.txt";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/";
//        String path2 = System.getProperty("user.dir") + "/target/classes/";

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        FileUtil.uploadFile(file.getBytes(), filePath, fileName);
//        FileUtil.uploadFile(file.getBytes(), path2, fileName);
        dataMap.put("success", true);
        dataMap.put("path",  fileName);

        // 返回图片的存放路径
        return dataMap;
    }


}
