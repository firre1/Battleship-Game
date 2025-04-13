package View;

import Controller.Controller;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.*;

public class LeftPanel extends JPanel {

    private Controller controller;
    private JList<String> list;
    private DefaultListModel<String> model;

        public LeftPanel(Controller controller){
            this.controller = controller;
            setupPanel();
        }

        public void setupPanel(){
            setBorder(BorderFactory.createTitledBorder("HighScores"));
            BorderLayout layout = new BorderLayout();
            setLayout(layout);
            Border border = this.getBorder();
            Border margin = BorderFactory.createEmptyBorder(6,6,6,6);
            setBorder(new CompoundBorder(border,margin));
            setPreferredSize(new Dimension(300,350));
            //setBackground(Color.CYAN);

            list = new JList();
            model = new DefaultListModel<>();
            list.setModel(model);
            JScrollPane scrollPane = new JScrollPane(list);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            try {
                readFile();
            } catch (IOException e){
                e.printStackTrace();
            }
            add(scrollPane, BorderLayout.CENTER);
        }

        public void readFile() throws IOException{
            try (BufferedReader br = new BufferedReader(new FileReader("U4/files/HighScore.txt"))) {
                model.clear();
                String line;
                while ((line = br.readLine()) != null) {
                    model.addElement(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}