package info;

import index.ConnCollection;
import index.ResultItem;
import lib.BigConnectionSet;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Zhangheng Li
 */
public class BorrowHistory extends JFrame {
    String userID;

    public BorrowHistory(String userID) throws SQLException {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.userID = userID;
        setLayout(new FlowLayout());
        add(new JLabel("Here are your borrow history >>"));
        BigConnectionSet bcs = BigConnectionSet.getInstance();
        ConnCollection cc =ConnCollection.getInstance();

        this.setSize(300,400);
        ResultSet rs =bcs.getBookIDResultSet(userID);
        while(rs.next()){
            String index = bcs.getIndexById(rs.getString(1));
            add(new ResultItem(cc.getbookTitle(index),
                    cc.getBookAuthor(index),
                    cc.getBookPicture(index),
                    cc.getBookCounter(index),
                    cc.getBookPress(index),
                    cc.getBookType(index)));
        }
    }
}
