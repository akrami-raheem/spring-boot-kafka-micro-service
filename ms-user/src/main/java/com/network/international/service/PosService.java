package com.network.international.service;

import com.network.international.entity.PosTransactions;

public interface PosService {

    PosTransactions savePosTransaction(PosTransactions input);

    Iterable<PosTransactions> findAll();
}
