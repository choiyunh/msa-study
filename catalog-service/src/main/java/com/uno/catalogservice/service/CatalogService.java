package com.uno.catalogservice.service;

import com.uno.catalogservice.model.Catalog;

public interface CatalogService {
    Iterable<Catalog> getAllCatalogs();
}
