package vn.goline.cp24.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.goline.cp24.api.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
