package ylab.seminar2014;

import java.util.*;

/**
 * 11.2<br>
 * 文字列の配列を、アナグラムになっている文字列がお互い隣り合うように並び替えるメソッドを書いて下さい。<br><br>
 * 
 * 文字列のchar配列をソートしたものが一致した場合アナグラムとなるので、<br>
 * ソートされた文字列 -> ソートされる前の文字列の配列（可変長）<br>
 * となる HashMap<String, ArrayList<String>> を作成し、アナグラムをまとめる。
 * 
 * @author yoshikyoto
 */
public class Anagram{
	public ArrayList<String> solve(String[] strs){
		// Anagram Map の作成
		AnagramMap map = new AnagramMap();
		for(int i = 0; i < strs.length; i++){
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			String sortedStr = String.valueOf(chars);
			map.add(sortedStr, strs[i]);
		}
		
		// 並べる
		ArrayList<String> result = new ArrayList<String>();
		for(String key : map.keySet()){
			ArrayList<String> array = map.get(key);
			for(String anagram : array){
				result.add(anagram);
			}
		}
		return result;
	}
}

/**
 * char[] をソートしたものをキーとして、そのAnagramを管理するMap
 * @author admin
 */
class AnagramMap extends HashMap<String, ArrayList<String>>{

	/**
	 * key に対応する ArrayList<String> に value を追加する
	 * @param key
	 * @param value
	 */
	public void add(String key, String value){
		if(containsKey(key)){
			ArrayList<String> array = get(key);
			array.add(value);
		}else{
			// まだキーを持っていない場合は新しく配列を作成する
			ArrayList<String> array = new ArrayList<String>();
			array.add(value);
			put(key, array);
		}
	}
}