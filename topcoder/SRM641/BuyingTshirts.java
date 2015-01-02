package topcoder.SRM641;

/**
 * topcoder SRM641 Div1 Level1
 * @author yoshikyoto
 */
public class BuyingTshirts{
	public int meet(int T, int[] Q, int[] P){
		int Qsum = 0, Psum = 0, count = 0;;
		for(int i = 0; i < Q.length; i++){
			Qsum += Q[i];
			Psum += P[i];
			
			boolean Qflag = false, Pflag = false;
			
			if(Qsum >= T){
				Qflag = true;
				Qsum -= T;
			}
			
			if(Psum >= T){
				Pflag = true;
				Psum -= T;
			}
			
			if(Qflag && Pflag) count++;
		}
		return count;
	}
}