package service;

import java.util.List;
import java.util.Optional;

public interface ICRUDService <E>{
    Iterable<E> findAll();
    Optional<E> findById(Long id);
    void updateById(E e);
    void deleteById(Long id);
    E save(E e);
}
