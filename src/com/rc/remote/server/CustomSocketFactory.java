package com.rc.remote.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.rmi.server.RMISocketFactory;

public class CustomSocketFactory extends RMISocketFactory {

	@Override
	public ServerSocket createServerSocket(int port) throws IOException {
		return new ServerSocket(port, 5, InetAddress.getLocalHost());
	}

	@Override
	public Socket createSocket(String host, int port) throws IOException {
		return RMISocketFactory
				.getDefaultSocketFactory()
				.createSocket(host, port);
	}

}
