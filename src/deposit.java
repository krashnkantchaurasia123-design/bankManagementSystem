import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class deposit extends JFrame{
    private JPanel jpanel;
    private JTextField searchaccount;
    private JButton submitButton;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JLabel jlabel;
    private JLabel accounth;
    private JLabel nameoutput;
    private JLabel csname;
    private JLabel notification;
    private JPanel jpanel3;
    private JLabel csnamelabel;
    private JTextField amounttextField1;
    private JLabel amount;
    private JButton submitButton1;
    private JButton backButton;
    private JButton backButton1;
    private JButton backButton2;
    private JLabel customer;
    private JLabel accno;
    private JPanel jpanel4;
    private JLabel alabel;
    private JLabel tamo;

    String accNo;
    sData data;


    JFrame homeFrame;

    deposit(JFrame homeFrame){

        this.homeFrame=homeFrame;
        setTitle("Bank Management System");
        setVisible(true);
        setSize(1380,725);
        add(jpanel);
        jpanel3.setVisible(false);
        jpanel4.setVisible(false);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpanel1.setBackground(new Color(20, 16, 77));
        jlabel.setForeground(new Color(255,255,255));


        submitButton.setBackground(new Color(20, 26, 77));
        submitButton.setForeground(new Color(255,255,255));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notification.setText("");
                boolean found = false;

                try {
                    FileInputStream file = new FileInputStream("accountData.txt");
                    ObjectInputStream in = new ObjectInputStream(file);

                    data= (sData) in.readObject();
                    accNo = searchaccount.getText();
                    for (int i = 0; i < data.accountNo.size(); i++) {

                        if (data.accountNo.get(i).equals(accNo)) {
                            jpanel3.setVisible(true);
                            submitButton.setVisible(false);
                            backButton1.setVisible(false);
                            nameoutput.setText(data.name.get(i));

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        notification.setText("Account not found");
                    }

                } catch (Exception ex) {
                    notification.setText("Enter valid account number");
                }
            }
        });
        submitButton1.setBackground(new Color(20, 26, 77));
        submitButton1.setForeground(new Color(255,255,255));
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    float amo = Float.parseFloat(amounttextField1.getText());
                    for (int i = 0; i < data.accountNo.size(); i++) {
                        if (data.accountNo.get(i).equals(accNo) ) {
                            float bal = data.balance.get(i);
                            bal+=amo;
                            data.balance.set(i,bal);

                            String str = Float.toString(bal);

                            tamo.setText(str);
                            customer.setText(data.name.get(i));
                            accno.setText(String.valueOf(accNo));
                            alabel.setText(String.valueOf(amo));
                            tamo.setText(String.valueOf(bal));

                            jpanel4.setVisible(true);
                            submitButton1.setVisible(false);
                            backButton.setVisible(false);

                            try {
                                FileOutputStream fout = new FileOutputStream("accountData.txt");
                                ObjectOutputStream out = new ObjectOutputStream(fout);
                                out.writeObject(data);
                            }catch (Exception ex) {
                                notification.setText("Enter valid account number");
                            }

                            notification.setText("Deposit successful....");
                            break;

                        }
                    }
                }catch (Exception ex) {
                    notification.setText("Enter valid account number");
                }
            }
        });
        backButton.setBackground(new Color(20, 26, 77));
        backButton.setForeground(new Color(255,255,255));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });
        backButton1.setBackground(new Color(20, 26, 77));
        backButton1.setForeground(new Color(255,255,255));
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });
        backButton2.setBackground(new Color(20, 26, 77));
        backButton2.setForeground(new Color(255,255,255));
        backButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });

    }
    static void main() {
        new deposit(new JFrame());
    }
}
