import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private String phoneBookName;
    private Map<String,List<Contact>> groupBase = new HashMap<String,List<Contact>>();

    public PhoneBook (String phoneBookName){
        this.phoneBookName = phoneBookName;
    }

    public String getPhoneBookName() {
        return phoneBookName;
    }

    // Добавление контакта в группу по умолчанию
    public void addContact (Contact contact){

        if (groupBase.containsKey("defaultGroup")){
            groupBase.get("defaultGroup").add(contact);
        }
        else{
            groupBase.put("defaultGroup", new ArrayList<Contact>() );
            groupBase.get("defaultGroup").add(contact);
        }
    }

    // Добавление контакта в указанную группу
    public void addContact (Contact contact, String groupName){
        //List<Contact> contactList = new ArrayList<Contact>();
        if (groupBase.containsKey(groupName)){
            groupBase.get(groupName).add(contact);
        }
        else{
            groupBase.get(groupBase.put(groupName, new ArrayList<Contact>()));
            groupBase.get(groupName).add(contact);
        }
    }

    // Добавление группы с указанным именем и группой контактов
    public void addGroup (String groupName, ArrayList<Contact> contactList){
        if (groupBase.containsKey(groupName)){
            groupBase.get(groupName).addAll(contactList);
        }
        else{
            groupBase.get(groupBase.put(groupName, new ArrayList<Contact>())).addAll(contactList);
            //groupBase.get(groupName).add(contact);
        }
    }

    // Добавление группы с указанным именем
    public void addGroup (String groupName){
        //List<Contact> contactList = new ArrayList<Contact>();
        if (groupBase.containsKey(groupName)){
            System.out.println("Группа с именем - " + groupName + " уже существует.");
        }
        else {
            groupBase.put(groupName, new ArrayList<Contact>());
            System.out.println("Группа с именем - " + groupName + " создана.");
        };
    }

    // Поиск контактов по группе (вывод списка контактов по ключу - названию группы)
    public void showGroupContacts (String groupName){
        List<Contact> list = this.groupBase.get(groupName);
        for(Contact person : list){
            System.out.println(person.toString());
        }
    }

    // Поиск контакта по номеру
    public Contact findContact (String phoneNumber) {
        for (Map.Entry<String, List<Contact>> item : groupBase.entrySet()) {
            for (Contact contact : item.getValue()) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    return contact;
                }
            }
        }
        return null;
    }
}