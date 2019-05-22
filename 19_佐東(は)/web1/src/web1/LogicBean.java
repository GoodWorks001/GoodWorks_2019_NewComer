package web1;

public class LogicBean {

	//excuteメソッド
	public ResultBean excute
	(String name,int year,int month, int date) {

		//引数nameを文字数を取得します。
		int len = name.length();
		//文字列と年と月と日の計算してます。%5+1は余りの計算式です。
		int mo = (len*year*month*date)%5+1;
		int lo = ((len+year)*month*date)%5+1;
		int wo = ((len+year+month)*date)%5+1;
		int he = (len+year+month+date)%5+1;
		int to =(int) (mo+lo+wo+he)/4;

		//ResultBeanをインスタンス化しています。
		ResultBean rb = new ResultBean();
		//Stringの配列に★を格納しています。
		String[] star = {"","★","★★","★★★","★★★★","★★★★★"};

		//上記の計算された数値を文字列"★"に変更してます。
		rb.setMoney(star[mo]);
		rb.setLove(star[lo]);
		rb.setWork(star[wo]);
		rb.setHealth(star[he]);
		rb.setTotal(star[to]);

		//rbを戻り値としています。
		return rb;
		}
	}
