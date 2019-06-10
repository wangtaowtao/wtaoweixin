package com.eyaoshun.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.eyaoshun.po.TextMessage;
import com.thoughtworks.xstream.XStream;

/*
 * 消息转换
 */
public class MessageUtil {

	/*
	 * 消息类型
	 */
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";

	/**
	 * xml转成map集合
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlTomap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();

		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);

		Element root = doc.getRootElement();

		List<Element> list = root.elements();

		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}


	/**
	 * 将文本消息对象转为xml
	 * @param textMessages
	 * @return
	 */
	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}


	/**
	 * 主菜单
	 * @return
	 */
	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("欢迎您的关注，已经对公众号进行整改！\n\n");
		sb.append("回复“『城市』天气”查看对应天气状况,如:\"北京天气\"\n");
		sb.append("回复2、关于公众号开发的介绍\n");
		sb.append("回复0、调出此菜单。");
		return sb.toString();
	}

	public static String firstText(){
		StringBuffer sb = new StringBuffer();
		sb.append("本公众号是我于2018年1月20日开发，用于了解微信公众号后端接入开发。很高兴你能关注，今后我慢慢的添加新东西，因为不是微信后台操作，所以会比较慢。");
		return sb.toString();
	}
	public static String secondText(){
		StringBuffer sb = new StringBuffer();
		sb.append("对于想有个自己的公众号的朋友们，其实申请很简单，百度微信公众平台根据步骤一步一步完成,即可这里不再赘述。我主要介绍下怎么接入开发：首先需要外网映射工具，我用的是natapp，然后开发ide用的是eclipse；云服务准备使用sae(SinaAppEngine,本来想用百度的bae,特么百度的刷脸认证太坑，我试了很多次都说不是本人。。。)，这样就不用我一直本地服务开启了。项目会打包发到GitHub上。其实你们也不会去了解的吧！不过在微信后台就可以做到很多信息发送了，拥有一个自己的公众号还是很好玩的哦！");
		return sb.toString();
	}
	public static String fantanText(){
		StringBuffer sb = new StringBuffer();
		sb.append("反弹！！！");
		return sb.toString();
	}public static String kuazanText(){
		StringBuffer sb = new StringBuffer();
		sb.append("谢谢！！！");
		return sb.toString();
	}

	//天气查询
	public static String TQText(String content){
		String tqUrl = "http://restapi.amap.com/v3/weather/weatherInfo";
		String jsonStr = HttpRequest.sendGet(tqUrl, "city="+content.substring(0, content.length()-2)+"&key=33366de6b9d7956aea9b080850069e50&extensions=all");
		JSONObject json = JSONObject.parseObject(jsonStr);
		try{
			JSONObject jsonOne = json.getJSONArray("forecasts").getJSONObject(0);
			String update = (String) jsonOne.get("reporttime");
			JSONArray jsonArray = jsonOne.getJSONArray("casts");
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
				tq.append("\t\t天气:"+cast.get("dayweather")+"\t\t\t\t风力:"+cast.get("daypower")+"级\n");
				tq.append("\t\t气温:"+cast.get("daytemp")+"℃ ~ "+cast.get("nighttemp")+"℃\n");
			}
			tq.append("更新时间:\n"+update);
			String tqStr = tq.toString();
			return tqStr;
		}catch (Exception e){
			return "您输入的地区名称有误，请核对格式再次发送，如：“丰台区天气”或“北京天气”";
		}
	}
}


