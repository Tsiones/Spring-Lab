package com.github.springlab.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.springlab.model.Issue;
import com.github.springlab.model.Team;
import com.github.springlab.model.User;
import com.github.springlab.model.WorkItem;
import com.github.springlab.repository.IssueRepository;
import com.github.springlab.repository.TeamRepository;
import com.github.springlab.repository.UserRepository;
import com.github.springlab.repository.WorkItemRepository;
import com.github.springlab.service.TaskerService;
import com.github.springlab.statuses.ItemStatus;

public class Main
{

	public static void main(String[] args)
	{
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext())
		{
			context.scan("com.github.springlab");
			context.refresh();

			TeamRepository teamRepo = context.getBean(TeamRepository.class);
			UserRepository userRepo = context.getBean(UserRepository.class);
			WorkItemRepository workRepo = context.getBean(WorkItemRepository.class);
			IssueRepository issueRepo = context.getBean(IssueRepository.class);

			TaskerService service = new TaskerService(userRepo, teamRepo, workRepo, issueRepo);

			Team team = new Team("yhc3l");
			service.update(team);

			User user = new User("john", "doe", "johnDoe", "123456", "1001");
			user.assignTeam(team);
			service.update(user);

			WorkItem item1 = new WorkItem("Add1 secret Pokemons!", "Requesting mystique");
			item1.assignUser(user);
			item1.setStatus(ItemStatus.DONE);
			service.update(item1);

			Issue issue = new Issue(item1, "Weird encounter with \"missingno\". What is that?");
			service.update(issue);

			user.deactivate();
			service.update(user);

			team.deactivate();
			service.update(team);

		}
	}

}
