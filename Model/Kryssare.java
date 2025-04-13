package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Klassen för skepp-typen Kryssare som ger antal liv och båt typen.
 */

public class Kryssare extends Ships{

    /**
     * Denna metod är klassen konstruktor och den använder sig av superklassens
     * konstruktor (klassen Ships) som ger antalet liv och typen av skepp.
     */
    public Kryssare(){
        super(4,ShipModel.Kryssare);
    }

}
