package org.duanc.weixin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;  

import javax.servlet.http.HttpServletRequest;  

import org.duanc.weixin.common.Help;
import org.duanc.weixin.common.Init;
import org.duanc.weixin.common.MessageUtil;
import org.duanc.weixin.model.resp.Article;
import org.duanc.weixin.model.resp.Music;
  
/** 
 * 核心服务类 
 */  
public class CoreService { 
	
	private static Map<String, String> map = new HashMap<>();
	
    /** 
     * 处理微信发来的请求 
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
        	String respContent = "请求处理异常，请稍候尝试！";
        	
            Map<String, String> requestMap = MessageUtil.parseXml(request);  // xml请求解析   
            String fromUserName = requestMap.get("FromUserName"); // 发送方帐号（open_id）    
            String toUserName = requestMap.get("ToUserName");  // 公众帐号
            String msgType = requestMap.get("MsgType");  // 消息类型  
            String content = requestMap.get("Content");  //文本内容
            
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  // 文本消息  
            	if("0".equals(content)){
            		respContent = MessageUtil.getMainMenu();
            	} else if("8".equals(content)) {
            		respContent = "[微笑]  /微笑    /::)";
            	} else if(MessageUtil.isQqFace(content)) {
            		respContent = "不要没事乱发表情" + MessageUtil.emoji(0x1F47F);
            	} else if (content.startsWith("翻译")) {  
                    String keyWord = content.replaceAll("^翻译", "").trim();  
                    if ("".equals(keyWord)) {  
                    	respContent = Help.getTranslateUsage();  
                    } else {  
                    	respContent = BaiduTranslateService.translate(keyWord);  
                    }  
                }  else if (content.endsWith("天气")) {  
                    String keyWord = content.replaceAll("天气", "").trim();  
                    if ("".equals(keyWord)) {  
                    	respContent = Help.getWeather();  
                    } else {
                    	List<Article> articleList =  BaiduWeatherService.searchWeather(keyWord);
                		return MessageUtil.newsMessageToXml(Init.initNewsMessage(fromUserName, toUserName, articleList));
                    }  
                }  else if (content.startsWith("电影") || content.endsWith("电影")) {  
                    String keyWord = content.replaceAll("电影", "").trim();  
                    if ("".equals(keyWord)) {  
                    	respContent = Help.getMovie();  
                    } else {
                    	List<Article> articleList = BaiduHotMovieService.searchHotMovie(keyWord);
                		return MessageUtil.newsMessageToXml(Init.initNewsMessage(fromUserName, toUserName, articleList));
                    }  
                }  else if (content.startsWith("歌曲")) {  
                    String keyWord = content.replaceAll("^歌曲[\\+ ~!@#%^-_=]?", "");  // 将歌曲2个字及歌曲后面的+、空格、-等特殊符号去掉 
                    if ("".equals(keyWord)) {  // 如果歌曲名称为空 
                        respContent = Help.getMusic();  
                    } else {  
                        String[] kwArr = keyWord.split("@");  
                        String musicTitle = kwArr[0];   // 歌曲名称  
                        String musicAuthor = "";   // 演唱者默认为空  
                        if (2 == kwArr.length)  
                            musicAuthor = kwArr[1];  
                        Music music = BaiduMusicService.searchMusic(musicTitle, musicAuthor);  // 搜索音乐
                        if (null == music) {  // 未搜索到音乐  
                            respContent = "对不起，没有找到你想听的歌曲<" + musicTitle + ">。";  
                        } else {  
                            respMessage = MessageUtil.musicMessageToXml(Init.initMusicMessage(fromUserName, toUserName, music));
                            return respMessage;
                        }  
                    }  
                }  else {
            		respContent = "提示:输入'0'获取系统菜单";
            	}
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {   // 图片消息  
                String picUrl = requestMap.get("PicUrl");  // 取得图片地址  
                respContent = FaceService.detect(picUrl); // 人脸检测   
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  // 地理位置消息 
                respContent = "您发送的是地理位置消息！";  
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {   // 链接消息 
                respContent = "您发送的是链接消息！";  
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  // 音频消息  
                respContent = "您发送的是音频消息！";  
            } else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  // 事件推送 
                String eventType = requestMap.get("Event");  // 事件类型
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {   // 订阅  
                    respContent = "谢谢您的关注！";  
                }
                if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {  //地理位置
                	String Latitude = requestMap.get("Latitude");
                	String Longitude = requestMap.get("Longitude");
                	String location = Longitude + "," + Latitude;
                	map.put("location", location);
                	return null;
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  // 取消订阅 
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  // 自定义菜单点击事件  
                    String eventKey = requestMap.get("EventKey");  // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
  
                    if (eventKey.equals("11")) {//天气预报 
                    	String location = map.get("location");
                    	location = location + "|";
                    	List<Article> articleList = BaiduWeatherService.searchWeather(location);
                		return MessageUtil.newsMessageToXml(Init.initNewsMessage(fromUserName, toUserName, articleList));
                    } else if (eventKey.equals("14")) {  //历史上的今天
                    	respContent = TodayInHistoryService.getTodayInHistoryInfo();
                    } else if (eventKey.equals("15")) {  //Q译通  
                    	respContent = Help.getTranslateUsage();
                    } else if (eventKey.equals("21")) {  //歌曲点播
                        respContent = Help.getMusic();
                    } else if (eventKey.equals("24")) { //人脸识别 
                        respContent = Help.getFace();  
                    } else if (eventKey.equals("31")) {  
                        respContent = "Q友圈菜单项被点击！";  
                    } else if (eventKey.equals("32")) {  //热门电影
                    	String location = map.get("location");
                    	List<Article> articleList = BaiduHotMovieService.searchHotMovie(location);
                    	return MessageUtil.newsMessageToXml(Init.initNewsMessage(fromUserName, toUserName, articleList));
                    } else if (eventKey.equals("33")) {  
                        respContent = "幽默笑话菜单项被点击！";  
                    }    
                }  
            }  
            respMessage = MessageUtil.textMessageToXml(Init.initTextMessage(fromUserName, toUserName, respContent));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return respMessage;  
    }  
}  