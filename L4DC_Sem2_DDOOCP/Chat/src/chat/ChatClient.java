/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Biju
 */
public class ChatClient extends JFrame implements ActionListener, ChatListener {

    String username;
    JLabel lblMsg;
    JTextField txtMsg;
    JTextArea txtHistory;
    JButton btnSend;
    ChatListener chatlst;

    public ChatClient(String username) {

        this.username = username;
        setTitle("Chat Client");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);

        lblMsg = new JLabel("Enter Message");
        txtHistory = new JTextArea(20, 20);
        txtMsg = new JTextField(30);
        btnSend = new JButton("Send");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        btnSend.addActionListener(this);

        c.add(lblMsg);
        c.add(txtMsg);
        c.add(btnSend);
        c.add(txtHistory);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String msg = txtMsg.getText();
        Message msg1 = new Message(username, msg);
        chatlst.send(msg1);
        String chatHistory = txtHistory.getText();
        txtHistory.setText(chatHistory + "\nYou:" + msg);

    }

    @Override
    public void send(Message msg) {
        String chatHistory = txtHistory.getText();
        txtHistory.setText(chatHistory + "\n" + msg.getUsername() + ": " + msg.getMsg());
    }

    public void addChatListener(ChatListener chatlst) {
        this.chatlst = chatlst;
    }

}
