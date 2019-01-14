package com.grade.project.grade.controller.wx;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
@RequestMapping(value = "/wx")
public class WXController {


    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam(value = "signature", required = true) String signature,
                      @RequestParam(value = "timestamp", required = true) String timestamp,
                      @RequestParam(value = "nonce", required = true) String nonce,
                      @RequestParam(value = "echostr", required = true) String echostr) {
        try {
            if (checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            } else {

            }
        } catch (Exception e) {

        }
    }

    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        // 将token、timestamp、nonce三个参数进行字典序排序
        String[] arr = new String[]{"10086", timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }
        MessageDigest md = null;
        String tmpStr = null;
        try {
            md = MessageDigest.getInstance("SHA-1");
            // 将三个参数字符串拼接成一个字符串进行 sha1 加密 byte[]
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        content = null;
        // 将 sha1 加密后的字符串可与 signature 对比，标识该请求来源于微信
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 将字节数组转换为十六进制字符串 * @param byteArray * @return
     */
    public static String byteToStr(byte[] byteArray) {
        String strDigest = "";
        for (int i = 0; i < byteArray.length; i++) {
            strDigest += byteToHexStr(byteArray[i]);
        }
        return strDigest;
    }

    /**
     * 将字节转换为十六进制字符串 * @param mByte * @return
     */
    private static String byteToHexStr(byte mByte) {
        char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }

    /**
     * @param params Map数组,里面需要 appid//appId mch_id//商户号 device_info//设备信息
     *               body//商品描述 nonce_str//随机字符串
     * @param key
     * @return String(签名)
     */
    public static String WeChatPay(Map<String, String> params, String key) {
        List<String> list = new ArrayList<String>(params.keySet());
        Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (String keyVal : list) {
            sb.append(keyVal + "=" + params.get(keyVal) + "&");
        }
        sb.append("key=" + key);
//		System.err.println(sb.toString());
        return DigestUtils.md5Hex(sb.toString()).toUpperCase();
    }

    /**
     * 获得随机字符串
     *
     * @return
     */
    public static String getNonceStr() {
        Random random = new Random();
        long val = random.nextLong();
        String res = DigestUtils.md5Hex(val + "yzx").toUpperCase();
        if (32 < res.length()) {
            return res.substring(0, 32);
        } else {
            return res;
        }
    }


}
