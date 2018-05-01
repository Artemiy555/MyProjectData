package homework.db.dataBase.insert;

public class Record {
    private Integer number;
    private Integer koefA;
    private Integer koefB;
    private Integer koefC;
    private Integer descr;
    private Double x1;
    private Double x2;

    public Record(Integer number, Integer koefA, Integer koefB, Integer koefC, Integer descr, Double x1, Double x2) {
        this.number = number;
        this.koefA = koefA;
        this.koefB = koefB;
        this.koefC = koefC;
        this.descr = descr;
        this.x1 = x1;
        this.x2 = x2;
    }

    public Record(Integer number, Integer koefA, Integer koefB, Integer koefC, Integer descr, Double x1) {
        this.number = number;
        this.koefA = koefA;
        this.koefB = koefB;
        this.koefC = koefC;
        this.descr = descr;
        this.x1 = x1;
    }

    public Record(Integer number, Integer koefA, Integer koefB, Integer koefC, Integer descr) {
        this.number = number;
        this.koefA = koefA;
        this.koefB = koefB;
        this.koefC = koefC;
        this.descr = descr;
    }

    public Record() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getKoefA() {
        return koefA;
    }

    public void setKoefA(Integer koefA) {
        this.koefA = koefA;
    }

    public Integer getKoefB() {
        return koefB;
    }

    public void setKoefB(Integer koefB) {
        this.koefB = koefB;
    }

    public Integer getKoefC() {
        return koefC;
    }

    public void setKoefC(Integer koefC) {
        this.koefC = koefC;
    }

    public Integer getDescr() {
        return descr;
    }

    public void setDescr(Integer descr) {
        this.descr = descr;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Record{");
        sb.append("NUMBER='").append(number).append('\'');
        sb.append(", Koef A='").append(koefA).append('\'');
        sb.append(", Koef B='").append(koefB).append('\'');
        sb.append(", Koef C='").append(koefC).append('\'');
        sb.append(", Descr='").append(descr).append('\'');
        sb.append(", Result1='").append(x1).append('\'');
        sb.append(", Result2='").append(x2).append('\'');
        sb.append("}");
        return sb.toString();
    }
}
