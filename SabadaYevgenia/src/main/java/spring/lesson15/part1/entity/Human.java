package spring.lesson15.part1.entity;

public class Human {

    private String name;
    private Integer age;
    private Integer hp;
    private Wearpon wearpon;

    public Human(String name, Integer age, Integer hp) {
        this.name = name;
        this.age = age;
        this.hp = hp;
    }


    public Wearpon getWearpon() { return wearpon; }
    public void setWearpon(Wearpon wearpon) { this.wearpon = wearpon; }

    public String getName() { return name; }
    public Integer getAge() { return age; }
    public Integer getHp() { return hp; }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hp=" + hp +
                ", wearpon=" + wearpon +
                '}';
    }
}
