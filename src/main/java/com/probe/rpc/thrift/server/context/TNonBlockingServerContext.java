package com.probe.rpc.thrift.server.context;

import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TTransportException;

import com.probe.rpc.thrift.server.argument.TNonBlockingServerArgument;
import com.probe.rpc.thrift.server.properties.ThriftServerProperties;
import com.probe.rpc.thrift.server.wrapper.ThriftServiceWrapper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TNonBlockingServerContext implements ContextBuilder {

	private static TNonBlockingServerContext serverContext;
	private TNonblockingServer.Args args;

	private TNonBlockingServerContext() {
	}

	public static TNonBlockingServerContext context() {
		if (Objects.isNull(serverContext)) {
			serverContext = new TNonBlockingServerContext();
		}
		return serverContext;
	}

	@Override
	public ContextBuilder prepare() {
		return context();
	}

	@Override
	public TServer buildThriftServer(ThriftServerProperties properties, List<ThriftServiceWrapper> serviceWrappers)
			throws TTransportException, IOException {
		serverContext = (TNonBlockingServerContext) prepare();
		serverContext.args = new TNonBlockingServerArgument(serviceWrappers, properties);
		return new TNonblockingServer(serverContext.args);
	}

}
