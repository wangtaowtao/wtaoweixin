package com.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eyaoshun.util.HttpRequest;
import com.eyaoshun.util.SendMsgUtil;

import util.SendEmail;


public class Train {

	public static void main(String[] args) throws Exception {
		SendMsgUtil.send("13426194436", "1212121");
		/*int count = 0;
		loop:while(true) {
			String url = "https://kyfw.12306.cn/otn/leftTicket/query";
			String param = "leftTicketDTO.train_date=2018-04-29&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=UUH&purpose_codes=ADULT";
			String content = HttpRequest.sendGet(url,param);
			
			JSONObject json = JSONObject.parseObject(content);
			String string = json.getString("data");
			JSONObject parseObject = JSONObject.parseObject(string);
			JSONArray parseArray = JSONObject.parseArray(parseObject.getString("result"));
			for (int i = 0; i < parseArray.size(); i++) {
				String ss = parseArray.getString(i);
				String[] s = ss.split("\\|");
				if(!s[30].equals("无") && s[3].equals("G33")){
					String c = s[3] + "班次列车,现在二等座的情况是" + s[30];
					System.out.println("***************成功************** *");
					SendEmail.sendEmail("weiwuwave@126.com", c);
					SendMsgUtil.send("13718180381", c);
//					SendEmail.sendEmail("298018972@qq.com", c);
//					SendMsgUtil.send("13426194436", c);
					break  loop;
				} 
			}
			System.out.println(++count);
			Thread.sleep(20000);
			
		}*/
		
		
	}
}

