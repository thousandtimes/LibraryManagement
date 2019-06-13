package lib;

import java.sql.*;

/**
 * @author Zohn
 */
public class BigConnectionSet {
    private final String JDBC_Driver="com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/lm?serverTimezone=CTT";

    private final String user="root";
    private final String passwd="ThreeThousandTimes";
    private static BigConnectionSet uniqueInsatance;
    Connection conn = null;
    PreparedStatement pst = null;
    private BigConnectionSet() {
        try {
            Class.forName(JDBC_Driver);
            conn= DriverManager.getConnection(URL,user,passwd);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static BigConnectionSet getInstance(){
        if(uniqueInsatance==null){
            synchronized (BigConnectionSet.class){
                if(uniqueInsatance==null){
                    uniqueInsatance=new BigConnectionSet();
                }
            }
        }
        return uniqueInsatance;
    }

    public String getPasswd(String userID){
        String sql="select user_password from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPicPath(String userID){
        String sql="select user_photo from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getGrade(String userID){
        String sql="select user_grade from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName(String userID){
        String sql="select user_name from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getMajor(String userID){
        String sql="select user_major from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getClass(String userID){
        String sql="select user_class from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getPhoneNumber(String userID){
        String sql="select user_PhoneNumber from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getEmail(String userID){
        String sql="select user_email from user_information where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getBookIDResultSet(String userID){
        String sql="select book_id from borrow_history where user_id = ?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,userID);
            ResultSet rs= pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getIndexById(String book_id){
        String sql = "select book_index_id from book_collection where book_id =?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1,book_id);
            ResultSet rs =pst.executeQuery();
            rs.next();
            return rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
