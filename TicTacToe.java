import java.util.Scanner;

public class TicTacToe{

    public static void main(String[] args) {
        
        // Board 2D array
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

        // Displaying the board
        printGameBoard(gameBoard);

        // Getting the position of an X or O from the user
        Scanner posObj = new Scanner(System.in);
        System.out.println("Enter your placement (1-9): ");
        int pos = posObj.nextInt();   

        System.out.println(pos);

        placePiece(gameBoard, pos, null);

        printGameBoard(gameBoard);

    }


        // ============================================================
        // Board display
        // ============================================================
        public static void printGameBoard(char[][] gameBoard){

        
            for(char[] r: gameBoard){

                for(char c: r){

                    System.out.print(c);

                }
                
                System.out.println();
            }

        }

        // ============================================================
        // X and O positioning
        // ============================================================
        public static void placePiece(char[][] gameBoard, int pos, String user){

            switch(pos){
                case 1:
                    gameBoard[0][0] = 'X';
                    break;
                case 2:
                    gameBoard[0][2] = 'X';
                    break;
                case 3:
                    gameBoard[0][4] = 'X';
                    break;
                case 4:
                    gameBoard[2][0] = 'X';
                    break;
                case 5:
                    gameBoard[2][2] = 'X';
                    break;
                case 6:
                    gameBoard[2][4] = 'X';
                    break;
                case 7:
                    gameBoard[4][0] = 'X';
                    break;
                case 8:
                    gameBoard[4][2] = 'X';
                    break;
                case 9:
                    gameBoard[4][4] = 'X';
                    break;
            }

        

    }

}