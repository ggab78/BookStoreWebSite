import java.sql.*;

public class ConnJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoredb?serverTimezone=UTC", "admin", "admin");
		
			con.createStatement().executeUpdate("INSERT INTO users (email, password, full_name)"+
					"VALUES ('gg@gmail.com', 'xxxx', 'gg');");
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
