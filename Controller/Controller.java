package Controller;

import Model.*;
import View.*;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Detta är controller klassen som har uppgiften för allt det logiska som sker.
 * Denna klassen kommunicerar med klasserna från paketet Model och View.
 */
public class Controller {

    private MainFrame mainframe;
    private Gameboard gameboard;
    private Player player;
    private int shots;
    private int ShipHP;
    private Highscore highscore;

    /**
     * Denna metod är klassen konstruktor den initialiserar instansvariablerna
     * "mainframe" och "highscore" sedan startas spelet.
     */
        public Controller(){
            mainframe = new MainFrame(this);
            highscore = new Highscore();
            NewGame();
        }

    /**
     * Denna metod används för att kunna visa ett meddelande till spelaren.
      * @param message parameterns värde motsvarar meddelandet som visas.
     */
        public void getMessage(String message){
            mainframe.getMessage(message);
        }

    /**
     * Denna metoden kollar om det blev en "hit" eller "miss".
     * Om det blev en träff sätts variabeln "hitormiss" till true.
     * Om det blev en miss sätts variabeln "hitormiss" till false.
     * Ett metodanrop görs till "IncShots" efter varje skott.
     * @param x en axel som utgör ett koordinatsystem med parametern y.
     * @param y en axel som utgör ett koordinatsystem med parametern x.
     * @return det som returneras är variabeln "hitormiss".
     */
        public boolean shoot(int x, int y){
            boolean hitormiss;
            if (gameboard.shoot(x,y)){
                hitormiss = true;
            } else{
                hitormiss = false;
            }
            IncShots();
            return hitormiss;
        }

    /**
     * Denna metoden inkrementerar instansvariabeln shots för att hålla koll
     * på antal skjutna skott. Dessutom sätter denna metoden också skeppens
     * totala antal liv. Både liven och skotten skickas som parametrar till
     * metoder i klassen MainFrame.
     */
        public void IncShots(){
            ShipHP = gameboard.getHPships();
            this.shots++;
            mainframe.IncShots(shots);
            mainframe.ShotsLeft(ShipHP);
        }

    /**
     * Denna metod skapar ett spel.
     * Här frågas spelaren om namnet och val av spelplan.
     * En ny spelplan skapas beroende på valet.
     * En ny spelar profil skapas.
     */
        public void NewGame(){
            boolean ok = true;
            int board = 0;
            String name = " ";
            while (ok){
                try{
                   String choice = mainframe.setMessage("Choose a game board between 1 or 2");
                   board = Integer.parseInt(choice);
                   if (board == 1 || board == 2){
                       name = mainframe.setMessage("Btw, What's your name?");
                       ok = false;
                   } else{
                       mainframe.getMessage("Try to choose a number between 1 or 2!");
                   }
                } catch (Exception e){}
            }
            gameboard = new Gameboard(board,this);
            shots = 0;
            player = new Player(name,0);
            mainframe.setName(name);
            mainframe.restart();

        }

    /**
     * Här kollas det om spelaren har vunnit eller inte.
     * Om spelaren har vunnit får man upp ett meddelande, poäng tilldelas
     * till spelaren och spelaren läggs till i highscore listan. Slutligen
     * startas det en ny spelomgång.
     */
        public void FinishedGame(){
            boolean finished = gameboard.FinishedGame();
            if (finished){
                mainframe.getMessage("Good Job "+ player.getName() +" Won!");
                player.setScore(shots);
                highscore.addPlayer(player);
                NewGame();
            }
        }

}
