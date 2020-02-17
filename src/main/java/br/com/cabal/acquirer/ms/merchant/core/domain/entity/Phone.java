package br.com.cabal.acquirer.ms.merchant.core.domain.entity;

import br.com.cabal.acquirer.ms.merchant.core.domain.enums.TypePhoneEnum;
import br.com.cabal.acquirer.ms.merchant.core.domain.enums.converter.TypePhoneConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
@Getter
@Setter
public class Phone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PHONE")
	private Long id;
	
	@Column(name = "PHONE", length = 9, nullable = false)
	private String phone;
	
	@Convert(converter = TypePhoneConverter.class)
	@Column(name = "TYPE_PHONE", length = 1, nullable = false)
	private TypePhoneEnum typePhone;
	
	@ManyToOne
	@JoinColumn(name = "ID_MERCHANT", nullable = false)
	private Merchant merchant;
}
