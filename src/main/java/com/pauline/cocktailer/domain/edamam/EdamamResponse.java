package com.pauline.cocktailer.domain.edamam;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class EdamamResponse {

    @JsonAlias("hits")
    private List<EdamamResult> results;
}
