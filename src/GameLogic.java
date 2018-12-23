import java.io.IOException;

class GameLogic{
    ReadFile file;
    Player[][] games;

    public void compareAllGames() throws IOException {
        int l = 0;
        int n = 0;
        int m = 0;
        file = new ReadFile();
        games = file.fileread();
        for(Player[] game : games){

            int result = game[0].whoWin(game[1]);

            if(result == 1){
                n++;
            }else if(result == 2){
                m++;
            }else if(result == 0){
                l++;
            }
        }
        System.out.println("Player 1 WIN: "+n+" Times");
        System.out.println("Player 2 WIN: "+m+" Times");
        System.out.println("Draws: "+l+" Times");
    }

}