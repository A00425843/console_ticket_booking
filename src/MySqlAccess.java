import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MySqlAccess {

	public Connection Mysql_Connection() throws Exception {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ticketbooking","root","JasNeet94");
			try {
		        if(!con.isClosed() || con!=null){
		           System.out.println("connection built"); 
		           return con;
		        }
		    } catch (SQLException e) {
		    	System.out.println("connection not built");
		    	return con;
		    }

		} catch (Exception e) {
			return con;
			
	}
		return con;

	}

	public boolean InsertDetails(TicketBooking tic, Connection con) {
		
		try {
		// Insert Query
		String query = "INSERT INTO customer (Name, Address, Email, Phone, ZipCode, MovieName, Tickets, CreatedOn, CreatedBy) values(?,?,?,?,?,?,?,?,?)"; 
		      // create the mysql insert prepared statement
		      PreparedStatement Stmt = con.prepareStatement(query);
		      
		      Stmt.setString (1, String.valueOf(tic.getName()));
		      Stmt.setString (2, String.valueOf(tic.getAddress()));
		      Stmt.setString (3, String.valueOf(tic.getEmail()));
		      Stmt.setInt(4, (tic.getPhone()));
		      Stmt.setString(5, String.valueOf(tic.getZipCode()));
		      Stmt.setString(6, String.valueOf(tic.getMovieName()));
		      Stmt.setString(7, String.valueOf(tic.getTickets()));
		      Stmt.setDate(8, tic.getCreatedOn());
		      Stmt.setString(9, String.valueOf(tic.getCreatedBy()));
		    

		      // execute the prepared statement
		  	int result = Stmt.executeUpdate();
		  	System.out.println("Details Inserted: " +result);
		       return true;
		     
		    }
catch (Exception e)
		    {
		      System.err.println("Got an exception!");
		      System.err.println(e.getMessage());
		     return false;
		    }
		  }	
	
	public TicketBooking getTicketBooking(String ticEmail, String ticMovieName, Connection con) {
		TicketBooking tic = null;
				
		try {
			Statement stmt1 = con.createStatement();
		
			ResultSet res = stmt1.executeQuery("Select * from customer where Email ='" +ticEmail+"' AND MovieName ='" +ticMovieName+"'");

			while (res.next()) {
				tic = new TicketBooking();                                         
				tic.setName(res.getString(1));
				tic.setAddress(res.getString(2));
				tic.setEmail(res.getString(3));
				tic.setPhone(res.getInt(4));     
				tic.setZipCode(res.getString(5));
				tic.setMovieName(res.getString(6));
				tic.setTickets(res.getInt(7));
				tic.setCreatedBy(res.getString(8));
				tic.setCreatedOn(res.getDate(9));
				
				
							}
		} catch (Exception e) {
			
		}
		return tic;

			}
	
	boolean DeleteTicketBooking(String TicEmail, String TicMovieName, Connection con) {
		TicketBooking Tic = null;
		
		try {
			PreparedStatement st=null;
			
			st = con.prepareStatement("Delete from customer where Email='" +TicEmail+"' AND MovieName ='" +TicMovieName+"'");
			

			int rowsDeleted = st.executeUpdate();
			
			
			if (rowsDeleted > 0) {
				System.out.println("Booking Cancelled !!!");
				return true;
				}
			
		} catch (Exception e) {
		}
		
		return false;
	}
		

	}
	
	
	
	
