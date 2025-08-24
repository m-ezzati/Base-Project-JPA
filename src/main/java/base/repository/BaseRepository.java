package base.repository;

import base.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository <T extends BaseEntity<ID>, ID extends Serializable>{

    void add(T type);
    void deleteById(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);
    }
