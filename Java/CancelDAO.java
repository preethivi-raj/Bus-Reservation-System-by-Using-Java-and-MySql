package busReservation;

import java.sql.*;

public class CancelDAO {
   public CancelDAO(String booking_num) throws SQLException{
	   
         String bookingNum=booking_num.toUpperCase();	  
         
	   String query ="delete from booking where booking_Id=?;";
	   
	    Connection con=DbConnection.getConnection();
	    PreparedStatement pst=con.prepareStatement(query);
	    pst.setString(1,bookingNum);
	    
	    pst.executeUpdate();
	    
	    System.out.println("Successfully Canceled");
   }
}
