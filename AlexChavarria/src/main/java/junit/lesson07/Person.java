package junit.lesson07;

public class Person {

    private String name;
    private String surName;
    private int age;

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, String surName, int age) {

        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person){
            Person person = (Person) obj;
            if (person.name.equals(this.name)
                    && person.surName.equals(this.surName)
                    && person.age == this.age) {
                return true;
            }
        }
        return false;
    }
}
