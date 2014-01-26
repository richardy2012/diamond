/**
 * Copyright 2013 Qiangqiang RAO
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.openteach.diamond.rpc.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author sihai
 *
 */
public abstract class AbstractRPCProtocolFactory {

	/**
	 * 
	 * @param fullProtocolName
	 * @return
	 */
	protected Properties loadConfiguration(String fullProtocolName) {
		try {
			Properties properties = new Properties();
			InputStream in = this.getClass().getResourceAsStream(String.format("/rpc/protocols/%s.cnf", fullProtocolName));
			properties.load(in);
			
			// try to load custom override
			in = Thread.currentThread().getContextClassLoader().getResourceAsStream(String.format("%s.cnf", fullProtocolName));
			if(null != in) {
				properties.load(in); 
			}
			return properties;
		} catch (IOException e) {
			throw new RuntimeException(String.format("Load configuration for protocol:%s failed", fullProtocolName), e);
		}
	}
	
	/**
	 * 
	 * @param properties
	 * @return
	 */
	protected RPCProtocolConfiguration properties2Configuration(Properties properties) {
		RPCProtocolConfiguration configuration = new RPCProtocolConfiguration();
		String value = properties.getProperty("network.max.sessionPreHost");
		if(StringUtils.isNotBlank(value)) {
			configuration.setMaxSessionPreHost(Integer.valueOf(StringUtils.trim(value)));
		}
		return configuration;
	}
}
