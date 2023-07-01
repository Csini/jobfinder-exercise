package hu.feladat.spring.service;

import java.util.UUID;

public interface ClientService {

	public UUID getClient(String name, String email);


}