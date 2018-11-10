/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Author : Sijan Maharjan
 * Email    : cradleofloneliness@gmail.com
 * Created date : 11th may, 2016
 * Apex College_BCIS_Batch_2013
 *
 */
 
//package classact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

/** Tic-tac-toe was a paper-and-pencil game for two players, X and O, who take turns marking the spaces in a 3×3 grid. 
 * This is a desktop version. The player who succeeds in placing three of their marks in a horizontal, vertical, or diagonal row wins the game
 *
 * @author sijan maharjan
 */
public class TicTacToe extends JFrame implements ActionListener,MouseListener{
    
    /**
     * This constant array contains two possible default players to restrict.
     * 
     * These values are changed if user chose to input their name
     *
     *  <br/>player[0] = "player1"
     *  <br/>player[1] = "player2"
     */
    private static final String player[]={"player 1","player 2"};
    
    /**
     * This constant array contains two possible signs to restrict.
     */
    private static final String player_sign[]={"O","X"};
    
    /**
     * This will contain buttons serving as the input field after start method is invoked
     * @see start()
     */
    private final ArrayList <JButton> buttons =new ArrayList<>();
    
    /**
     * Actual buttons from ArrayList buttons will be added to this panel after start method is invoked
     * @see buttons
     * @see start()
     */
    private final JPanel panel1;
    
    /**
     * Game status label and reset button will be added to this panel after start method is invoked
     * 
     * @see start()
     * @see status
     * @see reset
     */
    private final JPanel panel2;
    
    /**
     * Game status is the text of this label.
     * 
     * game status can be :   <br/>-winned by player 1
     *                                               <br/>-winned by player 2
     *                                               <br/>-dismissed
     *                                               <br/>-turn change
     */
    private final JLabel status;
    
    /**
     * This button is used for reseting game once the game is won or dismissed.
     * 
     * It is enabled when any player wins game or game is dismissed and is disabled when user is playing game
     */
    private final JButton reset;
    
    /**
     * This variable defines which player's turn.
     * It's value is taken from constant array player and is changing.
     * 
     * <br/>default value is player[0] = player 1
     * 
     * @see player
     */
    private String turn = player[0];
    
    /**
     * Sign of player 1.
     * @see player_sign
     */
    private String pl1_sign=player_sign[0];
    
    /**
     * Sign of player2
     * @see player_sign
     */
    private String pl2_sign=player_sign[1];
    
    /**
     * This variable works as flag to denote if any of player has won the game.
     * <br/>true - if won
     * <br/>false - if no one has won
     */
    boolean won=false;
    
    /**
     * This variable will contains the button identification number once any of user win the game.
     *<br/> It will useful to show matched row, column or diagonal, simply by setting background color of buttons to black.
     * <br/>Such buttons are taken from ArrayList buttons using these identification number
     * 
     * @see buttons
     * @see won
     */
    private final int commons[]={-1,-1,-1};
    
    /**
     * This variable is used to count number of times user hit the button.
     * <br/> This is useful to know if game is over but no one has won ie game dismissed, ie if counter == 9
     */
    private int counter=0;
    
    /**
     * invoked to initialize application.
     */
    public TicTacToe(){
        panel1=new JPanel(new GridLayout(3,3,2,2));//3x3 grid to add 9 buttons
        panel2=new JPanel();
        status =new JLabel();
        reset=new JButton("Reset");
    }
    
