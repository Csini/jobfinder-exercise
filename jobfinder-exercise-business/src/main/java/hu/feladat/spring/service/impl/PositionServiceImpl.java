package hu.feladat.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.feladat.spring.model.Position;
import hu.feladat.spring.repository.PositionRepository;
import hu.feladat.spring.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{


    @Autowired
    private PositionRepository repository;

	
	@Override
	public Position savePosition(String title, String place) {
		return repository.save(new Position(title, place));
	}

}
