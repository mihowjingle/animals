package com.animals.domain;

import com.animals.config.security.Role;
import io.ebean.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.jooby.Result;
import org.jooby.Status;
import org.jooby.mvc.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
//@Transactional // <- app fails to start
@Path("/animals")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class AnimalResource {

    private final AnimalRepository repository;

    @GET
    @Path("/:id")
    @Role("admin")
    public Result animalPathVarExplicitResult(Long id) {

        final Result result = new Result();

        result.status(Status.OK);
        result.set(repository.findOne(id));

        return result;
    }

    @GET
    @Role("admin")
//    @Transactional // <- app fails to start
    public List<Animal> allAnimals() {
        return repository.findAll();
    }

    @GET
    @Role("admin")
    public Optional<Animal> animalRequestParam(Long id) {
        return repository.findOne(id);
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
