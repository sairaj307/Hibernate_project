package com.tnsif.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.tnsif.dao.DBUtil;

public class DBMetaData {
	
	private static Connection cn;
	private static PreparedStatement pst;
	private static ResultSet rs;
	static
	{
		cn=DBUtil.getConnetion();
		if (cn!=null)
		{
			System.out.println("Connection established.....");
			try {
				pst=cn.prepareStatement("SELECT * FROM emp");
				rs=pst.executeQuery();	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	public static void showDatabaseMetataData()
	{
		try {
			DatabaseMetaData dbmd=cn.getMetaData();
			System.out.println(dbmd.getDatabaseProductName());
			System.out.println(dbmd.getDriverName());
			System.out.println(dbmd.getDriverVersion());
			System.out.println(dbmd.supportsBatchUpdates());
			System.out.println(dbmd.supportsStoredProcedures());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void showRSMetadata()
	{
		try {
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println(rsmd.getTableName(1));
			System.out.println(rsmd.getColumnCount());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
