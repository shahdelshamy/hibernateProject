/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginwithhn;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class NewAccount implements ActionListener {

    JFrame frame;

    private JLabel hello, firstName, lastName, phoneNumber,age,userName, password, confirme;
    private JTextField FText, LText, phoneText,ageText,userText;

    private JPasswordField passwordText, confirmeText;

    private JButton save;
    private JButton back;
    private JButton reset;

    public NewAccount() {
        frame = new JFrame();
        Font font1 = new Font("Arial", Font.CENTER_BASELINE, 20);
        Font font2 = new Font("Arial", Font.CENTER_BASELINE, 14);
      	Font font3 = new Font("Arial", Font.HANGING_BASELINE, 15);
        
        hello = new JLabel("Welcome Sir");
         hello.setFont(font1);
        firstName = new JLabel("FirstName:*");
        firstName.setFont(font2);
        lastName = new JLabel("LastName:*");
        lastName.setFont(font2);
        phoneNumber = new JLabel("PhoneNumber:*");
        phoneNumber.setFont(font2);
        age = new JLabel("Age:*");
        age.setFont(font2); 
        userName = new JLabel("UserName:*");
        userName.setFont(font2); 
        password = new JLabel("Password:*");
        password.setFont(font2);
        confirme = new JLabel("Confirmation:*");
        confirme.setFont(font2);

        FText = new JTextField();
        LText = new JTextField();
        phoneText = new JTextField();
        ageText = new JTextField();
        userText = new JTextField();

        passwordText = new JPasswordField();
        confirmeText = new JPasswordField();

        save = new JButton("Save");
        reset = new JButton("Reset");
        back = new JButton("Back <---");

        frame.setLayout(null);

        hello.setBounds(250, 0, 150, 60);
        firstName.setBounds(50, 55, 100, 50);
        lastName.setBounds(50, 102, 100, 50);
        phoneNumber.setBounds(39, 150, 125, 50);
        age.setBounds(60, 200, 125, 50);
        userName.setBounds(39, 250, 125, 50);
        password.setBounds(39, 300, 125, 50);
        confirme.setBounds(39, 350, 125, 50);

        FText.setBounds(160, 65, 150, 25);
        LText.setBounds(160, 115, 150, 25);
        phoneText.setBounds(160, 160, 150, 25);
        ageText.setBounds(160, 210, 150, 25);
        userText.setBounds(160, 260, 150, 25);
        passwordText.setBounds(160, 310, 150, 25);
        confirmeText.setBounds(160, 360, 150, 25);

        save.setBounds(330, 430, 75, 25);
        back.setBounds(80, 430, 100, 25);
        reset.setBounds(210, 430, 75, 25);
        
        frame.add(hello);
        frame.add(firstName);
        frame.add(lastName);
        frame.add(phoneNumber);
        frame.add(age);
        frame.add(userName);
        frame.add(password);
        frame.add(confirme);

        frame.add(FText);
        frame.add(LText);
        frame.add(phoneText);
        frame.add(ageText);
         frame.add(userText);
        frame.add(passwordText);
        frame.add(confirmeText);
        frame.add(save);
        frame.add(back);
       frame.add(reset);

        frame.setTitle("NewAccount");
        frame.setLocationRelativeTo(null);
        frame.setSize(500,550);
        frame.setVisible(true);
        
        save.addActionListener(this);
        reset.addActionListener(this);
       back.addActionListener(this);

    }
    
     public void actionPerformed(ActionEvent e) {
     if(e.getSource()==save){
     if(!FText.getText().isEmpty() && !LText.getText().isEmpty() && !phoneText.getText().isEmpty() && !ageText.getText().isEmpty()){
     if(passwordText.getText().equals(confirmeText.getText())){
     CRUD c=new CRUD();
     c.insert(userText.getText(),passwordText.getText(), FText.getText(),LText.getText(),phoneText.getText(),ageText.getText());
     save.setForeground(Color.red);
     JOptionPane.showConfirmDialog(null, "**Saved**");
     }else{
     JOptionPane.showConfirmDialog(null, "The password not matching");
     }
         
     }else{
     JOptionPane.showConfirmDialog(null, "There is Text empty!!");
     }
     
     }
     
     if(e.getSource()==reset){
     save.setForeground(Color.black);
     FText.setText("");
     LText.setText("");
     phoneText.setText("");
     ageText.setText("");
     userText.setText("");
     passwordText.setText("");
     confirmeText.setText(""); 
     }
     
     if(e.getSource()==back){
     frame.setVisible(false);
     GUI g=new GUI();
     }
     
     
     
     }

}
