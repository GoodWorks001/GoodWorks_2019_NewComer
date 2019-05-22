package web;

public class Login {

	public LoginUserBean getUserData(String name, String password) {

		LoginUserBean bean = new LoginUserBean();



		// 引数のIDとパスワードを判定

		if("web01".equals(name) && "password".equals(password)) {

			// IDがweb01の場合

			// BeanにIDを設定

			bean.setId(name);

			// Beanに名前を設定

			bean.setName("すく太郎");

			// Beanに年齢を設定

			bean.setAge(17);

		} else if ("web02".equals(name) && "password".equals(password)) {

			// IDがweb02の場合

			// BeanにIDを設定

			bean.setId(name);

			// Beanに名前を設定

			bean.setName("すく次郎");

			// Beanに年齢を設定

			bean.setAge(10);



		} else {

			// IDが合致しない場合はnullを代入

			bean = null;

		}

		return bean;

	}
}
