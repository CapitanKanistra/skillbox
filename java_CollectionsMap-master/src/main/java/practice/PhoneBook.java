package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PhoneBook {
    public final String NUMBER_VALIDATION = "[0-9]+";
    public final String NAME_VALIDATION = "^[а-яА-Я\\s]+";
    HashMap<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        if (phone.matches(NUMBER_VALIDATION) && name.matches(NAME_VALIDATION)) {
            phoneBook.put(phone, name);
            System.out.println("Контакт " + name + " сохранен");
        } else {
            System.out.println("Передан неверный формат телефонного номера");
        }
    }
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента


    public String getContactByPhone(String phone) {
        String result = "";
        if (phoneBook.containsKey(phone)) {
            result = phoneBook.get(phone) + " - " + phone;
        }

        return result;
    }
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку


    public Set<String> getContactByName(String name) {
        Set<String> result = new TreeSet<>();
        String twoPhoneName;

        if (phoneBook.containsValue(name)) {
            twoPhoneName = name + " - ";
            for (String phone : phoneBook.keySet()) {
                if (phoneBook.get(phone).equals(name)) {
                    twoPhoneName = twoPhoneName.concat(phone) + ", ";
                }
            }
            result.add(twoPhoneName.substring(0, twoPhoneName.length() - 2));
            return result;
        } else {
            return new TreeSet<>();
        }
    }

        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet

    public Set<String> getAllContacts() {
        Set<String> result = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String k = entry.getKey();
            String value = entry.getValue();
            if (!k.isEmpty() && !value.isEmpty()) {
                String phoneAndName = String.valueOf(getContactByName(value));
                result.add(phoneAndName.replaceAll("\\[", "").replaceAll("]", ""));
            } else {
                for (String key : phoneBook.keySet()) {
                    result.add(phoneBook.get(key) + " - " + key);
                }
            }
        }
        return result;
    }
}
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet


    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
