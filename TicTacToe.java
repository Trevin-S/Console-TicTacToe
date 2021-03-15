public class TicTacToe
{

    private String[][] board = new String[3][3];
    private int turn;
    
    public TicTacToe(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = "-";
            }
        }
    }
    
    public String[][] getBoard(){
        return board;
    }
   
   //this method returns the current turn
   public int getTurn()
   {
       return turn;
   }
   
   /*This method prints out the board array on to the console
   */
   public void printBoard()
   {
       System.out.println("  0 1 2");
       for (int i = 0; i < board.length; i++){
           System.out.print(i + " ");
           for (int j = 0; j < board.length; j++){
               System.out.print(board[i][j] + " ");
           }
           System.out.println();
       }
   }
   
   //This method returns true if space row, col is a valid space
   public boolean pickLocation(int row, int col)
   {
       if (board[row][col].equals("-")){
           return true;
       } 
       return false;
   }
   
   //This method places an X or O at location row,col based on the int turn
   public void takeTurn(int row, int col)
   {
        if (turn % 2 == 0){
            board[row][col] = "X";
        } else {
            board[row][col] = "O";
        }
        turn++;
   }
   
   //This method returns a boolean that returns true if a row has three X or O's in a row
   public boolean checkRow()
   {
        String[] row = new String[3];
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                row[j] = board[i][j];
            }
            if (!row[0].equals("-") && row[0].equals(row[1]) && row[1].equals(row[2])){
                return true;
            }
        }
        
        return false;
   }

    //This method returns a boolean that returns true if a col has three X or O's
   public boolean checkCol()
   {
        String[] col = new String[3];
        
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < board[i].length; j++){
                col[j] = board[j][i];
            }
            if (!col[0].equals("-") && col[0].equals(col[1]) && col[1].equals(col[2])){
                return true;
            }
        }
        return false;
   }
   
    //This method returns a boolean that returns true if either diagonal has three X or O's
   public boolean checkDiag()
   {
       String cornerTL = board[0][0];
       String cornerTR = board[0][2];
       
       
       if (!cornerTL.equals("-") && board[1][1].equals(cornerTL)){
           if (board[2][2].equals(cornerTL)){
               return true;
           }
       } else if (!cornerTR.equals("-") && board[1][1].equals(cornerTR)){
            if (board[2][0].equals(cornerTR)){
               return true;
           }
       }
    return false;
   }
   
   //This method returns a boolean that checks if someone has won the game
   public boolean checkWin()
   {
       return checkCol() || checkRow() || checkDiag();
   }

}
