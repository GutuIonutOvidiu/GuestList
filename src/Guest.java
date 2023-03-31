import java.util.Objects;

public class Guest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    Guest(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    Guest (String firstName, String lastName,String email){
        this(firstName,lastName);
        this.email = email;
    }

    Guest (String firstName, String lastName,String email,String phoneNumber){
        this(firstName,lastName,email);
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
    public void uppdateFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void uppdateLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void uppdateEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void uppdatePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean compareFirstName (String firstName) {
        if(this.firstName.equals(firstName)) {
            return true;
        }
        return false;
    }

    public boolean compareLastName (String lastName) {
        if(this.lastName.equals(lastName)) {
            return true;
        }
        return false;
    }

    public boolean compareFullName (String firstName, String lastName) {
        if(this.lastName.equals(lastName) && this.firstName.equals(firstName)) {
            return true;
        }
        return false;
    }

    public boolean compareEmail (String email) {
        if(this.email.equals(email)) {
            return true;
        }
        return false;
    }

    public boolean comparePhoneNumber (String phoneNumber) {
        if(this.phoneNumber.equals(phoneNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Guest other = (Guest) obj;
        return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
                && Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber);
    }

    public void notification(int curentPosition, int numberOfParticipants) {
        if( curentPosition <= numberOfParticipants) {
            System.out.println(this.firstName + " " + this.lastName +" ->> Felicitari! Locul tau la eveniment este confirmat.Numarul dvs. de ordine este: " + curentPosition  + ".Te asteptam!");
        }
        else if(curentPosition > numberOfParticipants) {
            int positionWaiting = curentPosition - numberOfParticipants ;
            System.out.println(this.firstName + " " + this.lastName + " ->> Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " + positionWaiting +  ".Te vom notifica daca un loc devine disponibil.");
        }
    }

    public boolean matchSubstr(String subStr) {

        CharSequence seq = subStr.toLowerCase().subSequence(0, subStr.length());

        return this.firstName.toLowerCase().contains(seq) || this.lastName.toLowerCase().contains(seq)
                || this.email.toLowerCase().contains(seq) || this.phoneNumber.toLowerCase().contains(seq);
    }


    @Override
    public String toString() {

        return "Guest info: " + "\n\t- First name: " + this.firstName
                + "\n\t- Last name: " + this.lastName
                + "\n\t- Email: " + this.email
                + "\n\t- Phone number: " + this.phoneNumber;

    }
}
