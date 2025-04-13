package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Klassen för skepp-typen Jagare som ger antal liv och båt typen.
 */

public class Jagare extends Ships{

    /**
     * Denna metod är klassen konstruktor och den använder sig av superklassens
     * konstruktor (klassen Ships) som ger antalet liv och typen av skepp.
     */
    public Jagare(){
        super(3,ShipModel.Jagare);
    }

}
