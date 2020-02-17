package br.com.cabal.acquirer.ms.merchant.core.domain.repository;

import br.com.cabal.acquirer.ms.merchant.core.domain.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

	@Query("FROM Phone WHERE merchant.id = :merchant")
	List<Phone> findAllByMerchantId(@Param("merchant") Long merchant);
}
