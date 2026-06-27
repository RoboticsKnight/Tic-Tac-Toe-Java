public class TicTacToe{

    public static void main(String[] args) {
        
        // Board 2D array
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

        // ============================================================
        // Board display
        // ============================================================
        for(char[] r: gameBoard){

            for(char c: r){

                System.out.print(c);

            }
            
            System.out.println();


        }

    }

}