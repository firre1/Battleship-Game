package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Klassen för skepp-typen Ubåt som ger antal liv och båt typen.
 */

public class Ubot extends Ships{

    /**
     * Denna metod är klassen konstruktor och den använder sig av superklassens
     * konstruktor (klassen Ships) som ger antalet liv och typen av skepp.
     */
    public Ubot(){
        super(1,ShipModel.Ubot);
    }
}
