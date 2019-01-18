package com.probe.rpc.thrift.server.exception;

public class ThriftServerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5928474936210612588L;

	public ThriftServerException(String message) {
		super(message);
	}

	public ThriftServerException(String message, Throwable t) {
		super(message, t);
	}
}
