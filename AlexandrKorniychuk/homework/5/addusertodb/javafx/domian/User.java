package javafx.domian;

public class User {
    private Integer id;
    private String name;
    private String surname;

    public User(Integer id,String name,String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public User(String name,String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void setId (Integer id ) {
        this.id = id ;
    }
    public void setName (String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append("");
        return sb.toString();
    }
}
