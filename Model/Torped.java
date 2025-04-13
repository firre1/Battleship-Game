package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Klassen för skepp-typen Torped som ger antal liv och båt typen.
 */

public class Torped extends Ships{

    /**
     * Denna metod är klassen konstruktor och den använder sig av superklassens
     * konstruktor (klassen Ships) som ger antalet liv och typen av skepp.
     */
    public Torped(){
        super(2,ShipModel.Torped);
    }
}
