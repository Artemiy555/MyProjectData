package group.service;

import group.entily.Group;
import group.entily.Student;

public interface StudentServise {

    Student create(
            Group group, String title);

}
