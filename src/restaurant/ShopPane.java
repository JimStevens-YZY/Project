package restaurant;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JTextField;

public class ShopPane extends JFrame {
    String [][]food={{"A1","铁板土豆牛肉盖饭","15"},
            {"A2","铁板肉末水晶粉丝","15"},
            {"B1","百味鲜套餐一","15"},
            {"B2","百味鲜套餐二","15"},
            {"B3","百味鲜套餐三","15"},
            {"C1","粥铺套餐一","12"},
            {"C2","粥铺套餐二","13"},
            {"C3","粥铺套餐三","13"},
            {"D1","饼铺套餐一","12"},
            {"D2","饼铺套餐二","15"},
            {"D3","饼铺热狗蛋炒饭","12"},
            {"E1","西施豆腐","12"},
            {"E2","饭团","7"},
            {"E3","关东煮","10"},
            {"F1","麻辣香锅套餐","12"},
            {"F2","黄焖鸡米饭套餐","12"},
            {"G1","湘味铺套餐一","13"},
            {"G2","湘味铺套餐二","16"},
            {"G3","湘味铺套餐三","15"},
            {"H1","牛柳套饭","15"},
            {"H2","酱鸭肉套饭","15"},
            {"H3","三鲜套饭","15"},
            {"I1","清真牛杂盖饭","15"},
            {"I2","清真兰州炒饭","15"},
            {"I3","清真牛肉炒年糕","15"},
            {"I4","清真红烧茄子盖饭","15"},
            {"J1","西餐厅套餐一","15"},
            {"J2","西餐厅套餐二","15"},
            {"J3","西餐厅套餐三","15"},};
    int flag = 0;
    double sum=0;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JPanel panel;
    private JPanel panel_1;
    private JButton btnNewButton,button;
    private JButton btnNewButton_1;
    private JPanel panel_2;
    private JPanel panel_3;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JLabel lblNewLabel_11;
    private JLabel lblNewLabel_12;
    private JLabel lblNewLabel_13;
    private JLabel lblNewLabel_14;
    private JLabel lblNewLabel_15;
    private JLabel lblNewLabel_16;
    private JLabel lblNewLabel_17;
    private JLabel lblNewLabel_18;
    private JLabel lblNewLabel_19;
    private JLabel lblNewLabel_20;
    private JLabel lblNewLabel_21;
    private JLabel lblNewLabel_22;
    private JButton btnNewButton_2;



    public  ShopPane(String a,String b,String c,String d,String e) {
        final String ways=a;
        final String time=b;
        final String adress=c;
        final String phonenumber=d;
        final String id2=e;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("购物清单");
        setBounds(835, 420, 483, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        lblNewLabel = new JLabel("购物清单");
        panel.add(lblNewLabel);

        panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.SOUTH);

        btnNewButton = new JButton("结账");
        panel_1.add(btnNewButton);
        button=new JButton("清除");
        panel_1.add(button);



        panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new GridLayout(0, 4, 4, 0));

        panel_3 = new JPanel();
        panel_2.add(panel_3);

