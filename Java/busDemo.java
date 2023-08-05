package busReservation;

import java.util.*;
public class busDemo {

	public static void main(String[] args)  {
		Scanner s= new Scanner(System.in);
	
	try {	
       BusDAO busdao = new BusDAO();
       busdao.displayBudInfo();
       int userOpt=1;
       while(userOpt==1){
           System.out.println("Enter 1 to Book");
           System.out.println("Enter 2 to display the Booking");
           System.out.println("Enter 3 to cancel the booking");
           System.out.println("Enter 4 to set the New Bus Info");
           System.out.println("Enter 5 to show the availability on perticular Date and Bus Number");
           System.out.println("Enter 6 to exit the Program");
           
           System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
           
           userOpt=s.nextInt();
           switch(userOpt) {
           case 1:
               Booking booking = new Booking();
                  
               if(booking.isAvailable()){
                     BookingDAO bookingdao = new BookingDAO();
                     bookingdao.addBooking(booking);
                   System.out.println("Your booking is confirmed");
                   System.out.println("------------------------------------------------------");
               }
               else
                   System.out.println("Sorry. Bus is full. Try another bus or date");
                break;
           
           
           case 2: 
        	   DisplayInfo da = new DisplayInfo();
        	    da.displayBooking();
                break;
           
           case 3: 
        	   System.out.println("Please enter the booking number");
        	    String cancel=s.next();
        	     new CancelDAO(cancel);
                  break;
           case 4: 
        	    
        	    BusDAO setNewBus= new BusDAO();
        	        setNewBus.setBusInfo();
        	      break;
           case 5:
        	     DisplayInfo  dp= new DisplayInfo();
        	     System.out.println("Enter the date(yyyy-mm-dd)");
        	     String date=s.next();
        	     System.out.println("Enter the Bus Number");
        	     int bus_no=s.nextInt();
        	      dp.displayAvaliableInDate(date, bus_no);
        	      break;
        	      
           case 6:
        	    userOpt=2;
        	    break;    
         } 
       } 
	}catch(Exception e) {
		System.out.print(e);
	}
	s.close();
	
	}
}
