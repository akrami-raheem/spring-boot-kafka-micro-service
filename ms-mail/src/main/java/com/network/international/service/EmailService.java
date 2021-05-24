package com.network.international.service;

import com.network.international.entity.dto.PosTransactionsDto;

public interface EmailService {

    void sendSimpleMessage(PosTransactionsDto input);
}
