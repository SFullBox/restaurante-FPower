package com.comer.almoco.repositorys;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comer.almoco.models.ComerModel;

public interface ComerRepository extends JpaRepository<ComerModel,UUID> {

}
