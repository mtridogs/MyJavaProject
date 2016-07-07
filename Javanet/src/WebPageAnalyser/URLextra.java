package WebPageAnalyser;

import java.util.ArrayList;
import java.util.HashSet;

import Tool.regular;


public class URLextra {
	
	public ArrayList<String> return_url(String webpage)
	{
		regular m = new regular();
		String url_pantter = "(http|https)://www\\.\\w{0,}\\.(com|cn)";
		ArrayList<String> list = m.match(url_pantter,webpage);
		return list;
	}
	
}
