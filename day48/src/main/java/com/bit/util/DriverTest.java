package com.bit.util;

import java.sql.SQLException;

public class DriverTest {
public static void main(String[] args) {
	try {
		System.out.println(new com.mysql.cj.jdbc.Driver());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
}
}
