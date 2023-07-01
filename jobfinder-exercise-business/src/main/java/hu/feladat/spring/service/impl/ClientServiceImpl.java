package hu.feladat.spring.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.feladat.spring.model.Client;
import hu.feladat.spring.repository.ClientRepository;
import hu.feladat.spring.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

	@Override
	public UUID getClient(String name, String email) {
		return repository.save(new Client(email, name, UUID.randomUUID())).getApikey();
	}
}
