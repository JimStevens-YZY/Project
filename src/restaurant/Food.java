package restaurant;
import restaurant.Cart;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Food extends JFrame {

    private JPanel contentPane;
    private static String rootname = "智慧订餐";
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootname);
    private JTree tree;
    private JLabel label_1,background,text,notice;
    private JTextField showtext;
    JMenuBar menuBar ;
    JMenu menu1,menu2,menu3;
    JMenuItem item1,item2,item3,item4,item5,item6;

    /*public static void main(String[] args) {
        Food frame = new Food();
        frame.setVisible(true);
    }*/
    public Food(String a,String b,String c,String d,String e,String f,String g) {
        final String ways=a;
        final String time=b;
        final String address=c;
        final String phonenumber=d;
        final String order=e;
        final String consumption=f;
        final String id2=g;
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 190  , 520);
        contentPane.add(scrollPane);
        //我的订单图片
        final ImageIcon icon1=new ImageIcon("src/res/icon-test.png");
        final ImageIcon icon2=new ImageIcon("src/res/icon-test-2.png");

        //Tree图片
        final ImageIcon icon3=new ImageIcon("src/res/icon-test-3.png");
        final ImageIcon icon4=new ImageIcon("src/res/xiaojuchang.png");
        final ImageIcon icon5=new ImageIcon("src/res/dinner.png");


        //菜单栏目图片
        final ImageIcon icon6=new ImageIcon("src/res/shopping.png");
        final ImageIcon icon7=new ImageIcon("src/res/people.png");
        final ImageIcon icon8=new ImageIcon("src/res/sunrise.png");
        final ImageIcon icon9=new ImageIcon("src/res/sun_max.png");
        final ImageIcon icon10=new ImageIcon("src/res/DND_mode.png");
        final ImageIcon icon11=new ImageIcon("src/res/phone.png");
        final ImageIcon icon12=new ImageIcon("src/res/Phone-2.png");


        //check图片
        final ImageIcon icon13=new ImageIcon("src/res/check.png");
        final ImageIcon icon16=new ImageIcon("src/res/bgc.JPG");
        final ImageIcon icon17=new ImageIcon("src/res/text.jpg");



        menuBar=new JMenuBar();
        menu1=new JMenu("个人中心");
        item1=new JMenuItem("我的订单",icon1);
        icon1.setImage(icon1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
        item1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JDialog jd1 = new JDialog();
                jd1.setVisible(true);
                jd1.setSize(255, 200);
                jd1.setLocation(480, 380);
                jd1.setLayout(new FlowLayout());
                JLabel texta = new JLabel("<html>您的消费记录如下</html>");
                JLabel textb = new JLabel("");
                if(ways==null){textb.setText("<html>暂无纪录</html>");}
                else{textb.setText(ways+" "+time+" "+" "+order+" "+consumption+"元");}
                texta.setFont(new java.awt.Font("宋体", 1, 15));
                jd1.add(texta);
                jd1.add(textb);

            }
        });
        item2=new JMenuItem("我的信息",icon2);
        icon2.setImage(icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog jd2 = new JDialog();
                jd2.setVisible(true);
                jd2.setSize(255, 130);
                jd2.setLocation(480, 380);
                jd2.setLayout(new FlowLayout());
                JLabel textc = new JLabel("<html>我的地址：</html>");
                final JLabel textd = new JLabel();
                textd.setText(address);
                textc.setFont(new java.awt.Font("微软雅黑", 1, 15));
                JLabel texte = new JLabel("<html>我的电话：</html>");
                texte.setFont(new java.awt.Font("微软雅黑", 1, 15));
                final JLabel textf= new JLabel();
                textf.setText(phonenumber);
                jd2.add(textc);
                jd2.add(textd);
                jd2.add(texte);
                jd2.add(textf);
            }
        });
        menu2=new JMenu("咨询方式");
        item3=new JMenuItem("电话一:5661692", icon11);
        icon11.setImage(icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        item4=new JMenuItem("电话二:5661695", icon12);
        icon12.setImage(icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));


        menu3=new JMenu("营业时间");
        item5=new JMenuItem("中餐 09:00—12:00", icon9);
        icon9.setImage(icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        item6=new JMenuItem("晚餐 14:00—17:00", icon10);
        icon10.setImage(icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));


        menu1.add(item1);
        menu1.addSeparator();
        menu1.add(item2);
        menu2.add(item3);
        menu2.addSeparator();
        menu2.add(item4);
        menu3.add(item5);
        menu3.addSeparator();
        menu3.add(item6);
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        setJMenuBar(menuBar);


        tree = new JTree(root);
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 1) {
                    if(tree.getSelectionPath()!=null){
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath()
                                .getLastPathComponent();
                        if(Food.class.getResource("/img/"+node.getParent()+"/"+node+".jpg")!=null)
                            label_1.setIcon(new ImageIcon(Food.class.getResource("/img/"+node.getParent()+"/"+node+".jpg")));
                    }

                }

            }
        });
        //设置Tree图标
        DefaultTreeCellRenderer renderer = (DefaultTreeCellRenderer) tree.getCellRenderer();
        renderer.setOpenIcon(icon3);
        icon3.setImage(icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));

        renderer.setClosedIcon(icon4);
        icon4.setImage(icon4.getImage().getScaledInstance(10, 10,Image.SCALE_DEFAULT));

        renderer.setLeafIcon(icon5);
        icon5.setImage(icon5.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT));



        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setViewportView(tree);

        label_1 = new JLabel("");
        label_1.setBounds(250, 46, 314, 227);
        notice = new JLabel("");
        notice.setText("请点击左侧开始点餐");
        notice.setBounds(250, 0, 314, 227);
        notice.setFont(new java.awt.Font("微软雅黑", 1, 34));
        text = new JLabel();
        text.setIcon(icon17);
        text.setBounds(250, 46, 314, 370);


       /* showtext = new JTextField();
        showtext.setBounds(285, 305, 236, 32);*/
        final JLabel text1=new JLabel();
        text1.setBounds(255, 320, 290, 100);
        text1.setFont(new java.awt.Font("微软雅黑", 1, 14));

        /* showtext.setColumns(10);*/

        JButton button = new JButton("订餐");
        button.setBounds(350, 500, 93, 23);
        background=new JLabel();
        background.setIcon(icon16);
        background.setBounds(0,0,630,540);

        contentPane.add(label_1);
        contentPane.add(text1);
        contentPane.add(button);
        contentPane.add(notice);
        contentPane.add(text);
        contentPane.add(background);


        Tree.jTree(root);
        tree.setOpaque(false);
        tree.setRootVisible(false);
        renderer.setTextSelectionColor(Color.GRAY);
        renderer.setBackgroundSelectionColor(new Color(205, 212, 205, 1));
        renderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 1));


        tree.setFont(new java.awt.Font("微软雅黑", 0, 15));

        DefaultTreeModel myModel = (DefaultTreeModel) tree.getModel();
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "铁板土豆牛肉盖饭") {

                    text1.setText("<html>A1:铁板土豆牛肉+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "铁板肉末水晶粉丝") {

                    text1.setText("<html>A2:肉末粉丝+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "百味鲜套餐一") {

                    text1.setText("<html>B1:香辣鸭块+香菇青菜+土豆炖茄子+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "百味鲜套餐二") {

                    text1.setText("<html>B2:蒜苗炒肉+青炒土豆丝+青椒炒蛋+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "百味鲜套餐三") {

                    text1.setText("<html>B3:红烧鱼块+干锅花菜+蒜泥黄瓜+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "粥铺套餐一") {

                    text1.setText("<html>C1:皮蛋瘦肉粥+三鲜蒸饺<br/><br/>¥12.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "粥铺套餐二") {

                    text1.setText("<html>C2:青菜肉丝火腿汤粉<br/><br/>¥13.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "粥铺套餐三") {

                    text1.setText("<html>C3:金针菇火腿鸡蛋汤粉<br/><br/>¥13.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "饼铺套餐一") {

                    text1.setText("<html>D1:里脊肉蛋炒饭<br/><br/>¥10.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "饼铺套餐二") {

                    text1.setText("<html>D2:鸡排蛋炒饭<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "饼铺热狗蛋炒饭") {

                    text1.setText("<html>D3:热狗蛋炒饭<br/><br/>¥12.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "西施豆腐") {

                    text1.setText("<html>E1:西施豆腐+配菜<br/><br/>¥13.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "饭团") {

                    text1.setText("<html>E2:基础配菜+热狗或者里脊肉<br/><br/>¥7.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "关东煮") {

                    text1.setText("<html>E3:海带+千张+豆腐+撒尿牛丸+甜不辣<br/><br/>¥10.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "麻辣香锅套餐") {

                    text1.setText("<html>F1:一人餐<br/><br/>¥12.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "黄焖鸡米饭套餐") {

                    text1.setText("<html>F2:一人餐<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "湘味铺套餐一") {

                    text1.setText("<html>G1:辣子鸡<br/><br/>¥13.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "湘味铺套餐二") {

                    text1.setText("<html>G2:梅干菜扣肉煲仔饭<br/><br/>¥16.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "湘味铺套餐三") {

                    text1.setText("<html>G3:土豆肉丝煲仔饭<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "牛柳套饭") {

                    text1.setText("<html>H1:牛肉+豆腐+土豆丝+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "酱鸭肉套饭") {

                    text1.setText("<html>H2:酱鸭+番茄鸡肉+油豆腐+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "三鲜套饭") {

                    text1.setText("<html>H3:三鲜+油豆腐白菜+土豆丝+米饭+饮料<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "清真牛杂盖饭") {

                    text1.setText("<html>I1:牛杂盖饭<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "清真兰州炒饭") {

                    text1.setText("<html>I2:兰州炒饭<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "清真牛肉炒年糕") {

                    text1.setText("<html>I3:牛肉炒年糕<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "清真红烧茄子盖饭") {

                    text1.setText("<html>I4:红烧茄子盖饭<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "西餐厅套餐一") {

                    text1.setText("<html>J1:黑椒肉酱焗饭+柠乐<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "西餐厅套餐二") {

                    text1.setText("<html>J2:黑椒无骨鸡柳焗饭+柠乐<br/><br/>¥15.00</html>");


                }
            }
        });
        tree.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (node.toString() == "西餐厅套餐三") {

                    text1.setText("<html>J3:日式照烧咖喱鸡丁焗饭+柠乐<br/><br/>¥15.00</html>");


                }
            }
        });
        myModel.reload();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Cart(id2);
            }
        });
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(205,170, 630, 580);
        setVisible(true);
    }
}



