package restaurant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class Pay extends JFrame{
    private JPanel contentPane;
    private JLabel avatar;
    private JPasswordField text2;
    private JButton user,manager,Register;
    public static void main(String[] args) {
        Pay frame2 = new Pay();
        frame2.setVisible(true);
    }
    public Pay(){
        this.setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550,320, 400, 300);
        setLocationRelativeTo(null);
        final ImageIcon icon15 =new ImageIcon("src/res/pay.jpg");
        final ImageIcon icon16 =new ImageIcon("src/res/paywall.jpg");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        avatar=new JLabel("");
        avatar.setIcon(icon15);
        avatar.setBounds(100,10,200,200);
        JLabel wall=new JLabel("");
        wall.setIcon(icon16);
        wall.setBounds(0,0,400,300);
        JLabel remind=new JLabel("请扫码支付");
        remind.setBounds(160,230,90,30);
        remind.setFont(new java.awt.Font("宋体", 1, 15));
        contentPane.add(remind);
        contentPane.add(avatar);
        contentPane.add(wall);
    }
}