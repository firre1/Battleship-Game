package Model;;

import java.io.*;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Denna klassen sparar alla spelare som vunnit och skriver de till textfilen.
 */

public class Highscore {

    private Player[] list;
    private String hsfile = "U4/files/HighScore.txt";
    private int players;

    /**
     * Denna metod är konstruktorn och här skapas det en array med
     * Player objekt. Dessutom initialiseras instansvariabeln player för
     * att hålla koll på antalet spelare.
     */
        public Highscore(){
            list = new Player[50];
            players = 0;
            readFile();
        }

    /**
     * Metoden lägger till en spelare i highscore listan.
     * Finns det plats i listan, läggs spelaren in i listan.
     * Listan sorteras och sedan skrivs det till textfilen.
     * @param player spelaren som ska läggas in i highscore listan.
     */
        public void addPlayer(Player player) {
            if (players < list.length) {
                list[players] = player;
                players++;
                sortList();
                writeFile();
            }
        }

    /**
     * Denna metoden sorterar arrayen med Insertion sort algoritmen.
     * Algoritmen delar upp arrayen i två intervall där ett är sorterat och ett är osorterat.
     * Det första elementet i den osorterade delen tas och flyttas ”bakåt” i den sorterade delen
     * tills det ligger på rätt plats i förhållande till de redan sorterade elementen.
     */
        public void sortList() {
            for (int i = 1; i < players && i < list.length; i++) {
                //Början på den sorterade delen
                Player player = list[i];
                int j = i - 1;
                while (j >= 0 && list[j].getScore() > player.getScore()) {
                    list[j + 1] = list[j];
                    j--;
                }
                list[j + 1] = player;
            }
        }

    /**
     * Läser highscore textfilen och för varje rad som har formatet,
     * "name: score" delas den raden upp där det uppkommer ":" i två delar.
     * Dem två delarna sparas till variabler som sedan det skapas spelar objekt av.
     * Spelar objekten läggs sedan in i highscore listan.
     */
        public void readFile() {
            try (BufferedReader br = new BufferedReader(new FileReader(hsfile))) {
                players = 0;
                String line;
                while ((line = br.readLine()) != null) {
                    String[] readPlayer = line.split(": ");
                    if (readPlayer.length == 2) {
                        String name = readPlayer[0];
                        int score = Integer.parseInt(readPlayer[1]);
                        Player player = new Player(name, score);
                        addPlayer(player);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    /**
     * Denna metod skriver ut listan med alla spelare till text filen.
     * Den skriver bara ut de tio bästa resultat.
     * För varje plats i listan som är tom skriver den inte ut något.
      */
        public void writeFile(){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(hsfile))){
                for (int i = 0; i < 10; i++){
                    if (list[i] != null){
                        bw.write(list[i].toString());
                    }
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
}
