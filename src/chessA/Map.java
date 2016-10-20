package chessA;

import java.util.Scanner;

public class Map {
	
	int map[][]=new int[8][8];
	int avail[][]=new int[8][8];
	pon p[]=new pon[16];

	
	public void startGame(int num){
		int i,j,k=0;
		
		/*for(i=0;i<2;i++){
			for(j=0;j<8;j++){
				map[i][j]=0;
				avail[i][j]=0;
			}
		}*/
		
		if(num==1){
			for(i=0;i<2;i++){
				for(j=0;j<8;j++){
					p[k]=new pon();
					p[k].nowx=i;
					p[k].nowy=j;
					map[i][j]=11;
					k=k+1;
				}
			}
		}
		else if(num==2){
			for(i=6;i<8;i++){
				for(j=0;j<8;j++){
					p[k]=new pon();
					p[k].nowx=i;
					p[k].nowy=j;
					map[i][j]=21;
					k=k+1;
				}
			}
		}
		
	}
	public void selectAble(){
		for(int i=0;i<16;i++){
				if(map[p[i].nowx][p[i].nowy]>0){
				System.out.print("num: "+i+"("+p[i].nowx+","+p[i].nowy+")");
				if(i==7){System.out.println();}
			}
		}
	}
	
	
	public void available(){
		int a,b;

		for(;;){
			selectAble();
			Scanner s = new Scanner(System.in);
			System.out.println("Select num");
		
			int t,q;
		
			t=s.nextInt();
		
			System.out.print("Available place :");
			for(a=0;a<8;a++){
				for(b=0;b<8;b++){
					if(map[a][b]==0){
						if(a==p[t].nowx+p[t].x && b==p[t].nowy){
							System.out.print("("+a+","+b+")");
						}
						else if(a==p[t].nowx-p[t].x && b==p[t].nowy){
							System.out.print("("+a+","+b+")");
						}
						else if(a==p[t].nowx && b==p[t].nowy+p[t].y){
							System.out.print("("+a+","+b+")");
						}
						else if(a==p[t].nowx && b==p[t].nowy-p[t].y){
							System.out.print("("+a+","+b+")");
						}
					}
				}
			}
			System.out.println("/ Move - 1 / back - other Num /");
			q=s.nextInt();
			map[p[t].nowx][p[t].nowy]=0;
			if(q==1){
				
				movePiece(t);
				break;
			}
		}
	}
	
	public void movePiece(int t){
		Scanner s = new Scanner(System.in);
		
		int a,b;
		int x,y;
		

			System.out.println("Insert coordinate  X : ");
			x=s.nextInt();
			
			System.out.println("Insert coordinate Y : ");
			y=s.nextInt();

		
		p[t].nowx=x;
		p[t].nowy=y;
		map[x][y]=1;
		
		
		
	}
}
