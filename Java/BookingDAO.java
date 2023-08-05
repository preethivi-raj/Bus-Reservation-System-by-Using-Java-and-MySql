package busReservation;
import java.sql.*;
import java.util.Date;
public class BookingDAO {
   public int getBookedCount(int busNo , Date date) throws SQLException{
		String query="select count(passenger_name) from booking where bus_no=? and travel_date=?";
	   Connection con=DbConnection.getConnection();
	   java.sql.Date sqldate=new java.sql.Date(date.getTime());

	   PreparedStatement pst=con.prepareStatement(query);	   
	   pst.setInt(1,busNo);
	   pst.setDate(2, sqldate);
       ResultSet rs=pst.executeQuery();
       rs.next();
       
	  return rs.getInt(1);  
	}
   
   public void addBooking(Booking booking)throws SQLException{
	   
	   String query ="Insert into booking values(?,?,?,?,?,?)";
	   
	   Connection con=DbConnection.getConnection();
	   
	   java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());

	   PreparedStatement pst=con.prepareStatement(query);
	   
	   pst.setString(1, booking.booking_id);
	   pst.setString(2, booking.passengerName);
	   pst.setInt(3, booking.busNo);
	   pst.setString(4, booking.from);
	   pst.setString(5, booking.destination);
	   pst.setDate(6,sqldate);
	  
	   pst.executeUpdate();
	  
   }
   
   
}
