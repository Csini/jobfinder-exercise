package hu.feladat.spring.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import hu.feladat.spring.service.ClientService;
import hu.spring.feladat.openapi.api.ClientApi;
import hu.spring.feladat.openapi.model.ClientResponse;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientController implements ClientApi {

	private ClientService service;

	@Autowired
	public ClientController(ClientService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<ClientResponse> getClient(String name, String email) {

		UUID apiKey = service.getClient(name, email);
		ClientResponse clientResponse = new ClientResponse(apiKey, email);
		return ResponseEntity.ok().body(clientResponse);
	}

}
