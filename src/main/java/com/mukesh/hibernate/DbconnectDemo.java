package com.mukesh.hibernate;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbconnectDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=testDb;integratedSecurity=true;";

		Connection conn = null;

		try {

			// String dbURL = "jdbc:sqlserver://localhost\\sqlexpress";
			// String user = "sa";
			// String pass = "secret";
			// conn = DriverManager.getConnection(dbURL, user, pass);
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: "
						+ dm.getDatabaseProductName());
				System.out.println("Product version: "
						+ dm.getDatabaseProductVersion());
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
