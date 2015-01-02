package ylab.seminar2014;

/**
 * 11.3 <br>
 * n個の整数からなる、ソート済みの配列を何回か回転させたものがあります。
 * この配列の中から、ある要素を見つけるコードを書いて下さい。<br>
 * 配列は、初め昇順でソートされていたと仮定してもかまいません。
 * 要素には重複がないと仮定します。
 * @author yoshikyoto
 */
public class MyBinarySearch {
	public int[] data;
	
	/**
	 * data から q 二分探索で探す。
	 * @param q 探したい要素
	 * @return 要素が見つかった場合はそのインデックスを返す。見つからなかったら -1 を返す。
	 */
	public int query(int q){
		return search(0, data.length-1, q);
	}
	
	/**
	 * 二分探索
	 */
	public int search(int left, int right, int q){
		if(left == right){
			if(data[left] == q) return left;
			else return -1;
		}
		// 分割する場所
		int center = (left + right) / 2;
		// 二分割したした場合には、どちらかが必ずソートされている。
		// ソートされている方に要素が含まれているかどうか確認する。
		if(data[left] < data[center]){
			// 左側がソートされている
			if(data[left] <= q && q <= data[center]){
				// 左側に要素が含まれている場合
				return search(left, center, q);
			}else{
				// 右側に要素が含まれている場合
				return search(center+1, right, q);
			}
		}else{
			// 右側がソートされている
			if(data[center+1] <= q && q <= data[right]){
				// 右側に要素が含まれている場合
				return search(center+1, right, q);
			}else{
				// 左側に要素が含まれている場合
				return search(left, center, q);
			}
		}
	}
}
