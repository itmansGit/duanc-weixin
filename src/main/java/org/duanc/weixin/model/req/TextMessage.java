package org.duanc.weixin.model.req;

/**
 * @ClassName: TextMessage 
 * @Description: 文本消息 
 * @author duanchao 
 */
public class TextMessage extends BaseMessage {  
    // 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}  
