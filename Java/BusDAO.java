package busReservation;

import java.sql.*;
import java.util.*;

public class BusDAO {
	int busNo;
	boolean ac;
	int capacity;
	String driver_name;
	
	public void displayBudInfo() throws SQLException {
		String query="select * from bus";
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("--------------------");
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==0)
				System.out.println("AC: No");
			else
				System.out.println("AC: Yes");
			System.out.println("Capacity: "+rs.getInt(3));
		}
		    System.out.println("---------------------");
	}
	
	public int getCapacity(int id) throws SQLException{
		String query="select capacity from bus where id="+id;
		Connection con=DbConnection.getConnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		
		return rs.getInt(1);
	}
	
	public void setBus() {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter the Bus number:");
		    busNo=s.nextInt();
		 System.out.println("Enter Wheather the bus is AC or Not:");
		     ac=s.nextBoolean();
		 System.out.println("Enter the Number of Seats:");
		    capacity=s.nextInt();
		 System.out.println("Enter the Bus Driver Name:");
		    driver_name=s.next();
		  s.close();
		 
	}
	
	public void setBusInfo()  throws SQLException{
		  
		 setBus();
		
		String query="insert into bus values (?,?,?,?);";
		Connection con=DbConnection.getConnection();
		PreparedStatement pst=con.prepareStatement(query);
		
		pst.setInt(1, busNo);
		pst.setBoolean(2, ac);
		pst.setInt(3, capacity);
		pst.setString(4, driver_name);
		
		pst.executeUpdate();
		
	
	}
	
}
