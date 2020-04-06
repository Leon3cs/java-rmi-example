package com.rc.remote.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import com.rc.remote.interfaces.IRemoteControl;
import com.rc.remote.constants.Constants;

public class RemoteControlClient {

	public static void main(String[] args) {
		try {
			System.out.println("References available in remote registry:");
			
			listRemoteReferences();
			
			ready();
			
			IRemoteControl remoteProvider = getRemoteControlReference();
			
			if(remoteProvider != null) {
				
				askOperation(remoteProvider);
				
			} else {
				throw new Exception("Unable to get remote reference.");
			}
			
		} catch(Exception e) {
			if(e.equals(new IllegalArgumentException())) {
				System.out.println(e.getMessage());
			}
			e.printStackTrace();
		}
	}
	
	public static void listRemoteReferences() throws Exception{
		String[] refs = Naming
			.list(
				"//"+
				InetAddress
					.getLocalHost()
					.getHostName()+
				":"+
				Registry.REGISTRY_PORT+
				Constants.REMOTE_OBJECT_REFERENCE
		);
		
		if(refs.length >= 1) {
			for (int i = 0; i < refs.length; i++) {
				System.out.println("Reference: " + refs[i]);
			}
		} else {
			System.out.println("No references on this remote.");
		}
	}
	
	public static void ready() throws Exception {
		System.out.println(
			Constants
			.createClientConnectionSuccessfulMessage(
					InetAddress
						.getLocalHost()
						.getHostName(), 
					Registry.REGISTRY_PORT
			)		
		);
	}
	
	public static IRemoteControl getRemoteControlReference() throws Exception {
		 return (IRemoteControl) Naming
			.lookup(
				"//"+
				InetAddress
					.getLocalHost()
					.getHostName()+
				":"+
				Registry.REGISTRY_PORT+
				Constants.REMOTE_OBJECT_REFERENCE
			);
	}
	
	public static void askMessage(IRemoteControl provider) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_1);
		String message = reader.readLine();
		provider.sendMessage(message);
	}
	
	public static void askLogicOperation(IRemoteControl provider) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_2_INTRO);
		
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_2_INPUT_1);
		String arg1 = reader.readLine();
		
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_2_INPUT_2);
		String arg2 = reader.readLine();
		
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_2_OPERATION);
		String operation = reader.readLine();
		
		boolean result = provider
				.makeLogicOperation(
						Integer.parseInt(arg1),
						operation,
						Integer.parseInt(arg2));
		System.out.println(Constants.ASK_USER_INPUT_QUESTION_2_RESULT + result);
	}
	
	public static void askOperation(IRemoteControl provider) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(Constants.ASK_OPERATION);
		String operation = reader.readLine();
		if(Integer.parseInt(operation) == Constants.ASK_OPERATION_1) {
			askMessage(provider);
		}else if(Integer.parseInt(operation) == Constants.ASK_OPERATION_2) {
			askLogicOperation(provider);
		}else {
			throw new IllegalArgumentException("Invalid method");
		}
	}
}
