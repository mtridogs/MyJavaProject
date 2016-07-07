package Core;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Macro.WebURLINFO;

public class CoreMacro {
	public static ArrayList<WebURLINFO> TargetINFO = new ArrayList<WebURLINFO>();//所有的网站信息
	public static boolean TargetINFOused = false;//线程公用上变量的变量锁
	public static ArrayList<String> ContainURL = new ArrayList<String>();
	public static boolean CotainURLused = false;
	
	public static int ThreadMaxNum=10;//可允许的线程数量
}
