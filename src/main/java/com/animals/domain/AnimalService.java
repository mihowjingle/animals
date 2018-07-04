package com.animals.domain;

import io.ebean.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Inject))
class AnimalService {

    private final AnimalRepository repository;

    Optional<Animal> findOne(Long id) {
        return repository.findOne(id);
    }

    List<Animal> findAll() {
        return repository.findAll();
    }

    Animal save(Animal animal) {
        return repository.save(animal);
    }

    Animal update(Animal animal) {
        return repository.update(animal);
    }

    void delete(Long id) {
        repository.delete(id);
    }
}
