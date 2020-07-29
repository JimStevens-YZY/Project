package restaurant;
import java.sql.*;
import javax.swing.JOptionPane;
public class HandleRegister {
    Connection con;
    PreparedStatement preSql;
    public HandleRegister(String id,String password){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(Exception e){}
        String uri = "jdbc:mysql://localhost:3306/jim?"
                + "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
        try{
            con=DriverManager.getConnection(uri,"root","1527296253");
        }
        catch(SQLException e){}
        String sqlStr="insert into register values(?,?)";
        try{
            preSql=con.prepareStatement(sqlStr);
            preSql.setString(1, id);
            preSql.setString(2, password);
            preSql.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "注册成功！");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "注册失败！");
            e.printStackTrace();
        }
    }
}
