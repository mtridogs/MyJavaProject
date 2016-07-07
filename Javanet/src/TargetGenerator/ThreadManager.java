package TargetGenerator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import WebPageAnalyser.AnalyserHtml;

import Core.CoreMacro;

public class ThreadManager {
	
	ExecutorService Threadpool = Executors.newFixedThreadPool(CoreMacro.ThreadMaxNum);
	
	public void addAnalyserHtmlThread(AnalyserHtml newthread)
	{
		this.Threadpool.execute(newthread);
	}
	
	public void shutdownAllThread()
	{
		this.Threadpool.shutdown();
	}
	
	public int getActivityThreadnum()
	{
		return ((ThreadPoolExecutor)this.Threadpool).getActiveCount();
	}
	
}
