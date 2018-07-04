package com.animals.domain;

import com.animals.config.security.Role;
import lombok.RequiredArgsConstructor;
import org.jooby.Result;
import org.jooby.Status;
import org.jooby.mvc.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
@Path("/animals")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class AnimalResource {

    private final AnimalService service;

    @GET
    @Path("/:id")
    @Role("admin")
    public Result animalPathVarExplicitResult(Long id) {

        final Result result = new Result();

        result.status(Status.OK);
        result.set(service.findOne(id));

        return result;
    }

    @GET
    @Role("admin")
    public List<Animal> allAnimals() {
        return service.findAll();
    }

    @GET
    @Role("admin")
    public Optional<Animal> animalRequestParam(Long id) {
        return service.findOne(id);
    }

    @POST
    @Role("admin")
    public Animal save(@Body Animal animal) {
        return service.save(animal);
    }

    @PUT
    @Role("admin")
    public Animal update(@Body Animal animal) {
        return service.update(animal);
    }

    @DELETE
    @Path("/:id")
    @Role("admin")
    public void delete(Long id) {
        service.delete(id);
    }
}
