package restaurant;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class RegisterPane extends JFrame{
    private JLabel account,password;
    private JButton button;
    private JTextField text1;
    private JPanel contentPane;
    private JPasswordField text2;
    public static void main(String[] args) {
        RegisterPane win=new RegisterPane();
        win.setTitle("注册");
        win.setSize(300, 200);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win. setLocationRelativeTo(null);
    }
    public RegisterPane(){
        this.setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        text1=new JTextField();
        text1.setBounds(55,65,230,30);
        text2=new JPasswordField();
        text2.setBounds(55,100,230,30);
        account=new JLabel("账户");
        account.setForeground(new Color(187,187,187));
        account.setBounds(15, 30, 100, 100);
        password=new JLabel("密码");
        password.setForeground(new Color(187,187,187));
        password.setBounds(15, 65, 100, 100);
        button=new JButton("注册");
        button.setForeground(new Color(187,187,187));
        button.setBounds(120,135,65,30);
        button.setBorderPainted(false);//不打印边框
        button.setBorder(null);//除去边框
        final ImageIcon icon19 = new ImageIcon("src/res/wall.JPG");
        final ImageIcon icon20 = new ImageIcon("src/res/zhuce.png");
        final ImageIcon icon21 = new ImageIcon("src/res/button.png");
        JLabel wall= new JLabel();
        wall.setBounds(0,0,300,200);
        wall.setIcon(icon19);
        JLabel pic= new JLabel();
        pic.setBounds(130,25,40,40);
        pic.setIcon(icon20);
        JLabel but= new JLabel();
        but.setBounds(133,142,40,17);
        but.setIcon(icon21);

        contentPane.add(account);
        contentPane.add(password);
        contentPane.add(text1);
        contentPane.add(text2);
        contentPane.add(button);
        contentPane.add(but);
        contentPane.add(pic);
        contentPane.add (wall);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=text1.getText();
                String password=new String(text2.getPassword());
                if(id.equals("")||password.equals("")){
                    JOptionPane.showMessageDialog(null, "请输入信息！","⚠️",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    new HandleRegister(id,password);
                    dispose();
                    Connection conn = null;
                    String url;
                    Statement stat = null;
                    String ss="create table "+id+"(ways varchar(255),time varchar(255),address varchar(255),phonenumber varchar(255), ordernum varchar(255),consumption varchar(255))";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }
                    url = "jdbc:mysql://localhost:3306/jim?useUnicode=true&characterEncoding=utf-8";
                    try {
                        conn = DriverManager.getConnection(url, "root", "1527296253");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        stat = conn.createStatement();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        stat.executeUpdate(ss);
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        stat.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    try {
                        conn.close();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });
    }
}
