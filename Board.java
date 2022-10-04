package tictactoe;

public class Board {
	private char[][] board;
	private char p1Symbol,p2Symbol;
	private static final int BOARD_SIZE=3;
	public static final int P1=1;
	public static final int P2=2;
	public static final int INVALID=3;
	public static final int INCOMPLETE=4;
	public static final int DRAW=5;
	private int count=0;
	public Board(char p1,char p2)
	{
		p1Symbol=p1;
		p2Symbol=p2;
		board=new char[BOARD_SIZE][BOARD_SIZE];
		for(int i=0;i<BOARD_SIZE;i++)
		{
			for(int j=0;j<BOARD_SIZE;j++)
			{
				board[i][j]=' ';
			}
		}
	}
	
	public void print()
	{
		for(int i=0;i<BOARD_SIZE;i++)
		{
			for(int j=0;j<BOARD_SIZE;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	public int move(char symbol,int x,int y)
	{
		if(x<0 || y<0 || x>board.length || y>board.length || board[x][y]!=' ')
			return INVALID;
		board[x][y]=symbol;
		count++;
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
			return symbol==p1Symbol ? P1 : P2;
		else if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
			return symbol==p1Symbol ? P1 : P2;
		else if(board[0][0]!= ' ' && board[0][0]==board[1][1] && board[0][0]==board[2][2])
			return symbol==p2Symbol ? P2 : P1;
		else if(board[2][0]!= ' ' && board[2][0]==board[1][1] && board[2][0]==board[0][2])
			return symbol==p1Symbol ? P1 : P2;
		else if(count==BOARD_SIZE * BOARD_SIZE)
			return DRAW;
		return INCOMPLETE;
	}
	
}
