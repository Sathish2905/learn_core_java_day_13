/** Challenge Activity 2 - complete the Tic-Tac-Toe game!
 *
 * It's time to complete the tic tac toe game. Here's what you must do:
 *
 *  In Board_1.java:
 *  - Implement the Full() method to detect when the board has no more empty spaces.
 *
 *  Main()
 *  - Write main game loop. Here's the logic:
 *
 *  while true:
 *      draw board
 *      get row and column as input for current player
 *      place a marker of the curren player at input row and col
 *      check for winner
 *      if winner or board full exit loop
 *      switch current player
 *
 *      After loop:
 *      draw board one more time
 *      display status (winner or tie)
 *
 *
 *  SAMPLE RUN:
 *  The best way to see a sample run it to open the solution file and execute it.
 *  (no peeking at the code!!!! vbg)
 *
 */
package Solutions;

import java.util.Scanner;

/**
 *
 * @author Sathishkumar T
 */
public class TicTacToeGameRun {

    public static void main(String[] args) {
        Board_1 b = new Board_1();
        int row, col;
        boolean winner = false;
        Scanner input = new Scanner(System.in);
        Marker_1 currentPlayer = Marker_1.X;
        System.out.printf("Let's Play Tic-Tac-Toe!!!\n\n");
        while (true) {

            // Draw Board_1
            b.Draw();

            // Get input for row and column
            System.out.printf("%s's turn! Enter Row : ", currentPlayer);
            row = input.nextInt();
            System.out.printf("%s's turn! Enter Col : ", currentPlayer);
            col = input.nextInt();

            // place marker of current player on board at row and col            
            b.Place(currentPlayer, row, col);

            // check for winner, 
            winner = b.Winner(currentPlayer);

            // exit loop if winner or board full
            if (winner || b.Full()) {
                break;
            }

            // Switch Players
            currentPlayer = currentPlayer == Marker_1.X ? Marker_1.O : Marker_1.X;
        }

        b.Draw();
        // check again for winner, if not it's a tie.
        if (winner) {
            System.out.printf("GAME OVER. %s WINS!\n", currentPlayer);
        } else {
            System.out.printf("GAME OVER. It's a TIE!\n");
        }

    }
}
