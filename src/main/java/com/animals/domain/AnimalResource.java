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
//@Transactional // <- ISSUE 3: app fails to start
@Path("/animals")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class AnimalResource {

    private final AnimalRepository repository;

    @GET
    @Path("/:id")
    @Role("animalPathVarExplicitResult")
    public Result animalPathVarExplicitResult(Long id) {

        System.out.println("animalPathVarExplicitResult");
        final Result result = new Result();

        result.status(Status.OK);
        result.set(repository.findOne(id));

        return result;
    }

    @GET
    @Role("allAnimals")
//    @Transactional // <- ISSUE 3: app fails to start
    public List<Animal> allAnimals() {
        System.out.println("allAnimals"); // <- ISSUE 4: method is matched well, but attribute "role" somehow is from...
        return repository.findAll();
    }

    @GET
    @Role("animalRequestParam") // <- ISSUE 4: ...here
    public Optional<Animal> animalRequestParam(Long id) {
        System.out.println("animalRequestParam");
        return repository.findOne(id);
    }

    @POST
    @Role("save")
    public Animal save(@Body Animal animal) {
        System.out.println("save");
        return repository.save(animal);
    }

    @PUT
    @Role("update")
    public Animal update(@Body Animal animal) {
        System.out.println("update");
        return repository.update(animal);
    }

    @DELETE
    @Path("/:id")
    @Role("delete")
    public void delete(Long id) {
        System.out.println("delete");
        repository.delete(id);
    }
}
