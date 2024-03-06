package CS_271_ASSIGNMENT_2;
import java.util.Scanner;
import static java.lang.System.exit;
/*
    This program runs a lottery numbers 0 - 5. There can be more than 1 lottery winner.
    If there is more than 1 winner, then the prize pool of $4000 gets split up between
    the winners. If there is 1 winner that person gets the entire $4000. If no numbers
    are put in the lottery bag, the program will terminate right away and no random number
    will get generated as there is no point because there are no potential winners.
 */
public class Lottery {
    public static void main(String[] args) {

        Bag bag = new Bag();


        Scanner sc = new Scanner(System.in);
        int lotteryChoice = 0;

        System.out.println("ENTER A LOTTERY NUMBER (0 - 5) OR -1 TO TERMINATE");
        System.out.println();

        while(lotteryChoice != -1) {
            System.out.print("ENTER LOTTERY #: ");
            lotteryChoice = sc.nextInt();

            if(lotteryChoice != -1) {
                bag.add(lotteryChoice);
            }
        }

        if(bag.IsEmpty()) {
            System.out.println("END OF GAME: NO LOTTERY NUMBERS IN BAG");
            exit(0);
        }

        int randomNumber = (int) (Math.random() * (5 + 1)); // LOTTERY BETWEEN 0 - 5
        int winnerCount = bag.occurrence(randomNumber);

        if(bag.contains(randomNumber)) {
            System.out.println("THERE IS " + winnerCount + " WINNER(S)");
            System.out.println("THE PRIZE BETWEEN WINNER(S) IS: $" +
                    4000.00 / winnerCount);
        }
        else {
            System.out.println("NO WINNERS IN THIS LOTTERY");
            exit(0);
        }
    }
}