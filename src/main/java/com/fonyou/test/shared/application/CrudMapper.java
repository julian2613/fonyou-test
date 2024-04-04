package com.fonyou.test.shared.application;

public interface CrudMapper<REQUEST, RESPONSE, ENTITY> {
    ENTITY requestToEntity(REQUEST request);

    RESPONSE entityToResponse(ENTITY entity);
}