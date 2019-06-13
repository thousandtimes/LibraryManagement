package login;

import lib.BigConnectionSet;
import lib.CommonOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginMenu extends JFrame {
    private JTextField uField;
    private JButton loginButton;
    private JPanel bottomPanel;
    private JPanel messagePanel;
    private JPanel buttonPanel;
    private JPasswordField pField;
    private JLabel welcome;
    private JPanel welcomePanel;
    BigConnectionSet cs=null;

    public LoginMenu() throws HeadlessException {

        //set all panel opaque to false
        messagePanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        welcomePanel.setOpaque(false);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle("LoginMenu");
        setSize(430,230);
        setLocation(300,200);

        CommonOperation co = CommonOperation.getInstance();
        co.setDefaultBackground(this,bottomPanel);
        setContentPane(bottomPanel);

        cs=BigConnectionSet.getInstance();
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String passwd=cs.getPasswd(uField.getText());
                if(passwd!=null && passwd.equals(pField.getText())){
                    dispose();
                    OptionalMenu om = new OptionalMenu(uField.getText());
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Username or password!");
                }
            }
        });
        pField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyChar()=='\n'){
//                    super.mouseClicked(e);
                    String passwd=cs.getPasswd(uField.getText());
                    if(passwd!=null && passwd.equals(pField.getText())){
                        OptionalMenu om = new OptionalMenu(uField.getText());
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Wrong Username or password!");
                    }
                };
            }
        });
    }

    public static void main(String[] args) {

    }
}