        lblNewLabel_1 = new JLabel("商品编号");
        panel_3.add(lblNewLabel_1);

        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4);

        lblNewLabel_2 = new JLabel("名称");
        panel_4.add(lblNewLabel_2);

        JPanel panel_5 = new JPanel();
        panel_2.add(panel_5);

        lblNewLabel_3 = new JLabel("单价(元)");
        panel_5.add(lblNewLabel_3);

        JPanel panel_6 = new JPanel();
        panel_2.add(panel_6);

        lblNewLabel_4 = new JLabel("数量");
        panel_6.add(lblNewLabel_4);

        JPanel panel_7 = new JPanel();
        panel_2.add(panel_7);

        lblNewLabel_5 = new JLabel();
        panel_7.add(lblNewLabel_5);

        JPanel panel_8 = new JPanel();
        panel_2.add(panel_8);

        lblNewLabel_6 = new JLabel();
        panel_8.add(lblNewLabel_6);

        JPanel panel_9 = new JPanel();
        panel_2.add(panel_9);

        lblNewLabel_7 = new JLabel();
        panel_9.add(lblNewLabel_7);

        JPanel panel_10 = new JPanel();
        panel_2.add(panel_10);

        lblNewLabel_8 = new JLabel();
        panel_10.add(lblNewLabel_8);

        JPanel panel_11 = new JPanel();
        panel_2.add(panel_11);

        lblNewLabel_9 = new JLabel();
        panel_11.add(lblNewLabel_9);

        JPanel panel_12 = new JPanel();
        panel_2.add(panel_12);

        lblNewLabel_10 = new JLabel();
        panel_12.add(lblNewLabel_10);

        JPanel panel_13 = new JPanel();
        panel_2.add(panel_13);

        lblNewLabel_11 = new JLabel();
        panel_13.add(lblNewLabel_11);

        JPanel panel_14 = new JPanel();
        panel_2.add(panel_14);

        lblNewLabel_12 = new JLabel();
        panel_14.add(lblNewLabel_12);

        JPanel panel_15 = new JPanel();
        panel_2.add(panel_15);

        lblNewLabel_13 = new JLabel();
        panel_15.add(lblNewLabel_13);

        JPanel panel_16 = new JPanel();
        panel_2.add(panel_16);

        lblNewLabel_14 = new JLabel();
        panel_16.add(lblNewLabel_14);

        JPanel panel_17 = new JPanel();
        panel_2.add(panel_17);

        lblNewLabel_15 = new JLabel();
        panel_17.add(lblNewLabel_15);

        JPanel panel_18 = new JPanel();
        panel_2.add(panel_18);

        lblNewLabel_16 = new JLabel();
        panel_18.add(lblNewLabel_16);

        JPanel panel_19 = new JPanel();
        panel_2.add(panel_19);

        lblNewLabel_17 = new JLabel();
        panel_19.add(lblNewLabel_17);

        JPanel panel_20 = new JPanel();
        panel_2.add(panel_20);

        lblNewLabel_18 = new JLabel("");
        panel_20.add(lblNewLabel_18);

        JPanel panel_21 = new JPanel();
        panel_2.add(panel_21);

        lblNewLabel_19 = new JLabel("");
        panel_21.add(lblNewLabel_19);

        JPanel panel_22 = new JPanel();
        panel_2.add(panel_22);

        lblNewLabel_20 = new JLabel("");
        panel_22.add(lblNewLabel_20);

        JPanel panel_23 = new JPanel();
        panel_2.add(panel_23);

        lblNewLabel_21 = new JLabel("总价：");
        panel_23.add(lblNewLabel_21);

        JPanel panel_24 = new JPanel();
        panel_2.add(panel_24);

        lblNewLabel_22 = new JLabel("0元");
        panel_24.add(lblNewLabel_22);

        setVisible(true);
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e){
                int isDelete = JOptionPane.showConfirmDialog(null, "您需要支付"+sum+"元", "取消", JOptionPane.YES_NO_CANCEL_OPTION);
                if(isDelete == JOptionPane.YES_OPTION){
                    String order="";
                    String consumption= String.valueOf(sum);
                    if(!lblNewLabel_5.getText().equals("")){order+=(lblNewLabel_5.getText()+"*"+lblNewLabel_8.getText()+" ");}
                    if(!lblNewLabel_9.getText().equals("")){order+=(lblNewLabel_9.getText()+"*"+lblNewLabel_12.getText()+" ");}
                    if(!lblNewLabel_13.getText().equals("")){order+=(lblNewLabel_13.getText()+"*"+lblNewLabel_16.getText()+" ");}
                    if(!lblNewLabel_17.getText().equals("")){order+=(lblNewLabel_17.getText()+"*"+lblNewLabel_20.getText()+" ");}
                    String Url = "jdbc:mysql://localhost:3306/jim?";
                    String name = "root";//数据库用户名
                    String psd = "1527296253";//数据库密码
                    String jdbcName = "com.mysql.cj.jdbc.Driver";//连接MySql数据库
                    String sql = "insert into "+id2+" values(?,?,?,?,?,?)";//数据库操作语句（插入）
                    String sql2 = "insert into food values(?,?,?,?,?,?,?,?)";
                    try {
                        Class.forName(jdbcName);
                        Connection con = DriverManager.getConnection(Url, name, psd);//与数据库建立连接
                        PreparedStatement pst = con.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
                        pst.setString(1, ways);
                        pst.setString(2, time);
                        pst.setString(3, adress);
                        pst.setString(4, phonenumber);
                        pst.setString(5, order);
                        pst.setString(6, consumption);
                        pst.executeUpdate();
                        PreparedStatement pst2 = con.prepareStatement(sql2);
                        pst2.setString(1, "3");
                        pst2.setString(2,id2);
                        pst2.setString(3, ways);
                        pst2.setString(4, time);
                        pst2.setString(5, adress);
                        pst2.setString(6, phonenumber);
                        pst2.setString(7, order);
                        pst2.setString(8, consumption);
                        pst2.executeUpdate();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (SQLException e2) {//执行与数据库建立连接需要抛出SQL异常
                        e2.printStackTrace();
                    }
                    new Pay();
                    String[] s = { "" };
                    Pay.main(s);
                }
            }
        });
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lblNewLabel_5.setText("");
                lblNewLabel_6.setText("");
                lblNewLabel_7.setText("");
                lblNewLabel_8.setText("");
                lblNewLabel_9.setText("");
                lblNewLabel_10.setText("");
                lblNewLabel_11.setText("");
                lblNewLabel_12.setText("");
                lblNewLabel_13.setText("");
                lblNewLabel_14.setText("");
                lblNewLabel_15.setText("");
                lblNewLabel_16.setText("");
                lblNewLabel_17.setText("");
                lblNewLabel_18.setText("");
                lblNewLabel_19.setText("");
                lblNewLabel_20.setText("");
                lblNewLabel_22.setText("0元");
            }
        });

    }
    public void list_1(String str1,String str2)throws Exception{
        for(int i=0;i<29;i++){
            if(str1.equals(food[i][0])&&(lblNewLabel_5.getText()).equals("")){ lblNewLabel_5.setText(food[i][0]);
                lblNewLabel_6.setText(food[i][1]);
                lblNewLabel_7.setText(food[i][2]);
                String count=str2;
                lblNewLabel_8.setText(count);
                Double d1 = new Double(food[i][2]);
                Double d2 = new Double(count);
                sum =sum+ d1*d2;
                break;}
            if(str1.equals(food[i][0])&&(lblNewLabel_9.getText()).equals("")){ lblNewLabel_9.setText(food[i][0]);
                lblNewLabel_10.setText(food[i][1]);
                lblNewLabel_11.setText(food[i][2]);
                String count=str2;
                lblNewLabel_12.setText(count);
                Double d1 = new Double(food[i][2]);
                Double d2 = new Double(count);
                sum =sum+ d1*d2;
                break;}
            if(str1.equals(food[i][0])&&(lblNewLabel_13.getText()).equals("")){ lblNewLabel_13.setText(food[i][0]);
                lblNewLabel_14.setText(food[i][1]);
                lblNewLabel_15.setText(food[i][2]);
                String count=str2;
                lblNewLabel_16.setText(count);
                Double d1 = new Double(food[i][2]);
                Double d2 = new Double(count);
                sum =sum+ d1*d2;
                break;}
            if(str1.equals(food[i][0])&&(lblNewLabel_17.getText()).equals("")){ lblNewLabel_17.setText(food[i][0]);
                lblNewLabel_18.setText(food[i][1]);
                lblNewLabel_19.setText(food[i][2]);
                String count=str2;
                lblNewLabel_20.setText(count);
                Double d1 = new Double(food[i][2]);
                Double d2 = new Double(count);
                sum =sum+ d1*d2;
                break;}
        }
        lblNewLabel_22.setText(sum+"元");
    }
}















