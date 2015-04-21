package org.duanc.weixin.service;

import org.duanc.weixin.model.baidu.translate.TranslateResult;
import org.duanc.weixin.util.EncodeUtil;
import org.duanc.weixin.util.HttpRequestUtil;

import com.google.gson.Gson;

/**
 * 百度翻译service
 */
public class BaiduTranslateService {
	// 组装查询地址
	private static String requestUrl = "http://openapi.baidu.com/public/2.0/bmt/translate?client_id=cFOIPgLbWNBG7qPWy9chKplk&q={keyWord}&from=auto&to=auto";
	
	/**
	 * 翻译（中->英 英->中 日->中 ）
	 * 
	 * @param source
	 * @return
	 */
	public static String translate(String source) {
		String dst = null;

		// 组装查询地址
		// 对参数q的值进行urlEncode utf-8编码
		requestUrl = requestUrl.replace("{keyWord}", EncodeUtil.encodeUTF8(source));

		// 查询并解析结果
		try {
			// 查询并获取返回结果
			String json = HttpRequestUtil.gethttpRequestStr(requestUrl);
			// 通过Gson工具将json转换成TranslateResult对象
			TranslateResult translateResult = new Gson().fromJson(json, TranslateResult.class);
			// 取出translateResult中的译文
			dst = translateResult.getTrans_result().get(0).getDst();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == dst)
			dst = "翻译系统异常，请稍候尝试！";
		return dst;
	}

	public static void main(String[] args) {
		// 翻译结果：The network really powerful
		System.out.println(translate("hello"));
	}
}