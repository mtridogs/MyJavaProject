package Core;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Macro.WebURLINFO;

public class CoreMacro {
	public static ArrayList<WebURLINFO> TargetINFO = new ArrayList<WebURLINFO>();//���е���վ��Ϣ
	public static boolean TargetINFOused = false;//�̹߳����ϱ����ı�����
	public static ArrayList<String> ContainURL = new ArrayList<String>();
	public static boolean CotainURLused = false;
	
	public static int ThreadMaxNum=10;//��������߳�����
}
