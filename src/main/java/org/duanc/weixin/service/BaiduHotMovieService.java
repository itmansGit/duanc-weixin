package org.duanc.weixin.service;

import java.util.ArrayList;
import java.util.List;

import org.duanc.weixin.model.baidu.hot_movie.HotMovieResult;
import org.duanc.weixin.model.baidu.hot_movie.Movie;
import org.duanc.weixin.model.resp.Article;
import org.duanc.weixin.util.HttpRequestUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class BaiduHotMovieService {
	/**
	 * @Description: 调用百度API查询周边热门电影 
	 * @param location
	 * @return List<Article>
	 */
	public static List<Article> searchHotMovie(String location) {
		//百度天气查询地址（返回json类型，包含ak）
		String requestUrl = "http://api.map.baidu.com/telematics/v3/movie?qt=hot_movie"
				+ "&location=LOCATION&ak=ANOx1z8ydoGdiaf6p3LeFtN5&output=json";
		List<Article> lists = new ArrayList<Article>();
		requestUrl = requestUrl.replace("LOCATION", location);
		String json = HttpRequestUtil.gethttpRequestStr(requestUrl);
		
		//解析json数据
		JSONObject jsonObject = JSON.parseObject(json);
		HotMovieResult hmr = jsonObject.getObject("result", HotMovieResult.class);
		
		List<Movie> movies = hmr.getMovie();
		for (int i = 0; i < 6; i++) {
			Movie movie = movies.get(i);
			Article article = new Article();
			article.setTitle(movie.getMovie_name() + "\n" + movie.getMovie_type() + " " + movie.getMovie_score() + "分 \n" + movie.getMovie_tags());
			article.setDescription("");
			article.setPicUrl(movie.getMovie_picture());
			lists.add(article);
		}
		
		return lists;
	}
	
	public static void main(String[] args) {
		searchHotMovie("121.367302,31.173441");
	}
}
