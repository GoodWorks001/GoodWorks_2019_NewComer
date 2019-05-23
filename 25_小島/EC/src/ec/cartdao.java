package ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class cartdao {

	public  ItemBean cart(String id) {
		Connection cn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		ItemBean cb = new ItemBean();

		try {
			System.out.println("カートだおだお");

			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost/EC", "root", "password");
			String qu="select * from product where pro_id=?";
			ps=cn.prepareStatement(qu);
			ps.setString(1,id);
			rs=ps.executeQuery();
			while( rs.next() ) {
				cb.setName(rs.getString(2));
				cb.setPrice(rs.getInt(4));;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cb;
	}

}



