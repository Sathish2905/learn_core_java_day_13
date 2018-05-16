package Solutions;

/**
 * Tic-Tac-Toe Board
 * @author Sathishkumar T
 */
public class Board_1 {
    
    private Marker_1[][] board;
    
    /**
     * Initializes a new Tic-Tac-Toe board (which is a 2-d array 
     * of Marker_1s (X, O, or EMPTY)
     */
    public Board_1(){
        board = new Marker_1[3][3];
        this.Clear();
    }
    
    /**
     * Initializes a new Tic-Tac-Toe board using the given array 
     * @param board the 2d array for the board
     */
    public Board_1(Marker_1[][] board) {
        this.board = board;
    }
    
    /**
     * Erases the board, called with the constructor of the class.
     */
    public final void Clear() {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                board[i][j] = Marker_1.EMPTY;
            }
        }
    }
    
    /**
     * Draws the current state of the board to System.out
     */
    public void Draw() {
        System.out.printf("\n  0 1 2\n");
        for (int i=0;i<3;i++) {
            System.out.printf("%d ",i);
            for (int j=0;j<3;j++) {
                if (j<2) {
                    System.out.printf("%s|",board[i][j]);
                } else {
                    System.out.printf("%s",board[i][j]);                
                }
            }
            System.out.printf("\n");
            if (i<2) System.out.printf("  -+-+-\n");
        }
        System.out.println();
    }
    
    /**
     * Places the marker on the board at position row and column
     * @param marker the marker to place (X or O)
     * @param row the row (0, 1 or 2)
     * @param column the column (0,1 or 2)
     * @return true if the marker was placed
     */
    public boolean Place(Marker_1 marker, int row, int column) {
        if (this.board[row][column] == Marker_1.EMPTY) {
            this.board[row][column] = marker;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns the marker of the winner Marker_1.Empty implies no winner
     * @return the winning marker
     */
    public boolean Winner(Marker_1 marker) {
        /* TODO: Check for winner (same marker) in row, colum and on the angles.
         * 
         * HINT: you can write this method with just logical and(&&) and or(&&) 
         *       in fact there are a couple of ways you can write this method. 
         *       I provide some boilerplate code for my approach, but you are 
         *       not obligated to do it this way.
         */ 
        boolean rowWinner = false;
        boolean colWinner = false;
        boolean angleWinner = false;
        
        // TODO: Check three in a row (rowWinner)
        rowWinner = (board[0][0] == marker && board[0][1] == marker && board[0][2] == marker) ||
                    (board[1][0] == marker && board[1][1] == marker && board[1][2] == marker) ||
                    (board[2][0] == marker && board[2][1] == marker && board[2][2] == marker);
        
        // TODO: Check three in a column (colWinner)
        colWinner = (board[0][0] == marker && board[1][0] == marker && board[2][0] == marker) ||
                    (board[0][1] == marker && board[1][1] == marker && board[2][1] == marker) ||
                    (board[0][2] == marker && board[1][2] == marker && board[2][2] == marker);

        
        // TODO: Check the angles (angleWinner)
        angleWinner = (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                      (board[2][0] == marker && board[1][1] == marker && board[0][2] == marker);                            
                

        // We have a winner if we have a row, column or angle winner
        return rowWinner || colWinner || angleWinner;
        
    }
    
    /**
     * Detects when the board is full (no more Marker_1.EMPTY on the board)
     * @return true when full, false otherwise
     */
    public boolean Full() {
        // TODO: Implement this method
        int emptyCount = 0;
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (this.board[i][j] == Marker_1.EMPTY) {
                    emptyCount++;
                }                    
            }
        }
        return (emptyCount==0);
    }
 
}
