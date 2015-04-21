package org.duanc.weixin.service;

import java.util.ArrayList;
import java.util.List;

import org.duanc.weixin.model.baidu.weather.Weather;
import org.duanc.weixin.model.baidu.weather.WeatherData;
import org.duanc.weixin.model.resp.Article;
import org.duanc.weixin.util.HttpRequestUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class BaiduWeatherService {
	
	/**
	 * @Description: 查询天气 
	 * @param location 传入地理位置 x,y或者XX市
	 * @return NewsMessage
	 */
	public static List<Article> searchWeather(String location) {
		//百度天气查询地址（返回json类型，包含ak）
		String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?location=LOCATION"
				+ "&output=json&ak=ANOx1z8ydoGdiaf6p3LeFtN5";
		List<Article> lists = new ArrayList<Article>();
		requestUrl = requestUrl.replace("LOCATION", location);
		String json = HttpRequestUtil.gethttpRequestStr(requestUrl);
		
		//解析json数据
		JSONArray jsonArray = (JSON.parseObject(json)).getJSONArray("results");
		Weather weather = jsonArray.getObject(0, Weather.class);
		
		//设置空图片的图文  模拟为标题
		Article article1 = new Article();
		article1.setTitle(weather.getCurrentCity() + "  pm " + weather.getPm25());
		article1.setDescription("");
		article1.setPicUrl("");
		article1.setUrl("");
		lists.add(article1);
		
		//设置图文
		List<WeatherData> list = weather.getWeather_data();
		for (WeatherData weatherData : list) {
			Article article = new Article();
			article.setTitle(weatherData.getDate() + "\n" + weatherData.getWeather() + " "+ weatherData.getWind() + "\n" + weatherData.getTemperature());
			article.setDescription(weatherData.getDate());
			article.setPicUrl(weatherData.getDayPictureUrl());
			lists.add(article);
		}
		
		return lists;
	}
	
	
	public static void main(String[] args) {
		String keyWord = "北京天气".replaceAll("天气", "").trim(); 
		List<Article> list = BaiduWeatherService.searchWeather(keyWord);
		System.out.println(keyWord + list.get(0).getTitle());
	}
}
