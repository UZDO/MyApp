package com.example.elenademidova.myapp;

import java.util.Objects;

public class Person {
    private String name;
    private String old;

    Person(String describe, String oldData) {
        name = describe;
        old = oldData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        return old.equals(person.old);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + old.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", old='" + old + '\'' +
                '}';
    }
}
