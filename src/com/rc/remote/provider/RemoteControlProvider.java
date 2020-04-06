package com.rc.remote.provider;

import com.rc.remote.interfaces.IRemoteControl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import com.rc.remote.constants.Constants;

public class RemoteControlProvider extends UnicastRemoteObject implements IRemoteControl {

	private static final long serialVersionUID = 1L;

	public RemoteControlProvider() throws RemoteException {
	}

	@Override
	public void sendMessage(String message) throws RemoteException {
		if(message.isEmpty()) {
			System.out.println("Invalid message");
		}else {
			StringBuilder builder = new StringBuilder("Message received successfully\n");
			builder.append("Message: ");
			builder.append(message);
			
			System.out.println(builder.toString());
		}
	}

	@Override
	public boolean makeLogicOperation(int arg1, String operation, int arg2) {
		if(operation.isEmpty()) throw new IllegalArgumentException("Operation cannot be empty.");
		
		boolean result;
		
		if(operation.contains(Constants.OPERATION_EQUAL)) {
			result = arg1 == arg2;
		}else if(operation.contains(Constants.OPERATION_GREATER_THAN)) {
			result = arg1 > arg2;
		}else if(operation.contains(Constants.OPERATION_LESS_THAN)) {
			result = arg1 < arg2;
		}else {
			throw new IllegalArgumentException("Invalid operation");
		}
		
		return result;
	}
	
}
