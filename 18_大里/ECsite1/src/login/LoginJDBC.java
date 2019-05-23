package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginJDBC {
		public String name1;
		public String pass1;


		public void main() {

			String url = "jdbc:mysql://localhost/ECsite";
			String id = "root";
			String pw = "password";

			//いつものやつ
			Connection cnct = null;
			Statement st = null;
			ResultSet rs = null;
			try {

				Class.forName("com.mysql.jdbc.Driver");

				cnct = DriverManager.getConnection(url, id, pw);

				st = cnct.createStatement();

				rs = st.executeQuery("select *  from user");

                //DBのnameとpwを格納
				while (rs.next()) {
					name1 = (rs.getString("user_name"));
					pass1 = (rs.getString("login_pw"));
				}

			} catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFound");
				ex.printStackTrace();
			} catch (SQLException ex) {
				System.out.println("SQLException");
				ex.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (st != null)
						st.close();
					if (cnct != null)
						cnct.close();
				} catch (Exception ex) {
				}
			}
		}
	}



