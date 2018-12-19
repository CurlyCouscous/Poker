import java.io.*;
import java.util.Scanner;

public class ReadFile {

    //    FileReader filereader = new FileReader("D:\\Projects\\java\\euler\\Poker\\src\\poker.txt");
    //    BufferedReader bufferreader = new BufferedReader(filereader);
    Scanner myScanner = new Scanner(new File("C:\\poker.txt" ));


    public Player[][] fileread() throws IOException {
        int k = 0;
        Player [][] allCards = new Player[1000][2];

        while ( myScanner.hasNextLine()){
            int n = 0;
            String line = myScanner.nextLine();
            Player[] player_cards = new Player[2];
            // "AK" "3K"
            for (int i=0; i<2 ; i++) {
                String[] cards = new String[5];
                for(int j = 0 ; j < 5 ; j++){
                    cards[j] = "";
                    do{
                        cards[j] += line.charAt(n);
                        n++;
                    }while(n != line.length() && line.charAt(n) != ' ');
                    n++;
                }
                player_cards[i] = new Player(cards);
            }
            allCards[k] = player_cards;
            k++;
        }
        System.out.println("WCZYTANO");
        return allCards;
    }



    public ReadFile() throws IOException {
    }
}