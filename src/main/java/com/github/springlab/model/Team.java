package com.github.springlab.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
public class Team extends Id
{
	@Column(nullable = false)
	private String name;

	@Column(name = "status", nullable = false)
	private int teamStatus;

	@Column(name = "is_active", nullable = false)
	private boolean isActive = true;

	protected Team()
	{
	}

	public Team(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void activate()
	{
		isActive = true;
	}

	public void deactivate()
	{
		isActive = false;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}
		if (other == null)
		{
			return false;
		}
		if (other instanceof Team)
		{
			Team otherTeam = (Team) other;
			return getName().equals(otherTeam.getName());
		}
		return false;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
