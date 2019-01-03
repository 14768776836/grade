package com.grade.project.grade.util.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.grade.project.grade.util.HttpKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * 类描述：获取微信用户的基本信息 <br>
 * 作者：田帅 <br>
 * 创建时间：2017-09-16 <br>
 * 版本：V1.0
 */
public class WxUserInfo {

	private static final Logger logger = LoggerFactory.getLogger(WxUserInfo.class);

	/**
	 * 
	 * 方法描述: 获取微信用户的基本信息<br>
	 * 作者：田帅 <br>
	 * 创建时间：2017-09-16 <br>
	 * 版本：V1.0
	 */
	public static String getWxUserInfo(String AppId, String AppSecret, String code) {
		/** 请求结果 */
		String result = null;
		String url = WxConfigUtils.GET_WX_TOKEN.replace("APPID",AppId).replace("APPSECRET",AppSecret).replace("CODE",code);
		try {
			result = HttpKit.get(url);
			JSONObject jsonTexts = (JSONObject) JSON.parse(result);
			String openid = "";
			String accessToken = "";
			if (null != (jsonTexts.get("openid"))) {
				openid = jsonTexts.get("openid").toString();
				accessToken = jsonTexts.get("access_token").toString();
			}
			url = WxConfigUtils.GET_WX_USERINFO.replace("ACCESSTOKEN", accessToken).replace("OPENID",openid);
			result = HttpKit.get(url);
			logger.info("result=" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