    /**
     * invoked to start application.
     * <br/>this simply builds,adds required event listeners and displays
     */
    public void start(){
        setTitle("TicTacToe");
        if(JOptionPane.showConfirmDialog(this,"Enter your name?", "TicTacToe", JOptionPane.YES_NO_OPTION)==0){//if user chooses to enter name
            String name;
            name=JOptionPane.showInputDialog(this, "Player 1:");//name for player1
            if(name==null||name.equals("")){//if user cancels or doesnot enter any value
                name=player[0];
            }
            player[0]=name;//change name of player1
            name=JOptionPane.showInputDialog(this, "Player 2:");//name for player2
             if(name==null||name.equals("")){//if user cancels or doesnot enter any value
                name=player[1];
            }
             if(name.equals(player[0])){//to reduce collision of name of players
                 name+=" [2]";
             }
             player[1]=name;//change name of player2
        }//else use default name for players
        turn=player[0];//giving default turn to player1 
        status.setText("Turn : "+turn);
        for(int i=0;i<9;i++){//adding 9 buttons to ArrayList buttons as well as panel1
            buttons.add(new JButton());//add new button to arraylist
            buttons.get(buttons.size()-1).setFont(new Font("Sans",Font.PLAIN,35));//changes font name, style and size of text on button
            buttons.get(buttons.size()-1).setBackground(Color.WHITE);//sets background color of all buttons white
            buttons.get(buttons.size()-1).addActionListener(this);//to set text on button and check, get and update game status as user clicks buttons
            buttons.get(buttons.size()-1).addMouseListener(this);//to add feature of hovering on buttons
            panel1.add(buttons.get(buttons.size()-1));//add button to panel
        }
        panel2.add(status);//adding status to panel2
        reset.setEnabled(false);//disable reset button by default
        reset.setBackground(Color.white);//sets background color of reset button white
        reset.addActionListener(this);//to reset game
        panel2.add(reset);//adding reset button to panel2
        add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.SOUTH);
        setSize(300,320);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * invoked to start game.
     * @param args 
     */
    public static void main(String[]args){
        TicTacToe game=new TicTacToe();
        game.start();
    }
    
    /**
     * invoked to check and get game status
     * @return int   
     * <br/>0 - game not finished, no one yet won
     * <br/>1 - game won
     * <br/>2 - game finished, no one won
     * 
     * @see updateGameStatus()
     */
    public int getGameStatus(){
        counter++;//This method is invoked by updateGameStatus() method which is invoked everytime user clicks the button thus counter is increased as per button clicked
        String sign;
        if(turn.equals(player[0])){//setting player sign as turn contains player which is always changing as user presses button
                sign=pl1_sign;
        }else{
                sign=pl2_sign;
        }
        for(int i=0;i<9;i++){//because 9 buttons to see through and includes 8 if conditions because there is 8 chances to win
                if(i==0||i==3||i==6){//combination of 3 ifs to look horizontally
                    if((buttons.get(i).getText().equals(buttons.get(i+1).getText()))&&
                            (buttons.get(i+1).getText().equals(buttons.get(i+2).getText()))&&
                            (buttons.get(i+2).getText().equals(sign))){//ex: if (0,0),(0,1),(0,2) contains the sign of player currently in turn variable
                            commons[0]=i;//to identify common button
                            commons[1]=i+1;//to identify common button
                            commons[2]=i+2;//to identify common button
                            won=true;//then player won the game
                            break;
                    }
                }
                if(i==0||i==1||i==2){//combination of 3 ifs to look vertically
                    if((buttons.get(i).getText().equals(buttons.get(i+3).getText()))&&
                            (buttons.get(i+3).getText().equals(buttons.get(i+6).getText()))&&
                            (buttons.get(i+6).getText().equals(sign))){//ex: if (0,0),(1,0),(2,0) contains the sign of player currently in turn variable
                            commons[0]=i;
                            commons[1]=i+3;
                            commons[2]=i+6;
                            won=true;//then player won the game
                            break;
                    }
                }
                if(i==0){
                    if((buttons.get(0).getText().equals(buttons.get(4).getText()))&&
                            (buttons.get(4).getText().equals(buttons.get(8).getText()))&&
                            (buttons.get(8).getText().equals(sign))){
                            commons[0]=0;
                            commons[1]=4;
                            commons[2]=8;
                            won=true;
                            break;
                    }
                }
                if(i==2){
                    if((buttons.get(2).getText().equals(buttons.get(4).getText()))&&
                            (buttons.get(4).getText().equals(buttons.get(6).getText()))&&
                            (buttons.get(6).getText().equals(sign))){
                            commons[0]=2;
                            commons[1]=4;
                            commons[2]=6;
                            won=true;
                            break;
                    }
                }
        }
        if(won){//player won the game
            return 1;
        }else if(counter==9){//game dismissed
            return 2;
        }else{//change player turn
        return 0;
        }
    }
    
