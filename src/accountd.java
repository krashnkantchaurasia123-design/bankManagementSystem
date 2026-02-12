import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class accountd extends JFrame implements Serializable{

    private JPanel jpanel;
    private JPanel jpanel1;
    private JLabel heading;
    private JPanel jpanel2;

    private JLabel accountlavel;
    private JTextField textField1;
    private JButton searchButton;
    private JButton backButton;
    private JPanel jpanel3;
    private JLabel d;
    private JLabel cnvalue;
    private JLabel customername;
    private JLabel accountno;
    private JLabel an;
    private JLabel mobileno;
    private JLabel mn;
    private JLabel age;
    private JLabel a;
    private JLabel notification;
    private JLabel total;
    private JLabel balance;
    private JButton backButton1;


    accountd(JFrame homeFrame) {

        setTitle("Bank Management System");
        jpanel1.setBackground(new Color(20, 16, 77));
        heading.setForeground(new Color(255, 255, 255));
        textField1.setPreferredSize(new Dimension(300, 25));
        setSize(1380,725);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        add(jpanel);
        setVisible(true);
        jpanel3.setVisible(false);
        backButton1.setBackground(new Color(20, 26, 77));
        backButton1.setForeground(new Color(255,255,255));
        backButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });

        searchButton.setBackground(new Color(20, 26, 77));
        searchButton.setForeground(new Color(255,255,255));
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                notification.setText("");
                boolean found = false;

                try {
                    FileInputStream file = new FileInputStream("accountData.txt");
                    ObjectInputStream in = new ObjectInputStream(file);

                    sData data= (sData) in.readObject();

                    String accNo =textField1.getText();

                    for (int i = 0; i < data.accountNo.size(); i++) {

                        if (data.accountNo.get(i).equals(accNo) ) {
                            jpanel3.setVisible(true);
                            searchButton.setVisible(false);
                            backButton.setVisible(false);
                            cnvalue.setText(data.name.get(i));
                            an.setText(String.valueOf(data.accountNo.get(i)));
                            mn.setText(String.valueOf(data.mobileNo.get(i)));
                            a.setText(String.valueOf(data.age.get(i)));
                            balance.setText(String.valueOf(data.balance.get(i)));

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        notification.setText("Account not found");
                    }

                }catch (Exception ex) {
                    ex.printStackTrace();
                    notification.setText("Error reading data");
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
    }
    static void main(String[] args) {

        new accountd(new JFrame());

    }
}
