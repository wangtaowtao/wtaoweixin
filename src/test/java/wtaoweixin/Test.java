package wtaoweixin;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eyaoshun.util.HttpRequest;

public class Test {
	public static void main(String[] args) {
		String tqUrl = "http://restapi.amap.com/v3/weather/weatherInfo";
		String jsonStr = HttpRequest.sendGet(tqUrl,"city=哈尔滨&key=33366de6b9d7956aea9b080850069e50&extensions=all");
		System.out.println(jsonStr);
		JSONObject json = JSONObject.parseObject(jsonStr);
		System.out.println(json);
		String forecastsStr = json.getString("forecasts");
		System.out.println(forecastsStr);
		JSONArray jsonArray = json.getJSONArray("forecasts").getJSONObject(0).getJSONArray("casts");
		StringBuffer tq = new StringBuffer();
		for (int i = 0; i < 3; i++) {
			JSONObject cast = jsonArray.getJSONObject(i);
			if(i==0) {
				tq.append("今天:\n");
			}else if(i==1){
				tq.append("明天:\n");
			}else if(i==2) {
				tq.append("后天:\n");
			}
			tq.append("\t白天天气:"+cast.get("dayweather")+"\n");
			tq.append("\t白天温度:"+cast.get("daytemp")+"℃\n");
			tq.append("\t晚上温度:"+cast.get("nighttemp")+"℃\n");
			tq.append("\t白天风力:"+cast.get("daypower")+"级\n");
		}
		tq.toString();
		System.out.println(tq);
		
		
		
	}
}

