package Model;

import Controller.Controller;

/**
 * @author Firoz Akbari & Bilal Ayubi
 * Denna klassen skapar spelplanerna och kollar om det finns en skepp på
 * den angivna platsen.
 */

public class Gameboard {

    private Ships[][] ships;
    private int HPships;
    private Controller controller;

    /**
     * Detta är konstruktorn, den sätter storleken på spelplanen och väljer även
     * vilken spelplan som används.
     * @param gameboard Denna parametern väljer spelplan 1 eller 2.
     * @param controller Denna parameter initialiserar instans variabeln controller.
     */
        public Gameboard(int gameboard, Controller controller){
            ships = new Ships[10][10];
            this.controller = controller;
            if (gameboard == 1){
                gameboard1();
            } else if (gameboard == 2) {
                gameboard2();
            } else{
                controller.getMessage("Pick a number between 1 or 2!");
            }
        }

    /**
     * Denna metod initialiserar den 2D array som skapas i konstruktorn d.v.s
     * den skapar spelplan 1.
      */
        public void gameboard1(){
            Ubot ubot = new Ubot();
            Torped torped = new Torped();
            Jagare jagare = new Jagare();
            Kryssare kryssare = new Kryssare();
            Slagskepp slagskepp = new Slagskepp();
            HPships = 15;

            ships[0][0] = ubot;

            ships[8][0] = torped;
            ships[9][0] = torped;

            ships[2][2] = jagare;
            ships[2][3] = jagare;
            ships[2][4] = jagare;

            ships[3][7] = kryssare;
            ships[4][7] = kryssare;
            ships[5][7] = kryssare;
            ships[6][7] = kryssare;

            ships[9][3] = slagskepp;
            ships[9][4] = slagskepp;
            ships[9][5] = slagskepp;
            ships[9][6] = slagskepp;
            ships[9][7] = slagskepp;
        }

    /**
     * Denna metod initialiserar den 2D array som skapas i konstruktorn d.v.s
     * den skapar spelplan 2.
     */
        public void gameboard2(){
            Ubot ubot = new Ubot();
            Torped torped = new Torped();
            Jagare jagare = new Jagare();
            Kryssare kryssare = new Kryssare();
            Slagskepp slagskepp = new Slagskepp();
            HPships = 15;

            ships[0][0] = ubot;

            ships[0][8] = torped;
            ships[0][9] = torped;

            ships[2][2] = jagare;
            ships[3][2] = jagare;
            ships[4][2] = jagare;

            ships[7][3] = kryssare;
            ships[7][4] = kryssare;
            ships[7][5] = kryssare;
            ships[7][6] = kryssare;

            ships[3][9] = slagskepp;
            ships[4][9] = slagskepp;
            ships[5][9] = slagskepp;
            ships[6][9] = slagskepp;
            ships[7][9] = slagskepp;
        }

    /**
     * Denna metoden kollar om det finns ett skepp på de angivna koordinaterna.
     * Om det finns ett skepp då ska de skeppet tappa ett liv och ett meddelande
     * om vilket skepp som träffades ska visas. Om skeppet har mindre liv än 1
     * då ska skeppet sänkas och ett meddelande om att skeppet har sänkts visas.
     * @param x en axel som utgör ett koordinatsystem med parametern y.
     * @param y en axel som utgör ett koordinatsystem med parametern x.
     * @return returnerar sant om det blev en träff, falskt om inte.
     */

        public boolean shoot(int x, int y){
            if (ships[y][x] != null){
                ships[y][x].setHP(ships[y][x].getHP() -1);
                String ship = ships[y][x].toString();
                controller.getMessage("Nice, you hit a: " + ship);
                HPships--;
                if (ships[y][x].getHP() < 1){
                    SankShip(ship);
                    return true;
                }
                return true;
            }
            return false;
        }

    /**
     * En metod som visar ett meddelande om ett skepp som har sänkts.
      * @param ship denna parametern berättar om vilket skepp det var som sänktes.
     */

        public void SankShip(String ship){
            controller.getMessage("Congrats, you sank a: " + ship);
        }

    /**
     * En getter-metod för antalet liv som skeppen har tillsammans.
      * @return returnerar instansvariabeln "HPships" som är skeppens totala liv.
     */
        public int getHPships(){
            return HPships;
        }

    /**
     * Denna metoden är till för att se när skeppens totala liv blir noll.
      * @return När skeppens totala liv blir 0 ska det returneras true om inte
     * ska det returneras falskt.
     */
        public boolean FinishedGame(){
            if (HPships == 0){
                return true;
            } else{
                return false;
            }
        }
}
