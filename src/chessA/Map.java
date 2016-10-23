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
		
		if(num==1){//플레이어1을 위한 생성
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
		else if(num==2){//플레이어2를 위한 생성
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
	public void selectAble(int toss){
		
			for(int i=0;i<16;i++){
				if(toss==0){
						if(map[p[i].nowx][p[i].nowy]/10==1){
						System.out.print("num: "+i+"("+p[i].nowx+","+p[i].nowy+")");
						}
				}
				else if(toss==1){
					if(map[p[i].nowx][p[i].nowy]/10==2){
					System.out.print("num: "+i+"("+p[i].nowx+","+p[i].nowy+")");
					}
				}
				if(i==7){System.out.println();}
			}
	}
	
	
	public void available(int toss){
		int a,b;
		int x,y;

		for(;;){
			selectAble(toss);
			Scanner s = new Scanner(System.in);
			System.out.println("Select num");
		
			int t,q;
		
			t=s.nextInt();
		
			System.out.print("Available place :");
			for(a=0;a<8;a++){
				for(b=0;b<8;b++){
					if(map[a][b]==0){//빈자리로 이동을 위한 조건 
						if(map[p[t].nowx][p[t].nowy]/10==1){//플레이어1의 이동조건 
							if(a==p[t].nowx+p[t].x && b==p[t].nowy){
								System.out.print("("+a+","+b+")");
							}
						}
						else if(map[p[t].nowx][p[t].nowy]/10==2){//플레이어2의 이동조건 
								if(a==p[t].nowx-p[t].x && b==p[t].nowy){
									System.out.print("("+a+","+b+")");
								}
							}
				//		else if(a==p[t].nowx-p[t].x && b==p[t].nowy){
				//			System.out.print("("+a+","+b+")");
				//		}
				//		else if(a==p[t].nowx && b==p[t].nowy+p[t].y){
				//			System.out.print("("+a+","+b+")");
				//		}
				//		else if(a==p[t].nowx && b==p[t].nowy-p[t].y){
				//			System.out.print("("+a+","+b+")");
				//		}
					}
				}
			}
			
			for(a=0;a<8;a++){
				for(b=0;b<8;b++){
					if(map[p[t].nowx][p[t].nowy]/10==1){//상대방 말의 위치를 잡아줌
						if(map[a][b]/10==2){//플레이어1이 플레이어2를 잡을수 있는 위치를 잡음 
							if(a==p[t].nowx+p[t].a && b==p[t].nowy+p[t].b){
								System.out.print("("+a+","+b+")");
							}
							else if(a==p[t].nowx+p[t].a && b==p[t].nowy-p[t].b){
								System.out.print("("+a+","+b+")");
							}
						}
					}
						else if(map[p[t].nowx][p[t].nowy]/10==2){//플레이어2가 플레이어1를 잡을수 있는 위치를 잡음 
							 if(map[a][b]/10==1){
								if(a==p[t].nowx-p[t].a && b==p[t].nowy+p[t].b){
									System.out.print("("+a+","+b+")");
								}
								else if(a==p[t].nowx-p[t].a && b==p[t].nowy-p[t].b){
									System.out.print("("+a+","+b+")");
								}
							 }
					}
				//		else if(a==p[t].nowx && b==p[t].nowy+p[t].y){
				//			System.out.print("("+a+","+b+")");
				//		}
				//		else if(a==p[t].nowx && b==p[t].nowy-p[t].y){
				//			System.out.print("("+a+","+b+")");
				//		}
					}
				}
			
			
			
			
			System.out.println("/ Move - 1 /back - other Num /");
			q=s.nextInt();
			
			if(q==1){
				System.out.println("Insert coordinate  X : ");
				x=s.nextInt();
				
				System.out.println("Insert coordinate Y : ");
				y=s.nextInt();
				
				
					movePiece(t,x,y);
					
					break;
			}
			else if(q==2){
				
				break;
			}
		}
	}
	
	public void movePiece(int t,int x, int y){
		Scanner s = new Scanner(System.in);
		
		int a,b;

		

		a=map[p[t].nowx][p[t].nowy];
		map[p[t].nowx][p[t].nowy]=0;
			
		p[t].nowx=x;
		p[t].nowy=y;
		map[x][y]=a;
		
		
		
	}
	
	public void catchPiece(){
		
	}
}
