package com.animals.domain;

import org.jooby.Jooby;

public class AnimalRoutes extends Jooby {
    {
        get("/animals", (req, rsp) -> {
            System.out.println("allAnimalsFirst");
            final AnimalRepository repository = require(AnimalRepository.class);
            rsp.send(repository.findAll());
        }).attr("role", "allAnimalsFirst");

        get("/animals", (req, rsp) -> {
            System.out.println("allAnimalsSecond");
            final AnimalRepository repository = require(AnimalRepository.class);
            rsp.send(repository.findAll());
        }).attr("role", "allAnimalsSecond");

        post("/animals", (req, rsp) -> {
            System.out.println("save");
            final AnimalRepository repository = require(AnimalRepository.class);
            rsp.send(repository.save(req.body().to(Animal.class)));
        }).attr("role", "save"); // ...or }).attr("role", new Object[]{}); (ISSUE 3)
    }
}
