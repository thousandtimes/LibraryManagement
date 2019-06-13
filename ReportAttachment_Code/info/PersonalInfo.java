package info;

import lib.BigConnectionSet;
import lib.CommonOperation;

import javax.swing.*;
import java.awt.*;

public class PersonalInfo extends JFrame{
    private JPanel bottomPanel;
    private JPanel letterPanel;
    private JLabel nameLabel;
    private JLabel gradeLabel;
    private JLabel majorLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel picLabel;

    public PersonalInfo(String userID) {

        bottomPanel=new JPanel(new GridLayout(1,2));
        BigConnectionSet cs=BigConnectionSet.getInstance();

        // initialize the frame
        setSize(450,300);
        CommonOperation co = CommonOperation.getInstance();
        co.setUserInfoBackground(this,bottomPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(200,200);
        setContentPane(bottomPanel);
        picLabel=new JLabel(new ImageIcon(cs.getPicPath(userID)));
        System.out.println(cs.getPicPath(userID));
        bottomPanel.add(picLabel);
        setTitle("UserInformation");

        letterPanel = new JPanel(new GridLayout(5,1));
        letterPanel.setOpaque(false);
        bottomPanel.add(letterPanel);

        nameLabel=new JLabel("Name: "+cs.getName(userID));
        gradeLabel=new JLabel("Grade:  "+cs.getGrade(userID));
        majorLabel=new JLabel("Major: "+cs.getMajor(userID));
        phoneNumberLabel = new JLabel("Phone:"+cs.getPhoneNumber(userID));
        emailLabel = new JLabel("Email: "+cs.getEmail(userID));

        letterPanel.add(nameLabel);
        letterPanel.add(gradeLabel);
        letterPanel.add(majorLabel);
        letterPanel.add(phoneNumberLabel);
        letterPanel.add(emailLabel);

    }

}
