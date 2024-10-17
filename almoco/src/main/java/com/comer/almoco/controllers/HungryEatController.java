package com.comer.almoco.controllers;

import java.sql.SQLException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.comer.almoco.dtos.danilexDTO;
import com.comer.almoco.models.ComerModel;
import com.comer.almoco.repositorys.ComerRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("esquina")

public class HungryEatController {
	@Autowired
	ComerRepository repository;

	@GetMapping("comer")
	public ResponseEntity<?> getComida() {
		var teste = repository.findAll();
		return ResponseEntity.ok().body(teste);

	}

	@PostMapping("comida")
	public ResponseEntity<?> postComida(@RequestBody @Valid danilexDTO data) {
		ComerModel teste = new ComerModel();
		teste.setProteina(data.proteina());
		teste.setCarboidrato(data.carboidrato());
		teste.setFibra(data.fibra());
		teste.setGordura(data.gordura());
		teste.setBebida(data.bebida());
		teste.setSobremesa(data.sobremesa());
		repository.save(teste);
		return ResponseEntity.ok().body(teste);

	}

	@PutMapping("/{id_cad}")

	public ResponseEntity<?> putById(@Valid @RequestBody danilexDTO data, @PathVariable UUID id_cad)
			throws SQLException {
		ComerModel us = repository.findById(id_cad).get();
		us.updateDTO(data);
		repository.save(us);
		return ResponseEntity.ok("HEHE");

	}

	@DeleteMapping("/{id_cad}")

	public ResponseEntity<?> deleteById(@PathVariable UUID id_cad) {

		repository.deleteById(id_cad);

		return ResponseEntity.ok("salvo");

	}
}
