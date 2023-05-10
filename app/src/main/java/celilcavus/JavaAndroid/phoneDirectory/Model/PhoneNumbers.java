package celilcavus.JavaAndroid.phoneDirectory.Model;

import java.io.Serializable;

public class PhoneNumbers implements Serializable {
    public int Id;
    public String Name;
    public String LastName;

    public  String PhoneNumber;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public PhoneNumbers(int id, String name, String lastName, String phoneNumber) {
        Id = id;
        Name = name;
        LastName = lastName;
        PhoneNumber = phoneNumber;
    }
    public PhoneNumbers(){

    }
}
