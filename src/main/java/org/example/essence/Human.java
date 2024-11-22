package org.example.essence;

public class Human implements Comparable<Human> {

    private final String gender;
    private final int age;
    private final String surname;

    private Human(HumanBuilder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.surname = builder.surname;
    }

    @Override
    public int compareTo(Human o) {
        int surnameComparison = this.surname.compareTo(o.surname);
        if (surnameComparison != 0) {
            return surnameComparison;
        }

        int ageComparison = Integer.compare(this.age, o.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        return this.gender.compareTo(o.gender);
    }

    public static class HumanBuilder {
        private String gender;
        private int age;
        private String surname;

        public HumanBuilder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public HumanBuilder age(int age) {
            this.age = age;
            return this;
        }

        public HumanBuilder surname(String surname) {
            this.surname = surname;
            return this;
        }

        public Human build() {
            return new Human(this);
        }
    }
}

