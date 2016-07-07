package TargetGenerator;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import Core.CoreMacro;
import Macro.CtrlMacro;
import Macro.WebURLINFO;
import Mysql.mysqlserver;
import Tool.MD5_pack;
import WebPageAnalyser.URLextra;
import Webextra.WebCollector;



public class TargetManager {//利用种子数值生成二级网络url
	public void WebPageURLExtra(String WebPage) throws InterruptedException//提取出新的URL并且放入list中
, UnsupportedEncodingException
	{
		URLextra URLextra = new URLextra();
		ArrayList<String> URLFpage = URLextra.return_url(WebPage);
		Iterator<String> arraylistiter = URLFpage.iterator();
		mysqlserver sqlserver = new mysqlserver();
		WebCollector collector = new WebCollector();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		while(arraylistiter.hasNext())
		{
			String URLweb = arraylistiter.next().toString();
			if(CoreMacro.ContainURL.contains(URLweb))
				continue;
			else
			{
				CoreMacro.ContainURL.add(arraylistiter.next().toString());
			    try {
					WebURLINFO webtemp = new WebURLINFO(URLweb, MD5_pack.MD5_security(URLweb),"0", simpledateformat.format(new Date()).toString(),collector.getwebpage_default(URLweb));
					sqlserver.intsertlevelt(webtemp.getURL(), webtemp.getLastExtraDate(),webtemp.getContentMD5(), webtemp.getUpdateContent());
					webtemp.mysql=1;
					CoreMacro.TargetINFO.add(webtemp);
				} catch (NoSuchAlgorithmException e) {
					if(CtrlMacro.debug_macro)
					e.printStackTrace();
					System.out.println("[!]ERROR TargetManager"+simpledateformat.format(new Date()).toString());
					continue;
				}
			}
			
		}
	}
	
	public void ManagerCollector()//管理收集器
	{
		WebCollector webcollector = new WebCollector();
		
		
	}
	
}
