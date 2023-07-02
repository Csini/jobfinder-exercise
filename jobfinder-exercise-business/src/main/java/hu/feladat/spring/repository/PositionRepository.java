package hu.feladat.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.feladat.spring.model.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
}
