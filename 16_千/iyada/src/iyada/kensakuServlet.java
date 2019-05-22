package iyada;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class kensakuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメータのコーディングの指定
				req.setCharacterEncoding("UTF-8");
				//商品情報格納用配列の宣言
				ArrayList<String> list = new ArrayList<>();
				//セッションの生成
				HttpSession ses = req.getSession();
				//DAOクラスのインスタンス化
				DAO dao = new DAO();
				//送信されたパラメータの取得
				String category = req.getParameter("category");
				//送信されたパラメータの取得
				String name = req.getParameter("ken");
				//int型へ変換
				int c = Integer.parseInt(category);
				//カテゴリに値が入っているかの確認
				System.out.println(category);
				//遷移するためのテンプレ
				RequestDispatcher rd ;
				//カテゴリを選択されているかの確認
				if(c == 0) {
					//名前検索ですか？
					if(name != "") {
						//名前検索が行われた場合
						//名前検索用メソッドの呼び出し
						list = dao.nameKensaku(name);
						//配列内に内容が入ったかの確認
						for(String x : list) {
							System.out.println(x);
						}
						//セッションに商品情報を格納
						ses.setAttribute("list", list);
						//画面に出力するflgの変更
						ses.setAttribute("syouhin", "!=");
					}
					//確認用メッセージ
					System.out.println("どちらも入力されていない場合");
				}else {
					//ID検索開始
					System.out.println("ID検索を開始します");
					//ID検索メソッドの呼び出し
					list = dao.Kensaku(category);
					//配列内に内容が入ったかの確認
					for(String x : list) {
						System.out.println(x);
					}
					//セッションに配列を格納
					ses.setAttribute("list", list);
					//画面に出力するflgの変更
					ses.setAttribute("syouhin", "!=");
					//確認用メッセージ
					System.out.println("検索サーブレット終了");
				}
				//ログインに成功していた場合
				rd = req.getRequestDispatcher("Kensaku.jsp");
				//遷移だ
				rd.forward(req, resp);
			}
	}

