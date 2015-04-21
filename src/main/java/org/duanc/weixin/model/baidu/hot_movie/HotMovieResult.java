package org.duanc.weixin.model.baidu.hot_movie;

import java.util.List;

public class HotMovieResult {
	private String cityname;
	private List<Movie> movie;
	
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public List<Movie> getMovie() {
		return movie;
	}
	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}
	
}
