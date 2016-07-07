package WebPageAnalyser;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Core.CoreMacro;
import Macro.WebURLINFO;
import Mysql.mysqlserver;
import Tool.MD5_pack;
import Webextra.WebCollector;

public class AnalyserHtml extends Thread{

	
	public void run()//分析线程，任务：分析URL加入列表
	{
		WebCollector webcollector = new WebCollector();
		URLextra urlextra = new URLextra();
		mysqlserver sqlserver = new mysqlserver();
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(CoreMacro.CotainURLused==true)
				continue;
			else 
				break;	
		}
			CoreMacro.TargetINFOused=true;
			CoreMacro.CotainURLused=true;
			for(int i=0;i<CoreMacro.TargetINFO.size();i++)
			{
				WebURLINFO tempwebinfo = CoreMacro.TargetINFO.get(i);
				if(CoreMacro.ContainURL.contains(tempwebinfo.URL))
				{
					continue;
				}
				else
				{
					String url_html = webcollector.getwebpage_default(tempwebinfo.URL);
					ArrayList<String> temp_URL = urlextra.return_url(url_html);
					SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					for(int urli=0;urli<temp_URL.size();urli++)
					{
						if(CoreMacro.ContainURL.contains(temp_URL))
						{
							continue;
						}
						else
						{
							
							try {
								WebURLINFO webtemp;
								webtemp = new WebURLINFO(temp_URL.get(urli), MD5_pack.MD5_security(temp_URL.get(urli)),"0", simpledateformat.format(new Date()).toString(),webcollector.getwebpage_default(tempwebinfo.URL));
								sqlserver.insertSpirdUrlInfo(webtemp.URL,"", webtemp.ContentMD5, webtemp.LastExtraDate, webtemp.LastExtraDate, webtemp.ExtraTimes, webtemp.getUpdateContent());
								CoreMacro.TargetINFO.add(webtemp);
							} catch (NoSuchAlgorithmException e) {
								
								System.out.println("[*]ERROR: AnalyserHtml ERROR!");
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
		
			
		
	}
	
	
}
