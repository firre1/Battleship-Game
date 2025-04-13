package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Denna klassen skapar en spelare med namn och antal poäng.
 *
 */

public class Player {

    private String name;
    private int score;

    /**
     * Klassen konstruktor som initialiserar spelaren namn och poäng.
     * @param name används för att kunna sätta ett namn på spelaren.
     * @param score används för att kunna tilldela poäng till spelaren.
     */
        public Player(String name, int score){
            this.name = name;
            this.score = score;
        }

    /**
     * En getter metod för att få namnet på spelaren som spelar.
      * @return det är namnet på spelaren som returneras.
     */
        public String getName(){
            return name;
        }

    /**
     * En setter metod som sätter ett namn på spelaren som spelar.
     * @param name , används för att kunna initialisera instansvariabeln med spelarens namn.
     */
        public void setName(String name){
            this.name = name;
        }

    /**
     * En getter metod för att få spelarens poäng.
     * @return det är spelarens poäng som returneras.
     */
        public int getScore(){
            return score;
        }
    /**
     * En setter metod som tilldelar poäng till den spelande spelaren.
     * @param score , används för att kunna initialisera instansvariabeln med spelarens poäng.
     */
        public void setScore(int score){
            this.score = score;
        }

    /**
     * En toString metod som returnerar spelarens info.
     * @return En sträng som returneras med spelarens namn och poäng.
     */
        public String toString(){
            return name + ": " + score + "\n";
        }
}
