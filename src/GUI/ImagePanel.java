package GUI;


import javax.swing.*;

public class ImagePanel extends JPanel {
    private ImageIcon image;

    void setImage(ImageIcon image) {
        this.image = image;
        repaint();
        setVisible(true);
    }
}

