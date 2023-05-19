package com.atm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.atm.dto.BankHolder;

import com.mysql.cj.jdbc.Driver;

public class CustomerDao {
public void saveDetails()  {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_crud","root","root");
		Statement statement=connection.createStatement();
		statement.execute("create table atm_crud(accountpin int primary key, name varchar(30), balance double, email varchar(20), phNo bigint(10))");
		connection.close();
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public BankHolder saveCustomer1(BankHolder e) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bank_crud","root","root");
		java.sql.PreparedStatement ps = connection.prepareStatement("insert into atm_crud values(?,?,?,?,?)");
		ps.setInt(1, e.getAccountPin());
		ps.setString(2, e.getName());
		ps.setDouble(3, e.getBalance());
		ps.setLong(5, e.getPhNo());
		ps.setString(4, e.getEmail());
		
		 ps.executeUpdate();
		connection.close();
		

	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return e;

}
public BankHolder updateEmployee(BankHolder e) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bank_crud?user=root&password=root");
		java.sql.PreparedStatement ps = connection
				.prepareStatement("update atm_crud set name=?,balance=?,email=?,phNo=?,accountpin=? where accountpin=?");

		ps.setString(1, e.getName());
		
		ps.setDouble(2, e.getBalance());
		ps.setString(3, e.getEmail());
		ps.setLong(4, e.getPhNo());
		ps.setInt(5, e.getAccountPin());
		ps.executeUpdate();
		 ps.executeUpdate();
		connection.close();
		
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		return e;
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		return e;
	}
	return e;
}
public int deleteEmployee(int id) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bank_crud?user=root&password=root");
		java.sql.PreparedStatement ps = connection.prepareStatement("delete from atm_crud where accountpin  =?");
		ps.setInt(1, id);
		int res = ps.executeUpdate();
		connection.close();
		return res;

	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	return 0;

}

public BankHolder getAllEmployeeById(int id)  {
	BankHolder employee=new BankHolder();
	try {
		DriverManager.registerDriver(new Driver());
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/bank_crud?user=root&password=root");
		PreparedStatement statement =  connection.prepareStatement("select * from atm_crud where accountpin=?");
		statement.setInt(1, id);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			int id1 = res.getInt(1);
			String name = res.getString(2);
			double balance = res.getDouble(3);
			String email = res.getString(4);
			long phone = res.getLong(5);
			
			
			
			employee.setAccountPin(id1);
			employee.setName(name);
			employee.setPhNo(phone);
			employee.setBalance(balance);
			employee.setEmail(email);
		}
			connection.close();
			
			return employee;
	}
	catch (SQLException e1) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		return null;
	}
	

}

}
