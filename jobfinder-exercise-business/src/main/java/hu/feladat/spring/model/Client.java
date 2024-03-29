package hu.feladat.spring.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

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
public class Client implements Serializable {

	@Id
	@Email
	@Column(name="email")
	private String email;

	@Column(name="name", length = 100)
	private String name;
	
	@Column(name = "apikey", length = 36)
	@Type(type="uuid-char")
	private UUID apikey;
}
