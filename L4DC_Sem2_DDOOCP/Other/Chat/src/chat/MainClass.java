/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author Class
 */
public class MainClass {

    public static void main(String[] args) {
        // TODO code application logic here
        ChatClient user1 = new ChatClient("User 1");
        ChatClient user2 = new ChatClient("User 2");
        
        user1.addChatListener(user2);
        user2.addChatListener(user1);
        
        user1.setVisible(true);
        user2.setVisible(true);
    }
}
