package hu.feladat.spring.repository;

import java.util.List;

import hu.feladat.spring.model.Position;

public interface PositionRepositoryCustom {

	List<Position> findPositionsByTitleAndPlace(String title, String place);
}
