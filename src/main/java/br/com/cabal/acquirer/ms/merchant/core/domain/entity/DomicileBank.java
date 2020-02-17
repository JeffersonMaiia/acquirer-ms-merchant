package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.ProductEnum;
import br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter.ProductConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "DOMICILE_BANK")
@Getter
@Setter
public class DomicileBank implements Serializable {
	
	private static final long serialVersionUID = -8834036353780785804L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ADDRESS")
	private Long id;
	
	@Convert(converter = ProductConverter.class)
	@Column(name = "PRODUCT", length = 1, nullable = false)
	private ProductEnum product;
	
	@Column(name = "DOMICILE", length = 3, nullable = false)
	private String domicile;
	
	@Size(min = 3)
	@Column(name = "AGENCY", length = 4, nullable = false)
	private String agency;
	
	@Column(name = "ACCOUNT", length = 10, nullable = false)
	private String account;
	
	@ManyToOne
	@JoinColumn(name = "ID_MERCHANT", nullable = false)
	private Merchant merchant;
}
