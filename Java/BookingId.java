package busReservation;

import java.sql.*;


public class BookingId  {
	
	    
	    static String book="SSP00000";
	    static int id;
	     
	    public BookingId() throws SQLException{
		     String last;
		     String query="SELECT * FROM booking ORDER BY booking_Id DESC LIMIT 1";
		   Connection con=DbConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			
			rs.next();
			last=rs.getString(1);
			  String last_Id="";
			for(int i=0 ; i<last.length() ;i++) {
				if(Character.isDigit(last.charAt(i))) {
					last_Id+=last.charAt(i);
				}
			}
			
			id=Integer.parseInt(last_Id); 
			
	   }
	    
	     
	  public String bookingId() {
	       id++;
	  String id_num=Integer.toString(id);
	   int len=id_num.length();
	   return book.substring(0 , (8-len))+id_num;
}
	  
	  
}
