package org.duanc.weixin.util;

import java.io.UnsupportedEncodingException;

public class EncodeUtil {
	/** 
     * UTF-8编码 
     *  
     * @param source 
     * @return 
     */  
    public static String encodeUTF8(String source) {  
        String result = source;  
        try {  
            result = java.net.URLEncoder.encode(source, "UTF-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
}
