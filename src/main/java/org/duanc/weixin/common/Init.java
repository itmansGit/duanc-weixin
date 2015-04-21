package org.duanc.weixin.common;

import java.util.Date;
import java.util.List;

import org.duanc.weixin.model.resp.Article;
import org.duanc.weixin.model.resp.Music;
import org.duanc.weixin.model.resp.MusicMessage;
import org.duanc.weixin.model.resp.NewsMessage;
import org.duanc.weixin.model.resp.TextMessage;

public class Init {
	
	private static String respContent = "请求处理异常，请稍候尝试！";  
	
	public static TextMessage initTextMessage(String fromUserName, String toUserName, String respStr) {
    	// 回复文本消息  
        TextMessage textMessage = new TextMessage();  
        textMessage.setToUserName(fromUserName);  
        textMessage.setFromUserName(toUserName);  
        textMessage.setCreateTime(new Date().getTime());  
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
        textMessage.setFuncFlag(0);  
    	if(null != respStr) {
    		textMessage.setContent(respStr); 
    	}else {
    		textMessage.setContent(respContent); 
    	}
    	return textMessage;
    }
    
	public static NewsMessage initNewsMessage(String fromUserName, String toUserName, List<Article> articleList) {
    	// 创建图文消息  
        NewsMessage newsMessage = new NewsMessage();  
        newsMessage.setToUserName(fromUserName);  
        newsMessage.setFromUserName(toUserName);  
        newsMessage.setCreateTime(new Date().getTime());  
        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);  
        newsMessage.setFuncFlag(0);  
        newsMessage.setArticles(articleList);
        newsMessage.setArticleCount(articleList.size());
        return newsMessage;
    }
    
	public static MusicMessage initMusicMessage(String fromUserName, String toUserName, Music music) {
    	// 音乐消息  
        MusicMessage musicMessage = new MusicMessage();  
        musicMessage.setToUserName(fromUserName);  
        musicMessage.setFromUserName(toUserName);  
        musicMessage.setCreateTime(new Date().getTime());  
        musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);  
        musicMessage.setMusic(music);  
        return musicMessage;
    }
}
