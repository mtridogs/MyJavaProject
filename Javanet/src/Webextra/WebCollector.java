package Webextra;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import Macro.Macro_re;

public class WebCollector {
	
	
	public String re_encoding(String url,String webpage)
	{
		Pattern r = Pattern.compile(Macro_re.pattern_charac);
		Matcher m = r.matcher(webpage);
		String res = new String();
		String test = new String();
		while(m.find())
		{
	    res = m.group(3);
	    break;
		}
		if(res.equals("utf"))
			return "utf-8";
		else if(res.equals("gb2312"))
			return "gb2312";
		else 
			return "utf-8";
	}
	
	public String getwebpage_default(String url)
	{
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		HttpResponse res;
		try {
			res = httpclient.execute(httpget);
	        HttpEntity entity = res.getEntity();
	       // String strResult = EntityUtils.toString(entity); 
	       byte[] bytes = EntityUtils.toByteArray(entity); 
	       String ecoding = this.re_encoding(url,bytes.toString());
	       String strResult = new String(bytes, ecoding); 
	        return strResult;
		} catch (ClientProtocolException e) {
			return "0";
		} catch (IOException e) {
			e.toString();
			return "0";
		}
	}
}
