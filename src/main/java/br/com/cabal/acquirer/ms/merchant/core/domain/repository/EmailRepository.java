package br.com.cabal.acquirer.ms.merchant.core.domain.repository;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {
	
	@Query("FROM Email WHERE merchant.id = :merchant")
	List<Email> findAllByMerchantId(@Param("merchant") Long merchant);
}
