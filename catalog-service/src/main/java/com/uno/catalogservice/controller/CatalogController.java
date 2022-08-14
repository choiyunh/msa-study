package com.uno.catalogservice.controller;

import com.uno.catalogservice.model.Catalog;
import com.uno.catalogservice.service.CatalogService;
import com.uno.catalogservice.vo.ResponseCatalog;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("catalog-service")
public class CatalogController {
    Environment env;
    CatalogService catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogService catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in catalog service on PORT %s",
                env.getProperty("local.server.port"));
    }

    @GetMapping("/user")
    public ResponseEntity<List<ResponseCatalog>> getUsers() {
        Iterable<Catalog> catalogs = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        catalogs.forEach(v ->
                result.add(new ModelMapper().map(v, ResponseCatalog.class)));


        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
