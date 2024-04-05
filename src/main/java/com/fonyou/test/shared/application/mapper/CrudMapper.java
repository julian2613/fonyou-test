package com.fonyou.test.shared.application.mapper;

import com.fonyou.test.shared.model.exception.OperationNotAllowed;
import java.util.List;

public interface CrudMapper<REQUEST, RESPONSE, ENTITY> {
    ENTITY requestToEntity(REQUEST request) throws OperationNotAllowed;

    RESPONSE entityToResponse(ENTITY entity);

    List<RESPONSE> entityToResponse(List<ENTITY> entity);
}