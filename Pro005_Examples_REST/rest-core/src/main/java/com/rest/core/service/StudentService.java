package com.rest.core.service;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.parameters.CreateStudentParameters;

public interface StudentService {

    public Long create(CreateStudentParameters params);

    public void delete(Long id);

    public StudentDTO get(Long id);

}
