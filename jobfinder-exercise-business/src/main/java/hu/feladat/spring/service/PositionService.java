package hu.feladat.spring.service;

import java.util.List;

import hu.feladat.spring.model.Position;

public interface PositionService {

	public Position savePosition(String title, String place);

	public Position getPosiion(Integer id);

	public List<Position> searchPosition(String location, String keywword);

}