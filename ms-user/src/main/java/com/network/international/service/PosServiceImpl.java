package com.network.international.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.network.international.entity.PosTransactions;
import com.network.international.kafka.producer.Sender;
import com.network.international.repository.PosRepository;

@Component
public class PosServiceImpl implements PosService {

	@Value("${spring.kafka.topic.posTransations}")
	private String POS_TRANSACTIONS_TOPIC;

	@Autowired
	private PosRepository posRepository;

	@Autowired
	private Sender sender;

	@Override
	public PosTransactions savePosTransaction(PosTransactions input) {
		PosTransactions createdUser = posRepository.save(input);
		sender.send(POS_TRANSACTIONS_TOPIC, createdUser);
		return createdUser;
	}

	@Override
	public Iterable<PosTransactions> findAll() {
		return posRepository.findAll();
	}
}
