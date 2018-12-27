import java.sql.Date;

public class TicketBooking {

	private String Name;
	private String Address;
	private String Email;
	private int Phone;
	private String ZipCode;
	private String MovieName;
	private int Tickets ;
	private String CreatedBy;
	private Date CreatedOn;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public int getPhone() {
		return Phone;
	}
	public void setPhone(int phone) {
		Phone = phone;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getMovieName() {
		return MovieName;
	}
	public void setMovieName(String movieName) {
		MovieName = movieName;
	}
	public int getTickets() {
		return Tickets;
	}
	public void setTickets(int tickets) {
		Tickets = tickets;
	}
	public String getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}
	public Date getCreatedOn() {
		return CreatedOn;
	}
	public void setCreatedOn(Date createdOn) {
		CreatedOn = createdOn;
	}
	

}


