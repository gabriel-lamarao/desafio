package com.anunciosapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.anunciosapp.models.Anuncio;
import com.anunciosapp.models.Relatorio;

public interface RelatorioRepository extends CrudRepository<Relatorio, String>{
	
}
