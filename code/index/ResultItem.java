package index;

import javax.swing.*;
import java.awt.*;

public class ResultItem extends JPanel {

    public ResultItem(String bookTitle, String author, String picPath, int count, String bookPress, String bookType) {

        setLayout(new GridLayout(1,2));
        setVisible(true);
        this.setSize(300,200);

        ImageIcon ii = new ImageIcon(picPath);
        JLabel labelPicture=new JLabel(ii);

        JPanel infoPanel = new JPanel(new GridLayout(3,1));
        JLabel titleLabel=new JLabel();
        JLabel authorLabel=new JLabel();
        JLabel remindLabel=new JLabel();

        titleLabel.setText("  "+bookTitle);
        authorLabel.setText("   Author:  "+author);
        remindLabel.setText("   Remind book:"+count);
        infoPanel.add(titleLabel);
        infoPanel.add(authorLabel);
        infoPanel.add(remindLabel);

        add(labelPicture);
//        add(new JPanel());
        add(infoPanel);

    }

    public static void main(String[] args) {

    }
}
