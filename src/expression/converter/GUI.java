/*
        *Devontae Robinson
        *CMSC 350 Project 1
        *23-03-2021
        *This class contains the hand code of a GUI
        *It does not include any drag and drop.

*/

package expression.converter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author iTTaste
 */
public class GUI {
    JPanel panel1;                      //panel for holding all the components
    JButton btnPostfix,btnPrefix;       //two buttons for prefix and postfix
    JFrame frame1;                      //main frame of GUI
    JLabel label1,label2;               //two labels for input and output
    JTextField textField1,textField2;   //input and output text-fields
    
    
    //Below is a constructor of the class
    
    GUI(){
        frame1=new JFrame("Expression Converter");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(600, 200);
        panel1=new JPanel();
        panel1.setLayout(null);
        init();                         //self-defined method for initializing different components
        bounds();                       //method for setting the sizes and bounds of all components
        addComponent();                 //method which adds all the components in panel and panel in a frame
        frame1.setVisible(true);
        
        
        //Below is a actionListener on prefix to postfix button
        btnPostfix.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               PreToPost obj=new PreToPost();
               String s=obj.PreToPost(textField1.getText());
               result(s);
               
               
            }
        
        });
        
        
        //Below is a actionListener on postfix to prefix button
        btnPrefix.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                PostToPre obj=new PostToPre();
               String s=obj.PostToPre(textField1.getText());
               result(s);
               
            }
        
        });
    }
    
    //method for displaying the relavent results of the methods
    private void result(String s){
        if(s.equals("0")){
                    textField2.setText("");
                    JOptionPane.showMessageDialog(frame1, "Trying to pop from empty stack");
        }
        else if(s.equals("1")){
            textField2.setText("");
            JOptionPane.showMessageDialog(frame1, "Items still in the stack");
        }
        else{
            textField2.setText(s);
        }
        
    }
    
    //method for initializing components
    private void init(){
        btnPostfix=new JButton("Prefix to Postfix");
        btnPrefix=new JButton("Postfix to Prefix");
        label1=new JLabel("Enter Expression");
        label2=new JLabel("Result");
        textField1=new JTextField();
        textField2=new JTextField();
    }
    
    
    //method for setting boundaries
    private void bounds(){
        label1.setBounds(0, 0, 100, 30);
        textField1.setBounds(105, 0, 350, 30);
        btnPostfix.setBounds(50, 50, 150, 30);
        label2.setBounds(0, 100, 100, 30);
        textField2.setBounds(105, 100, 350, 30);
        btnPrefix.setBounds(210, 50, 150, 30);
    }
    
    
    //method for adding components
    private void addComponent(){
        panel1.add(label1);
        panel1.add(textField1);
        panel1.add(btnPrefix);
        panel1.add(btnPostfix);
        panel1.add(label2);
        panel1.add(textField2);
        frame1.getContentPane().add(panel1);
    }
   
                                
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GUI g=new GUI();
        
        
    }
    
}
