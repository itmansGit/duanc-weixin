package org.duanc.weixin.model.baidu.weather;

import java.util.List;

/***
 * @ClassName: Weathers 
 * @Description: 快速解析model 
 * @author duanchao 
 */
public class Weathers {
	private Integer error;
	private String status;
	private String date;
	private List<Weather> results;
	
	public Integer getError() {
		return error;
	}

	public void setError(Integer error) {
		this.error = error;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<Weather> getResults() {
		return results;
	}

	public void setResults(List<Weather> results) {
		this.results = results;
	}
	
}
