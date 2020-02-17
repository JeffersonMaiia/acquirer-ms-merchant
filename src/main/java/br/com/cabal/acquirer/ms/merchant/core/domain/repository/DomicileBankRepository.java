package br.com.cabal.acquirer.ms.merchant.core.domain.repository;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.DomicileBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicileBankRepository extends JpaRepository<DomicileBank, Long> {
	
	@Query("FROM DomicileBank WHERE merchant.id = :merchant")
	List<DomicileBank> findAllByMerchantId(@Param("merchant") Long merchant);
}
