package ru.job4j.collection;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        System.out.println(office.get(citizen.getPassport()));
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestUserAlreadyExist() {
        Citizen citizen = new Citizen("123", "Petr Arsentev");
        Citizen citizen2 = new Citizen("123", "Ivan Ivanov");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(citizen2)).isFalse();
    }
}