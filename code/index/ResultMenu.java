package index;


import lib.CommonOperation;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMenu extends JFrame {


    ResultMenu(ResultSet rs) throws SQLException {
        ConnCollection cc = ConnCollection.getInstance();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("ResultMenu");
        JPanel bottomPanel = new JPanel(new FlowLayout());

        //initialize the frame
        setSize(320,550);
        CommonOperation co = CommonOperation.getInstance();
        co.setResultSetBackground(this,bottomPanel);
        setContentPane(bottomPanel);
        setLayout(new FlowLayout());
        setVisible(true);


        bottomPanel.add(new JLabel("The select Result >>"));
        setLocation(200,50);

        int count = 0;
        while(rs.next()){
            count++;
            String index=rs.getString(1);
            bottomPanel.add(new ResultItem(cc.getbookTitle(index),
                    cc.getBookAuthor(index),
                    cc.getBookPicture(index),
                    cc.getBookCounter(index),
                    cc.getBookPress(index),
                    cc.getBookType(index)));
        }
        if(count ==0){
            add(new JLabel("     Sorry we didn't find any result      "));
        }
    }

    public static void main(String[] args) {
//        ResultMenu rm = new ResultMenu();
    }
}
