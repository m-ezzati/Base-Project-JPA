package base.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {
    void add(T entity);
    List<T> displayAllOrder();
    Optional<T> findById(ID id);
    void delete(ID id);
}
