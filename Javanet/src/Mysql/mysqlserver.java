package Mysql;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import Core.CoreMacro;
import Macro.CtrlMacro;
import Tool.Stringcheck;
import Tool.myGzip;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;



public class mysqlserver {

	public   String mysqlurl = "jdbc:mysql://127.0.0.1/spider";  
    public   String user = "root";  
    public   String password = "admin";
    
    public mysqlserver()
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("[!]INFO:Mysql JDBC ERROR");
		}
    }
    public mysqlserver(String mysqlurl)
    {
    	this.mysqlurl = mysqlurl;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("[!]INFO:Mysql JDBC ERROR");
		}
    }
    
    private Connection getspiderurlinfoconn()
    {
    	Connection conn;
		try {
			conn = (Connection)DriverManager.getConnection(this.mysqlurl,this.user,this.password);
			return conn;
		} catch (SQLException e) {
			System.out.print("[!]Erro:MYsql Connection Error!");
			if(CtrlMacro.debug_macro)
			e.printStackTrace();
		}
		
    	return null;
    }
    
    public int insertSpirdUrlInfo(String url,String purl,String MD5,String date,String lastdate,String updatetime,String content )
    {
    	content = Stringcheck.Contentcheckkong(content);
    	String sqllan = "insert into urlinformation(url,p_url,MD5,date,lastdate,updatetime,content) value('"+url+"','"+purl+"','"+MD5+"','"+date+"','"+lastdate+"','"+updatetime+"','"+content+"');";
    	Connection conn = this.getspiderurlinfoconn();
    	int rows=0;
    	Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
		 	 rows = stmt.executeUpdate(sqllan);
		 	if(CtrlMacro.debug_macro)
		 	if (rows > 0) {
		 		System.out.println("您增加了" + rows + "行数据");
		 	}
		 	conn.close();
		} catch (SQLException e) {
			System.out.println("[!]Error: SQL server insert teblespiderurlinformation Error!");
			if(CtrlMacro.debug_macro)
			e.printStackTrace();
		}
		
    	return rows;
    }
    
    public  void intsertseed(String url,String date,String md5,String content)
    {
    	content = Stringcheck.Contentcheckkong(content);

    	String sqllan = "insert into seedurl(url,date,md5,content) value('"+url+"','"+date+"','"+md5+"','"+content+"');";
    	Connection conn = this.getspiderurlinfoconn();
    	int rows=0;
    	Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
		 	 rows = stmt.executeUpdate(sqllan);
		 	if(CtrlMacro.debug_macro)
		 	if (rows > 0) {
		 		System.out.println("您增加了" + rows + "行数据");
		 	}
		 	conn.close();
		} catch (SQLException e) {
			System.out.println("[!]Error: SQL server insert intsertseed Error!");
			if(CtrlMacro.debug_macro)
			e.printStackTrace();
		}
    }
    
    public  void intsertlevelt(String url,String date,String md5,String content) throws InterruptedException
    {
    	content = Stringcheck.Contentcheckkong(content);

    	String sqllan = "insert into levelturl(url,date,md5,content) value('"+url+"','"+date+"','"+md5+"','"+content+"');";
    
    	Connection conn = this.getspiderurlinfoconn();
    	int rows=0;
    	Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
		 	 rows = stmt.executeUpdate(sqllan);
		 	if(CtrlMacro.debug_macro)
		 	if (rows > 0) {
		 		System.out.println("您增加了" + rows + "行数据");
		 	}
		 	conn.close();
		 	Thread.sleep(10000);
		} catch (SQLException e) {
			System.out.println("[!]Error: SQL server insert levelturl Error! SQL Synax is :"+sqllan);
			if(CtrlMacro.debug_macro)
			e.printStackTrace();
		}
    }
    
    
    
}
