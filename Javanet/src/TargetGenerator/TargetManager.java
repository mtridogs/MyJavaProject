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



public class TargetManager {//����������ֵ���ɶ�������url
	public void WebPageURLExtra(String WebPage) throws InterruptedException//��ȡ���µ�URL���ҷ���list��
, UnsupportedEncodingException
	{
		URLextra URLextra = new URLextra();
		ArrayList<String> URLFpage = URLextra.return_url(WebPage);
		Iterator<String> arraylistiter = URLFpage.iterator();
		mysqlserver sqlserver = new mysqlserver();
		WebCollector collector = new WebCollector();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
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
	
	public void ManagerCollector()//�����ռ���
	{
		WebCollector webcollector = new WebCollector();
		
		
	}
	
}
