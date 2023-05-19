package com.atm.controller;

import java.util.Scanner;

import com.atm.dao.CustomerDao;
import com.atm.dto.BankHolder;

public class SaveCustomer {

	public static void main(String[] args) {
		CustomerDao cd=new CustomerDao();
		Scanner sc=new Scanner(System.in);	
		System.out.println("Enter 1 for create account");
		System.out.println("Enter 2 for login");
		switch(sc.nextInt()) {
		case 1:
		BankHolder b =new  BankHolder();
		System.out.println("Enter Bank Holder pin");
		b.setAccountPin(sc.nextInt());
		System.out.println("Enter Bank Holder Name");
		b.setName(sc.next());
		System.out.println("Enter Bank Holder Mobile Number");
		b.setPhNo(sc.nextLong());
		
		System.out.println("Enter Bank Holder email");
		b.setEmail(sc.next());
		
		System.out.println("Enter Bank Holder Deposite Amount");
		b.setBalance(sc.nextDouble());
		
		cd.saveCustomer1(b);
		System.out.println("Your Account has been Created Successfully");
		System.out.println("Thank You for Visiting Our Bank");
		break;
		case 2:
			System.out.println("Enter Bank Holder Pin");
			BankHolder customer =cd.getAllEmployeeById(sc.nextInt());
			if(customer==null) {
				System.out.println("Enter Correct Pin");
				System.out.println("Thank You for Visiting Our Bank");
				break;
			}
			else {
				System.out.println("****Login Successfully****");
				System.out.println("For Withdraw Please enter 1");
				System.out.println("For Deposite Please enter 2");
				System.out.println("For Checking balance Please enter 3");
				System.out.println("For View Details Please enter 4");
				switch(sc.nextInt()) {
				case 1: 
					System.out.println("Enter the Withdraw Amount");
					double balance=customer.getBalance()-sc.nextInt();
					customer.setBalance(balance);
					cd.updateEmployee(customer);
					System.out.println("Thank You for Visiting Our Bank");
					break;
				case 2: 
					System.out.println("Enter the Credit Amount");
					double balance1=customer.getBalance()+sc.nextInt();
					customer.setBalance(balance1);
					cd.updateEmployee(customer);
					System.out.println("Thank You for Visiting Our Bank");
					break;
				case 3:
					System.out.println("Bank Holder Current Balance"+ customer.getBalance());
					System.out.println("Thank You for Visiting Our Bank");
					break;
				case 4:
					System.out.println("Bank Holder Name "+customer.getName());
					System.out.println("Bank Holder Email "+customer.getEmail());
					System.out.println("Bank Holder Phno "+customer.getPhNo());
					System.out.println("Bank Holder Available Balance "+customer.getBalance());
					System.out.println("Thank You for Visiting Our Bank");
					break;
					default:
						System.out.println("Enter The Correct Option");
						System.out.println("Thank You for Visiting Our Bank");
						break;
					
					

				}
			}
			break;
			default:
				System.out.println("Enter the Correct Option");
				System.out.println("Thank You for Visiting Our Bank");
		}
	}

}
