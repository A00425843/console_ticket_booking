import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySqlAccess con=new MySqlAccess();
		
				Scanner scn = new Scanner(System.in);
				validation valid=new validation();
				
				System.out.println("Book Your Movie Tickets. Enjoy the SHOW!!!");
				
				String Option = "Choose one of the Options below :" +
		                "1 -> Book Tickets\n" +
		                "2 -> Get Booked Ticket Details\n"+
		                "3 -> Update Details\n" +
		                "4 -> Cancel Ticket\n" +
		                "0 -> Exit";
				
			try {	
			int select = -1;
			Connection conn = con.Mysql_Connection();
			
					while(select!=0) {

			            System.out.println(Option);

			            try {
			            	select = scn.nextInt();
			            } catch (Exception e) {
			            	
			  		          System.out.println("Please Try again with Valid Option");
				}
			            switch(select) {
			           
			           
			            case 1:
			            	//Booking Ticket
			            	 try {
			            
			             System.out.println("Enter your Name:");
			             String Name = valid.check_String(scn.next());
			             						
						System.out.println("Enter your Address:");
						 String Address = scn.next();
						 
						 System.out.println("Enter your Email:");
						 String Email = scn.next();
						 
						 System.out.println("Enter your Phone Number:");
						 int Phone = scn.nextInt();
						 
						 System.out.println("Enter your Zipcode:");
						 String Zipcode = scn.next();
						 
						 System.out.println("Enter Movie Name:");
						 String MovieName = scn.next();
						 
						 System.out.println("Enter Number of Tickets:");
						 int tickets = Integer.parseInt(scn.next()); 
						 
						 String CreatedBy=System.getProperty("user.name");
					     System.out.println("Created by :" +CreatedBy);
						 
					        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					        
					        TicketBooking tic = new TicketBooking();
					        tic.setName(Name);
					        tic.setAddress(Address);
					        tic.setEmail(Email);
					        tic.setPhone(Phone);
					        tic.setZipCode(Zipcode);
					        tic.setMovieName(MovieName);
					        tic.setTickets(tickets);
					        tic.setCreatedBy(CreatedBy);
					        tic.setCreatedOn(date);
					        
					       con.InsertDetails(tic, conn);
					        	System.out.println("Ticket Booked Successfully " +tic.getName()+ "," +tic.getAddress()+ "," +tic.getEmail()+ "," +tic.getPhone()+
					        			"," +tic.getZipCode()+ "," +tic.getMovieName()+ "," +tic.getTickets()+ "," +tic.getCreatedBy()+ "," +tic.getCreatedOn());
					        
						} 	catch(Exception e) {
							
						}
	                    break;
						   
			            case 2:
			            	try {
		                		  // Get Booking Details
		                        System.out.print("Enter the Email:\n");
		                        String Email = scn.next();
		                        
		                        System.out.print("Enter Movie Name:");
		                        String MovieName = scn.next();
		                        
		                        System.out.println("Printing...");
		                     TicketBooking  Tic = con.getTicketBooking(Email, MovieName, conn);
		                     System.out.println("Details are as follows:" +Tic.getName()+ "," +Tic.getAddress()+ "," +Tic.getEmail()+ "," +Tic.getPhone()+
					        			"," +Tic.getZipCode()+ "," +Tic.getMovieName()+ "," +Tic.getTickets()+ "," +Tic.getCreatedBy()+ "," +Tic.getCreatedOn());
					              		                       		 
			            	} catch(Exception e) {
				        		
				        	}
		                	break;
		                				            	
			            case 4: 
			            	try {
			            		// Cancel Booking
			            		System.out.print("Enter the Email and Movie Name.");
			            		 System.out.print("Enter the Email:\n");
			                        String Email = scn.next();
			                        
			                        System.out.print("Enter Movie Name:");
			                        String MovieName = scn.next();
			                        
		                      con.DeleteTicketBooking(Email, MovieName, conn);
		                      
			            					            		
			            	}catch(Exception e) {
			            		System.out.println(e);
			            	}
			            	break;
			            	//Exit
			            case 0: System.out.println("**** THANK YOU! HAVE A GREAT DAY ****"); 
	                	break;
	                	
		                default:
		                    System.out.print("Please Enter Valid Information.");		  
			            }
					}
			}catch(Exception e) {
			}
	}
}
			            
					
				            



