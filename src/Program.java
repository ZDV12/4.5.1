import java.time.LocalDateTime;

public class Program {
    public static void main (String args[]) throws InterruptedException {
        try {
            PhoneBook phoneBook = new PhoneBook("Телефонный справочник");
            phoneBook.addGroup("Семья");
            phoneBook.addGroup("Работа");
            Contact petya = new Contact("Петя", "89123456789");
            Contact ivan = new Contact("Иван", "82126452730");
            Contact denis = new Contact("Денис", "82142345221");

            System.out.println("Контакты созданы");
            phoneBook.addContact(petya, "Семья");
            phoneBook.addContact(ivan, "Семья");
            phoneBook.addContact(petya, "Работа");
            phoneBook.addContact(denis);
            phoneBook.addContact(denis, "Семья");
            phoneBook.addContact(petya);
            phoneBook.addContact(ivan);

            System.out.println("Контакты добавлены");
            phoneBook.showGroupContacts("Семья");
            phoneBook.showGroupContacts("Работа");
            phoneBook.showGroupContacts("defaultGroup");


            Contact tempContact = phoneBook.findContact("89123456789");
            System.out.println(tempContact);
            tempContact = phoneBook.findContact("82142345221");
            System.out.println(tempContact);

            System.out.println("\nБлок с пропущенными вызовами:\n------------------------------------\n");
            MissedСalls missedСalls = new MissedСalls();
            missedСalls.addMissingCall("89123456789");
            Thread.sleep(2000);
            missedСalls.addMissingCall("89155456711");
            Thread.sleep(3000);
            missedСalls.addMissingCall("79135467719");
            System.out.println("Добавление завершено:\n----------------------------\n");
            missedСalls.showMissedCalls(phoneBook);

        }
        catch (Exception ex){
            System.out.println("Что-то пошло не так!\n");
            System.out.println(ex.getMessage());
        }


    }
}