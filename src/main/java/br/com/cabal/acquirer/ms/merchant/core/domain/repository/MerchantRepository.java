package br.com.cabal.acquirer.ms.merchant.core.domain.repository;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
