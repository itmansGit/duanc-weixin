package org.duanc.weixin.model.resp;

/**
 * @ClassName: TextMessage 
 * @Description: 消息信息 
 * @author duanchao 
 */
public class TextMessage extends BaseMessage {  
    // 回复的消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}  
