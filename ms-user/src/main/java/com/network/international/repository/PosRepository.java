package com.network.international.repository;

import org.springframework.data.repository.CrudRepository;

import com.network.international.entity.PosTransactions;


public interface PosRepository extends CrudRepository<PosTransactions, Long> {

}