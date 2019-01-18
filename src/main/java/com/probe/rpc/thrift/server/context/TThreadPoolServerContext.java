package com.probe.rpc.thrift.server.context;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TTransportException;

import com.probe.rpc.thrift.server.argument.TThreadPoolServerArgument;
import com.probe.rpc.thrift.server.properties.ThriftServerProperties;
import com.probe.rpc.thrift.server.wrapper.ThriftServiceWrapper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class TThreadPoolServerContext implements ContextBuilder {

	private static TThreadPoolServerContext serverContext;
	private TThreadPoolServer.Args args;

	private TThreadPoolServerContext() {
	}

	public static TThreadPoolServerContext context() {
		if (Objects.isNull(serverContext)) {
			serverContext = new TThreadPoolServerContext();
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
		serverContext = (TThreadPoolServerContext) prepare();
		serverContext.args = new TThreadPoolServerArgument(serviceWrappers, properties);
		return new TThreadPoolServer(serverContext.args);
	}

}
