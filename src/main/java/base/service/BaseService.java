package base.service;

import base.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {
    void add(T entity);
    List<T> displayAll();
    Optional<T> findById(ID id);
    void delete(ID id);
}
