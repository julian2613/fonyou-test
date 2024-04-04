package com.fonyou.test.quiz.infrastructure.mapper.mapstruct;

import com.fonyou.test.quiz.application.mapper.QuizMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuizMapstructMapper extends QuizMapper {
}