    /**
     * invoked to update status label in application.
     * This method is invoked each time user clicks button
     * 
     * @see getGameStatus()
     */
    public void updateGameStatus(){
        switch(getGameStatus()){
            case 0://change turn
                if(turn.equals(player[0])){
                    turn=player[1];
                }else{
                    turn=player[0];
                }
                status.setText("Turn : "+turn);
                reset.setEnabled(false);
                break;
            case 1://player won the game
                status.setText("Winner : "+turn);
                for(int i=0;i<9;i++){//to disable all button to force players stop click button
                    buttons.get(i).setEnabled(false);
                }
                for(int i=0;i<3;i++){//to show matched row, column or diagonal, simply by setting background color of buttons to black
                    buttons.get(commons[i]).setBackground(Color.black);
                }
                reset.setEnabled(true);
                break;
            case 2://dismiss the game
                status.setText("Game Dismissed!");
                reset.setEnabled(true);
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reset){//if user clicks reset button, reset game:-
            for(int i=0;i<9;i++){//to enable all disabled buttons
                buttons.get(i).setBackground(Color.white);//setting background color to default white for all buttons
                buttons.get(i).setText("");//setting text to nothing for all buttons
                buttons.get(i).setEnabled(true);//enabling all buttons
            }
            if(won){//change player sign
                    if(pl1_sign.equals(player_sign[0])){
                        pl1_sign=player_sign[1];
                        pl2_sign=player_sign[0];
                    }else{
                        pl1_sign=player_sign[0];
                        pl2_sign=player_sign[1];
                    }
            }//else leave it as it is
            counter=0;//set counter back to 0
            won=false;
            status.setText("Turn : "+turn);
            reset.setEnabled(false);//resetButton disabled
        }else{//if user clicks other buttons
            for(int i=0;i<9;i++){//loop nine times to check which button is clicked among of 9 buttons included in buttons ArrayList
                if(e.getSource()==buttons.get(i)){//if button that is clicked is been found, set player sign as text on that particular button, as per the player in turn, and disable it:-
                    if(turn.equals(player[0])){//if turn is of player1...
                        buttons.get(i).setText(pl1_sign);//set sign of player1 as text on that button
                    }else{//if turn is of player2...
                        buttons.get(i).setText(pl2_sign);//set sign of player2 as text on that button
                    }
                    buttons.get(i).setEnabled(false);//disable the button that is been clicked
                    break;
                }
            }
            updateGameStatus();//now check and update status of game
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
         for(int i=0;i<9;i++){//to check the button among of 9 buttons in which mouse entered into
            if(e.getSource()==buttons.get(i)){//if got the button...
                if(buttons.get(i).isEnabled()){//and only if that particular button is enabled...
                    if(turn.equals(player[0])){//and if current turn is of player1...
                        buttons.get(i).setText(pl1_sign);//set sign of player1 as text on that button
                    }else{//if current turn is of player2...
                        buttons.get(i).setText(pl2_sign);//set sign of player2 as text on that button
                    }
                }
                break;
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
         for(int i=0;i<9;i++){//to check the button among of 9 buttons in which mouse exited from
            if(e.getSource()==buttons.get(i)){//if got the button...
                if(buttons.get(i).isEnabled()){//and only if that particular button is enabled...
                    buttons.get(i).setText("");//remove text from that button
                }
                break;
            }
        }
    }
}
