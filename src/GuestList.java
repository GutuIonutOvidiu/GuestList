import java.util.ArrayList;
import java.util.List;

public class GuestList {
    private int numberOfParticipants;
    private List<Guest> guestList;


    public GuestList(int numberOfParticipant) {
        this.guestList = new ArrayList<Guest>();
        this.numberOfParticipants = numberOfParticipant;
    }


    public int add(Guest otherGuest) {

        if(guestList.contains(otherGuest)) {
            return -1;
        }else {
            guestList.add(otherGuest);
            if(guestList.size() <= numberOfParticipants) {
                otherGuest.notification( guestList.size(), numberOfParticipants);
                return 0;
            }else {
                otherGuest.notification( guestList.size(), numberOfParticipants);
                return guestList.size();
            }
        }
    }

    public Guest findGuestByFullName(String firstName, String lastName) {
        for(Guest guest : guestList) {
            if(guest.compareFullName(firstName,lastName)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestByFirstName(String firstName) {
        for(Guest guest : guestList) {
            if(guest.compareFirstName(firstName)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestByLastName(String lasttName) {
        for(Guest guest : guestList) {
            if(guest.compareLastName(lasttName)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestByEmail(String email) {
        for(Guest guest : guestList) {
            if(guest.compareEmail(email)) {
                return guest;
            }
        }
        return null;
    }

    public Guest findGuestByPhone(String phoneNumber) {
        for(Guest guest : guestList) {
            if(guest.comparePhoneNumber(phoneNumber)) {
                return guest;
            }
        }
        return null;
    }

    private boolean removeAndNotifyGuest(Guest guest) {
        if(guest != null) {
            int guestIndex = guestList.indexOf(guest);
            guestList.remove(guest);
            if(guestIndex < numberOfParticipants && numberOfParticipants <= guestList.size() ) {
                guestList.get(numberOfParticipants-1).notification( numberOfParticipants, numberOfParticipants);
            }
            return true;
        }
        return false;
    }

    public boolean removeGuestByFullName(String firstName, String lastName) {
        Guest guest = findGuestByFullName(firstName,lastName);
        return removeAndNotifyGuest(guest);
    }


    public boolean removeGuestByEmail(String email) {
        Guest guest = findGuestByEmail(email);
        return removeAndNotifyGuest(guest);
    }


    public boolean removeGuestByPhoneNumber(String phoneNumber) {
        Guest guest = findGuestByPhone(phoneNumber);
        return removeAndNotifyGuest(guest);
    }


    public void printListOfParticipants() {
        for(int i = 0; i < this.numberOfParticipants; i++ ) {
            System.out.println(guestList.get(i).toString());
        }
    }



    public void printListOfWattingParticipants() {
        for(int i = this.numberOfParticipants ; i < guestList.size(); i++ ) {
            System.out.println(guestList.get(i).toString());
        }
    }

    public int numberOfOpenPosition() {

        if(guestList.size() < this.numberOfParticipants) {
            int openPosition = this.numberOfParticipants - guestList.size();
            return openPosition;
        }else {
            return 0;
        }
    }

    public int numberOfWattingParticipants() {

        if(guestList.size() > this.numberOfParticipants) {
            int wattingParticipants = guestList.size() - this.numberOfParticipants ;
            return wattingParticipants;
        }else {
            return -1;
        }
    }

    public int numberTotalOfList() {
        return guestList.size();
    }

    public int numberOfParticipants() {
        if(this.numberOfParticipants > guestList.size()) {
            return guestList.size();
        }else {
            return this.numberOfParticipants;
        }
    }

    public List<Guest> searchSubstring(String substr) {
        List<Guest> guestMatch = new ArrayList<Guest>();

        for(Guest guest: guestList) {
            if(guest.matchSubstr(substr)) {
                guestMatch.add(guest);
            }
        }

        return guestMatch;
    }
}
