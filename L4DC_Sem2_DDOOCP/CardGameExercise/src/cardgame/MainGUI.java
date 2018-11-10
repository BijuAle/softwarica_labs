/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author madan
 */
public class MainGUI  extends JFrame implements ActionListener{
    private JTextArea displayArea;
    private JTextField inputCard;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnShuffle;
    private JButton btnShowCards;
    private final CardStack stack;
    

    public MainGUI() {
       initComponents();
       stack = new CardStack();
       
        
    }
    
    private void initComponents(){
        setSize(350, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        displayArea= new JTextArea(30, 30);
        displayArea.setPreferredSize(new Dimension(150, 50));
        inputCard= new JTextField(30);
        inputCard.setPreferredSize(new Dimension(150, 20));
        btnAdd= new JButton("Add");
        btnRemove= new JButton("Remove");
        btnShuffle= new JButton("Shuffle");
        btnShowCards= new JButton("Show All");
        getContentPane().add(inputCard);
        getContentPane().add(btnAdd);
        getContentPane().add(btnShuffle);
        getContentPane().add(btnShowCards);
        getContentPane().add(btnRemove);
        getContentPane().add(displayArea);
        
        btnAdd.addActionListener(this);
        btnRemove.addActionListener(this);
        btnShuffle.addActionListener(this);
        btnShowCards.addActionListener(this);
        
        
        
    }
    
    public static void main(String[] args) {
        new MainGUI().setVisible(true);
        System.out.println("test");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        if(source.equals(btnAdd)){
            try {
               Card   c = new Card(inputCard.getText());
                if(stack.addToStack(c)){
                displayArea.setText("Card added successfilly");
                }else{
                   displayArea.setText("Card already present in stack"); 
                }
            } catch (Exception ex) {
                displayArea.setText(ex.getMessage());
              
            }
            
       
            
        }
        
        else if(source.equals(btnRemove)){
             try {
               Card   c = new Card(inputCard.getText());
               if (stack.removeFromStack(c)){
                   displayArea.setText("Card removed");
               }else{
                  displayArea.setText("Card is not present in stack");
               }
            } catch (Exception ex) {
               displayArea.setText(ex.getMessage());
                
            }
            
         
        }
        
        else if(source.equals(btnShuffle)){
            stack.shuffle();
            displayArea.setText("Card shuffeled\n");
            
            for(Card c : stack.getCardStack()){
                displayArea.setText(displayArea.getText()+c.getNumber()+"\n");
            }
        }
        
        else if(source.equals(btnShowCards)){
            
            displayArea.setText("List of cards\n");
           for(Card c : stack.getCardStack()){
                displayArea.setText(displayArea.getText()+c.getNumber()+"\n");
            } 
        }
        
        
       
    }
    
   
    
    
    
}
