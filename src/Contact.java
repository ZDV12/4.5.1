import java.util.Objects;

public class Contact {

    private final String name;
    private final String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        return this.name + " ==> " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object obj){
        // проверка ссылки на объект
        if(this == obj) return true;

        // проверка ссылки на null или на несоответствие класса
        if(obj == null || !obj.getClass().equals(Contact.class)) return false;

        // приведение типа объекта для сравнения
        Contact altContact = (Contact) obj;

        // сравнение
        return name.equals(altContact.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}