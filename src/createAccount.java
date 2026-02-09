import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class createAccount extends JFrame{
    private JPanel jpanel;
    private JPanel jpanel1;
    private JLabel jlable1;
    private JPanel jpanel3;
    private JTextField customerNameTextField;
    private JTextField accountNumberTextField;
    private JButton submitButton;
    private JButton backButton;
    private JLabel jlablen;
    private JTextField mobileNo;
    private JTextField age;
    private JTextField balance;
    private JLabel balancelabel;


    JFrame homeFrame;
    createAccount(JFrame homeFrame)  {

         this.homeFrame=homeFrame;
        setTitle("Bank Management System");
        setSize(1380,725);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        jpanel1.setBackground(new Color(20, 16, 77));
        jlable1.setForeground(new Color(255,255,255));
        setContentPane(jpanel);

        setVisible(true);

        backButton.setBackground(new Color(20, 26, 77));
        backButton.setForeground(new Color(255,255,255));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });
        submitButton.setBackground(new Color(20, 26, 77));
        submitButton.setForeground(new Color(255,255,255));
        submitButton.addActionListener(e -> {

            try {
                String n = customerNameTextField.getText();
                String acc = accountNumberTextField.getText().trim();
                String mob = mobileNo.getText().trim();

                String ageText = age.getText().trim();
                String balanceText = balance.getText().trim();

                if (n.isEmpty() || acc.isEmpty() || mob.isEmpty()
                        || age.getText().isEmpty() || balance.getText().isEmpty()) {
                    jlablen.setText("All fields are required!");
                    return;
                }

                if (!mob.matches("\\d{10}")) {
                    jlablen.setText("Enter valid 10-digit mobile number");
                    return;
                }

                if (!acc.matches("\\d{10,16}")) {
                    jlablen.setText("Invalid account number");
                    return;
                }
                int ag = Integer.parseInt(ageText);
                float ba = Float.parseFloat(balanceText);
                sData data= new sData();
                try {
                    long bytes = Files.size(Path.of("accountData.txt"));
                    if(bytes!=0){
                        FileInputStream fis =new FileInputStream("accountData.txt");
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        data = (sData) ois.readObject();
                        ois.close();
                    }

                    data.setData(n, acc, mob, ag,ba);
                    saveDataObjectToFile(data);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


                jlablen.setText(n + " Account is Successfully Created...");

                setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

            } catch (Exception ex) {
                ex.printStackTrace();
                jlablen.setText("Error!");
            }
        });
    }
    void saveDataObjectToFile(sData data) {
        try {
            FileOutputStream fos = new FileOutputStream("accountData.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(data);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void main(String[] args) throws IOException  {
        new createAccount( new JFrame());

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
