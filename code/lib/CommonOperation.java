package lib;

import javax.swing.*;
import java.awt.*;

public class CommonOperation {
    private static CommonOperation uniqueInstance;
    private CommonOperation(){

    }

    public static CommonOperation getInstance(){
        if(uniqueInstance==null){
            synchronized (CommonOperation.class){
                if(uniqueInstance==null){
                    uniqueInstance=new CommonOperation();
                }
            }
        }
        return uniqueInstance;
    }

    public void setDefaultBackground(JFrame f,JPanel content){
        ImageIcon icon = new ImageIcon("C:\\Users\\WZH\\Desktop\\Niit\\src\\ProjectPicture\\BackGroundPure.png");
        Image img = icon.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_FAST);
        JLabel backlabel = new JLabel(new ImageIcon(img));
        backlabel.setBounds(0, 0, f.getWidth(), f.getHeight());

        f.getRootPane().add(backlabel);
        f.getLayeredPane().setOpaque(false);
        content.setOpaque(false);
    }

    public void setDefaultButtonIcon(JButton button){
        ImageIcon icon = new ImageIcon("C:\\Users\\WZH\\Desktop\\Niit\\src\\ProjectPicture\\ButtonBigger.png");
        Image img = icon.getImage().getScaledInstance(button.getWidth(),button.getHeight(),Image.SCALE_FAST);
        button.setIcon(new ImageIcon(img));
    }

    public void setUserInfoBackground(JFrame f,JPanel content){
        ImageIcon icon = new ImageIcon("C:\\Users\\WZH\\Desktop\\Niit\\src\\ProjectPicture\\UserInfoBackground.png");
        Image img = icon.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_FAST);
        JLabel backlabel = new JLabel(new ImageIcon(img));
        backlabel.setBounds(0, 0, f.getWidth(), f.getHeight());

        f.getRootPane().add(backlabel);
        f.getLayeredPane().setOpaque(false);
        content.setOpaque(false);
    }

    public void setResultSetBackground(JFrame f,JPanel content){
        ImageIcon icon = new ImageIcon("C:\\Users\\WZH\\Desktop\\Niit\\src\\ProjectPicture\\ListBackground.png");
        Image img = icon.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_FAST);
        JLabel backlabel = new JLabel(new ImageIcon(img));
        backlabel.setBounds(0, 0, f.getWidth(), f.getHeight());

        f.getRootPane().add(backlabel);
        f.getLayeredPane().setOpaque(false);
        content.setOpaque(false);
    }
}
