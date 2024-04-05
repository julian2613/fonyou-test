package com.fonyou.test.shared.model.repository;

import java.util.Optional;
import java.util.UUID;

public interface CrudRepository<ENTITY> {
    Optional<ENTITY> findById(UUID id);

    ENTITY save(ENTITY entity);
}
