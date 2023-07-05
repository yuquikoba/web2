package model;

public class NumLogic {
	public void execute(Num num) {
		//引数に入ってきたインスタンスからもとの文字列を取得
		String org=num.getOrg();
		//splitして配列にする
		String[] orgArr=org.split(",");
		//要素数がわかったのでsetSize
		num.setSize(orgArr.length);
		int max,min,sum;
		//１つ目の要素でそれぞれ初期化する
		max=min=sum=Integer.parseInt(orgArr[0]);
		//2つ目から最後まで回すループ
		for(int i=1;i<orgArr.length;i++) {
			//文字列から整数に変換
			int n=Integer.parseInt(orgArr[i]);
			//最大値チェック
			if(max < n) {
				max=n;
			}
			//最小値チェック
			if(min > n) {
				min=n;
			}
			//合計に加算
			sum+=n;
		}
		//値がわかったのでインスタンスにセットする
		num.setMax(max);
		num.setMin(min);
		num.setSum(sum);
		/*ここに到達するころにはnumインスタンスはほしい情報を
		 * すべて保持している*/
	}
}