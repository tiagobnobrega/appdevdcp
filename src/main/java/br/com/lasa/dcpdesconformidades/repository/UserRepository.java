package br.com.lasa.dcpdesconformidades.repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lasa.dcpdesconformidades.domain.User;

/**
 * Spring Data JPA repository for the User entity.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  String USERS_BY_LOGIN_CACHE = "usersByLogin";

  String USERS_BY_EMAIL_CACHE = "usersByEmail";

  List<User> findAllByActivatedIsFalseAndCreatedDateBefore(Instant dateTime);

  Optional<User> findOneByEmailIgnoreCase(String email);

  Optional<User> findOneByLogin(String login);

  @EntityGraph(attributePaths = "authorities")
  Optional<User> findOneWithAuthoritiesById(Long id);

  @EntityGraph(attributePaths = "authorities")
  @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
  Optional<User> findOneWithAuthoritiesByLogin(String login);

  @EntityGraph(attributePaths = "authorities")
  @Cacheable(cacheNames = USERS_BY_EMAIL_CACHE)
  Optional<User> findOneWithAuthoritiesByEmail(String email);

  Page<User> findAllByLoginNotIn(Pageable pageable, Set<String> logins);

  Optional<User> findOneByProntuario(Integer prontuario);
}
