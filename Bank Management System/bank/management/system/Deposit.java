package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    TextField textField;
    JButton b1,b2;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/management/system/Icon/atmmachine.png"));
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(0,0,1550,830);
        add(l1);

        JLabel l2 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        l2.setFont(new Font("System",Font.BOLD,18));
        l2.setForeground(Color.WHITE);
        l2.setBounds(460,200,400,35);
        l1.add(l2);

        textField = new TextField();
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460,230,320,25);
        textField.setFont(new Font("Raleway",Font.BOLD,22));
        l1.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700,362,150,35);
        b1.setBackground(new Color(65,125,128));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l1.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700,406,150,35);
        b2.setBackground(new Color(65,125,128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l1.add(b2);

        setLayout(null);
        setSize(1550,1000);
        setLocation(0,0);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textField.getText();
            Date date = new Date();
            if(e.getSource() == b1){
                if(textField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"PLEASE ENTER THE AMOUNT THAT YOU WANT TO DEPOSIT");

                }else {
                    Con c = new Con();
                    c.statement.executeUpdate("insert into bank values('" + pin + "','" + date + "','Deposit','" + amount + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " DEPOSIT SUCCESFULLY");
                    setVisible(false);
                }
            } else if (e.getSource() == b2) {
                setVisible(false);

            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }
}
