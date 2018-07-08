package com.rest.core.service;

import com.rest.api.request.parameters.CreateStudentParameters;

public interface StudentService {

    public Long create(CreateStudentParameters params);

}
