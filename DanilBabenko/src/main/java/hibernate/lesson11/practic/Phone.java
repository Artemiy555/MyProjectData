package hibernate.lesson11.practic;

public class Phone {
    private Long number;
    private String mark;
    private String model;
    private Integer year;

    public Phone() {
    }

    public Phone(String mark, String model, Integer year) {
        this.mark = mark;
        this.model = model;
        this.year = year;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{Phone=");
        sb.append("number ='").append(number).append("\'");
        sb.append(", mark ='").append(mark).append("\'");
        sb.append(", model ='").append(model).append("\'");
        sb.append(", year ='").append(year).append("\'");
        sb.append("}");
        return sb.toString();
    }
}
