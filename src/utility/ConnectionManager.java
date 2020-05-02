package utility;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;


public class ConnectionManager {
	public static Connection getConnection() throws Exception,SQLException {
		Properties p = loadPropertiesFile(); //loadproperties returns properties.
		Class.forName(p.getProperty("driver")); //getting value in jdbc assigned to prop.why seperate file is db may change
		//create connection object
		System.out.println(p.getProperty("driver"));
		System.out.println(p.getProperty("url"));
		Connection con= null;
		con= DriverManager.getConnection(p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
	
		return con;
		
		
	}
	public static Properties loadPropertiesFile() throws Exception {
		Properties prop = new Properties();	
		InputStream in =  ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close(); 
		return prop;
	}
}