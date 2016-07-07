package Core;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Macro.CtrlMacro;
import Mysql.mysqlserver;
import TargetGenerator.TargetStart;
import TargetGenerator.TargetThreadManager;
import TargetGenerator.ThreadManager;

public class Fun_TestCore {

	public void test() throws InterruptedException
	{
		
		TargetStart start = new TargetStart();
		try {
			start.SeedStart();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TargetThreadManager th = new TargetThreadManager();
		try {
			th.startAnalyserHtmltoURLExtra();
		} catch (InterruptedException e) {
			System.out.print("[!]Error:Thread AnalyserHtmltoURL is Error now!");
			if(CtrlMacro.debug_macro)
			e.printStackTrace();
		}
		
		
		
	}
}
