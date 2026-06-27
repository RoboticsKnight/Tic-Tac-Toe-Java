import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe{

    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {
        
        // Board 2D array
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '},
        {'-', '+', '-', '+', '-'},
        {' ', '|', ' ', '|', ' '}};

        // Displaying the board
        printGameBoard(gameBoard);


        while(true){

            // Getting the position of an X or O from the user
            Scanner posObj = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = posObj.nextInt();   

            // Checking if the player has chosen a free space, if not they are asked to choose a new space until a valid space is chosen
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){

                System.out.println("Position taken! Enter a valid position (1-9): ");
                playerPos = posObj.nextInt();

            }

            //System.out.println(playerPos);

            placePiece(gameBoard, playerPos, "player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;

            // Checking if the CPU has chosen a free space, if not it is made to generate a new number until a valid space is chosen
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){

                cpuPos = rand.nextInt(9) + 1;

            }

            placePiece(gameBoard, cpuPos, "cpu");

            printGameBoard(gameBoard);

            String result = checkWinner();

            System.out.println(result);
        }


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

            char symbol = ' ';

            if(user.equals("player")){

                symbol = 'X';
                playerPositions.add(pos);

            }
            else if(user.equals("cpu")){

                symbol = 'O';
                cpuPositions.add(pos);

            }

            switch(pos){
                case 1:
                    gameBoard[0][0] = symbol;
                    break;
                case 2:
                    gameBoard[0][2] = symbol;
                    break;
                case 3:
                    gameBoard[0][4] = symbol;
                    break;
                case 4:
                    gameBoard[2][0] = symbol;
                    break;
                case 5:
                    gameBoard[2][2] = symbol;
                    break;
                case 6:
                    gameBoard[2][4] = symbol;
                    break;
                case 7:
                    gameBoard[4][0] = symbol;
                    break;
                case 8:
                    gameBoard[4][2] = symbol;
                    break;
                case 9:
                    gameBoard[4][4] = symbol;
                    break;
                default:
                    break;

            }

        

    }


    // ============================================================
    // Checking win conditions
    // ============================================================
    public static String checkWinner(){

        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List diag1 = Arrays.asList(1, 5, 9);
        List diag2 = Arrays.asList(7, 5, 3);
        
        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(diag1);
        winning.add(diag2);

        for(List l: winning){

            if(playerPositions.containsAll(l)){

                return "Congratulations you won!";

            }
            else if(cpuPositions.containsAll(l)){

                return "CPU wins! Better luck next time.";

            }
            else if(playerPositions.size() + cpuPositions.size() == 9){

                return "It is a tie!";

            }

        }

        return "";

    }

}