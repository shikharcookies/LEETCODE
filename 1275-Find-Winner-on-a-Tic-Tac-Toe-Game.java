class Solution {
    public String tictactoe(int[][] moves) {
        int[] row = new int[3];
        int[] col = new int[3];

        int diag=0, antiDiag=0;

        for(int i=0;i<moves.length;i++)
        {
            int r= moves[i][0];
            int c= moves[i][1];
            if(i%2==0)
            {
                row[r]++;
                col[c]++;
                if(r==c)diag++;
                if(r+c==2)antiDiag++;

                if(row[r]==3 || col[c]==3 || diag == 3 || antiDiag == 3 )
                {
                    return "A";
                }
            }
            else
            {
               row[r]--;
               col[c]--;
               if(r==c)diag--;
               if(r+c==2)antiDiag--;

               if(row[r]== -3 || col[c] == -3 || diag ==-3 || antiDiag == -3)
               {
                return "B";
               }
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}