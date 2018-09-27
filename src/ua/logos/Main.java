package ua.logos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		
		String dbUrl = "jdbc:mysql://localhost:3306/university?useSSL=false";
		String username = "root"; // root
		String password = "olegmonka2309698"; // 123456
		
		conn = DriverManager.getConnection(dbUrl, username, password);
		System.out.println("Connected? " + !conn.isClosed());
		
		createTable();
		conn.close();
	}
	
	private static void createTable() throws SQLException {
		String dropQuerty = "Drop table if exists student";
		
		String query = "CREATE TABLE student("
				+ "id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,"
				+ "full_name VARCHAR(60) NOT NULL,"
				+ "city VARCHAR(45) NOT NULL,"
				+ "age INT NOT NULL"
				+ ");";
		Statement stmt = conn.createStatement();
		stmt.execute(dropQuerty);
		stmt.execute(query);
		System.out.println("Table 'Student' created");
		stmt.close();
	}
	
	private static void addStudent() {
		String querty = "insert into student(full_name,city,age) values(?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(querty);
		pstmt.setString(1, "Ron");
		pstmt.setString(2, "Lviv");
		pstmt.setString(3, 27);
		}
	
}
