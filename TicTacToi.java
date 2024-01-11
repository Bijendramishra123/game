
import java.util.Scanner;

 class TicTacToe
{
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';
    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        while (true) {
            getPlayerMove();
            displayBoard();
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
            togglePlayer();
        }
    }
    private static void initializeBoard()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    private static void displayBoard()
    {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }
    private static void getPlayerMove()
    {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do
        {
            System.out.print("Player " + currentPlayer + ", enter row (1-3) and column (1-3) separated by space: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!isValidMove(row, col));

        board[row][col] = currentPlayer;
    }
    private static boolean isValidMove(int row, int col)
    {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ')
        {
            System.out.println("bhai Block bhele se bhara hua hai ");
            return false;
        }
        return true;
    }
    private static boolean checkWin()
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)
                return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
            return true;
        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }
    private static boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == ' ')
                {
                    return false;
                }
            }
        }
        return true;
    }
    private static void togglePlayer()
    {
        if (currentPlayer == 'X')
        {
            currentPlayer = 'O';
        }
        else
        {
            currentPlayer = 'X';
        }
    }
}
