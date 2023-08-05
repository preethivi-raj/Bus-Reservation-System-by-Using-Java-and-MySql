package busReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Booking {
	String booking_id;
	String passengerName;
    int busNo;
    String from;
    String destination;
    Date date;
   
    
    Scanner s= new Scanner(System.in);
    
    Booking() throws SQLException{
    	   BookingId last_id=new BookingId();
   	        booking_id=last_id.bookingId();
         
        System.out.println("Enter name of Passenger: ");
        passengerName=s.next();
        
        System.out.println("Enter bus Number: ");
        busNo=s.nextInt();
        
        System.out.println("From");
        from=s.next();
        
       System.out.println("Destination");
         destination=s.next();
         
         
        System.out.println("Enter date dd-mm-yyyy");
            String dateInput=s.next(); 
             
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            date=dateFormat.parse(dateInput);
        }catch(ParseException e){
            e.printStackTrace();
        }      
    }
    
	
  
    
    public boolean isAvailable() throws SQLException {
    	BusDAO busdao = new BusDAO();
    	BookingDAO bookingdao = new BookingDAO();
        int capacity =busdao.getCapacity(busNo);
       
        int booked=bookingdao.getBookedCount(busNo , date);
        
        return booked<capacity; 
    }
}
