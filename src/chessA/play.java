package chessA;

public class play{

	public static void main(String[] args) {
		
		
		Player p1 = new Player();
		
		p1.startGame();
		
		for(;;){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					System.out.printf("%3d",p1.map[i][j]);
				}
				System.out.println();
			}
			p1.available();
		}
		
	}

}
