package org.duanc.weixin.common;


public class Help {

    /** 
     * Q译通使用指南 
     *  
     * @return 
     */  
    public static String getTranslateUsage() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append(MessageUtil.emoji(0xe148)).append("Q译通使用指南").append("\n\n");  
        buffer.append("Q译通为用户提供专业的多语言翻译服务，目前支持以下翻译方向：").append("\n");  
        buffer.append("    中 -> 英").append("\n");  
        buffer.append("    英 -> 中").append("\n");  
        buffer.append("    日 -> 中").append("\n\n");  
        buffer.append("使用示例：").append("\n");  
        buffer.append("    翻译我是中国人").append("\n");  
        buffer.append("    翻译dream").append("\n");  
        buffer.append("    翻译さようなら").append("\n\n");  
        buffer.append("回复“?”显示主菜单");  
        return buffer.toString();  
    }  
    
    /** 
     * 歌曲点播使用指南 
     *  
     * @return 
     */  
    public static String getMusic() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("歌曲点播操作指南").append("\n\n");  
        buffer.append("回复：歌曲+歌名").append("\n");  
        buffer.append("例如：歌曲存在").append("\n");  
        buffer.append("或者：歌曲存在@汪峰").append("\n\n");  
        buffer.append("回复“0”显示主菜单");  
        return buffer.toString();  
    }  
    
    /** 
     * 人脸检测帮助菜单 
     */  
    public static String getFace() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("人脸检测使用指南").append("\n\n");  
        buffer.append("发送一张清晰的照片，就能帮你分析出种族、年龄、性别等信息").append("\n");  
        buffer.append("快来试试你是不是长得太着急");  
        return buffer.toString();  
    }  
    
    public static String getWeather() {
    	StringBuffer buffer = new StringBuffer();  
        buffer.append("天气预报使用指南").append("\n\n");  
        buffer.append("回复：市名+天气").append("\n");  
        buffer.append("例如：北京市天气").append("\n");  
        return buffer.toString();  
    }
    
    public static String getMovie() {
    	StringBuffer buffer = new StringBuffer();  
        buffer.append("热门电影使用指南").append("\n\n");  
        buffer.append("回复：市名+电影").append("\n");  
        buffer.append("例如：北京市电影").append("\n");  
        return buffer.toString();  
    }
}
