package org.duanc.weixin.model.resp;


/**
 * @ClassName: MusicMessage 
 * @Description: 音乐信息 
 * @author duanchao 
 */
public class MusicMessage extends BaseMessage {  
    // 音乐  
    private Music Music;  
  
    public Music getMusic() {  
        return Music;  
    }  
  
    public void setMusic(Music music) {  
        Music = music;  
    }  
}  