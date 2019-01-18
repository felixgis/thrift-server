package com.probe.rpc.thrift.server.context;

import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TTransportException;

import com.probe.rpc.thrift.server.properties.ThriftServerProperties;
import com.probe.rpc.thrift.server.wrapper.ThriftServiceWrapper;

import java.io.IOException;
import java.util.List;

public interface ContextBuilder {

	ContextBuilder prepare();

	TServer buildThriftServer(ThriftServerProperties properties, List<ThriftServiceWrapper> serviceWrappers)
			throws TTransportException, IOException;

}
