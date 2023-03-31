import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String firstName ;
        String lastName ;
        String email;
        String phoneNumber;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti numarul de participanti la eveniment: ");
        int numberOfParticipants = sc.nextInt();

        GuestList listaInvitati = new GuestList(numberOfParticipants);
        sc.nextLine();

        System.out.println("Alegeti una dintre optiuni:");
        System.out.println("\thelp         - Afiseaza aceasta lista de comenzi");
        System.out.println("\tadd          - Adauga o noua persoana (inscriere)");
        System.out.println("\tcheck        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("\tremove       - Sterge o persoana existenta din lista");
        System.out.println("\tupdate       - Actualizeaza detaliile unei persoane");
        System.out.println("\tguests       - Lista de persoane care participa la eveniment");
        System.out.println("\twaitlist     - Persoanele din lista de asteptare");
        System.out.println("\tavailable    - Numarul de locuri libere");
        System.out.println("\tguests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("\twaitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("\tsubscribe_no - Numarul total de persoane inscrise");
        System.out.println("\tsearch       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("\tquit         - Inchide aplicatia");
        String optiune = sc.nextLine();

        while(!optiune.equals("quit") ) {
            switch (optiune){
                case "help":
                    System.out.println("\thelp         - Afiseaza aceasta lista de comenzi");
                    System.out.println("\tadd          - Adauga o noua persoana (inscriere)");
                    System.out.println("\tcheck        - Verifica daca o persoana este inscrisa la eveniment");
                    System.out.println("\tremove       - Sterge o persoana existenta din lista");
                    System.out.println("\tupdate       - Actualizeaza detaliile unei persoane");
                    System.out.println("\tguests       - Lista de persoane care participa la eveniment");
                    System.out.println("\twaitlist     - Persoanele din lista de asteptare");
                    System.out.println("\tavailable    - Numarul de locuri libere");
                    System.out.println("\tguests_no    - Numarul de persoane care participa la eveniment");
                    System.out.println("\twaitlist_no  - Numarul de persoane din lista de asteptare");
                    System.out.println("\tsubscribe_no - Numarul total de persoane inscrise");
                    System.out.println("\tsearch       - Cauta toti invitatii conform sirului de caractere introdus");
                    System.out.println("\tquit         - Inchide aplicatia");
                    break;

                case "add":
                    System.out.println("Adauga datele persoanei pentru inscriere:");
                    System.out.println("First name:");
                    firstName = sc.nextLine();
                    System.out.println("Last name:");
                    lastName = sc.nextLine();
                    System.out.println("Email:");
                    email = sc.nextLine();
                    System.out.println("Phone number:");
                    phoneNumber = sc.nextLine();
                    Guest guest = new Guest(firstName, lastName, email, phoneNumber );
                    listaInvitati.add(guest);
                    break;

                case "check":
                    System.out.println(" Optiuni de cautare: "
                            + "\n\t1. Check by full name" + "\n\t2. Check by email" + "\n\t3. Check by phone number");
                    String optionCheck = sc.nextLine();

                    if(optionCheck.equals("1") || optionCheck.equals("2") || optionCheck.equals("3") ) {
                        switch(optionCheck) {
                            case "1":
                                System.out.println("Introduceti numele de familie:");
                                firstName = sc.nextLine();
                                System.out.println("Introduceti prenumele:");
                                lastName = sc.nextLine();
                                System.out.println(listaInvitati.findGuestByFullName(firstName, lastName));
                                break;
                            case "2":
                                System.out.println("Introduceti email-ul:");
                                email = sc.nextLine();
                                System.out.println(listaInvitati.findGuestByEmail(email));
                                break;
                            case "3":
                                System.out.println("Introduceti numarul de telefon:");
                                phoneNumber = sc.nextLine();
                                System.out.println(listaInvitati.findGuestByPhone(phoneNumber));
                                break;
                            default:
                                break;
                        }
                    }
                    break;

                case "remove":
                    System.out.println(" Optiuni stergere dupa: "
                            + "\n\t1. Remove by full name" + "\n\t2. Remove by email" + "\n\t3. Remove by phone number");
                    String optionRemove = sc.nextLine();

                    if(optionRemove.equals("1")  || optionRemove.equals("2") || optionRemove.equals("3") ) {
                        switch(optionRemove) {
                            case "1":
                                System.out.println("Introduceti numele de familie:");
                                firstName = sc.nextLine();
                                System.out.println("Introduceti prenumele:");
                                lastName = sc.nextLine();
                                listaInvitati.removeGuestByFullName(firstName, lastName);
                                break;
                            case "2":
                                System.out.println("Introduceti email-ul:");
                                email = sc.nextLine();
                                listaInvitati.removeGuestByEmail(email);
                                break;
                            case "3":
                                System.out.println("Introduceti numarul de telefon:");
                                phoneNumber = sc.nextLine();
                                listaInvitati.removeGuestByPhoneNumber(phoneNumber);
                                break;
                            default:
                                break;
                        }
                    }
                    break;


                case "update":
                    System.out.println(" Optiuni de schimbare a datelor : "
                            + "\n\t1. Change firstName" +"\n\t2. Change lastName" + "\n\t3. Change email" + "\n\t4. Change phone number");
                    String option = sc.nextLine();
                    switch(option) {
                        case "1":
                            System.out.println("Introduceti numele de faimile pe care doriti sa il schimbati");
                            String firstName1 =sc.nextLine();
                            System.out.println("Introduceti  noul numele de faimile");
                            String firstName2 = sc.nextLine();
                            listaInvitati.findGuestByFirstName(firstName1).uppdateFirstName(firstName2);
                            break;

                        case "2":
                            System.out.println("Introduceti prenumele pe care doriti sa il schimbati");
                            String lastName1 =sc.nextLine();
                            System.out.println("Introduceti  noul prenumele de faimile");
                            String lastName2 = sc.nextLine();
                            listaInvitati.findGuestByLastName(lastName1).uppdateFirstName(lastName2);
                            break;

                        case "3":
                            System.out.println("Introduceti email pe care doriti sa il schimbati");
                            String oldEmail =sc.nextLine();
                            System.out.println("Introduceti  noul email ");
                            String newEmail = sc.nextLine();
                            listaInvitati.findGuestByEmail(oldEmail).uppdateEmail(newEmail);;
                            break;

                        case "4":
                            System.out.println("Introduceti numarul de telefon pe care doriti sa il schimbati");
                            String oldPhoneNumber =sc.nextLine();
                            System.out.println("Introduceti noul numar de telefon");
                            phoneNumber = sc.nextLine();
                            listaInvitati.findGuestByPhone(oldPhoneNumber).uppdatePhoneNumber(phoneNumber);
                            break;
                    }
                    break;

                case "guests":
                    System.out.println("Lista de persoane la evenimnet este urmatoarea: ");
                    listaInvitati.printListOfParticipants();
                    break;

                case "waitlist":
                    System.out.println("Lista persoanelor de pe lista de asteptare este: ");
                    listaInvitati.printListOfWattingParticipants();
                    break;

                case "available":
                    System.out.println("Numarul de locuri disponibile la evenimente este: " + listaInvitati.numberOfOpenPosition());
                    break;

                case "guests_no":
                    System.out.println("Numarul total de persoane inscrise la eveniment este de: " + listaInvitati.numberOfParticipants());
                    break;

                case "waitlist_no":
                    System.out.println("Numarul persoanelor pe lista de asteptare este de: " + listaInvitati.numberOfWattingParticipants());
                    break;

                case "subscribe_no":
                    listaInvitati.numberTotalOfList();
                    break;

                case "search":
                    System.out.println("Introduceti un subsir pentru cautare: ");
                    String subStringToFind = sc.nextLine();
                    System.out.println(listaInvitati.searchSubstring(subStringToFind).toString());
                    break;

                case "quit":
                    break;

                default:
                    System.out.println("Comanda invalida, alegeti una dintre optiuni");
                    break;
            }
            optiune = sc.nextLine();
        }
        sc.close();
    }
}
