/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author Biju
 */
public class MainClass {

    public static void main(String[] args) {
        // TODO code application logic here
        ChatClient user1 = new ChatClient("John");
        ChatClient user2 = new ChatClient("Sarah");
        
        user1.addChatListener(user2);
        user2.addChatListener(user1);
        
        user1.setVisible(true);
        user2.setVisible(true);
    }
}
