package chessA;

public class play{
	
	static int centerMap[][] = new int[8][8];
	public static void syncMap(Player p,int num){
		if(num==1){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					centerMap[i][j]=centerMap[i][j]+p.map[i][j];
				}
			}
		}
		else if(num==2){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					p.map[i][j]=centerMap[i][j];
				}
			}
		}
		else if(num==3){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					centerMap[i][j]=p.map[i][j];
				}
			}
		}
		
		
	}

	public static void main(String[] args) {
		Player p1 = new Player();
		Player p2 = new Player();
		int toss;
		
		//시작을 위한 작업//
		p1.startGame(1);
		p2.startGame(2);
		syncMap(p1,1);
		syncMap(p2,1);
		syncMap(p1,2);
		syncMap(p2,2);
		/////////////
		
		
		toss=0;//어느 플레이어의 턴인지 알려줄
		
		for(;;){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					System.out.printf("%3d",centerMap[i][j]);
				}
				System.out.println();
			}
			if(toss==0){
				System.out.println("1의 턴");
				p1.available();
				syncMap(p1,3);
				syncMap(p2,2);
				toss=1;
			}
			else if(toss==1){
				System.out.println("2의 턴");
				p2.available();
				syncMap(p2,3);
				syncMap(p1,2);
				toss=0;
			}
		}
		
	}

}
