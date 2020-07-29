package restaurant;

import java.awt.*;
import java.awt.event.*;
import restaurant.Food;
import restaurant.Tree;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.table.DefaultTableModel;

public class Cart extends JFrame{
    private JLabel re,count;
    private JButton confirm;
    private JTextArea showorder;
    private JPanel pur;

    public Cart(String a){
        final String id2=a;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 260);
        setLocation(462,350);
        setTitle("个人信息");
        setVisible(true);
        pur = new JPanel();
        pur.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pur);
        pur.setLayout(null);
        JLabel title =new JLabel("请输入个人信息");
        title.setFont(new java.awt.Font("宋体", 1, 14));
        title.setBounds(100,10,100,30);
        final JLabel jl1=new JLabel("取餐方式");
        jl1.setBounds(40,40,100,30);

        JLabel jl2=new JLabel("时间");
        jl2.setBounds(40,80,100,30);

        JLabel jl3=new JLabel("地址");
        jl3.setBounds(40,120,100,30);

        JLabel jl4=new JLabel("联系方式");
        jl4.setBounds(40,160,100,30);

        final ImageIcon ic = new ImageIcon("src/res/cart.JPG");
        final ImageIcon zhifu = new ImageIcon("src/res/zhifu.png");
        final ImageIcon time = new ImageIcon("src/res/time.png");
        final ImageIcon dizhi = new ImageIcon("src/res/dizhi.png");
        final ImageIcon lianxi = new ImageIcon("src/res/lianxi.png");


        JLabel zhifupic=new JLabel("");
        zhifupic.setIcon(zhifu);
        zhifupic.setBounds(15,45,20,20);

        JLabel timepic=new JLabel("");
        timepic.setIcon(time);
        timepic.setBounds(15,85,20,20);

        JLabel dizhipic=new JLabel("");
        dizhipic.setIcon(dizhi);
        dizhipic.setBounds(15,125,20,20);

        JLabel lianxipic=new JLabel("");
        lianxipic.setIcon(lianxi);
        lianxipic.setBounds(15,165,20,20);


        JLabel wall=new JLabel("");
        wall.setIcon(ic);
        wall.setBounds(0,0,300,280);


        final JComboBox check1=new JComboBox<String>();
        check1.setBounds(140,35,140,40);
        check1.addItem("--请选择--");
        check1.addItem("自提");
        check1.addItem("外卖");



        final JComboBox check2=new JComboBox<String>();
        check2.setBounds(140,80,140,40);
        check2.addItem("--请选择--");
        check2.addItem("早餐");
        check2.addItem("中餐");
        check2.addItem("晚餐");


        final JTextField jt1=new JTextField();
        jt1.setBounds(140,120,150,30);
        jt1.setColumns(10);


        final JTextField jt2=new JTextField();
        jt2.setBounds(140,160,150,30);
        jt2.setColumns(10);


        JButton jbt=new JButton("确定");
        jbt.setBounds(130,210,50,20);
        jbt.setBorder(BorderFactory.createRaisedBevelBorder());
        jbt.setContentAreaFilled(false);
        pur.add(zhifupic);
        pur.add(timepic);
        pur.add(dizhipic);
        pur.add(lianxipic);
        pur.add(title);
        pur.add(jl1);
        pur.add(jl2);
        pur.add(jl3);
        pur.add(jl4);
        pur.add(check1);
        pur.add(check2);
        pur.add(jt1);
        pur.add(jt2);
        pur.add(jbt);
        pur.add(wall);
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a=(String)check1.getSelectedItem();
                String b=(String)check2.getSelectedItem();
                String c=jt1.getText();
                String d=jt2.getText();
                new ShopPane1(a,b,c,d,id2);
                dispose();

            }
        });






    }
}

