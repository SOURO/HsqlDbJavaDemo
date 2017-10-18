package com.souro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author sourabrata
 *
 */

public class SelectFromTable {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			if (con != null) {
				System.out.println("Connection created successfully");

				stmt = con.createStatement();
				resultSet = stmt.executeQuery( "SELECT id, title, author FROM tutorials_tbl");
				while(resultSet.next()){ 
					System.out.println(resultSet.getInt("id")+" | "+ resultSet.getString("title")+" | "+ resultSet.getString("author")); 
				}

			} else {
				System.out.println("Problem with creating connection");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
