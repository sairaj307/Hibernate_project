package com.tnsif.crudoperations.client;

import com.tnsif.crudoperations.service.PreparedStatementDemo;
import com.tnsif.crudoperations.service.StatementInterfaceDemo;

public class Executor {
	public static void main(String[] args) {
		//PreparedStatementDemo.addEmployee(4, "Jaishika",20000.00);
		//PreparedStatementDemo.addEmployee(3, "Chaitra",50000.00);
		PreparedStatementDemo.showEmp();
		PreparedStatementDemo.updateEmpName(3, "Neha");
		PreparedStatementDemo.updateEmpSalary(3, 65000);
		PreparedStatementDemo.showEmp();
		if(!PreparedStatementDemo.deleteEmp(9));
			System.err.println("No such employee...");
	
		PreparedStatementDemo.showEmp();

	}
}
