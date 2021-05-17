package com.anunciosapp.repository;


import org.springframework.data.repository.CrudRepository;

import com.anunciosapp.models.Anuncio;

public interface AnuncioRepository extends CrudRepository<Anuncio, String>{
}
