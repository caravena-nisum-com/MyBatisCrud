import	java.sql.*; 

public class ConnectionDB {

	
	static final String DB_URL = "jdbc:postgresql://localhost/POS";
	
	// Database credentials 
	static final String USER = "caravena";
	static final String PASS = "123";
	static int	ID = 0; 
	
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public Connection getConnection(){
		return conn;
	}
	
	public ConnectionDB() {
		
		try{
			
			createConnection();
			rs = st.executeQuery("SELECT VERSION();");
			if(rs.next()){	
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	public void insertValues(String tableName) throws SQLException{
		String sql = "INSERT INTO "+tableName+" (id_product,product,stock,sale_price,buy_price,tax,user_login)"+
					"VALUES ("+ID+","+"'bike'"+","+100+","+120+","+100+","+20+","+"caravena"+");";
		st.executeUpdate(sql);
	}
	
	public void createConnection() throws SQLException{
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Creating database...");
		st = conn.createStatement();
	}
	
	public void closeConnection(){
		try {
			if(rs!=null) rs.close();
		} catch (SQLException se1) {
				// TODO Auto-generated catch block
				se1.printStackTrace();
		}
		
		try {
			if(st!=null) st.close();
		} catch (SQLException se2) {
				// TODO Auto-generated catch block
				se2.printStackTrace();
		}
		
		try {
			if(conn!=null) conn.close();
		} catch (SQLException se3) {
				// TODO Auto-generated catch block
				se3.printStackTrace();
		}
	}
}
