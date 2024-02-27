// By Tyler Lee and Matthew Zaluski :)

import java.awt.Graphics;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UParty extends JFrame implements ActionListener {
    // creates the labels, text fields, and buttons that will be added to the frame
    JLabel heading = new JLabel("Party Creator");
    //sets a default font size that will be used for things like the header
    Font bigFont = new Font("Arial", Font.BOLD, 16);
    JLabel enterGuests = new JLabel("Enter number of guests for the party: ");
    JTextField guestCount = new JTextField();
    JLabel enterDGuests = new JLabel("Enter number of guests for the dinner party: ");
    JTextField dguestCount = new JTextField();
    JCheckBox dOption = new JCheckBox("Select for vegetarian dinner option 2", false);
    JLabel enterKGuests = new JLabel("Enter number of guests for the karaoke party: ");
    JTextField kguestCount = new JTextField();
    JLabel enterKSongs = new JLabel("Enter number of songs that will be played: ");
    JTextField ksongCount = new JTextField();
    JButton press = new JButton("Confirm");
    //creates empty labels that will have user input added to
    JLabel partynum = new JLabel("");
    JLabel dpartynum = new JLabel("");
    JLabel dpartyopt = new JLabel("");
    JLabel kpartynum = new JLabel("");
    JLabel ksongnum = new JLabel("");
    //declares the default size for the frame
    final int WIDTH = 300;
    final int HEIGHT = 450;
    //UParty class
    public UParty(){
        super("My Frame");
        //sets the width and height of the frame
        setSize(WIDTH,HEIGHT);
        setLayout(new BorderLayout());
        //creates a new gridlayout for the labels, buttons, and text fields
        JPanel gridPanel1 = new JPanel(new GridLayout(0, 1));
        //adds our elements to the grid layout.
        gridPanel1.add(heading);
        gridPanel1.add(enterGuests);
        gridPanel1.add(guestCount);
        gridPanel1.add(enterDGuests);
        gridPanel1.add(dguestCount);
        gridPanel1.add(dOption);
        gridPanel1.add(enterKGuests);
        gridPanel1.add(kguestCount);
        gridPanel1.add(enterKSongs);
        gridPanel1.add(ksongCount);
        gridPanel1.add(partynum);
        gridPanel1.add(dpartynum);
        gridPanel1.add(dpartyopt);
        gridPanel1.add(kpartynum);
        gridPanel1.add(ksongnum);
        //sets the size and color of title text
        heading.setFont(bigFont);
        heading.setForeground(Color.red);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adds an action listener to the button
        press.addActionListener(this);
        //creates a new flowlayout for the confirm button
        JPanel button = new JPanel(new FlowLayout());
        button.add(press);
        //adds the panels to the frame
        add(gridPanel1, BorderLayout.NORTH);
        add(button, BorderLayout.SOUTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //creates new classes
        Party p1 = new Party();
        DinnerParty dp1 = new DinnerParty();
        KaraokeParty kp1 = new KaraokeParty();
        boolean isVeggie = dOption.isSelected();
        //checks if checkbox is clicked or unclicked
        if(e.getSource() == press) {
            if (isVeggie) {
                dp1.setDinnerChoice(2);
            }
            else{
                dp1.setDinnerChoice(1);
            }
        }
        //Updates the empty strings with the user input and adds the values to the classes
        //handles number of guests display
        String pnum = guestCount.getText();
        p1.setGuests(Integer.parseInt(pnum));
        String pnumtext = "The party has " + p1.getGuests() + " guests.";
        partynum.setText(pnumtext);
        partynum.setForeground(Color.blue);
        //handles number of dinner party guests display
        String dpnum = dguestCount.getText();
        dp1.setGuests(Integer.parseInt(dpnum));
        String dpnumtext = "The dinner party has " + dp1.getGuests() + " guests.";
        dpartynum.setText(dpnumtext);
        dpartynum.setForeground(Color.red);
        //handled dinner option display
        String dinopt = "Dinner option " + dp1.getDinnerChoice() + " will be served.";
        dpartyopt.setText(dinopt);
        dpartyopt.setForeground(Color.blue);
        //handles kareoke party number display
        String knum = kguestCount.getText();
        kp1.setGuests(Integer.parseInt(knum));
        String kpnumtext = "The karaoke party has " + kp1.getGuests() + " guests.";
        kpartynum.setText(kpnumtext);
        kpartynum.setForeground(Color.red);
        //handles the amount of karaoke songs that will be played
        String ksong = ksongCount.getText();
        kp1.setSongs(Integer.parseInt(ksong));
        String ksongtext = kp1.getSongs() + " songs will be played.";
        ksongnum.setText(ksongtext);
        ksongnum.setForeground(Color.blue);
    }
    //main function that runs the Party Class
    public static void main(String[] args) {

        UParty ex = new UParty();
        ex.setVisible(true);
    }
}