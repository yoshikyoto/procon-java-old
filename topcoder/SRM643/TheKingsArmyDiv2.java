package topcoder.SRM643;

public class TheKingsArmyDiv2 {
	int[] vi={-1,1,0,0},vj={0,0,-1,1};
	public int getNumber(String[] state){
		int r = state.length;
		int c = state[0].length();
		char[][] ch = new char[r][];
		for (int i = 0; i < r; i++) {
			ch[i] = state[i].toCharArray();
		}
		
		boolean flag = false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(ch[i][j] == 'H'){
					flag = true;
					for (int k = 0; k < 4; k++) {
						int ni = i+vi[k], nj = j+vj[k];
						try{
							if(ch[ni][nj] == 'H'){
								return 0;
							}
						}catch(Exception e){}
					}
				}
			}
		}
		if(flag) return 1;
		else return 2;
	}
	
	boolean inside(int i, int j, int r, int c){
		return 0 <= i && i < r && 0 <= j && j < c;
	}
}
