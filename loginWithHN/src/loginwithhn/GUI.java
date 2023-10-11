/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwithhn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI implements ActionListener {

    JFrame f;
   NewAccount a;

    private JLabel userName, password;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton done, newAccount, reset;

    public GUI() {
        userName = new JLabel("userName:*");
        password = new JLabel("password:*");
        userText = new JTextField();
        passwordText = new JPasswordField();

        done = new JButton("Done");
        reset = new JButton("Reset");
        newAccount = new JButton("NewAccount");

        f = new JFrame();
        f.setLayout(null);

        userName.setBounds(50, 50, 100, 30);
        password.setBounds(50, 120, 100, 30);
        userText.setBounds(130, 50, 120, 30);
        passwordText.setBounds(130, 120, 120, 30);
        done.setBounds(270, 220, 75, 30);
        reset.setBounds(175, 220, 75, 30);
        newAccount.setBounds(20, 220, 130, 30);

        f.add(userName);
        f.add(password);
        f.add(userText);
        f.add(passwordText);
        f.add(done);
        f.add(reset);
        f.add(newAccount);

        done.addActionListener(this);
        reset.addActionListener(this);
        newAccount.addActionListener(this);

        f.setTitle("loginPage");
        f.setLocationRelativeTo(null);
        f.setSize(400, 350);
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == done) {
            if (!userText.getText().isEmpty() && !passwordText.getText().isEmpty()) {
                CRUD c = new CRUD();
                List<employees> l = c.select();
                int check=0;
                for (employees emp : l) {
                    if (userText.getText().equals(emp.getUserNameDB()) && passwordText.getText().equals(emp.getPasswordDB())) {    
                        check=1;
                        break;
                    }      
                }
                if(check==1){
                    JOptionPane.showConfirmDialog(null, "true");
                    }else{
                    JOptionPane.showConfirmDialog(null, "false");
                    
                    }

            } else {
                JOptionPane.showConfirmDialog(null, "The username or Password is empty!!");
            }

        }

        if (e.getSource() == reset) {
            userText.setText("");
            passwordText.setText("");
        }

        if (e.getSource() == newAccount) {
            f.setVisible(false);
             a = new NewAccount();

        }

    }

}
