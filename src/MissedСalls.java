import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MissedСalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissingCall(String number){
        this.missedCalls.put(LocalDateTime.now(),number);
    };
    public void showMissedCalls (PhoneBook phoneBook){
        for(Map.Entry<LocalDateTime, String> item : missedCalls.entrySet()){
            String whoCall = "";
            if (phoneBook.findContact(item.getValue()) != null && item.getValue().equals((phoneBook.findContact(item.getValue())).getPhoneNumber())){
                whoCall = (phoneBook.findContact(item.getValue())).toString();
            }
            else
            whoCall = item.getValue();
            System.out.printf("Время вызова: " + item.getKey() + " - Звонил: " + whoCall + "\n");
        }
    }
}
