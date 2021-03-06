/**
 * Copyright 2013 openteach
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
package com.openteach.diamond.metadata;

import java.util.List;

import com.openteach.diamond.common.lifecycle.LifeCycle;


/**
 * 描述：发布服务元数据的服务
 * 
 * @author sihai
 *
 */
public interface MetadataWriteService extends LifeCycle {

	/**
	 * 
	 * @param metadata
	 * @param exportedProtocols
	 */
	void register(ServiceMetadata metadata, List<ServiceURL> exportedProtocols);
	
	/**
	 * 
	 * @param metadata
	 */
	void unregister(ServiceMetadata metadata);

	/**
	 * 
	 * @param hook
	 */
	void addPublishHook(PublishHook hook);
}