package dao;
import java.sql.DriverManager;
import java.sql.Connection;

public class CreateConnection {
  public Connection getConnection() {
	  Connection con = null;
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver"); 
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","suma1234");
		}catch(Exception e) { 
			e.printStackTrace(); 
			System.exit(1);
		}
	return con;	
  }
  
}
