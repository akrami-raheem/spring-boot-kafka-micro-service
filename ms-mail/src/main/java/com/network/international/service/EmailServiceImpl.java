package com.network.international.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.network.international.entity.Mail;
import com.network.international.entity.dto.PosTransactionsDto;
import com.network.international.repository.MailRepository;

@Component
public class EmailServiceImpl implements EmailService {

	@Autowired
	public JavaMailSender emailSender;

	@Autowired
	public MailRepository mailRepository;

	@Override
	public void sendSimpleMessage(PosTransactionsDto posTransactionsDto) {
		try {

			Mail newMail = new Mail();
			newMail.setTo(getEmailAddress(posTransactionsDto.getAccountNo()));
			newMail.setSubject("POS Transaction");
			newMail.setText("Transaction of amount " + posTransactionsDto.getAmount());

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(newMail.getTo());
			message.setSubject(newMail.getSubject());
			message.setText(newMail.getText());

			mailRepository.save(newMail);
			emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}

	}

	private String getEmailAddress(String accountNumber) {
		String emailAddress = "";
		return emailAddress;
	}
}
