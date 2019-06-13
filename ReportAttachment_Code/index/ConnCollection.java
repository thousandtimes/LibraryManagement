package index;

import java.sql.*;

public class ConnCollection {
    private String querySql =null;
    private Connection conn = null;
    private ResultSet rs= null;
    private static ConnCollection uniqueInstance;

    private ConnCollection(){
        try {
            String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
            String URL = "jdbc:mysql://localhost:3306/lm?serverTimezone=CTT";
            String databaseUser = "root";
            String databasePassword = "ThreeThousandTimes";

            Class.forName(JDBC_Driver);
            conn= DriverManager.getConnection(URL, databaseUser, databasePassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnCollection getInstance(){
        if (uniqueInstance==null){
            synchronized (ConnCollection.class){
                if(uniqueInstance==null){
                    uniqueInstance=new ConnCollection();
                }
            }
        }
        return uniqueInstance;
    }

    // Book 索引部分
    // 根据作者/书名等用户输入信息获得相关book的索引，即BookIndex
    ResultSet getBookIndexByAuthor(String bookAuthor){
        querySql ="select book_index_id from book_index where book_author regexp ?";
        executeQuery(bookAuthor);
        return rs;
    }

    ResultSet getBookIndexByTitle(String bookName){
        querySql ="select book_index_id from book_index where book_title regexp ?";
        executeQuery(bookName);

        return rs;
    }

    // 根据得到的BookIndex获得书籍相关信息
    public String getbookTitle(String bookIndex){
        querySql ="select book_title from book_index where book_index_id=?";
        executeQuery(bookIndex);
        try {
            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getBookAuthor(String bookIndex){
        querySql ="select book_author from book_index where book_index_id=?";
        executeQuery(bookIndex);
        try {
            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int getBookCounter(String bookIndex){
        querySql ="select book_count from book_index where book_index_id=?";
        executeQuery(bookIndex);
        try {
            rs.next();
            return rs.getInt(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public String getBookPicture(String bookIndex){
        querySql ="select book_picture_link from book_index where book_index_id=?";
        executeQuery(bookIndex);
        try {
            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getBookPress(String bookIndex){
        querySql ="select book_press from book_index where book_index_id=?";
        executeQuery(bookIndex);

        try {
            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getBookType(String bookIndex){
        querySql ="select book_type from book_index where book_index_id=?";
        executeQuery(bookIndex);
        try {
            rs.next();
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void executeQuery(String info){
        try {
            PreparedStatement ps = conn.prepareStatement(querySql);
            ps.setString(1,info);
            rs= ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
