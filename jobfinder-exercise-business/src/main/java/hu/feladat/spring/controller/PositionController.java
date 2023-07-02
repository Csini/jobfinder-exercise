package hu.feladat.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import hu.feladat.spring.model.Position;
import hu.feladat.spring.service.PositionService;
import hu.spring.feladat.openapi.api.PositionApi;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class PositionController implements PositionApi {

	private PositionService service;

	@Autowired
	public PositionController(PositionService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<String> savePosition(String title, String place) {
		return ResponseEntity.ok().body(ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()
				+ "/position/" + service.savePosition(title, place).getId());
	}

	@Override
	public ResponseEntity<hu.spring.feladat.openapi.model.Position> getPosition(Integer id) {
		Position dbPosition = service.getPosiion(id);
		hu.spring.feladat.openapi.model.Position position = new hu.spring.feladat.openapi.model.Position();
		position.setId(dbPosition.getId());
		position.setTitle(dbPosition.getTitle());
		position.setPlace(dbPosition.getPlace());
		return ResponseEntity.ok().body(position);

	}

}
