package com.rest.api.endpoint;

import com.rest.api.dto.StudentDTO;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.parameters.CreateStudentParameters;
import com.rest.api.response.GeneralResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@SwaggerDefinition(info = @Info(description = "Rest API", version = "1.0.0", title = "Rest API"), produces = MediaType.APPLICATION_JSON_UTF8_VALUE, schemes = SwaggerDefinition.Scheme.HTTPS)
@Api(tags = "Students Endpoint", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, protocols = "https")
@RequestMapping("/students/")
public interface StudentsEndpoint {

    @ApiOperation(value = "student record create")
    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public GeneralResponse<Long> createStudent(GeneralRequest<CreateStudentParameters>parameters);

    @ApiOperation(value = "Student record delete")
    @RequestMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
    public GeneralResponse<Void> deleteStudent(
            @RequestParam("studentId") Long studentId);

    @ApiOperation(value = "Student record get by ID")
    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public GeneralResponse<StudentDTO> getStudent(
            @RequestParam("studentId") Long studentId);

}
