package com.rc.remote.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteControl extends Remote {
	/**
	 * Method used to send messages to the remote server.
	 * 
	 * @param message The message to the displayed remotely on server.
	 *
	 * @return Response given by the server.
	 * 
	 * @author Rafael Paim
	 */
	public void sendMessage(String message) throws RemoteException;

	/**
	 * Invokes the server to perform a logic operation with the given arguments.
	 * 
	 * @param arg1      The first argument in the logic operation.
	 * 
	 * @param arg2      The second argument in the logic operation.
	 * 
	 * @param operation The operation to be with the given arguments. It must be one
	 *                  of the following: "equal", "greaterThan" or "lessThan".
	 * 
	 * @throws IllegalArgumentException if the operation argument is empty or if it
	 *                                  isn't a valid operation.
	 * 
	 * @return The result of the logic operation processed by the server.
	 * 
	 * @author Rafael Paim
	 */
	public boolean makeLogicOperation(int arg1, String operation, int arg2) throws RemoteException;
}
