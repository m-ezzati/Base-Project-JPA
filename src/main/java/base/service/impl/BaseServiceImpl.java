package base.service.impl;

import base.repository.BaseRepository;
import base.service.BaseService;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    protected final BaseRepository<T, ID> repository;

    public BaseServiceImpl(BaseRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public void add(T entity) {
        repository.add(entity);
        System.out.println("the "+ entity.getClass() + " added");
    }

    @Override
    public List<T> displayAllOrder() {
        return repository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}
