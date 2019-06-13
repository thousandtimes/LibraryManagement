package borrow;

import lib.CommonOperation;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Zohn
 */
public class BorrowMenu extends JFrame{
    private JPanel BottomPanel;
    private JButton buttonBorrow;
    private JTextField StudentIDField;
    private JTextField BookIDField;
    private JPanel lpanel;
    private JPanel upanel;
    private JButton returnButton;
    private JLabel logLabel;
    private JPanel stuIDPanel;
    private JPanel bookIDPanel;
    JLabel jpp=null;

    public BorrowMenu(String studentID,String bookID){
        this();
        StudentIDField.setText(studentID);
        BookIDField.setText(bookID);
    }

    public BorrowMenu(String studentID){
        this();
        StudentIDField.setText(studentID);
    }

    public BorrowMenu() {
        //initial all the panel
        stuIDPanel.setOpaque(false);
        bookIDPanel.setOpaque(false);
        logLabel.setOpaque(false);
        lpanel.setOpaque(false);
        upanel.setOpaque(false);

        //initial frame
        setSize(420,300);
        CommonOperation co = CommonOperation.getInstance();
        co.setDefaultBackground(this,BottomPanel);
        setTitle("BorrowMenu");
        setContentPane(BottomPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(300,200);
        setVisible(true);

        //Adapter code
        buttonBorrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BorrowReturnConn brc = BorrowReturnConn.getInstance();
                boolean flag =brc.bookBorrow(BookIDField.getText(),StudentIDField.getText());

                if(flag){
                    JOptionPane.showMessageDialog(null,"借阅成功");
                }
                else {
                    JOptionPane.showMessageDialog(null,"借阅失败，该图书已外借");
                }
            }
        });

        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BorrowReturnConn brc = BorrowReturnConn.getInstance();
                boolean flag =brc.bookReturn(BookIDField.getText(),StudentIDField.getText());
                if(flag) {
                    JOptionPane.showMessageDialog(null, "归还成功");
                }
                else {
                    JOptionPane.showMessageDialog(null,"归还失败，该图书已在馆");
                }
            }
        });

    }
}
