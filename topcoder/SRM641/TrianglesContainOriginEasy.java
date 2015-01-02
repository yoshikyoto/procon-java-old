package topcoder.SRM641;

/**
 * topcoder SRM641 Div2 Level2 
 * @author yoshikyoto
 */
public class TrianglesContainOriginEasy{
	public int count(int[] x, int[] y){
		int l = x.length;
		int count = 0;
		for(int i = 0; i < l-2; i++)
			for(int j = i+1; j < l-1; j++)
				for(int k = j+1; k < l; k++){
					// check
					int ax = x[i];
					int ay = y[i];
					int bx = x[j];
					int by = y[j];
					int cx = x[k];
					int cy = y[k];
					
					int abx = bx - ax;
					int aby = by - ay;
					int bcx = cx - bx;
					int bcy = cy - by;
					int cax = ax - cx;
					int cay = ay - cy;
					
					// 外積
					int c1 = aby * bx - abx * by;
					int c2 = bcy * cx - bcx * cy;
					int c3 = cay * ax - cax * ay;
					
					if(c1 > 0 && c2 > 0 && c3 > 0){
						count++;
					}else if(c1 < 0 && c2 < 0 && c3 < 0){
						count++;
					}
				}
		return count;
	}
}