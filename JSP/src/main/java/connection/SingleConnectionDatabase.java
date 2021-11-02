package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionDatabase {

	public static final String URL = "jdbc:mysql://localhost/jpa_database?autoReconnect=true";
	public static final String USER = "root";
	public static final String PASSWORD = "";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	public static Connection CONNECTION = null;
	
	public static Connection getConnection() {
		return CONNECTION;
	}
	
	static {
		connect();
	}
	
	public SingleConnectionDatabase(){
		connect();
	}
    
    public static void connect() {
    	try {
    		if(CONNECTION == null) {
    			//carrega o driver de conexao do banco
    			Class.forName(DRIVER_CLASS);
    			CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
    			CONNECTION.setAutoCommit(false);/*Para não efetuar alterações no banco sem nosso comando*/
    		}
    	}catch (Exception e) {
			
		}
    }
     
  
	
}
