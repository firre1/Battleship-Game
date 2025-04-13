package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.IOException;

public class MainPanel extends JPanel{

    private Controller controller;
    private int width;
    private int height;
    private BorderLayout layout;
    private CenterPanel centerpanel;
    private LeftPanel leftpanel;
    private RightPanel rightpanel;

        public MainPanel(Controller controller, int width, int height){
            this.controller = controller;
            this.width = width;
            this.height = height;
            setupPanel();
        }

        public void setupPanel(){
            layout = new BorderLayout();
            setLayout(layout);

            Border border = this.getBorder();
            Border margin = BorderFactory.createEmptyBorder(6,6,6,6);
            setBorder(new CompoundBorder(border,margin));
            //setBackground(Color.BLUE);

            centerpanel = new CenterPanel(controller);
            add(centerpanel, layout.CENTER);

            leftpanel = new LeftPanel(controller);
            add(leftpanel, layout.WEST);

            rightpanel = new RightPanel(controller);
            add(rightpanel, layout.EAST);

        }

        public void restart(){
            int shots = 0;
            int shotsleft = 15;
            rightpanel.IncShots(shots);
            rightpanel.ShotsLeft(shotsleft);
            centerpanel.restart();
            try {
                leftpanel.readFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        public void IncShots(int shots){
            rightpanel.IncShots(shots);
        }

        public void ShotsLeft(int shots){
            rightpanel.ShotsLeft(shots);
        }

        public void setName(String name){
            rightpanel.setName(name);
        }

}