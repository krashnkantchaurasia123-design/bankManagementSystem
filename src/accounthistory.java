import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;



public class accounthistory extends JFrame {
    private JPanel jpanel1;
    private JPanel jpanel2;
    private JTable table1;
    private JLabel jlabel;
    private JButton backButton;
    private JPanel jpanel;
    JFrame homeFrame;
    accounthistory(JFrame homeFrame) {
        setVisible(true);

        setTitle("Bank Management System");
        setSize(1380,725);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jpanel1.setBackground(new Color(20, 16, 77));
        jlabel.setForeground(new Color(255,255,255));
        table1.setRowHeight(30);

        table1.getTableHeader().setFont(new java.awt.Font("Arial Black", java.awt.Font.BOLD, 24));

        Vector<String> columnNames = new Vector<>();
        columnNames.add("S No.");
        columnNames.add("Name");
        columnNames.add("Account No.");
        columnNames.add("Mobile No.");
        columnNames.add("Balance");

        Vector<Vector<Object>> dataa = new Vector<>();
        try {
            FileInputStream file = new FileInputStream("accountData.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            sData data = (sData) in.readObject();
            for(int i=0; i<data.accountNo.size(); i++){
                Vector<Object> row1 = new Vector<>();
                row1.add(i+1);
                row1.add(data.name.get(i));
                row1.add(data.accountNo.get(i));
                row1.add(data.mobileNo.get(i));
                dataa.add(row1);

            }
            DefaultTableModel model = new DefaultTableModel(dataa, columnNames);
            table1.setModel(model);


            JScrollPane scrollPane = new JScrollPane(table1);
            jpanel.add(scrollPane);

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        backButton.setBackground(new Color(20, 26, 77));
        backButton.setForeground(new Color(255,255,255));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                homeFrame.setVisible(true);
            }
        });
        jpanel.add(backButton, BorderLayout.SOUTH);


        add(jpanel);


    }

    static void main() {
        new accounthistory(new JFrame());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
