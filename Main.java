package com.person;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Person originalPerson = new Person("Шевченко", "Тарас", 25);
        System.out.println("1. Початковий об'єкт: " + originalPerson);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(originalPerson);
        System.out.println("\n2. Об'єкт у форматі JSON:\n" + json);

        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("\n3. Відновлений об'єкт: " + deserializedPerson);

        boolean isEqual = originalPerson.equals(deserializedPerson);
        boolean isSameReference = (originalPerson == deserializedPerson);

        System.out.println("\n4. Результат перевірки:");
        System.out.println("originalPerson == deserializedPerson (посилання в пам'яті): " + isSameReference);
        System.out.println("originalPerson.equals(deserializedPerson) (логічна рівність): " + isEqual);
    }
}
