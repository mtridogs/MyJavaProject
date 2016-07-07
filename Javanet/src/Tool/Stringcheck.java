package Tool;

public class Stringcheck {

	public static String Contentcheckkong(String html)
	{
		html= html.replaceAll("\n","");
    	html = html.replaceAll(" ", "");
    	html=html.replaceAll("'","");
    	html=html.replaceAll("\\\\","");
    	html=html.replaceAll("/","");
    	html=html.replaceAll("\"","");
    	html=html.replaceAll(";","");
    	html=html.replaceAll("\r", "");
    	html=html.replaceAll("[^\u4E00-\u9FA5]","");
		return html;
		
		
	}
}
