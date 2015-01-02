
import java.util.Arrays;
import java.util.HashSet;

/**
 * topcoder SRM 640 Div2 Level2
 * @author yoshikyoto
 */
public class NumberGameAgain{
	HashSet<Long> checked = new HashSet<Long>();
	
	public long solve(int k, long[] table){
		Arrays.sort(table);
		
		long ans = (long)Math.pow(2, k) - 2;
		
		for(long f : table){
			if(isChecked(f)) continue;
			long log = (long) (Math.log(f) / Math.log(2));
			ans -= (long)Math.pow(2, k-log) - 1;
			checked.add(f);
		}
		return ans;
	}
	
	boolean isChecked(long f){
		if(checked.contains(f)) return true;
		if(f == 1) return false;
		if(f % 2 == 0){
			return isChecked(f / 2);
		}else{
			return isChecked((f-1) / 2);
		}
	}
}

