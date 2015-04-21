package org.duanc.weixin.model.baidu.weather;

import java.util.List;

/**
 * @ClassName: Weather 
 * @Description: 百度天气查询model
 * @see http://developer.baidu.com/map/index.php?title=car/api/weather
 * @author duanchao 
 */
public class Weather {
	private String currentCity;
	private Integer pm25;
	private List<WeatherIndex> index;
	private List<WeatherData> weather_data;
	public String getCurrentCity() {
		return currentCity;
	}
	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}
	public Integer getPm25() {
		return pm25;
	}
	public void setPm25(Integer pm25) {
		this.pm25 = pm25;
	}
	public List<WeatherIndex> getIndex() {
		return index;
	}
	public void setIndex(List<WeatherIndex> index) {
		this.index = index;
	}
	public List<WeatherData> getWeather_data() {
		return weather_data;
	}
	public void setWeather_data(List<WeatherData> weather_data) {
		this.weather_data = weather_data;
	}
}
