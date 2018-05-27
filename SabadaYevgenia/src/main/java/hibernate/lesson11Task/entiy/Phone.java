package hibernate.lesson11Task.entiy;

public class Phone {

    private Integer namber;
    private String telephoneMarks;
    private String getTelephoneModel;
    private Integer year;

    public Phone(String telephoneMarks, String getTelephoneModel, Integer year) {
        this.telephoneMarks = telephoneMarks;
        this.getTelephoneModel = getTelephoneModel;
        this.year = year;
    }

    public Phone() {
    }

    public Integer getNamber() { return namber; }
    public void setNamber(Integer namber) { this.namber = namber; }
    public String getTelephoneMarks() { return telephoneMarks; }
    public void setTelephoneMarks(String telephoneMarks) { this.telephoneMarks = telephoneMarks; }
    public String getGetTelephoneModel() { return getTelephoneModel; }
    public void setGetTelephoneModel(String getTelephoneModel) { this.getTelephoneModel = getTelephoneModel; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }

    @Override
    public String
    toString() {
        return "Phone{" +
                "namber=" + namber +
                ", telephoneMarks='" + telephoneMarks + '\'' +
                ", getTelephoneModel='" + getTelephoneModel + '\'' +
                ", year=" + year +
                '}';
    }
}