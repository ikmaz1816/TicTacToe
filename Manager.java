package tictactoe;

import java.util.Scanner;

public class Manager {
	private int num;
	private Scanner sc;
	public Manager()
	{
		this.num=0;
		sc=new Scanner(System.in);
	}
	public Player takePlayerInput(int num)
	{
		System.out.println("Enter the name for Player"+" "+num);
		String name=sc.next();
		System.out.println("Enter the symbol for player"+" "+num);
		char c=sc.next().charAt(0);
		Player p=new Player(name,c);
		return p;
	}
	public void startGame()
	{
		//Taking player input
		Player p1=takePlayerInput(++num);
		Player p2=takePlayerInput(++num);
		while(p1.getSymbol() == p2.getSymbol())
		{
			p2.setSymbol(sc.next().charAt(0));
		}
		//Initializing the board
		Board board=new Board(p1.getSymbol(),p2.getSymbol());
				
				
		//Start the game
		int status=Board.INCOMPLETE;
		boolean player1=true;
		while(status==Board.INCOMPLETE || status==Board.INVALID)
		{
			if(player1)
			{
				System.out.println("Enter the x coordinate for player 1");
				int x=sc.nextInt();
				System.out.println("Enter the y coordinate for player 1");
				int y=sc.nextInt();
				status=board.move(p1.getSymbol(), x, y);
				if(status==Board.INVALID)
					continue;
				board.print();
				player1=!player1;
			}
			else
			{
				System.out.println("Enter the x coordinate for player 2");
				int x=sc.nextInt();
				System.out.println("Enter the y coordinate for player 2");
				int y=sc.nextInt();
				status=board.move(p2.getSymbol(), x, y);
				if(status==Board.INVALID)
					continue;
				board.print();
				player1=true;
			}
			
		}
		if(status==Board.P1)
		{
			System.out.println(p1.getName()+"Wins");
		}
		else if(status==Board.P2)
		{
			System.out.println(p2.getName()+"Wins");
		}
		else
		{
			System.out.println("DRAW");
		}
	}
	
	public static void main(String[] args) {
		Manager m=new Manager();
		m.startGame();

	}

}
