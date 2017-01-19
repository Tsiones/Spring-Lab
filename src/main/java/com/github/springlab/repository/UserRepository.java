package com.github.springlab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.springlab.model.Team;
import com.github.springlab.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>
{
	List<User> findByUsernameLike(String username);

	List<User> findByFirstNameLike(String firstName);

	List<User> findByLastNameLike(String lastName);

	@Query("SELECT u FROM #{#entityName} u WHERE u.userNumber = ?1")
	List<User> findByUserNumber(String userNumber);

	List<User> findByTeam(Team team);
}
