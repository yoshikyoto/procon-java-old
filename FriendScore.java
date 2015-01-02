
public class FriendScore{
	public int INF = 5000;
	public int highestScore(String[] friends){
		int[][] g = convert(friends);
		int l = g.length;
		warshallFloyd(g, l);
		int max = 0;
		for(int i = 0; i < l; i++){
			int sum = 0;
			for(int j = 0; j < l; j++){
				if(i == j) continue;
				if(g[i][j] <= 2) sum++;
			}
			max = Math.max(max, sum);
		}
		return max;
	}
		
	public int[][] convert(String[] friends){
		int l = friends.length;
		int[][] res = new int[l][l];
		for(int i = 0; i < l; i++){
			for(int j = 0; j < l; j++){
				if(friends[i].charAt(j) == 'Y') res[i][j] = 1;
				else res[i][j] = INF;
			}
		}
		return res;
	}
	
	void warshallFloyd(int[][] d, int n){
	    for(int k = 0; k < n; ++k)
	        for(int i = 0; i < n; ++i)
	            for(int j = 0; j < n; ++j)
	                if(d[i][k] != -1 && d[k][j] != -1){
	                    if(d[i][j] == -1){
	                        d[i][j] = d[i][k] + d[k][j];
	                    }else{
	                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
	                    }
	                }
	};
}