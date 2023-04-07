import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        PhoneBook phonebook = new PhoneBook();
        ArrayList<Contact> contactsList = new ArrayList<>();
        Reader reader = new Reader();
        reader.readFromFile(contactsList);
        Menu menu = new Menu();

        while (true) {
            menu.mainMenu();
            Scanner scn = new Scanner(System.in);
            String input = scn.nextLine();

            if (input.equals("w"))
                break;
            else if (input.equals("1")) 
            {
                for (int i = 0; i < contactsList.size(); i++) {
                    System.out.print(i + 1 + ". ");
                    contactsList.get(i).print();
                }
                menu.pressEnter();
            }
            else if (input.equals("2")){
                phonebook.addContact(contactsList);
            }
            else if (input.equals("3")) 
            {
                phonebook.deleteContact(contactsList);
                menu.pressEnter();
            } 
            else if (input.equals("4")) {
                Writer writer = new Writer();
                writer.writeToFile(contactsList);
            }
            else if (input.equals("5")){
                phonebook.setAdditionalNumber(contactsList);
            }
        }
    }
}
