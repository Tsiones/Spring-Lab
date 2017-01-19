package com.github.springlab.service;

public class InvalidUserException extends RuntimeException
{

	public InvalidUserException(String message)
	{
		super(message);
	}

	public InvalidUserException(Throwable cause)
	{
		super(cause);
	}

}
