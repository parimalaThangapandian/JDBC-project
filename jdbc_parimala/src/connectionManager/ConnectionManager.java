package connectionManager;
import java.sql.*;
public class ConnectionManager {
	//Create connection object
	Connection con=null;
	public Connection establishConnection() throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parimala","root","root");
		return con;
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}
        
}
