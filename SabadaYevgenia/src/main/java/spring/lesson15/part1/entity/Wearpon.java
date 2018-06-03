package spring.lesson15.part1.entity;

public class Wearpon {

    private String type;
    private Integer damage;
    private Integer waight;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getDamage() { return damage; }
    public void setDamage(Integer damage) { this.damage = damage; }
    public Integer getWaight() { return waight; }
    public void setWaight(Integer waight) { this.waight = waight; }

    @Override
    public String toString() {
        return "Wearpon{" +
                "type='" + type + '\'' +
                ", damage=" + damage +
                ", waight=" + waight +
                '}';
    }
}
