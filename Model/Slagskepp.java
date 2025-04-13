package Model;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Klassen för skepp-typen Slagskepp som ger antal liv och båt typen.
 */

public class Slagskepp extends Ships{

    /**
     * Denna metod är klassen konstruktor och den använder sig av superklassens
     * konstruktor (klassen Ships) som ger antalet liv och typen av skepp.
     */
    public Slagskepp(){
        super(5,ShipModel.Slagskepp);
    }

}
