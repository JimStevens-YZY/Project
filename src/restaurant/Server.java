package restaurant;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

import entity.FoodEntity;

public class Server extends JFrame {

    private JPanel panel1;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton add, edit, delete, save;
    DefaultTableModel tableModel;
    PreparedStatement prestmt = null;
    ResultSet rs = null;
    String query = "select * from food";
    Connection con = null;
    Statement st = null;
    private List<Integer> changeIndex = new ArrayList<>();
    private List<FoodEntity> foods = new ArrayList<>();
    public static void main(String[] args) {
        Server frame3 = new Server();
        frame3.setVisible(true);
    }

    public Server() {
        // this.setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 480);
        setTitle("后台订单管理");
        setLocationRelativeTo(null);
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        this.getContentPane().add(panel1, BorderLayout.NORTH);
        setContentPane(panel1);

        edit = new JButton("修改");
        delete = new JButton("删除");
        save = new JButton("保存");

        final JPanel panel2 = new JPanel();
        getContentPane().add(panel2, BorderLayout.CENTER);
        panel2.add(edit);
        panel2.add(delete);
        panel2.add(save);

        ResultSetMetaData rsd = null;
        Vector col = new Vector();
        Vector dat = new Vector();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            System.out.println("未找到相关的驱动程序!");
        }

        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jim?user=root&password=1527296253&useUnicode=true&characterEncoding=UTF8");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = st.executeQuery("select * from food");
            rsd = rs.getMetaData();
            for (int i = 1; i <= rsd.getColumnCount(); i++) {
                col.add(rsd.getColumnName(i));
            }
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= rsd.getColumnCount(); i++) {
                    v.addElement(rs.getString(i));
                }
                dat.addElement(v);
                FoodEntity foodEntity = new FoodEntity();//
                foodEntity.setId(v.get(0).toString());
                foodEntity.setName(v.get(1).toString());
                foodEntity.setWays(v.get(2).toString());
                foodEntity.setTime(v.get(3).toString());
                foodEntity.setAddress(v.get(4).toString());
                foodEntity.setPhonenumber(v.get(5).toString());
                foodEntity.setOrder(v.get(6).toString());
                foodEntity.setConsumption(v.get(7).toString());
                System.out.println(foodEntity);
                foods.add(foodEntity);
            }

            st.close();
            con.close();
            System.out.println("数据库加载成功!");
        } catch (SQLException e2) {
            System.out.println("table not found!" + e2.getNextException() + "\n" + e2.getSQLState());
        }

        /*
         * tableModel = new DefaultTableModel(dat,col) {
         *
         * public boolean isCellEditable(int row, int column) { return false; }
         * };
         */

        tableModel = new DefaultTableModel(dat, col);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        panel1.add(scrollPane, BorderLayout.NORTH);
        table.setEnabled(false);

        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table.setEnabled(true);
            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowcount = table.getSelectedRow();
                if (rowcount >= 0) {
                    delete(rowcount+1 );
                    tableModel.removeRow(rowcount);

                    /*
                     * try { String delete="delete from food where name=?";
                     * prestmt = con.prepareStatement(
                     * "delete from food where id=?"); prestmt.setString(1,
                     * String.valueOf(rowcount)); prestmt.executeUpdate();
                     * //prestmt.execute(); //rs = st.executeQuery(query); }
                     * catch (SQLException ex) { ex.printStackTrace(); }
                     */

                }
            }
        });
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                Integer rowIndex = e.getFirstRow();
                Integer colIndex = e.getColumn();
                if(null != rowIndex && null != colIndex) {//找到修改的那一个数据,来到此处把tableModel里的值对应进行修改，然后保存的时候再存到数据库
                    String changeValue = ((Vector)tableModel.getDataVector().get(rowIndex)).get(colIndex).toString();
                    System.out.println(((Vector)tableModel.getDataVector().get(rowIndex)).get(colIndex));
                    switch(colIndex){
                        case 0:foods.get(rowIndex).setId(changeValue);break;
                        case 1:foods.get(rowIndex).setName(changeValue);break;
                        case 2:foods.get(rowIndex).setWays(changeValue);break;
                        case 3:foods.get(rowIndex).setTime(changeValue);break;
                        case 4:foods.get(rowIndex).setAddress(changeValue);break;
                        case 5:foods.get(rowIndex).setPhonenumber(changeValue);break;
                        case 6:foods.get(rowIndex).setOrder(changeValue);break;
                        case 7:foods.get(rowIndex).setConsumption(changeValue);break;
                    }
                    changeIndex.add(rowIndex);
                    System.out.println(foods.get(rowIndex));
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con = null ;
                try {
                    con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/jim?user=root&password=1527296253&useUnicode=true&characterEncoding=UTF8");
                    String sql = "update food set name=?,ways=?,createtime=?,address=?,phonenumber=?,ordernum=?,consumption=? where id=?";
                    //String sql = "update food set name=?,address=?,contact=?,consumption=? where id=?";
                    prestmt = con.prepareStatement(sql);
                    for(Integer index : changeIndex) {
                        if(null != foods.get(index)) {
                            FoodEntity foodEntity = foods.get(index);
                            prestmt.setString(1, foodEntity.getName());
                            prestmt.setString(2, foodEntity.getWays());
                            prestmt.setString(3, foodEntity.getTime());
                            prestmt.setString(4, foodEntity.getAddress());
                            prestmt.setString(5, foodEntity.getPhonenumber());
                            prestmt.setString(6, foodEntity.getOrder());
                            prestmt.setString(7, foodEntity.getConsumption());
                            prestmt.setString(8, foodEntity.getId());
                            Integer affectedRow = prestmt.executeUpdate();
                            System.out.println("[id="+foodEntity.getId()+"]数据修改结果："+affectedRow);
                        }
                    }

                } catch (Exception e2) {
                    System.out.println(e2.getMessage());
                }finally {
                    if(null != con){
                        try {
                            con.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }

            }
        });

    }

    public void delete(Integer id) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jim?user=root&password=1527296253&useUnicode=true&characterEncoding=UTF8");
            prestmt = con.prepareStatement("delete from food where id=?");
            prestmt.setInt(1, id);
            prestmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}