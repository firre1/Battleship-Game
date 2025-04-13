package View;

import Controller.Controller;
import javax.swing.*;

public class MainFrame extends JFrame{

    private Controller controller;
    private MainPanel mainpanel;

        public MainFrame(Controller controller){
            this.controller = controller;
            setupFrame();
        }

        public void setupFrame(){
            setSize(1050,350);
            setTitle("Sänka Skepp!");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(150,250);

            mainpanel = new MainPanel(controller, 1050,350);
            setContentPane(mainpanel);
            setResizable(false);
            //pack();

            setVisible(true);
        }

        public void IncShots(int shots){
            mainpanel.IncShots(shots);
        }

        public void setName(String name){
            mainpanel.setName(name);
        }

        public void ShotsLeft(int shots){
            mainpanel.ShotsLeft(shots);
        }

        public void restart(){
            mainpanel.restart();
        }

        public void getMessage(String message){
            JOptionPane.showMessageDialog(this,message);
        }

        public String setMessage(String message){
            return JOptionPane.showInputDialog(this,message);
        }
}