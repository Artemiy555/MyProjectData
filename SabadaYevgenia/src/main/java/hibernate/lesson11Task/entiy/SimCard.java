package hibernate.lesson11Task.entiy;

public class SimCard {

    private Integer namberID;
    private String operator;
    private Integer tarif;

    public SimCard(String operator, Integer tarif) {
        this.operator = operator;
        this.tarif = tarif;
    }

    public SimCard() { }

    public Integer getNamberID() { return namberID; }
    public void setNamberID(Integer namberID) { this.namberID = namberID; }
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }
    public Integer getTarif() { return tarif; }
    public void setTarif(Integer tarif) { this.tarif = tarif; }

    @Override
    public String toString() {
        return "SimCard{" +
                "namberID=" + namberID +
                ", operator='" + operator + '\'' +
                ", tarif=" + tarif +
                '}';
    }
}
