package com.fonyou.test.shared.model.repository;

public interface CrudRepository<ENTITY> {
    ENTITY save(ENTITY entity);
}
