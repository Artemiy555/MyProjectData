package testsql.insert;

public class Directory {
    private String NAMEDISRASE;
    private String FREQUENCY;
    private String DESCRIPTION;
    private String DEPARTAMENT;

    public Directory(String NAMEDISRASE, String FREQUENCY, String DESCRIPTION, String DEPARTAMENT) {
        this.NAMEDISRASE = NAMEDISRASE;
        this.FREQUENCY = FREQUENCY;
        this.DESCRIPTION = DESCRIPTION;
        this.DEPARTAMENT = DEPARTAMENT;
    }

    public String getNAMEDISRASE() {
        return NAMEDISRASE;
    }

    public void setNAMEDISRASE(String NAMEDISRASE) {
        this.NAMEDISRASE = NAMEDISRASE;
    }

    public String getFREQUENCY() {
        return FREQUENCY;
    }

    public void setFREQUENCY(String FREQUENCY) {
        this.FREQUENCY = FREQUENCY;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getDEPARTAMENT() {
        return DEPARTAMENT;
    }

    public void setDEPARTAMENT(String DEPARTAMENT) {
        this.DEPARTAMENT = DEPARTAMENT;
    }
}
