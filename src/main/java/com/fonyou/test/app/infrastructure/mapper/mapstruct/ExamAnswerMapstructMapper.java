package com.fonyou.test.app.infrastructure.mapper.mapstruct;

import com.fonyou.test.app.application.mapper.ExamAnswerMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExamAnswerMapstructMapper extends ExamAnswerMapper {
}
