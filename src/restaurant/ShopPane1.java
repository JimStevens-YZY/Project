package restaurant;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class ShopPane1 extends JFrame {
    public ShopPane1(String a,String b, String c,String d,String e) {
        String ways=a;
        String time=b;
        String adress=c;
        String phonenumber=d;
        String id2=e;
        final ShopPane li;
        JPanel contentPane;
        final JTextField textField;
        final JTextField textField_1;
        JLabel lblNewLabel;
        JButton btnNewButton;
        JButton btnNewButton_1;
        JLabel lblNewLabel_1;
        JLabel lblNewLabel_2;
        String str = "", str1 = "";
        li = new ShopPane(ways,time,adress,phonenumber,id2);
        setTitle("购物车");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(835, 192, 483, 228);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        lblNewLabel = new JLabel("请输入");
        lblNewLabel.setFont(new java.awt.Font("宋体", 1, 14));
        lblNewLabel.setBounds(220,10,60,40);
        contentPane.add(lblNewLabel);

        btnNewButton = new JButton("确定");
        btnNewButton.setBounds(150,180,50,20);
        btnNewButton.setBorder(BorderFactory.createRaisedBevelBorder());
        btnNewButton.setContentAreaFilled(false);

        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("清除");
        btnNewButton_1.setBounds(280,180,50,20);
        btnNewButton_1.setBorder(BorderFactory.createRaisedBevelBorder());
        btnNewButton_1.setContentAreaFilled(false);

        contentPane.add(btnNewButton_1);



        lblNewLabel_1 = new JLabel("商品编号");
        lblNewLabel_1.setBounds(100,30,60,60);
        contentPane.add(lblNewLabel_1);

        textField = new JTextField();
        textField.setBounds(158,45,200,30);
        contentPane.add(textField);
        textField.setColumns(10);


        lblNewLabel_2 = new JLabel("商品数量");
        lblNewLabel_2.setBounds(100,100,60,60);
        contentPane.add(lblNewLabel_2);

        textField_1 = new JTextField();
        textField_1.setBounds(158,115,200,30);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        final ImageIcon ic = new ImageIcon("src/res/shoppane.JPG");
        JLabel wall=new JLabel("");
        wall.setIcon(ic);
        wall.setBounds(0,0,483,250);

        contentPane.add(wall);
        setVisible(true);

        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    li.list_1(textField.getText(), textField_1.getText());
                } catch (Exception e1) {

                    e1.printStackTrace();
                }

            }
        });
        btnNewButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField_1.setText("");

            }
        });
    }

    /*public static void main(String[] args) {
    	new ShopPane();
    }*/
}






















