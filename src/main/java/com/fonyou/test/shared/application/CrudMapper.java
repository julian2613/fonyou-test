package com.fonyou.test.shared.application;

import com.fonyou.test.shared.model.exception.OperationNotAllowed;

public interface CrudMapper<REQUEST, RESPONSE, ENTITY> {
    ENTITY requestToEntity(REQUEST request) throws OperationNotAllowed;

    RESPONSE entityToResponse(ENTITY entity);
}