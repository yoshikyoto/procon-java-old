package topcoder.SRM641;

/**
 * topcoder SRM641 Div2 Level3
 * @author yoshikyoto
 */
public class ShufflingCardsDiv2{
	public String shuffle(int[] permutation){
		int n = permutation.length / 2;
		
		int small = 0, large = 0;
		for(int i = 0; i < 2*n; i += 2){
			if(permutation[i] <= n) small++;
			else large++;
		}
		if(small - large == n % 2) return "Possible";
		return "Impossible";
	}
}