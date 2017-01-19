package com.github.springlab.service;

public class InvalidTeamException extends RuntimeException
{
	public InvalidTeamException(String message)
	{
		super(message);
	}

	public InvalidTeamException(Throwable cause)
	{
		super(cause);
	}

}
