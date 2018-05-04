package DAO;

import query.Queries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public abstract class AbstractDAO {
	static Connection conn = null;
	static String user;
	static String password;
	static String url;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Queries query= new Queries();

	public AbstractDAO() {
		FileInputStream input=null;
		try {
			input = new FileInputStream("resources/config.properties");
			Properties prop = new Properties();
			prop.load(input);
			url= prop.getProperty("database");
			user=prop.getProperty("dbuser");
			password=(prop.getProperty("dbpassword"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(input!=null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, password);
			if(conn.isValid(0)){
				System.out.println("Connected to Database");
			}
			else{
				System.out.println("ERROR in Connecting");
			}
		}catch(SQLException|ClassNotFoundException|InstantiationException|IllegalAccessException e){
			e.printStackTrace();
		}
	}
	
	static void closeConnection(){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
