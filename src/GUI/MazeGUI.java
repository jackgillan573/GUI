package GUI;



import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JTextField;

public class MazeGUI extends JFrame implements Runnable  {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final int PANELS = 5;
    public static final int FONT_SIZE = 24;
    private JPanel panels[];
    private JTextArea display;
    private static final int BTN_PANEL = 1;
    private static final int DISPLAY_PANEL = 4;
    private static final int SCREEN_PANEL = 1;
    private JButton AutoMaze, ScratchMaze, EditMaze,ChildMaze,loginbtn;
    private JFrame frame;`
    JPasswordField password;
    JTextField username;
    JLabel label_password, label_username, message, title;
    JButton btn;



    public MazeGUI(String title) throws HeadlessException {
        super(title);
    }



    private void createGUI() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        String layoutLocation[] = {BorderLayout.NORTH,BorderLayout.SOUTH,BorderLayout.EAST,BorderLayout.WEST,BorderLayout.CENTER};
        //Panel related code
        panels = new JPanel[PANELS];

        Color color[] = {Color.LIGHT_GRAY,Color.LIGHT_GRAY, Color.LIGHT_GRAY, Color.LIGHT_GRAY,Color.WHITE};


        for (int i = 0; i<PANELS;i++) {
            panels[i] = createPanel(color[i]);
            getContentPane().add(panels[i],layoutLocation[i]);
        }

        AutoMaze = createButton("AutoMaze",this::AutoMazeButtonClicked);
        ScratchMaze = createButton("ScratchMaze",this::ScratchMazeButtonClicked);
        EditMaze = createButton("EditMaze",this::EditMazeButtonClicked);
        ChildMaze = createButton("ChildMaze",this::ChildMazeButtonClicked);


        layoutButtonPanel();

        display = newDisplay();
        panels[DISPLAY_PANEL].setLayout(new BorderLayout());
        panels[DISPLAY_PANEL].add(display);

      //  btn_login.label_username.setBounds(200,200,100,40);
      // btn_login.password.setBounds(200,250,200,40);
       // btn_login.username.setBounds(300,200,300,40);
      //  btn_login.message.setBounds(11,200,100,40);

        login btn_login = new login();
        btn_login.login_pass();

        display.add(btn_login.label_password).setBounds(200,200,100,40);
        display.add(btn_login.password).setBounds(300,200,300,40);

        display.add(btn_login.username).setBounds(300,150,300,40);
        display.add(btn_login.label_username).setBounds(200,150,300,40);

        display.add(btn_login.message).setBounds(250,330,300,40);

        loginbtn = createButton("Sign in", this::loginbtnclicked);

        display.add(loginbtn).setBounds(300,270,100,40);


        repaint();
        setVisible(true);
    }

    private void loginbtnclicked(ActionEvent actionEvent) {

        if (login.username != "Hary") {
        }

        String msg = "Your username is : " + login.username.getText();
        msg += " and your password is : " + new String (login.password.getPassword());
        login.message.setText(msg);

        }

    public void createImageLabel(Container contentPane){
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.magenta);
        contentPane.add(imagePanel, BorderLayout.CENTER);
    }
    private void AutoMazeButtonClicked(ActionEvent actionEvent) {
      ImageIcon mazeImage = new ImageIcon(getClass().getResource("Maze.jpg"));
      JLabel img = new JLabel(mazeImage);
      display.add(img);


    }

    private void ScratchMazeButtonClicked(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(this,"Cannot draw Mazes currently",
                "Wiring Class: Warning", JOptionPane.ERROR_MESSAGE);
    }
    private void EditMazeButtonClicked(ActionEvent actionEvent) {

    }

    private void ChildMazeButtonClicked(ActionEvent actionEvent) {

    }


    private void layoutButtonPanel() {
        GridBagLayout layout = new GridBagLayout();
        JPanel button_panel = panels[BTN_PANEL];

        panels[BTN_PANEL].setLayout(layout);
        //Lots of layout code here
        //add components to grid
        GridBagConstraints constraints = new GridBagConstraints();
        //Defaults
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 100;
        constraints.weighty = 100;
        addToPanel(button_panel,  AutoMaze,constraints,0,0,2,1);
        addToPanel(button_panel,  ScratchMaze,constraints,3,0,2,1);
        addToPanel(button_panel, ChildMaze,constraints,0,2,2,1);
        addToPanel(button_panel, EditMaze,constraints,3,2,2,1);


    }


    private void addToPanel(JPanel jp,Component c, GridBagConstraints constraints,
                            int x, int y, int w, int h) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        jp.add(c, constraints);

    }


    private JButton createButton(String str,ActionListener listener) {
        //Create a JButton object and store it in a local var
        JButton button = new JButton();
        //Set the button text to that passed in str
        button.setText(str);
        //Add the frame as an actionListener
        button.addActionListener(listener);
        //Return the JButton object
        return button;
    }

    private JPanel createPanel(Color c) {
        //Create a JPanel object and store it in a local var
        JPanel panel = new JPanel();

        //set the background colour to that passed in c
        panel.setBackground(c);
        //Return the JPanel object
        return panel;
    }


    private JTextArea newDisplay() {
        display = new JTextArea();
        display.setEditable(false);
        display.setLineWrap(true);
        display.setFont(new Font("Arial",Font.BOLD, FONT_SIZE));
        // font size = 24
        display.setBorder(BorderFactory.createEtchedBorder());
        return display;
    }




    public static void main(String[] args){
        SwingUtilities.invokeLater(new MazeGUI("BorderLayout"));


    }

    @Override
    public void run() {
        createGUI();
    }


}

/// GUI code taken from Week  Lectures