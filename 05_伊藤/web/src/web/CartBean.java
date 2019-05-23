package web;

public class CartBean {
	//カプセル化
	private String buy = null;


	// フィールドのnameを取得して返す
		public String getBuy() {
			return buy;
		}

		// フィールドのnameを設定
		public void setBuy(String buy) {
			this.buy = buy;
		}
}
