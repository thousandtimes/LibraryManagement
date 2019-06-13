package borrow;

import java.sql.*;

class BorrowReturnConn {

    private final String databaseUser = "root";
    private final String databasePassword = "ThreeThousandTimes";
    private int flag = 1;
    private Connection conn = null;
    private PreparedStatement st1 = null;
    private PreparedStatement st2 = null;
    private PreparedStatement st3 = null;
    private PreparedStatement st4 = null;
    private static BorrowReturnConn uniqueInstance =null;

    private BorrowReturnConn() {

        try {
            String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            Class.forName(jdbcDriver);
            String dbUrl = "jdbc:mysql://localhost:3306/lm?serverTimezone=CTT";
            conn = DriverManager.getConnection(dbUrl, databaseUser, databasePassword);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static BorrowReturnConn getInstance(){
        if(uniqueInstance==null){
            uniqueInstance = new BorrowReturnConn();
        }
        return uniqueInstance;
    }

    Boolean bookBorrow(String bookID, String studentID) {
        checked(bookID);
        if (flag == 0) {
            return false;
        } else {
            // make sure book is in lib
            // mark on the book_id
            // update borrow history
            // count--
            String sql1 = "update book_collection set is_inLib = 0 where book_id = ?";
            String sql2 = "insert into borrow_history values (?,?,0,?)";

            try {
                st1 = conn.prepareStatement(sql1);
                st1.setString(1, bookID);
                st1.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                st2 = conn.prepareStatement(sql2);
                st2.setString(1, studentID);
                st2.setString(2, bookID);
                st2.setDate(3, null);
                st2.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String sql3 = "select book_index_id from book_collection where book_id = ?";
            String sql4 = "update book_index set book_count=book_count-1 where book_index_id=?";
            String bookIndex = null;

            try {
                st3 = conn.prepareStatement(sql3);
                st3.setString(1, bookID);
                ResultSet rs = st3.executeQuery();
                rs.next();
                bookID = rs.getString(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                st4 = conn.prepareStatement(sql4);
                st4.setString(1, bookIndex);
                st4.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;

    }

    Boolean bookReturn(String bookID, String studentID) {

        checked(bookID);
        if (flag == 1) {
            return false;
        } else {
            // update borrow history
            // remark on the bookid
            // count++
            String sql1 = "update book_collection set is_inLib = 1 where book_id=?";
            String sql2 = "update borrow_history set book_status=1 where book_id = ?";

            try {
                st1 = conn.prepareStatement(sql1);
                st1.setString(1, bookID);
                st1.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                st2 = conn.prepareStatement(sql2);
                st2.setString(1, bookID);

                st2.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }


            String sql3 = "select book_index_id from book_collection where book_id = ?";
            String sql4 = "update book_index set book_count=book_count+1 where book_index_id=?";
            String bookIndex = null;

            try {
                st3 = conn.prepareStatement(sql3);
                st3.setString(1, bookID);
                ResultSet rs = st3.executeQuery();
                rs.next();
                bookID = rs.getString(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                st4 = conn.prepareStatement(sql4);
                st4.setString(1, bookIndex);
                st4.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return true;
    }

    private void checked(String bookID) {

        String sql1 = "select is_inLib from book_collection where book_id = ? ";
        flag = 1;
        try {
            PreparedStatement stCheck = conn.prepareStatement(sql1);
            stCheck.setString(1, bookID);
            ResultSet rs = stCheck.executeQuery();
            rs.next();
            flag = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class MysqlConn {
}
