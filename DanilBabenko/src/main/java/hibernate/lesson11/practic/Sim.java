package hibernate.lesson11.practic;

public class Sim {
    private Long id;
    private String carier;
    private String tariff;

    public Sim() {

    }

    public Sim(String carier, String tariff) {
        this.carier = carier;
        this.tariff = tariff;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarier() {
        return carier;
    }

    public void setCarier(String carier) {
        this.carier = carier;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("{Sim=");
        sb.append("carier ='").append(carier).append("\'");
        sb.append(", tariff ='").append(tariff).append("\'");
        sb.append("}");
        return sb.toString();
    }
}
