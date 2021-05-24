package com.network.international.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.network.international.entity.PosTransactions;
import com.network.international.service.PosService;

@RestController
@RequestMapping(value = "/pos", produces = MediaType.APPLICATION_JSON_VALUE)
public class PosController {

	@Autowired
	private PosService posService;

	@RequestMapping(method = RequestMethod.POST, path = "/transactions/save")
	public ResponseEntity<PosTransactions> register(@Valid @RequestBody PosTransactions input) {
		PosTransactions result = posService.savePosTransaction(input);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
