package com.fonyou.test.app.application.mapper;

import com.fonyou.test.shared.application.mapper.CrudMapper;
import com.fonyou.test.app.application.model.request.student.StudentRequest;
import com.fonyou.test.app.application.model.response.student.StudentResponse;
import com.fonyou.test.app.domain.model.student.Student;

public interface StudentMapper extends CrudMapper<StudentRequest, StudentResponse, Student> {
}
