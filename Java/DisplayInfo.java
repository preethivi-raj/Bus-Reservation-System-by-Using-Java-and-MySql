package busReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayInfo {
  
	
	public void displayBooking()throws SQLException{
		   
		   String query="Select * from booking;";
		   Connection con=DbConnection.getConnection();
		   
		   Statement st=con.createStatement();
		   ResultSet rs=st.executeQuery(query);
		   
		   while(rs.next()) {
			   System.out.println("Booking number :"+rs.getString(1));
			   System.out.println("Passeneger Name :"+rs.getString(2));
			   System.out.println("Bus Number :"+rs.getInt(3));
			   System.out.println("From :"+rs.getString(4));
			   System.out.println("Destination :"+rs.getString(5));
			   System.out.println("Date  of the journy :"+rs.getDate(6));
			   System.out.println("-------------------------------------------------");
		   }
	}
	
	public void displayAvaliableInDate(String date , int bus_no) throws SQLException {
		String query="select count(travel_date) from booking where travel_date=? and bus_no=?;";
		
		 Connection con=DbConnection.getConnection();
		   
		 PreparedStatement pst=con.prepareStatement(query);
		 pst.setString(1,date);
		 pst.setInt(2, bus_no);
		 ResultSet rs=pst.executeQuery();
		 rs.next();
		 System.out.print(rs.getInt(1));
	}
}
