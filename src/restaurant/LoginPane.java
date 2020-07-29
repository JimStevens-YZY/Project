
package restaurant;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class LoginPane extends JFrame {
    private JPanel contentPane;
    private JTextField text1;
    private JLabel accountname,profile,passwordname,avatar;
    private JPasswordField text2;
    private JButton user,manager,Register;


    public static void main(String[] args) {
        LoginPane frame2 = new LoginPane();
        frame2.setVisible(true);
    }

    public LoginPane(){
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550,320, 400, 300);
        setLocationRelativeTo(null);
        final ImageIcon icon15 =new ImageIcon("src/res/user--avatar--filled.png");
        final ImageIcon icon14=new ImageIcon("src/res/background.JPG");
        final ImageIcon icon21 =new ImageIcon("src/res/button2.png");

        final ImageIcon icon22 =new ImageIcon("src/res/zhanghao.png");
        final ImageIcon icon23 =new ImageIcon("src/res/mima.png");


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        text1=new JTextField();
        text1.setBounds(120,105,200,30);
        text2=new JPasswordField();
        text2.setBounds(120,140,200,30);



        accountname=new JLabel("账户");
        accountname.setBounds(65, 70, 100, 100);
        passwordname=new JLabel("密码");
        passwordname.setBounds(65, 105, 100, 100);
        profile=new JLabel("");
        profile.setIcon(icon14);
        profile.setBounds(0,0,400,300);
        avatar=new JLabel("");
        avatar.setIcon(icon15);
        avatar.setBounds(150,5,100,100);


        user=new JButton("用户登录");
        user.setBounds(165,200,75,35);
        user.setBorderPainted(false);//不打印边框
        user.setBorder(null);//除去边框
        manager=new JButton("管理员登录");
        manager.setBounds(250,200,75,35);
        manager.setBorderPainted(false);//不打印边框
        manager.setBorder(null);//除去边框
        Register=new JButton("注册账户");
        Register.setBounds(80,200,75,35);
        Register.setBorderPainted(false);//不打印边框
        Register.setBorder(null);//除去边框
        JLabel pic1= new JLabel();
        pic1.setBounds(166,210,70,17);
        pic1.setIcon(icon21);
        JLabel pic2= new JLabel();
        pic2.setBounds(252,210,70,17);
        pic2.setIcon(icon21);
        JLabel pic3= new JLabel();
        pic3.setBounds(80,210,70,17);
        pic3.setIcon(icon21);
        JLabel accpic=new JLabel("");
        JLabel passpic=new JLabel("");
        accpic.setBounds(35,110,20,20);
        accpic.setIcon(icon22);
        passpic.setBounds(35,145,20,20);
        passpic.setIcon(icon23);
        contentPane.add(text1);
        contentPane.add(text2);
        contentPane.add(accpic);
        contentPane.add(passpic);
        contentPane.add(accountname);
        contentPane.add(passwordname);
        contentPane.add(user);
        contentPane.add(manager);
        contentPane.add(Register);
        contentPane.add(pic1);
        contentPane.add(pic2);
        contentPane.add(pic3);
        contentPane.add(avatar);
        contentPane.add(profile);
        user.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=text1.getText();
                String password=new String(text2.getPassword());
                try{
                    boolean com=compareWithSql(id,password);
                    if(com){
                        JOptionPane.showMessageDialog(null, "登录成功！");
                        dispose();
                        String ways = null;
                        String time = null;
                        String adress = null;
                        String phonenumber = null;
                        String order = null;
                        String consumption = null;
                        Statement sql;
                        ResultSet rs;
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        String uri = "jdbc:mysql://localhost:3306/jim?"
                                + "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
                        Connection conn=DriverManager.getConnection(uri,"root","1527296253");
                        sql=conn.createStatement();
                        rs=sql.executeQuery("select*from food");
                        while(rs.next()){
                            if(rs.getString(2).equals(id)){ways=rs.getString(3);
                                time=rs.getString(4);
                                adress=rs.getString(5);
                                phonenumber=rs.getString(6);
                                order=rs.getString(7);
                                consumption=rs.getString(8);}
                        }
                        new Food(ways,time,adress,phonenumber,order,consumption,id);
					    /*String[] s = { "" };
					    Food.main(s);*/
                    }
                    else{JOptionPane.showMessageDialog(null, "登录失败！");}
                }

                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        manager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=text1.getText();
                String password=new String(text2.getPassword());
                try{
                    boolean com=ManagercompareWithSql(id,password);
                    if(com){
                        JOptionPane.showMessageDialog(null, "登录成功！");
                        dispose();
                        new Server();
                        String[] s = { "" };
                        Server.main(s);
                    }
                    else{JOptionPane.showMessageDialog(null, "登录失败！");}
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] s = { "" };
                RegisterPane person=new RegisterPane();
                person.main(s);
            }
        });


    }
    public boolean compareWithSql(String id,String password) throws Exception{
        PreparedStatement preSql;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String uri = "jdbc:mysql://localhost:3306/jim?"
                + "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
        Connection conn=DriverManager.getConnection(uri,"root","1527296253");
        String sqlStr="select id,password from register where id=?and password=?";
        preSql=conn.prepareStatement(sqlStr);
        preSql.setString(1,id);
        preSql.setString(2,password);
        ResultSet rs = preSql.executeQuery();
        while(rs.next()){
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if(acc.equals(id) && names.equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean ManagercompareWithSql(String id,String password) throws Exception{
        PreparedStatement preSql;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String uri = "jdbc:mysql://localhost:3306/jim?"
                + "useSSL=false&serverTimezone=CST&characterEncoding=utf-8";
        Connection conn=DriverManager.getConnection(uri,"root","1527296253");
        String sqlStr="select id,password from manager where id=?and password=?";
        preSql=conn.prepareStatement(sqlStr);
        preSql.setString(1,id);
        preSql.setString(2,password);
        ResultSet rs = preSql.executeQuery();
        while(rs.next()){
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if(acc.equals(id) && names.equals(password)){
                return true;
            }
        }
        return false;
    }
}
