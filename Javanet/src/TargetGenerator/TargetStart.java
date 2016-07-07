package TargetGenerator;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import Core.CoreMacro;
import Macro.WebURLINFO;
import WebPageAnalyser.URLextra;
import Webextra.WebCollector;

public class TargetStart {

	public static ArrayList<String> SeedURL = new ArrayList<String>();
	
	public void SeedStart() throws InterruptedException, UnsupportedEncodingException
	{
		WebCollector webcollector = new WebCollector();
		while(true)
		{
			System.out.println("Enter Seed Url Key£º");
			Scanner enter = new Scanner(System.in);
			String url_user_key = enter.next();
			if(SeedURL.contains(url_user_key)&&url_user_key!="debug")
			{
				System.out.println("[!]WARNING: THIS SITE URL HAS CONTAIN!");
				continue;
			}
			else if(url_user_key=="debug")
			{
				for (String urlseed:this.SeedURL)
					System.out.println("[D]Seed Url: "+urlseed);
				for(WebURLINFO urltarget:CoreMacro.TargetINFO)
				{
					System.out.println("[D]Targe Info URL: "+urltarget.URL);
					System.out.println("[D]   Targe Info Date: "+urltarget.LastExtraDate);
				}
			}
			else
			{
			SeedURL.add(url_user_key);
			String htmlExtra = webcollector.getwebpage_default(url_user_key);
			TargetManager target = new TargetManager();
	    	target.WebPageURLExtra(htmlExtra);
	    	
	    	for(WebURLINFO urltarget:CoreMacro.TargetINFO)
				{
					System.out.println("[D]Targe Info URL: "+urltarget.URL+":");
					System.out.println("[D]   Targe Info Date: "+urltarget.LastExtraDate);
					System.out.println("[D]   Targe Info MD5: "+urltarget.ContentMD5);
				}
			}
		}
		
		
	}
	
	public void URLFormatJudge(String URL)
	{
		
		
	}
}
