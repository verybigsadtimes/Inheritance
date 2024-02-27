import java.util.Scanner;
public class UseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of guests for the party >> "); //party guests
        int guests = sc.nextInt();
        Party p1 = new Party();
        p1.setGuests(guests);
        System.out.println("The party has " + p1.getGuests() + " guests");
        p1.displayInvitation();
        System.out.println("Enter number of guests for the dinner party >> "); //dinner party guests
        int dguests = sc.nextInt();
        DinnerParty dp1 = new DinnerParty();
        dp1.setGuests(dguests);
        System.out.println("Enter the menu option -- 1 for chicken or 2 for veggie >> "); //dinner party choice
        int dchoice = sc.nextInt();
        while(dchoice < 1 || dchoice > 2){ //range checker
            System.out.println("Please enter option 1 or 2 >> ");
            dchoice = sc.nextInt();
        }
        dp1.setDinnerChoice(dchoice);
        System.out.println("The dinner party has " + dp1.getGuests() + " guests");
        System.out.println("Menu option " + dp1.getDinnerChoice() + " will be served.");
        dp1.displayInvitation();
        System.out.println("Enter number of guests for the karaoke party >> "); //karaoke party guests
        int kguests = sc.nextInt();
        KaraokeParty kp1 = new KaraokeParty();
        kp1.setGuests(kguests);
        System.out.println("Enter number of songs >> "); //karaoke party song num
        int songs = sc.nextInt();
        kp1.setSongs(songs);
        System.out.println("The karaoke party has " + kp1.getGuests() + " guests");
        System.out.println("There will be " + kp1.getSongs() + " songs played.");
        p1.displayInvitation();
    }
}
