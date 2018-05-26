package spring.lesson15.entity;

public class Human {

    private String name;

    private Integer age;

    private Integer hp;

    public Human(String name, Integer age, Integer hp) {
        this.name = name;
        this.age = age;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hp=" + hp +
                '}';
    }
}
