package com.zwy.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHandler {

	public void openDatabase() throws Throwable {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VipAppData";
		final String USER = "admin";

		final String PWD = "123";
		Connection con = DriverManager.getConnection(URL, USER, PWD);

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from ProductInfo ");

		while (rs.next()) {
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getInt(3));
		}

		con.close();
	}
}
