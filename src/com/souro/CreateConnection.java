package com.souro;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author sourabrata
 *
 */

public class CreateConnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection(
					"jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
			if (con != null) {
				System.out.println("Connection created successfully");

			} else {
				System.out.println("Problem with creating connection");
			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
