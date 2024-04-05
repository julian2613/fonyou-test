package com.fonyou.test.app.infrastructure.mapper.mapstruct;

import com.fonyou.test.app.application.mapper.QuizMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapstructMapper extends QuizMapper {
}