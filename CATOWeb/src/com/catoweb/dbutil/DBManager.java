package com.catoweb.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	Connection conn=null;
	private static DBManager dBManager ;
	private DBManager(){} 
	public static DBManager getInstance(){    
        if(dBManager==null)
            synchronized(DBManager.class){    
            	dBManager = new DBManager();    
            }    
        return dBManager;           
    }       
	
	public void getConn(){
		try{
			if(conn==null){
				Statement stmt=null;
				Context ctx = new InitialContext();
				DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CATODS");
				conn=ds.getConnection();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeConn(){
		try{
			if(conn!=null){
				//conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public ArrayList<String> getAltXList(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT altX FROM CATO.Altitude WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(String.valueOf(rst.getDouble("altX")));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getAltYList(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT altY FROM CATO.Altitude WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(String.valueOf(rst.getDouble("altY")));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getStation(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT * FROM CATO.Station ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(rst.getString("sName")+"\""+String.valueOf(rst.getDouble("sX"))+"\""+String.valueOf(rst.getInt("railNumber"))+"\""+String.valueOf(rst.getInt("trailNumber"))+"\""+rst.getString("stop")+"\""+String.valueOf(rst.getInt("arriveTime"))+"\""+String.valueOf(rst.getInt("outTime"))+"\""+rst.getString("oTrain")+"\""+rst.getString("h"));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getAdvSList(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT advS FROM CATO.AdviceSpeed WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(String.valueOf(rst.getDouble("advS")));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getLmtSList(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT lmtS FROM CATO.LimitSpeed WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(String.valueOf(rst.getDouble("lmtS")));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getActSList(){
		ArrayList<String> list=new ArrayList<String>();
		try{
			this.getConn();
			String sql="SELECT actS FROM CATO.ActualSpeed WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list.add(String.valueOf(rst.getDouble("actS")));
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<String> getColor(){
		ArrayList<String> list=null;
		try{
			this.getConn();
			String sql="SELECT * FROM CATO.Color WHERE trainid=1220 ORDER By id ASC";
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery(sql);
			while(rst.next()){
				list=new ArrayList<String>();
				list.add(String.valueOf(rst.getInt("Cl1")));
				list.add(String.valueOf(rst.getInt("Cl2")));
				list.add(String.valueOf(rst.getInt("Cl3")));
				list.add(String.valueOf(rst.getInt("Cl4")));
				list.add(String.valueOf(rst.getInt("Cl5")));
				list.add(String.valueOf(rst.getInt("Cl6")));
				list.add(String.valueOf(rst.getInt("Cl7")));
				list.add(String.valueOf(rst.getInt("Cl8")));
				list.add(String.valueOf(rst.getInt("Cl9")));
				list.add(String.valueOf(rst.getInt("Cl10")));
				list.add(String.valueOf(rst.getInt("Cl11")));
				
			}
			rst.close();
			rst=null;
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void clearPosition(){
		try{
			this.getConn();
			String sql="DELETE FROM CATO.ActualSpeed WHERE trainid=1220";
			String sql1="DELETE FROM CATO.AdviceSpeed WHERE trainid=1220";
			Statement stmt=conn.createStatement();
			stmt.execute(sql);
			stmt.execute(sql1);		
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setColorProfile(String profilename){
		try{
			this.getConn();
			String sql="DELETE FROM CATO.Color WHERE trainid=1220";
			String sqlp1="INSERT INTO `CATO`.`Color` (`Cl1`, `Cl2`, `Cl3`, `Cl4`, `Cl5`, `Cl6`, `Cl7`, `Cl8`, `Cl9`, `Cl10`, `Cl11`, `trainid`) VALUES ('-65281','-16776961','-16777216','-65536','-16716936','-7829368','-7829368','-7829368','-7829368','-7829368','-7829368', '1220')";
			String sqlp2="INSERT INTO `CATO`.`Color` (`Cl1`, `Cl2`, `Cl3`, `Cl4`, `Cl5`, `Cl6`, `Cl7`, `Cl8`, `Cl9`, `Cl10`, `Cl11`, `trainid`) VALUES ('-65536','-16776961','-16777216','-65281','-16716936','-7829368','-7829368','-7829368','-7829368','-7829368','-7829368', '1220')";
			Statement stmt=conn.createStatement();
			stmt.execute(sql);
			if(profilename.trim().equalsIgnoreCase("p1")){
				stmt.execute(sqlp1);
			}
			if(profilename.trim().equalsIgnoreCase("p2")){
				stmt.execute(sqlp2);
			}
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private float getrdm(float offset,float acc){
		//Random rd=new Random();
		return offset;
		
	}
	public void genPosition(float InitSpeed,float Acce1,float Acce2,float Acce3,float Acce4,float Acce5,float Acce6,float Acce7,float Acce8,float Acce9,float Acce10,float Acce11,float Acce12, float offset){
		try{
			this.getConn();
			String sql="";
			Statement stmt=conn.createStatement();
			float spd=0;
			float advspeed=0;
			float pos=0;
			for(int i=0;i<600;i++){
				if(i<50){
					pos=Acce1/2+spd+pos;
					spd=spd+Acce1;
					advspeed=(float)((getrdm(offset,Acce1)+spd)*3.6);
				}
				if(i>=50 && i<100){
					pos=Acce2/2+spd+pos;
					spd=spd+Acce2;
					advspeed=(float)((getrdm(offset,Acce2)+spd)*3.6);
				}
				if(i>=100 && i<150){
					pos=Acce3/2+spd+pos;
					spd=spd+Acce3;
					advspeed=(float)((getrdm(offset,Acce3)+spd)*3.6);
				}
				if(i>=150 && i<200){
					pos=Acce4/2+spd+pos;
					spd=spd+Acce4;
					advspeed=(float)((getrdm(offset,Acce4)+spd)*3.6);
				}
				if(i>=200 && i<250){
					pos=Acce5/2+spd+pos;
					spd=spd+Acce5;
					advspeed=(float)((getrdm(offset,Acce5)+spd)*3.6);
				}
				if(i>=250 && i<300){
					pos=Acce6/2+spd+pos;
					spd=spd+Acce6;
					advspeed=(float)((getrdm(offset,Acce6)+spd)*3.6);
				}
				if(i>=300 && i<350){
					pos=Acce7/2+spd+pos;
					spd=spd+Acce7;
					advspeed=(float)((getrdm(offset,Acce7)+spd)*3.6);
				}
				if(i>=350 && i<400){
					pos=Acce8/2+spd+pos;
					spd=spd+Acce8;
					advspeed=(float)((getrdm(offset,Acce8)+spd)*3.6);
				}
				if(i>=400 && i<450){
					pos=Acce9/2+spd+pos;
					spd=spd+Acce9;
					advspeed=(float)((getrdm(offset,Acce9)+spd)*3.6);
				}
				if(i>=450 && i<500){
					pos=Acce10/2+spd+pos;
					spd=spd+Acce10;
					advspeed=(float)((getrdm(offset,Acce10)+spd)*3.6);
				}
				if(i>=500 && i<550){
					pos=Acce11/2+spd+pos;
					spd=spd+Acce11;
					advspeed=(float)((getrdm(offset,Acce11)+spd)*3.6);
				}
				if(i>=550 && i<600){
					pos=Acce12/2+spd+pos;
					spd=spd+Acce12;
					advspeed=(float)((getrdm(offset,Acce12)+spd)*3.6);
				}
				System.out.println(String.valueOf(Math.round(pos/25)));
				sql="INSERT INTO `CATO`.`ActualSpeed` (`actS`, `trainid`) VALUES ('"+String.valueOf(pos)+"', '1220')";
				stmt.execute(sql);
				sql="INSERT INTO `CATO`.`AdviceSpeed` (`advS`, `trainid`) VALUES ('"+String.valueOf(advspeed)+"', '1220')";
				stmt.execute(sql);
			}		
			this.closeConn();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
