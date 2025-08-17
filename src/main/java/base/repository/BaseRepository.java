package base.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepository <T, ID>{

    void add(T type);
    void deleteById(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);
    }
