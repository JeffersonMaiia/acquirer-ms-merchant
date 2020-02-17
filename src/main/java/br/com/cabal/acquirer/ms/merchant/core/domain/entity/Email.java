package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMAIL")
@Getter
@Setter
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EMAIL")
	private Long id;
	
	@Column(name = "EMAIL", length = 100, nullable = false)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ID_MERCHANT", nullable = false)
	private Merchant merchant;
}
