package uk.ac.leedsbeckett.c7293754.se4.gui;

import uk.ac.leedsbeckett.c7293754.se4.utils.FileUtils;

import javax.swing.*;
import java.awt.*;

public class GuiManager {

    private JFrame frame;
    private App app;

    public void start() {

        app = new App();

        frame = new JFrame("GPL App");
        frame.setPreferredSize(new Dimension(800, 500));
        frame.setContentPane(app.getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
