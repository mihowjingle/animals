package com.animals.domain;

import io.ebean.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.jooby.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Inject))
class AnimalService {

    private final AnimalRepository repository;

    List<Animal> findAll() {
        return repository.findAll();
    }

    Optional<Animal> findOne(Long id) {
        return repository.findOne(id);
    }

    Animal save(Animal animal) {
        return repository.save(animal);
    }

    void delete(Long id) {
        repository.delete(id);
    }

    Result update(Animal animal) {
        Result result = new Result();
        if (!repository.exists(animal.getId())) {
            result.status(400);
            return result;
        }
        result.set(repository.update(animal));
        return result;
    }
}
