package hu.feladat.spring.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.feladat.spring.model.Client;
import hu.feladat.spring.model.Position;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	
	public Optional<Client> findByApikey(UUID apikey);
}
