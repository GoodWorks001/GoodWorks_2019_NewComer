package ECpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import web1.MeisaiBean;
import web1.ProBean;

public class DAO_S {

	public ArrayList<ProBean> pb(String nam) {

		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<ProBean> Proli = new ArrayList<ProBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			String sql = "SELECT * FROM product WHERE pro_name = '" + nam+"'";

			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ProBean pro = new ProBean();
				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_price(rs.getInt("pro_cd"));
				Proli.add(pro);
			}

			return Proli;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return Proli;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return Proli;
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return Proli;
			} catch (Exception ex) {
			}
		}
	}

	public ArrayList<ProBean> searchpro(String no) {

		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		ArrayList<ProBean> Proli = new ArrayList<ProBean>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			String sql = "SELECT * FROM product WHERE cat_id = " + no;

			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ProBean pro = new ProBean();
				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_cd(rs.getInt("pro_cd"));
				Proli.add(pro);
			}

			return Proli;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return Proli;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return Proli;
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return Proli;
			} catch (Exception ex) {
			}
		}
	}

	public ProBean ProductShousai(String pro_cd) {
		String url = "jdbc:mysql://localhost/lesson20xx";
		String id = "root";
		String pw = "password";

		Connection cnct = null;
		Statement st = null;
		ResultSet rs = null;

		ProBean pro = new ProBean();

		try {
			Class.forName("com.mysql.jdbc.Driver");

			cnct = DriverManager.getConnection(url, id, pw);
			st = cnct.createStatement();
			String sql = "SELECT * FROM product  inner join category5 on product.cat_id = category5.cat_id "
					+ " where pro_cd = " + pro_cd;

			System.out.println(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {

				pro.setPro_name(rs.getString("pro_name"));
				pro.setPro_price(rs.getInt("pro_price"));
				pro.setPro_cd(rs.getInt("pro_cd"));
				pro.setStock_no(rs.getInt("stock_no"));
				pro.setPro_img(rs.getString("pro_img"));
				pro.setPro_msg(rs.getString("pro_msg"));
				pro.setCat_name(rs.getString("cat_name"));
			}

			return pro;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return pro;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return pro;
		} finally {
			try {

				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (cnct != null)
					cnct.close();
				return pro;
			} catch (Exception ex) {
			}
		}
	}
		public void Meisai(ArrayList<MeisaiBean> meisai,String user_id) {
			String url = "jdbc:mysql://localhost/lesson20xx";
			String id = "root";
			String pw = "password";

			Connection cnct = null;
			Statement st = null;

			try {
				Class.forName("com.mysql.jdbc.Driver");

				cnct = DriverManager.getConnection(url, id, pw);
				st = cnct.createStatement();

				for( int i = 0; i<meisai.size(); i++){
					MeisaiBean mb = meisai.get(i);
					int now_zaiko = zaiko(mb.getPro_cd());
					String sql = "update product set stock_no = "
					+ ( now_zaiko - mb.getPro_Rstock())  + " where pro_cd = "+ mb.getPro_cd()+"";
					System.out.println(sql);
					st.executeUpdate(sql);
				}

				for(int i = 0; i<meisai.size(); i++) {
					MeisaiBean m = meisai.get(i);

					Date dt = new Date();
					SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-MM-dd-HH");
					String c2 = dt2.format(dt);
					System.out.println(c2);

					String sql = "insert into meisai (user_id,pro_cd,ko_date,mei_price)"
							+ " values("+ user_id+"," + m.getPro_cd()+",'" + c2 +"'," +m.getMei_price()+")";
					System.out.println(sql);
					st.executeUpdate(sql);


				}

			} catch (ClassNotFoundException ex) {
				ex.printStackTrace();

			} catch (SQLException ex) {
				ex.printStackTrace();

			} finally {
				try {
					if (st != null)
						st.close();
					if (cnct != null)
						cnct.close();
				} catch (Exception ex) {
				}
			}
		}
public int zaiko(int pro_cd) {

	String url = "jdbc:mysql://localhost/lesson20xx";
				String id = "root";
				String pw = "password";

				Connection cnct = null;
				Statement st = null;
				ResultSet rs = null;

				int zaiko = 0;

				try {
					Class.forName("com.mysql.jdbc.Driver");

					cnct = DriverManager.getConnection(url, id, pw);
					st = cnct.createStatement();
					String sql = "select * from product where pro_cd =" + pro_cd;

					System.out.println(sql);
					rs = st.executeQuery(sql);
					rs.next();
					zaiko = rs.getInt("stock_no");
					System.out.println("在庫数"+zaiko);

					return zaiko;
				} catch (ClassNotFoundException ex) {
					ex.printStackTrace();
					return zaiko;
				} catch (SQLException ex) {
					ex.printStackTrace();
					return zaiko;
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (st != null)
							st.close();
						if (cnct != null)
							cnct.close();
						return zaiko;
					} catch (Exception ex) {
					}
				}
			}
	}

