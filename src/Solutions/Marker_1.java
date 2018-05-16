package Solutions;

/**
 * An enumeration for the tic-tac-toe markers (X and O)
 * @author Sathishkumar T
 */
public enum Marker_1 {
    X ('X'), O('O'), EMPTY(' ');

    private char ch;

    Marker_1(char ch) {
        this.ch = ch;
    }
    
    @Override
    public String toString() {
        return String.format("%c", this.ch);
    }
}
