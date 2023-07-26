package com.tnsif.crudoperations.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.tnsif.crudoperations.dao.DBUtil;

public class PreparedStatementDemo {
	
	static Connection cn;
	static PreparedStatement pst;
	static {
		cn = DBUtil.getConnetion();
		if (cn != null)
			System.out.println("JDBC:connection is taken..");
		}
	
	public static int addEmployee(int empId, String empName, double empSalary) {

		int n = 0;
		try {

			pst = cn.prepareStatement("INSERT INTO emp values(?,?,?)");
			pst.setInt(1, empId);
			pst.setString(2, empName);
			pst.setDouble(3, empSalary);

			n = pst.executeUpdate();
		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
		return n;

	}
	
	public static int validateEmp(int empId) {
		int n = 0;
		try {
			String query = "SELECT count(*) FROM emp where empid=" + empId;
			pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				// System.out.println(rs.getInt(1));
				n = 1;
			}

		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
		return n;
	}
	public static boolean deleteEmp(int empId) {
		boolean status = false;

		try {

			int n = validateEmp(empId);

			if (n == 1) {
				String query = "DELETE FROM emp WHERE empid=" + empId;
				pst = cn.prepareStatement(query);
				n = pst.executeUpdate();
				if (n == 1)
					status = true;
			}

		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
		return status;
	}
	
	public static boolean updateEmpName(int empId, String empName) {
		boolean status = false;
		try {

			if (validateEmp(empId) == 1) {
				String query = "UPDATE emp set empname='" + empName + "' WHERE empid=" + empId;
				pst = cn.prepareStatement(query);
				pst.executeUpdate();
				status = true;
			}

		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
		return status;
	}
	
	public static boolean updateEmpSalary(int empId, double salary) {
		boolean status = false;
		try {

			if (validateEmp(empId) == 1) {
				String query = "UPDATE emp SET empsalary=" + salary + " WHERE empid=" + empId;
				pst = cn.prepareStatement(query);
				pst.executeUpdate();
				status = true;
			}

		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
		return status;
	}
	
	public static void showEmp() {
		try {

			String query = "SELECT * FROM emp";
			pst = cn.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);

			if (rs.next()) {
				while (rs.next()) {

					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
				}
			} else
				System.out.println("No Employee Records.....");
			rs.close();

		} catch (SQLException e) {

			System.out.println("Error...." + e.getMessage());
		}
	}

	public void closeConnection() {
		try {
			pst.close();
			cn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}