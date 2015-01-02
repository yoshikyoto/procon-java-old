public class CrazyBot{
	double prob[];
	int[] vy = {0, 0, -1, 1}, vx = {1, -1, 0, 0};
	
	public double getProbability(int n, int east, int west, int south, int north){
		prob = new double[4];
		prob[0] = east / 100.0;
		prob[1] = west / 100.0;
		prob[2] = south / 100.0;
		prob[3] = north / 100.0;
		
		boolean[][] visited = new boolean[31][31];
		return dfs(visited, 15, 15, n);
	}
	
	double dfs(boolean[][] visited, int y, int x, int n){
		if(visited[y][x]) return 0.0;
		if(n == 0) return 1.0;
		
		visited[y][x] = true;
		double p = 0.0;
		for(int i = 0; i < 4; i++){
			p += dfs(visited, y+vy[i], x+vx[i], n-1) * prob[i];
		}
		visited[y][x] = false;
		return p;
	}
}