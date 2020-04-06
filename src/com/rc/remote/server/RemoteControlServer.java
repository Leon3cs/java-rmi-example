package com.rc.remote.server;

import java.rmi.registry.Registry;
import java.net.InetAddress;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;
import com.rc.remote.provider.RemoteControlProvider;
import com.rc.remote.constants.Constants;

public class RemoteControlServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		try {
			if(connect())
				ready();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static long getSerialVersionUid() {
		return serialVersionUID;
	}
	
	public static void ready() throws Exception {
		System.out.println(
			Constants
			.createServerConnectionSuccessfulMessage(
					InetAddress
					.getLocalHost()
					.getHostName(),
					Registry.REGISTRY_PORT
			)
		);
	}
	
	public static boolean connect() throws Exception {
		RMISocketFactory.setSocketFactory(new CustomSocketFactory());
		
		RemoteControlProvider provider = new RemoteControlProvider();
		
		Registry registry = LocateRegistry.createRegistry(
				Registry.REGISTRY_PORT, 
				RMISocketFactory
				.getDefaultSocketFactory(), 
				RMISocketFactory
				.getDefaultSocketFactory());
		
		registry.rebind(Constants.REMOTE_OBJECT_NAME, provider);
		
		return true;
	}

}
