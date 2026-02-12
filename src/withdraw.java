import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class withdraw extends JFrame{
    private JPanel jpanel;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JLabel label1;
    private JTextField textField1;
    private JButton submitButton;
    private JPanel jpanel3;
    private JLabel custmorname;
    private JTextField textField2;
    private JLabel accountlabel;
    private JLabel customerlabel;
    private JLabel amountlabel;
    private JButton submitButton1;
    private JButton backButton;
    private JButton backButton1;
    private JLabel notification;
    private JPanel jpanel4;
    private JLabel csname;
    private JLabel cslabel;
    private JLabel transiction;
    private JLabel acclabel;
    private JLabel accno;
    private JButton backButton3;
    private JLabel withamount;
    private JLabel tamount;

    JFrame homeFrame;

    String accNo;

    withdraw(JFrame homeFrame){
        this.homeFrame=homeFrame;

        setVisible(true);
        setSize(1380,725);
        setTitle("Bank Management System");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpanel1.setBackground(new Color(20, 16, 77));
        label1.setForeground(new Color(255,255,255));
        jpanel3.setVisible(false);
        jpanel4.setVisible(false);

        submitButton.setBackground(new Color(20, 16, 77));
        submitButton.setForeground(new Color(255,255,255));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notification.setText("");
                boolean found = false;

                try {
                    FileInputStream file = new FileInputStream("accountData.txt");
                    ObjectInputStream in = new ObjectInputStream(file);

                    sData data= (sData) in.readObject();

                    accNo =textField1.getText();
                    for (int i = 0; i < data.accountNo.size(); i++) {

                        if (data.accountNo.get(i).equals(accNo) ) {
                            jpanel3.setVisible(true);
                            submitButton.setVisible(false);
                            backButton.setVisible(false);
                            custmorname.setText(data.name.get(i));


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

        backButton.setBackground(new Color(20, 16, 77));
        backButton.setForeground(new Color(255,255,255));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });

        submitButton1.setBackground(new Color(20, 16, 77));
        submitButton1.setForeground(new Color(255,255,255));
        submitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream file = new FileInputStream("accountData.txt");
                    ObjectInputStream in = new ObjectInputStream(file);

                    sData data= (sData) in.readObject();
                    float amo = Float.parseFloat(textField2.getText());
                    boolean updated = false;

                    for (int i = 0; i < data.accountNo.size(); i++) {
                        if (data.accountNo.get(i).equals(accNo)) {
                            float bal = data.balance.get(i);
                            if (bal > amo) {
                                bal -= amo;
                                data.balance.set(i, bal);
                                String str = Float.toString(bal);

                                csname.setText(data.name.get(i));
                                accno.setText(data.accountNo.get(i));
                                withamount.setText(String.valueOf(amo));
                                tamount.setText(str);

                                submitButton1.setVisible(false);
                                backButton1.setVisible(false);
                                jpanel4.setVisible(true);

                                notification.setText("Withdrow Successful......");
                                updated = true;

                            } else {
                                notification.setText("Enter right amount..");
                                return;
                            }
                            break;
                        }
                    }
                    if(updated){
                        FileOutputStream fout = new FileOutputStream("accountData.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fout);
                        out.writeObject(data);
                    }
                }catch (NumberFormatException ex) {
                    notification.setText("Enter valid account number");
                }catch (Exception ex) {
                    ex.printStackTrace();
                    notification.setText("Error processing withdrawal");
                }
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
        backButton3.setBackground(new Color(20, 26, 77));
        backButton3.setForeground(new Color(255,255,255));
        backButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });

        add(jpanel);
    }
    static void main() {
        new withdraw(new JFrame());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
