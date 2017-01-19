package com.github.springlab.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.springlab.model.Team;

public interface TeamRepository extends PagingAndSortingRepository<Team, Long>
{

}
