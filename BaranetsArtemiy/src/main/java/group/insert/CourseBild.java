package group.insert;

public class CourseBild {

    private Integer COURSE_ID;

    private String DESCRIPTION;

    private String TITLE;

    public Integer getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(Integer COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public CourseBild(Integer COURSE_ID, String DESCRIPTION, String TITLE) {
        this.COURSE_ID = COURSE_ID;
        this.DESCRIPTION = DESCRIPTION;
        this.TITLE = TITLE;
    }
}
