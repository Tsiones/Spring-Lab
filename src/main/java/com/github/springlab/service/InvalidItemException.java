package com.github.springlab.service;

public class InvalidItemException extends RuntimeException
{

	public InvalidItemException(String message)
	{
		super(message);
	}

	public InvalidItemException(Throwable cause)
	{
		super(cause);
	}

}
