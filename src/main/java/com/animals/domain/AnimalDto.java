package com.animals.domain;

import lombok.Getter;

@Getter
class AnimalDto {
    private final Long id;
    private final String name;

    AnimalDto(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
    }
}
