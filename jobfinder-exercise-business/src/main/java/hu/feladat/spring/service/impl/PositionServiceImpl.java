package hu.feladat.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.feladat.spring.config.NotFoundException;
import hu.feladat.spring.model.Position;
import hu.feladat.spring.repository.PositionRepository;
import hu.feladat.spring.repository.PositionRepositoryCustom;
import hu.feladat.spring.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService{


    @Autowired
    private PositionRepository repository;
    
    @Autowired
    private PositionRepositoryCustom repositoryCustom;

	
	@Override
	public Position savePosition(String title, String place) {
		return repository.save(new Position(title, place));
	}


	@Override
	public Position getPosiion(Integer id) {
		return repository.findById(id).orElseThrow(() ->new NotFoundException("Position wird id " + id + "not found!"));
	}


	@Override
	public List<Position> searchPosition(String keyword, String location) {
		return repositoryCustom.findPositionsByTitleAndPlace(keyword, location);
	}
	
	

}
