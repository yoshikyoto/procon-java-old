/**
 * topcoder SRM 640 Div2 Level1
 * @author yoshikyoto
 */
public class ChristmasTreeDecorationDiv2{
	int solve(int[] col, int[] x, int[] y){
		int count = 0;
		for(int i = 0; i < x.length; i++)
			if(col[x[1]-1] == col[y[i]-1]) count++;
		return count;
	}
}