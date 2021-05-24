package Spotify.Spotify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseSelinium {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/student_mysql";

		// database Username & Password
		String username = "root";
		String password = "Ashu@8541";

		// Query to Execute
		String query = "select * from student;";

		// load mysql jdbc driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Create Connection to DB
		Connection con = DriverManager.getConnection(dbUrl, username, password);

		// Create Statement Object
		Statement stmt = con.createStatement();

		// Execute the SQL Query. Store results in ResultSet
		ResultSet rs = stmt.executeQuery(query);

		// While Loop to iterate through all data and print results
		while (rs.next()){
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String institutename = rs.getString(3);
			String course = rs.getString(4);
			int amount = rs.getInt(5);
			System.out.println(id + " " + name + " " + institutename + " " + course + " " + amount);
		}

		// closing DB Connection
		con.close();
	}

}
