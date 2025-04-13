package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RightPanel extends JPanel {
    private Controller controller;
    private JLabel name;
    private JLabel shotsleft;
    private JLabel totshots;
    private JButton restart;
    public RightPanel(Controller controller){
        this.controller = controller;
        setupPanel();
    }

    public void setupPanel(){
        setBorder(BorderFactory.createTitledBorder("Game info"));
        BorderLayout layout = new BorderLayout();
        setLayout(layout);
        Border border = this.getBorder();
        Border margin = BorderFactory.createEmptyBorder(6,6,6,6);
        setBorder(new CompoundBorder(border,margin));
        setPreferredSize(new Dimension(250,350));

        GridLayout gridLayout = new GridLayout(4,1);
        JPanel labelpanel = new JPanel(gridLayout);

        name = new JLabel("Name: ");
        totshots = new JLabel("Total shots fired: 0");
        shotsleft = new JLabel("Number of shots needed: 15");
        labelpanel.add(name);
        labelpanel.add(totshots);
        labelpanel.add(shotsleft);
        add(labelpanel,BorderLayout.WEST);

        ActionListener listener = new ButtonListener();
        restart = new JButton("Restart");
        restart.addActionListener(listener);
        labelpanel.add(restart);
        //setBackground(Color.CYAN);
    }

    public void IncShots(int shots){
        totshots.setText("Total shots fired: " + shots);
    }

    public void ShotsLeft(int shots){
        shotsleft.setText("Number of shots needed: " + shots);
    }

    public void setName(String name){
        this.name.setText("Name: " + name);
    }

    private class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            controller.NewGame();
        }
    }

}
