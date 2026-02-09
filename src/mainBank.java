import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mainBank extends JFrame {
    private JPanel jpanel;
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JPanel jpanel3;
    private JButton createAccountButton;
    private JButton depositButton;
    private JButton withdrawlButton;
    private JButton balanceCheckButton;
    private JButton accountDetailButton;
    private JButton transictionHistoryButton;
    private JButton signOutButton;
    private JLabel jlabel;
    private JFrame jframe;



    mainBank(){

        setTitle("Bank Management System");
        setVisible(true);
        setSize(1380,725);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jpanel1.setBackground(new Color(20, 16, 77));
        jlabel.setForeground(new Color(255,255,255));


        createAccountButton.setBackground(new Color(20, 26, 77));
        createAccountButton.setForeground(new Color(255,255,255));
        createAccountButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                createAccountButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                createAccountButton.setBackground(new Color(20, 16, 77));
            }

        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new createAccount(new mainBank());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        depositButton.setBackground(new Color(20, 26, 77));
        depositButton.setForeground(new Color(255,255,255));
        depositButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                depositButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                depositButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new deposit(new mainBank());


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        withdrawlButton.setBackground(new Color(20, 26, 77));
        withdrawlButton.setForeground(new Color(255,255,255));
        withdrawlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    new withdraw(new mainBank());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        withdrawlButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                withdrawlButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                withdrawlButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });

        balanceCheckButton.setBackground(new Color(20, 26, 77));
        balanceCheckButton.setForeground(new Color(255,255,255));
        balanceCheckButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                balanceCheckButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                balanceCheckButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });
        balanceCheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try{
                    new balance(new mainBank());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        accountDetailButton.setBackground(new Color(20, 26, 77));
        accountDetailButton.setForeground(new Color(255,255,255));
        accountDetailButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                accountDetailButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                accountDetailButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });
        accountDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                try {
                    new accountd(new mainBank());


                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
        transictionHistoryButton.setBackground(new Color(20, 26, 77));
        transictionHistoryButton.setForeground(new Color(255,255,255));
        transictionHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new accounthistory(new mainBank());
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        transictionHistoryButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                transictionHistoryButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                transictionHistoryButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });

        signOutButton.setBackground(new Color(20, 26, 77));
        signOutButton.setForeground(new Color(255,255,255));
        signOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signOutButton.setBackground(new Color(13, 58, 101));
            }
            @Override
            public void mouseExited(MouseEvent evt) {
                signOutButton.setBackground(new Color(20, 16, 77)); // back to normal
            }

        });
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(jpanel);

    }


    static void main() {
        new mainBank();
    }
}
