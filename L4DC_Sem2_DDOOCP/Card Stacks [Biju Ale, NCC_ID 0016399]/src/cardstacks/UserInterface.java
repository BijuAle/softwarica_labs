/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardstacks;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Biju Ale
 */
public class UserInterface extends JFrame implements ActionListener, NotificationListener {

    private JLabel lblEnterNotation;
    private JTextField txtDiceNotation;
    private static JTextArea txtNotification;
    private JButton btnSubmit, btnFutureCards, btnRemoved, btnDealt, btnShuffle, btnGetCard;
    private JPanel pnlUserInput, pnlCommands, pnlNotification;

    private NotationReader nreader;
    private HistoryDice historyDice;
    private CardStack cardStack;
    private CollectionCardStacks collectionCardStacks;
    private CardStackRemovedCards cardStackRemovedCards;
    private CardStackDealtCards cardStackDealtCards;
    private Graphics g;
    private static DrawActionListener drawActionListener;
    private static Canvas canvas;

    UserInterface() {

        //Setting up Frame Properties
        setSize(800, 850);
        setTitle("Card Stacks - authored by Biju Ale");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Stting up Container
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.setBackground(Color.decode("#F7E3CB"));

        //Instantiating components at NORTH (for input)
        lblEnterNotation = new JLabel("Enter dice notation");
        lblEnterNotation.setFont(new Font("Times New Roman", Font.BOLD, 20));

        txtDiceNotation = new JTextField(8);
        txtDiceNotation.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.GRAY, Color.BLUE), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        txtDiceNotation.setPreferredSize(new Dimension(30, 30));
        txtDiceNotation.setFont(new Font("Times New Roman", Font.BOLD, 20));

        btnSubmit = new JButton("SUBMIT");
        btnSubmit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnSubmit.setBackground(Color.DARK_GRAY);
        btnSubmit.setForeground(Color.LIGHT_GRAY);

        //Instantiating components at WEST (for commands)
        btnFutureCards = new MyButton("PEEK FUTURE CARDS");
        btnRemoved = new MyButton("PEEK REMOVED CARD");
        btnDealt = new MyButton("PEEK DEALT CARDS");
        btnShuffle = new MyButton("SHUFFLE");
        btnGetCard = new MyButton("GET CARD");

        //Instantiating panels for input, commands & notifciation
        pnlUserInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlUserInput.setBackground(Color.decode("#1DE9B6"));
        pnlCommands = new JPanel(new GridLayout(5, 1));
        pnlNotification = new JPanel(new GridLayout(1, 1));

        //Adding all components to input panel
        pnlUserInput.add(lblEnterNotation);
        pnlUserInput.add(txtDiceNotation);
        pnlUserInput.add(btnSubmit);

        //Adding all components to commands panel
        pnlCommands.add(btnGetCard);
        pnlCommands.add(btnShuffle);
        pnlCommands.add(btnDealt);
        pnlCommands.add(btnRemoved);
        pnlCommands.add(btnFutureCards);

        //Adding notification area
        txtNotification = new JTextArea(3, 50);
        txtNotification.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        txtNotification.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        txtNotification.setBackground(Color.decode("#1DE9B6"));
        JScrollPane txtNotificationScroll = new JScrollPane(txtNotification);

        c.add(pnlUserInput, BorderLayout.PAGE_START);
        c.add(pnlCommands, BorderLayout.LINE_START);
        c.add(txtNotificationScroll, BorderLayout.PAGE_END);

        //Adding action listener to all buttons
        btnSubmit.addActionListener(this);
        btnShuffle.addActionListener(this);
        btnRemoved.addActionListener(this);
        btnFutureCards.addActionListener(this);
        btnGetCard.addActionListener(this);
        btnDealt.addActionListener(this);

        //Initialize all stacks, dice & cardstack history
        historyDice = new HistoryDice();
        cardStackRemovedCards = new CardStackRemovedCards();
        cardStackDealtCards = new CardStackDealtCards();
        collectionCardStacks = new CollectionCardStacks();
        collectionCardStacks.addNotificationListener(this);

        //Instantiating canvas
        canvas = new Canvas();
        canvas.addNotificationListener(this);
        canvas.setPreferredSize(new Dimension(6000, 2000));
        canvas.setBackground(Color.decode("#F7E3CB"));
        JScrollPane canvasScroll = new JScrollPane(canvas);
        c.add(canvasScroll, BorderLayout.CENTER);

        drawActionListener = canvas;
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btnSrc = (JButton) e.getSource();
        if (btnSrc.equals(btnSubmit)) {
            String diceNotation = txtDiceNotation.getText();
            try {
                nreader = new NotationReader();
                nreader.parseDiceNotation(diceNotation);
                Dice dice = new Dice(nreader);
                if (historyDice.addToDiceHistory(dice)) {
                    cardStack = new CardStack(dice, nreader, cardStackRemovedCards);
                    collectionCardStacks.add(cardStack);
                    txtNotification.append("\n\nRolling...\n" + diceNotation + "'s combinations & frequencies added to card stack.");
                    btnGetCard.doClick();
                } else {
                    txtNotification.append("\n\nAlready rolled dice - " + diceNotation);
                    btnGetCard.doClick();
                }
            } catch (Exception ex) {
                txtNotification.append(ex.getMessage());
                txtDiceNotation.requestFocus();
            }
        } else if (btnSrc.equals(btnGetCard)) {
            canvas.sendSingleDealtCard(collectionCardStacks.moveDealtCard(txtDiceNotation.getText(), cardStackDealtCards));
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_GET_CARD;
        } else if (btnSrc.equals(btnDealt)) {
            canvas.sendAllDealtCards(cardStackDealtCards.getDealtCards(txtDiceNotation.getText()));
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_DEALT_CARD;
        } else if (btnSrc.equals(btnRemoved)) {
            canvas.sendRemovedCards(cardStackRemovedCards.getRemovedCards(txtDiceNotation.getText()));
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_REMOVED;
        } else if (btnSrc.equals(btnFutureCards)) {
            canvas.sendFutureCards(collectionCardStacks.getFutureCards(txtDiceNotation.getText()));
            canvas.ACTION_DRAW = Canvas.DRAW_FOR_FUTURE;
        } else if (btnSrc.equals(btnShuffle)) {
            if (collectionCardStacks.shuffleStack(txtDiceNotation.getText())) {
                txtNotification.append("\n\nShuffing stack " + txtDiceNotation.getText() + " complete.");
                canvas.repaint();
            } else {
                txtNotification.append("\n\nNo such stack to shuffle.");
            }
        }
    }

    @Override
    public void send(String notification
    ) {
        txtNotification.append(notification);
    }

    public class MyButton extends JButton {

        MyButton(String text) {
            setText(text);
            setFont(new Font("Century Gothic", Font.BOLD, 14));
            setBackground(Color.decode("#B38B6D"));
            setFocusPainted(false);
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        }
    }

    public static void main(String[] args) {
        UserInterface UI = new UserInterface();
        UI.setVisible(true);
    }
}
