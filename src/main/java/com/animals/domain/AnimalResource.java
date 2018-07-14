package com.animals.domain;

import com.animals.config.security.Role;
import lombok.RequiredArgsConstructor;
import org.jooby.Result;
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
    public Optional<Animal> findOne(Long id) {
        return service.findOne(id);
    }

    @GET
    public List<Animal> findAll() {
        return service.findAll();
    }

    @POST
    @Role("admin")
    public Animal save(@Body Animal animal) {
        return service.save(animal);
    }

    @PUT
    @Role("admin")
    public Result update(@Body Animal animal) {
        return service.update(animal);
    }

    @DELETE
    @Path("/:id")
    @Role("admin")
    public void delete(Long id) {
        service.delete(id);
    }
}
