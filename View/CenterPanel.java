package View;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CenterPanel extends JPanel implements ActionListener {

    private JButton[][] buttons;
    private Controller controller;

        public CenterPanel(Controller controller){
            this.controller = controller;
            buttons = new JButton[10][10];
            newButtons();
        }

        public void newButtons(){
            setBorder(BorderFactory.createTitledBorder("The Game"));
            GridLayout layout = new GridLayout(10,10,1,1);
            ActionListener listener = this::actionPerformed;
            setLayout(layout);
            for (int y = 0; y < 10; y++){
                for (int x = 0; x < 10; x++){
                    buttons[y][x] = new JButton(" ");
                    add(buttons[y][x]);
                    buttons[y][x].addActionListener(listener);
                }
            }
            setBackground(Color.CYAN);
        }

        public void restart(){
            for (int y = 0; y < 10; y++){
                for (int x = 0; x < 10; x++){
                    buttons[y][x].setEnabled(true);
                    buttons[y][x].setText(" ");
                }
            }
        }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource();
            for (int y = 0; y < 10; y++){
                for (int x = 0; x < 10; x++){
                    if (buttons[y][x].equals(button)){
                        buttons[y][x].setEnabled(false);
                        if (controller.shoot(y,x)){
                            buttons[y][x].setText("X");
                        }
                        break;
                    }
                }
            }
            controller.FinishedGame();
        }

}