package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Denna abstrakta klassen ärvs av alla skepp-typer.
 * Denna klassens konstruktor används för att ge liv och skepp-typer
 * till skeppen.
 */

public abstract class Ships{

    private int HP;
    private ShipModel shipmodel;

    /**
     * Klassens konstruktor som ger liv och model till de olika skepp-typerna.
     * @param hp parametern används för att initialisera skeppens liv.
     * @param shipmodel parametern används för att initialisera skeppens typ.
     */
        public Ships(int hp,ShipModel shipmodel){
            this.HP = hp;
            this.shipmodel = shipmodel;
        }

    /**
     * En getter metod som används för att få skeppens liv.
     * @return det är skeppens liv som returneras.
     */
        public int getHP(){
            return HP;
        }

    /**
     * En setter metod som sätter skeppens liv.
     * @param hp parametern används för att ge ett nytt värde på skeppets liv.
     */
        public void setHP(int hp){
            this.HP = hp;
        }

    /**
     * Denna toString metod formaterar skeppets typ till en sträng som
     * kan returneras. "%s" används för att ge instansvariabeln som argument
     * så att en sträng kan skapas.
     * @return den skapade stringen returneras sedan, vilket är vilken typ av skepp det är.
     */
        public String toString(){
            return String.format("%s ",shipmodel);
        }
}
