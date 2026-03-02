package org.prog.collections.session12.MapHW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<PhoneOwner, List<Phone>> phoneOwners = new HashMap<>();

        PhoneOwner owner1 = new PhoneOwner("Ben");
        PhoneOwner owner2 = new PhoneOwner("Lisa");
        PhoneOwner owner3 = new PhoneOwner("Kate");
        PhoneOwner owner4 = new PhoneOwner("Viktor");

        List<Phone> benPhone = new ArrayList<>();
        benPhone.add(new Phone("Iphone 16"));
        benPhone.add(new Phone("ASUS ROG"));
        benPhone.add(new Phone("Iphone 15"));

        List<Phone> lisaPhone = new ArrayList<>();
        lisaPhone.add(new Phone("Xiaomi 13"));
        lisaPhone.add(new Phone("GOOGLE PIXEL 8"));

        List<Phone> katePhone = new ArrayList<>();
        katePhone.add(new Phone("Huawei"));
        katePhone.add(new Phone("Iphone Air"));

        List<Phone> viktorPhone = new ArrayList<>();
        viktorPhone.add(new Phone("Sony"));
        viktorPhone.add(new Phone("Motorola"));

        phoneOwners.put(owner1, benPhone);
        phoneOwners.put(owner2, lisaPhone);
        phoneOwners.put(owner3, katePhone);
        phoneOwners.put(owner4, viktorPhone);

        phoneOwners.get(owner1);
        for (Phone phone : phoneOwners.get(owner1)) {
            System.out.println(owner1.name + "\n" + phone.model);
        }
        phoneOwners.get(owner2);
        for (Phone phone : phoneOwners.get(owner2)) {
            System.out.println(owner2.name + "\n"  + phone.model);
        }
        phoneOwners.get(owner3);
        for (Phone phone : phoneOwners.get(owner3)) {
            System.out.println(owner3.name + "\n"  + phone.model);
        }
        phoneOwners.get(owner4);
        for (Phone phone : phoneOwners.get(owner4)) {
            System.out.println(owner4.name + "\n"  + phone.model);
        }
    }
}
