package com.rc.remote.servants;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.management.InvalidAttributeValueException;

import com.rc.remote.interfaces.IPersonInformationHandler;

public class PersonInformationHandler extends UnicastRemoteObject implements IPersonInformationHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PersonInformationHandler() throws RemoteException {
		super();
	}

	@Override
	public Person createPersonRegistry(int age, String name) throws RemoteException {
		if(age < 0) {
			throw new IllegalArgumentException("Age cannot be lest than zero");
		}
		
		if(name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		
		return new Person(age, name);
	}

	@Override
	public Person updatePersonRegistry(Person person, int age) throws RemoteException, InvalidAttributeValueException {
		if(person == null) {
			throw new IllegalArgumentException("A person object mus be provided");
		}
		
		if(age < person.getAge()) {
			throw new InvalidAttributeValueException("The age cannot be less than the person's actual age");
		}
		
		person.setAge(age);
		
		return person;
	}
	
}
