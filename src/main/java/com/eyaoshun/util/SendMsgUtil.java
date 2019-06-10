package com.eyaoshun.util;

import com.alibaba.fastjson.JSON;
import com.eyaoshun.shop.sms.request.SmsSendRequest;
import com.eyaoshun.shop.sms.response.SmsSendResponse;


public class SendMsgUtil {

	public static final String charset = "utf-8";
	// 用户平台API账号(非登录账号,示例:N1234567)
	public static String account = "N5124510";
	// 用户平台API密码(非登录密码)
	public static String pswd = "XQ3BdV6mkMb04a";
	
	public static void main(String[] args) {
		send("13426194436","2232");
	}
	
	public static void send(String mobile,String content) {
		//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		// 短信内容
		String msg = content;
		//手机号码
		String phone = mobile;
		//状态报告
		String report= "true";

		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);

		String requestJson = JSON.toJSONString(smsSingleRequest);

		System.out.println("before request string is: " + requestJson);

		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);

		System.out.println("response after request result is :" + response);

		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);

		System.out.println("response  toString is :" + smsSingleResponse);
	}
	
	/*public static void main(String[] args) throws UnsupportedEncodingException {

		//请求地址请登录253云通讯自助通平台查看或者询问您的商务负责人获取
		String smsSingleRequestServerUrl = "http://smssh1.253.com/msg/send/json";
		// 短信内容
	    String msg = "【e尧舜】你好,你的验证码是1222565";
		//手机号码
		String phone = "13426194436";
		//状态报告
		String report= "true";
		
		SmsSendRequest smsSingleRequest = new SmsSendRequest(account, pswd, msg, phone,report);
		
		String requestJson = JSON.toJSONString(smsSingleRequest);
		
		System.out.println("before request string is: " + requestJson);
		
		String response = ChuangLanSmsUtil.sendSmsByPost(smsSingleRequestServerUrl, requestJson);
		
		System.out.println("response after request result is :" + response);
		
		SmsSendResponse smsSingleResponse = JSON.parseObject(response, SmsSendResponse.class);
		
		System.out.println("response  toString is :" + smsSingleResponse);
		
	
	}*/


}

