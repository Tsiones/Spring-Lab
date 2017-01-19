package com.github.springlab.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.springlab.model.Issue;
import com.github.springlab.model.WorkItem;

public interface IssueRepository extends PagingAndSortingRepository<Issue, Long>
{
	List<Issue> findByWorkItem(WorkItem workItem);
}
