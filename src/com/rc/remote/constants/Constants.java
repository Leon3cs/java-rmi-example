package com.rc.remote.constants;

public abstract class Constants {
	public static final String REMOTE_OBJECT_NAME_PROVIDER = "RemoteControlProvider";
	public static final String REMOTE_OBJECT_REFERENCE_PROVIDER = "/" + REMOTE_OBJECT_NAME_PROVIDER;
	public static final String REMOTE_OBJECT_NAME_PERSON = "PersonInformationHandler";
	public static final String REMOTE_OBJECT_REFERENCE_PERSON = "/" + REMOTE_OBJECT_NAME_PERSON;

	public static final String createServerConnectionSuccessfulMessage(String hostname, int port) {
		StringBuilder builder = new StringBuilder("Server connected successfully\n");
		builder.append("On host: ");
		builder.append(hostname);
		builder.append("\n");
		builder.append("Port: ");
		builder.append(port);

		return builder.toString();
	};

	public static final String createClientConnectionSuccessfulMessage(String hostname, int port) {
		StringBuilder builder = new StringBuilder("Connection to server successfully established\n");
		builder.append("On host: ");
		builder.append(hostname);
		builder.append("\n");
		builder.append("Port: ");
		builder.append(port);

		return builder.toString();
	};

	public static final String ASK_USER_INPUT_QUESTION_1 = "Input your message and the application will perfom a remote method invocation to the server to process it:";
	public static final String ASK_USER_INPUT_QUESTION_2_INTRO = "Logic operation with two values, input two arguments and a operation type to retrieve from server the result by remote method invocation:";
	public static final String ASK_USER_INPUT_QUESTION_2_INPUT_1 = "arg1: ";
	public static final String ASK_USER_INPUT_QUESTION_2_INPUT_2 = "arg2: ";
	public static final String ASK_USER_INPUT_QUESTION_2_OPERATION = "Operation (equal, lessThan, greaterThan): ";
	public static final String ASK_USER_INPUT_QUESTION_2_RESULT = "Result: ";
	public static final String ASK_OPERATION = "Inform method for remote invocation: (1 - sendMessage | 2 - logicOperation)";
	public static final String OPERATION_EQUAL = "equal";
	public static final String OPERATION_GREATER_THAN = "greaterThan";
	public static final String OPERATION_LESS_THAN = "lessThan";
	public static final int ASK_OPERATION_1 = 1;
	public static final int ASK_OPERATION_2 = 2;
	public static final String NAME = "John Smith";
	public static final int AGE = 40;
}
