package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.JTextField;

public class login extends MazeGUI{
    static JPasswordField password;
    static JTextField username;
    JLabel label_password;
    JLabel label_username;
    static JLabel message;
    JLabel title;
    JButton btn;
    private String user_usermame, user_password;

    public login() throws HeadlessException {
        super(null);
    }


    public void login_pass(){

        label_username = new JLabel("Username");
        label_password = new JLabel("Password");
        username = new JTextField();
        password = new JPasswordField();
        message = new JLabel("Message here");
        btn = new JButton("Sign in");


    }




}
// this.add(btn_login.label_username);
//  this.add(btn_login.username);
//this.add(btn_login.label_password);
// this.add(btn_login.password);
//this.add(btn_login.message);

//  btn_login.label_username.setBounds(200,200,100,40);
// btn_login.password.setBounds(200,250,200,40);
// btn_login.username.setBounds(300,200,300,40);
//  btn_login.message.setBounds(11,200,100,40);