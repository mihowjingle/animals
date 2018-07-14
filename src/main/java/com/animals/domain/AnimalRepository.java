package com.animals.domain;

import io.ebean.EbeanServer;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor(onConstructor = @__(@Inject))
class AnimalRepository {

    private final EbeanServer ebean;

    List<Animal> findAll() {
        return ebean.find(Animal.class).findList();
    }

    Optional<Animal> findOne(Long id) {
        return ebean.find(Animal.class).where().eq("id", id).findOneOrEmpty();
    }

    Animal save(Animal animal) {
        ebean.save(animal);
        return animal;
    }

    void delete(Long id) {
        ebean.find(Animal.class).where().eq("id", id).delete();
    }

    Animal update(Animal animal) {
        ebean.update(animal);
        return animal;
    }

    boolean exists(Long id) {
        return id == null || ebean.find(Animal.class).where().eq("id", id).findCount() > 0;
    }
}
