package hu.feladat.spring.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import hu.feladat.spring.model.Position;
import hu.feladat.spring.repository.PositionRepositoryCustom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class PositionRepositoryCustomImpl implements PositionRepositoryCustom {
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Position> findPositionsByTitleAndPlace(String title, String place) {
		
		log.info("findPositionsByTitleAndPlace: " + title + ", " + place);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Position> cq = cb.createQuery(Position.class);

		Root<Position> position = cq.from(Position.class);
		Predicate placePredicate = cb.equal(position.get("place"), place);
		Predicate titlePredicate = cb.like(position.get("title"), "%" + title + "%");
		cq.where(cb.or(placePredicate, titlePredicate));

		TypedQuery<Position> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
}
