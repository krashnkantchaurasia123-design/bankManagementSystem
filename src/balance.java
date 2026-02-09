import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class balance extends JFrame implements Serializable {
    private JPanel jpanel;
    private JPanel jpanel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton searchButton;
    private JButton backButton;
    private JLabel balanceheading;
    private JPanel jpanel3;
    private JLabel csnlabel;
    private JLabel accnlabel;
    private JLabel totallabel;
    private JLabel name;
    private JLabel accountno;
    private JLabel balance;
    private JLabel notification;
    private JButton backButton1;

    JFrame homeFrame;
    balance(JFrame homeFrame){
        this.homeFrame=homeFrame;
        setTitle("Balance Check");
        setVisible(true);
        setSize(1380,725);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpanel1.setBackground(new Color(20, 16, 77));
        label1.setForeground(new Color(255,255,255));
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

                        if (data.accountNo.get(i).equals(accNo)) {

                            jpanel3.setVisible(true);
                            searchButton.setVisible(false);
                            backButton.setVisible(false);
                            name.setText(data.name.get(i));
                            accountno.setText(String.valueOf(data.accountNo.get(i)));

                            balance.setText(String.valueOf(data.balance.get(i)));

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        notification.setText("Account not found");
                    }

                }catch (NumberFormatException ex) {
                    notification.setText("Enter valid account number");
                } catch (Exception ex) {
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
        add(jpanel);

    }
    static void main() {
        new balance(new JFrame());
    }
}
