package com.fonyou.test.app.infrastructure.mapper.mapstruct;

import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import com.fonyou.test.app.application.mapper.StudentMapper;
import com.fonyou.test.app.application.model.request.student.StudentRequest;
import com.fonyou.test.app.domain.model.student.Student;
import java.time.ZoneId;
import java.time.zone.ZoneRulesException;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapstructMapper extends StudentMapper {
    default Student requestToEntity(StudentRequest request) throws OperationNotAllowed {
        Student student = new Student();
        student.setName(request.getName());
        student.setBirthdate(request.getBirthdate());
        student.setCity(request.getCity());
        try {
            student.setTimezone(ZoneId.of(request.getTimezone()).getId());
        } catch (ZoneRulesException ex) {
            throw new OperationNotAllowed("Invalid timezone");
        }
        return student;
    }
}
