package web;

public class UserBean {
    private String user_id = null;  //ユーザーID
    private String user_name = null;//ユーザー名
    private String login_cd = null; //ログインコード
    private String login_pw = null; //ログインPW


    //ユーザーIDの取得
    public String getUser_id() {
        return user_id;
    }
    //ユーザーIDの設定
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    //ユーザー名の取得
    public String getUser_name() {
        return user_name;
    }
    //ユーザー名の設定
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    //ログインコードの取得
    public String getLogin_cd() {
        return login_cd;
    }
    //ログインコードの設定
    public void setLogin_cd(String login_cd) {
        this.login_cd = login_cd;
    }
    //ログインPWの取得
    public String getLogin_pw() {
        return login_pw;
    }
    //ログインPWの設定
    public void setLogin_pw(String login_pw) {
        this.login_pw = login_pw;
    }


}
