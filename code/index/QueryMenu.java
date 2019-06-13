package index;

import lib.CommonOperation;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryMenu extends JFrame {
    private JPanel bottomPanel;

    private JLabel picLabel;
    private JPanel lPanel;
    private JPanel uPanel;
    private JPanel infoPanel;
    private JPanel textPanel;
    private JTextField textField;
    private JRadioButton titleRadioButton;
    private JRadioButton authorRadioButton;
    private JRadioButton keyWordRadioButton;
    private JCheckBox onlyBox;
    private JButton searchButton;
    private JPanel lowerPanel;
    private JPanel lowerLeftPanel;

    private ConnCollection cc = ConnCollection.getInstance();
    private ResultSet rs=null;
    private ResultMenu rm =null;

    public QueryMenu() {
        // set all the component with opaque to false
        picLabel.setOpaque(false);
        lPanel.setOpaque(false);
        uPanel.setOpaque(false);
        infoPanel.setOpaque(false);
        textPanel.setOpaque(false);
        onlyBox.setOpaque(false);
        titleRadioButton.setOpaque(false);
        authorRadioButton.setOpaque(false);
        keyWordRadioButton.setOpaque(false);
        lowerLeftPanel.setOpaque(false);
        lowerPanel.setOpaque(false);


        // initial the frame
        setSize(430,270);
        CommonOperation co = CommonOperation.getInstance();
        co.setDefaultBackground(this,bottomPanel);
        setContentPane(this.bottomPanel);
        setTitle("QueryMenu");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocation(300,200);

        ButtonGroup gp1 = new ButtonGroup();
        gp1.add(titleRadioButton);
        gp1.add(authorRadioButton);
        gp1.add(keyWordRadioButton);

        searchButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String message=textField.getText();

                if(titleRadioButton.isSelected()){
                    rs =cc.getBookIndexByTitle(message);
                    try {
                        rm=new ResultMenu(rs);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(authorRadioButton.isSelected()){
                    rs =cc.getBookIndexByAuthor(message);
                    try {
                        rm=new ResultMenu(rs);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
                else if(keyWordRadioButton.isSelected()){
                    JOptionPane.showMessageDialog(null,"Sorry we didn't offer the server of search by keyword now, we will completed it ASAP");
                }
            }
        });
    }


    public static void main(String[] args) {
        QueryMenu qm = new QueryMenu();
    }
}
