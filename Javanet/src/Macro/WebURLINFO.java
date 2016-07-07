package Macro;

public class WebURLINFO {
	public String getURL() {
		return URL;
	}


	public void setURL(String uRL) {
		URL = uRL;
	}


	public String getContentMD5() {
		return ContentMD5;
	}


	public void setContentMD5(String contentMD5) {
		ContentMD5 = contentMD5;
	}


	public String getExtraTimes() {
		return ExtraTimes;
	}


	public void setExtraTimes(String extraTimes) {
		ExtraTimes = extraTimes;
	}


	public String getLastExtraDate() {
		return LastExtraDate;
	}


	public void setLastExtraDate(String lastExtraDate) {
		LastExtraDate = lastExtraDate;
	}


	public String getUpdateContent() {
		return UpdateContent;
	}


	public void setUpdateContent(String updateContent) {
		UpdateContent = updateContent;
	}


	public int getThreadSync() {
		return ThreadSync;
	}


	public void setThreadSync(int threadSync) {
		ThreadSync = threadSync;
	}


	public int getWeatherExtra() {
		return WeatherExtra;
	}


	public void setWeatherExtra(int weatherExtra) {
		WeatherExtra = weatherExtra;
	}


	public int getMysql() {
		return mysql;
	}


	public void setMysql(int mysql) {
		this.mysql = mysql;
	}


	public  String URL;
	public String ContentMD5;
	public String ExtraTimes;//ci shu
	public String LastExtraDate;//
	public String UpdateContent;
	public int ThreadSync;
	public int WeatherExtra;
	public int mysql;
	public WebURLINFO(String URL,String ContentMD5,String ExtraTimes,String LastExtraDate,String UpdateContent) {
		this.ContentMD5=ContentMD5;
		this.URL=URL;
		this.ExtraTimes=ExtraTimes;
		this.LastExtraDate=LastExtraDate;
		this.UpdateContent=UpdateContent;
		this.ThreadSync=0;
		this.WeatherExtra=0;
		this.mysql=0;
	}
}
