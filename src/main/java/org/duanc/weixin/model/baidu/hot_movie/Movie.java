package org.duanc.weixin.model.baidu.hot_movie;

/**
 * @ClassName: Movie 
 * @Description: 热映影片 -- movie model
 * @see http://developer.baidu.com/map/index.php?title=car/api/movie 
 * @author duanchao 
 */
public class Movie {
	private String movie_id; //id
	private String movie_name;//名称
	private String movie_type;//类型 3D/2D
	private String movie_release_date;//上映日期
	private String movie_nation;//地区
	private String movie_starring;//演员表
	private String movie_length;//电影时长
	private String movie_picture;//图片地址
	private String movie_score;//评分
	private String movie_director;//导演
	private String movie_tags;//分类
	private String movie_message;//电影描述
	private Integer is_imax;//是否是IMAX
	private Integer is_new;//是否新上映
	private String movies_wd;// 标签 （例："冰雪奇缘热门电影"）
	public String getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public String getMovie_type() {
		return movie_type;
	}
	public void setMovie_type(String movie_type) {
		this.movie_type = movie_type;
	}
	public String getMovie_release_date() {
		return movie_release_date;
	}
	public void setMovie_release_date(String movie_release_date) {
		this.movie_release_date = movie_release_date;
	}
	public String getMovie_nation() {
		return movie_nation;
	}
	public void setMovie_nation(String movie_nation) {
		this.movie_nation = movie_nation;
	}
	public String getMovie_starring() {
		return movie_starring;
	}
	public void setMovie_starring(String movie_starring) {
		this.movie_starring = movie_starring;
	}
	public String getMovie_length() {
		return movie_length;
	}
	public void setMovie_length(String movie_length) {
		this.movie_length = movie_length;
	}
	public String getMovie_picture() {
		return movie_picture;
	}
	public void setMovie_picture(String movie_picture) {
		this.movie_picture = movie_picture;
	}
	public String getMovie_score() {
		return movie_score;
	}
	public void setMovie_score(String movie_score) {
		this.movie_score = movie_score;
	}
	public String getMovie_director() {
		return movie_director;
	}
	public void setMovie_director(String movie_director) {
		this.movie_director = movie_director;
	}
	public String getMovie_tags() {
		return movie_tags;
	}
	public void setMovie_tags(String movie_tags) {
		this.movie_tags = movie_tags;
	}
	public String getMovie_message() {
		return movie_message;
	}
	public void setMovie_message(String movie_message) {
		this.movie_message = movie_message;
	}
	public Integer getIs_imax() {
		return is_imax;
	}
	public void setIs_imax(Integer is_imax) {
		this.is_imax = is_imax;
	}
	public Integer getIs_new() {
		return is_new;
	}
	public void setIs_new(Integer is_new) {
		this.is_new = is_new;
	}
	public String getMovies_wd() {
		return movies_wd;
	}
	public void setMovies_wd(String movies_wd) {
		this.movies_wd = movies_wd;
	}
	
}
