import java.util.Random;
public class SnakeNLadder{
	public static final int NOPLAY = 1;
        public static final int LADDER = 2;
        public static final int SNAKE = 3;
	public static int COUNTER = 0;
        public static int WININGTHROWS = 0;
        public static int LOSINGTHROWS = 0;
        public static int NOPLAYTHROWS = 0;
	public static int currentPlayer = -1;
	final static int WINPOINT = 100;

	public static int position = 0;
	public static int calculatedPosition = 0;
	public static int player1 = 0;
	public static int player2 = 0;

	public static int rolldice(int number) {
                int n = 0;
                Random r = new Random();
                n=r.nextInt(number);
        	COUNTER++;
	        return (n==0?1:n);
        }
	public static int startGame() {
                    do{
		    	int random = rolldice(4);
                        int rolldice = rolldice(7);
                        System.out.println("---------------------");
                        System.out.println("Roll Dice Value : " + rolldice);
                        System.out.println("Random value : " + random);
                        switch (random) {
                        case NOPLAY:
                          	NOPLAYTHROWS++;
			        System.out.println("NOPLAY");
                                System.out.println("Position of player : " + calculatedPosition);
                                System.out.println("----------------------");
                                break;
                        case LADDER:
				WININGTHROWS++;
                                System.out.println("############## Climb the LADDER ############");
                                calculatedPosition = calculatePlayerLadderPosition(calculatedPosition,rolldice);
                                System.out.println("Position of the  Player = " + calculatedPosition);
				int rolldice1 = rolldice(7);
				calculatedPosition = calculatePlayerLadderPosition(calculatedPosition,rolldice1);
				System.out.println("Position of the  Player = " + calculatedPosition);
                                System.out.println("----------------------");
                                break;
                        case SNAKE:
				LOSINGTHROWS++;
                                System.out.println("~~~~~~~~~~~~~~~~ Bites the SNAKE ~~~~~~~~~~~~");
                                calculatedPosition = calculatePlayerSnakeBitePosition(calculatedPosition,rolldice);
                                System.out.println("Position of the  Player = " + calculatedPosition);
                                System.out.println("----------------------");
                                break;
                        default:
                                break;
                        }
			return calculatedPosition;
                   }while(calculatedPosition != WINPOINT);
        }
		public static void twoPlayerGame() {
		do {
		System.out.print(currentPlayer == -1 ? "\n\n **** First Player Turn ****" : "\n\n **** Second Player Turn ****");
		
		if(currentPlayer == -1) {
			player1 = startGame();
			System.out.println("First Player Values " + player1);
			System.out.println("Second Player Values " + player2);
			System.out.println("------------------------------");
			if(isWin(player1)) {
				System.out.println("First Player Wins  " + player1);
				System.out.println("------------------------------");
				return;
			}
			
		}else {
			player2 = startGame();
			System.out.println("\nFirst Player Values " + player1);
			System.out.println("\nSecond Player Values " + player2);
			System.out.println("------------------------------");
			if(isWin(player2)) {
				System.out.println("\nSecond Player Wins  " + player2);
				System.out.println("------------------------------");
				return;
			}
			
		}
		currentPlayer = -currentPlayer;
		}while(player1 != 100 || player2 != 100);
	}
	public static boolean isWin(int player) {
		return WINPOINT == player;
	}

	 public static int calculatePlayerLadderPosition(int position,int dicevalue) {
                position = position + dicevalue;
                if(position > 100) {
                        position = position - dicevalue;
                }
                else if(position == 100){
                        return position;
                }
                return position;
        }
        public static int calculatePlayerSnakeBitePosition(int position,int dicevalue) {
                position = position - dicevalue;
                if(position < 0) {
                        position = 0;
                }
                return position;
        }

	public static void main(String[] args){
		System.out.println("---------------------- START-----------------------" );

		System.out.println("Player Position At Start: "+ position );
                twoPlayerGame();
		System.out.println("---------------------- END -----------------------" );

		System.out.println("NOPLAY Rolls of Die: " + NOPLAYTHROWS);
                System.out.println("Wining Rolls of Die: " + WININGTHROWS);
                System.out.println("Losing Rolls of Die: " + LOSINGTHROWS);
                System.out.println("Total Number of Die rolls : " + COUNTER);

	}
}
