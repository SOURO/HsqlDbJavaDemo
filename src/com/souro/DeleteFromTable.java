package com.souro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author sourabrata
 *
 */

public class DeleteFromTable {
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
				result = stmt.executeUpdate( "DELETE FROM tutorials_tbl WHERE id=100");
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
