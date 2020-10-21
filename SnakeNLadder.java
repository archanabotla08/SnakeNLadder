import java.util.Random;
public class SnakeNLadder{
	public static int position = 0;
	int player1 = 0;
	 public static int rolldice(int number) {
                int n = 0;
                Random r = new Random();
                n=r.nextInt(number);
                return (n==0?1:n);
        }
	public static void main(String[] args){
		 int rolldice = rolldice(7);
		System.out.println("Roll Dice Value: " + rolldice);
	}
}
