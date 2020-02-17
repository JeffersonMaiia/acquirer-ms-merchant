package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "MERCHANT")
public class Merchant implements Serializable {
	
	private static final long serialVersionUID = -2664452051683795874L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_MERCHANT")
	private Long id;
	
	@Column(name = "DOCUMENT", length = 14, nullable = false)
	private String document;
	
	@Column(name = "COMPANY_NAME", length = 100, nullable = false)
	private String companyName;
	
	@Size(min = 20, max = 100)
	@Column(name = "TRADING_NAME", length = 100, nullable = false)
	private String tradingName;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_CREATE", nullable = false)
	private Date dataCreate;
	
	@OneToOne
	@JoinColumn(name = "ID_ADDRESS", nullable = false)
	public Address address;

	@PrePersist
	public void prePersist(){
		this.setDataCreate(new Date());
	}
}
