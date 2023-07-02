package hu.feladat.spring.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Position implements Serializable {

	@Id
	@GeneratedValue
	private int id;

	@Column(name="title", length = 50)
	private String title;
	
	@Column(name="place", length = 50)
	private String place;
	
	public Position(String title, String place) {
		super();
		this.title = title;
		this.place = place;
	}
	
}
