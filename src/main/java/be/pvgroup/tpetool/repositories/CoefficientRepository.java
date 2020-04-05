package be.pvgroup.tpetool.repositories;

import java.math.BigDecimal;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import be.pvgroup.tpetool.model.Coefficient;

@Repository
public interface CoefficientRepository extends JpaRepository<Coefficient, Long> {

	public Optional<Coefficient> findByCode(String code);

	default Map<String, BigDecimal> loadAll() {
		return findAll().stream().collect(Collectors.toMap(o -> o.getCode(), o -> o.getValue()));
	}
}
