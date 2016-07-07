package TargetGenerator;

import WebPageAnalyser.AnalyserHtml;
import Core.CoreMacro;

public class TargetThreadManager {
	
	public void startAnalyserHtmltoURLExtra() throws InterruptedException
	{
		ThreadManager threadm = new ThreadManager();
		while(true)
		{
			if(threadm.getActivityThreadnum()<CoreMacro.ThreadMaxNum)
			{
				AnalyserHtml analyhtml = new AnalyserHtml();
				threadm.addAnalyserHtmlThread(analyhtml);
				Thread.sleep(1000);
			}
			else
			{
				Thread.sleep(1000);
				continue;
			}
		}
	}
	
	
}
