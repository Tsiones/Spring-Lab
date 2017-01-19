package com.github.springlab.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.github.springlab.model.Team;
import com.github.springlab.model.User;
import com.github.springlab.model.WorkItem;

public interface WorkItemRepository extends PagingAndSortingRepository<WorkItem, Long>
{
	List<WorkItem> findByAssignedUser(User assignedUser);

	List<WorkItem> findByItemStatus(int itemStatus);

	List<WorkItem> findByDescriptionLike(String description);

	List<WorkItem> findByTopicLike(String topic);

	List<WorkItem> findByAssignedUser_Team(Team team);

}
