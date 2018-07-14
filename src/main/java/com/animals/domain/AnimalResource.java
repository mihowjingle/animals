package com.animals.domain;

import com.animals.config.security.Role;
import lombok.RequiredArgsConstructor;
import org.jooby.mvc.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Path("/animals")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class AnimalResource {

    private final AnimalRepository repository;

    @GET
    @Path("/:id")
    public Optional<Animal> unique(Long id) {
        return repository.findOne(id);
    }

    @GET
    public List<Animal> all() {
        return repository.findAll();
    }

    @POST
    @Role("admin")
    public Animal save(@Body Animal animal) {
        return repository.save(animal);
    }

    @PUT
    @Role("admin")
    public Animal update(@Body Animal animal) {
        return repository.update(animal);
    }

    @DELETE
    @Path("/:id")
    @Role("admin")
    public void delete(Long id) {
        repository.delete(id);
    }
}
