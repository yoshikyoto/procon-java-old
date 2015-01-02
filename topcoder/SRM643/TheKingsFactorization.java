package topcoder.SRM643;

import java.util.ArrayList;

public class TheKingsFactorization {
	public long[] getVector(long N, long[] primes){
		ArrayList<Long> ret = new ArrayList<Long>();
		for (Long prime : primes) {
			while(N % prime == 0){
				ret.add(prime);
				N /= prime;
			}
		}
		
		long[] res = new long[ret.size()];
		for (int i = 0; i < ret.size(); i++) {
			res[i] = ret.get(i);
		}
		return res;
	}
}
