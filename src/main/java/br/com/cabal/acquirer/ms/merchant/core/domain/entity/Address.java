package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
public class Address implements Serializable {
	
	private static final long serialVersionUID = 5676027555787275043L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	private Long id;
	
	@Column(name = "ZIP_CODE", length = 8, nullable = false)
	private String zipCode;
	
	@Column(name = "PUBLIC_PLACE", length = 100, nullable = false)
	private String publicPlace;
	
	@Column(name = "NEIGHBORHOOD", length = 100, nullable = false)
	private String neighborhood;
	
	@Column(name = "CITY", length = 50, nullable = false)
	private String city;
	
	@Column(name = "COMPLEMENT", length = 1000)
	private String complement;

	@Column(name = "UF", length = 2, nullable = false)
	private String uf;
	
}
