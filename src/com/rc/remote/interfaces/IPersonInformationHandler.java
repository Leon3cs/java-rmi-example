package com.rc.remote.interfaces;

import java.rmi.RemoteException;

import javax.management.InvalidAttributeValueException;

import com.rc.remote.servants.Person;

import java.rmi.Remote;

public interface IPersonInformationHandler extends Remote {
	/**
	 * Invokes the server to create a new Person registry. With the given arguments
	 * 
	 * @param age		The person's age.
	 * 
	 * @param name		The person's name.
	 * 
	 * @return A Person object containing the information provided.
	 * 
	 * @throws IllegalArgumentException if no name is provided, or if the age is less than zero.
	 * 
	 * @author Rafael Paim
	 * */
	public Person createPersonRegistry(int age, String name) throws RemoteException ;
	/**
	 * Invokes the server to update a person's age.
	 * 
	 * @param person	The person object to update.
	 * 
	 * @param age		The person's new age.
	 * 
	 * @return A Person object containing the information provided.
	 * 
	 * @throws IllegalArgumentException if person is null.
	 * 
	 * @throws InvalidAttributeValueException if the age specified is less than the person's actual age. 
	 * 
	 * @author Rafael Paim
	 * */
	public Person updatePersonRegistry(Person person, int age) throws RemoteException, InvalidAttributeValueException;
}
