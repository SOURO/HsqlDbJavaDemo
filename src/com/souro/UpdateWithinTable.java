package com.souro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author sourabrata
 *
 */

public class UpdateWithinTable {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		int result = 0;

		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			if (con != null) {
				System.out.println("Connection created successfully");

				stmt = con.createStatement();
				result = stmt.executeUpdate( "UPDATE tutorials_tbl SET title = 'C and Data Structures' WHERE id = 100");
				con.commit();
				System.out.println(result+" Rows effected");

			} else {
				System.out.println("Problem with creating connection");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
