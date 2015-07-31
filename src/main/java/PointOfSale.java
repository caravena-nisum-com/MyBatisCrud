import java.sql.SQLException;



public class PointOfSale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionDB connection = new ConnectionDB();
	
		try {
			connection.insertValues("products");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			connection.closeConnection();
		}
	}

}
