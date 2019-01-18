package com.probe.rpc.thrift.server.exception;

public class ThriftServerInstantiateException extends ThriftServerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4826102713292497524L;

	public ThriftServerInstantiateException(String message) {
		super(message);
	}

	public ThriftServerInstantiateException(String message, Throwable t) {
		super(message, t);
	}
}
