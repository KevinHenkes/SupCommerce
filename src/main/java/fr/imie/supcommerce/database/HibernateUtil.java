package fr.imie.supcommerce.database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mysql.jdbc.Statement;
 
public class HibernateUtil {
 
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();
 
    private static EntityManagerFactory buildEntityManagerFactory() {
    	initDbIfNotExist();
    	
        try {
            return Persistence.createEntityManagerFactory("SupCommerceUnit");
        }
        catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
    
    private static void initDbIfNotExist() {
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/";

		// Database credentials
		final String USER = "supcommerce";
		final String PASS = "supcommerce";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = (Statement) conn.createStatement();
			
			String sql = "CREATE DATABASE IF NOT EXISTS supcommerce CHARACTER SET utf8 COLLATE utf8_general_ci";
			
			stmt.executeUpdate(sql);
			
			System.out.println("DB CREATED OK");
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) { se2.printStackTrace(); }
			
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
 
}