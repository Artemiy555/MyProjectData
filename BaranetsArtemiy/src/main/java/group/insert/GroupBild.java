package group.insert;

import java.sql.Time;

public class GroupBild {

    private Integer GROUP_ID;
    private Time Begin;
    private Time BEGIN;
    private Integer COURSE_ID;
    private String TITLE;

    public GroupBild(Integer GROUP_ID, Time begin, Time BEGIN, Integer COURSE_ID, String TITLE) {
        this.GROUP_ID = GROUP_ID;
        Begin = begin;
        this.BEGIN = BEGIN;
        this.COURSE_ID = COURSE_ID;
        this.TITLE = TITLE;
    }

    public Integer getGROUP_ID() {
        return GROUP_ID;
    }

    public void setGROUP_ID(Integer GROUP_ID) {
        this.GROUP_ID = GROUP_ID;
    }

    public Time getBegin() {
        return Begin;
    }

    public void setBegin(Time begin) {
        Begin = begin;
    }

    public Time getBEGIN() {
        return BEGIN;
    }

    public void setBEGIN(Time BEGIN) {
        this.BEGIN = BEGIN;
    }

    public Integer getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(Integer COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }
}
