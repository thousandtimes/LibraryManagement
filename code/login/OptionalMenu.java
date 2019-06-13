package login;

import borrow.BorrowMenu;
import index.QueryMenu;
import info.BorrowHistory;
import info.PersonalInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class OptionalMenu extends JFrame{
    private JButton personalInfomationButton;
    private JButton borrowHistoryButton;
    private JButton bookSearchButton;
    private JLabel Personalinformationicon;
    private JLabel HistoryIcon;
    private JLabel SearchIcon;
    private JPanel infoPanel;
    private JPanel historyPanel;
    private JPanel retrievalPanel;
    private JPanel bottomPanel;
    private JButton bookBorrowAndReturnButton;
    private JPanel leftTakePlace;
    private JPanel borrowPanel;

    String userID=null;

    public OptionalMenu(String userID) throws HeadlessException {
        this.userID=userID;
        setContentPane(bottomPanel);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(300,100);
        pack();

        setSize(getWidth()+20,  getHeight()+50);
        setVisible(true);
        personalInfomationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                PersonalInfo pi = new PersonalInfo(userID);
            }
        });
        borrowHistoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    BorrowHistory bh = new BorrowHistory(userID);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        bookSearchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                QueryMenu qm = new QueryMenu();
            }
        });
        bookBorrowAndReturnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BorrowMenu bm = new BorrowMenu(userID);
            }
        });
    }

    public static void main(String[] args) {
//        OptionalMenu om = new OptionalMenu();
    }
}
