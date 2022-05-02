import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class sample{
 public static void main(String[] args) throws ClassNotFoundException,InstantiationException, SQLException, IllegalAccessException {
	try{
	Connection con=null;
	Class.forName("com.mysql.jdbc.Driver");

	con=DriverManager.getConnection("jdbc:mysql://172.17.0.2/Airticket","root","Password");

	System.out.println("Connection is Successful!");
	Statement s= con.createStatement();
	System.out.println("19BBS0165");
	s.executeUpdate("insert into table flight values('patna','america','23 january',12,'Economy');");
	s.executeUpdate("insert into table flight values('Delhi','Bihar','26 january',2,'Economy');");
	System.out.println("Record updated!");
	s.close();
	con.close();
	}
	catch(SQLException e){
		System.out.println(e.getMessage());
	}
 }
}
