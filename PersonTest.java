package com.person;

import com.google.gson.Gson;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testEqualsContract() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    void testJsonSerializationAndEquals() {
        Person original = new Person("Коваленко", "Олена", 21);
        Gson gson = new Gson();

        String json = gson.toJson(original);
        Person restored = gson.fromJson(json, Person.class);

        assertNotSame(original, restored, "Мають бути різні об'єкти в пам'яті");
        assertEquals(original, restored, "Об'єкти мають бути рівними за equals()");
        assertEquals(original.hashCode(), restored.hashCode(), "Хеш-коди мають збігатися");
    }
}
