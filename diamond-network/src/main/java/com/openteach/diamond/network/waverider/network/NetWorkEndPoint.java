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
package com.openteach.diamond.network.waverider.network;

import java.nio.channels.SocketChannel;

import com.openteach.diamond.network.waverider.common.LifeCycle;

/**
 * <p>
 * 网络对等节点
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public interface NetWorkEndPoint extends LifeCycle {

	/**
	 * 通知有数据要写
	 * @param channel
	 * @return 
	 */
	boolean notifyWrite(SocketChannel channel);
	
	/**
	 * 通知读数据请求
	 * @param channel
	 * @return 
	 */
	boolean notifyRead(SocketChannel channel);
	
	/**
	 * 等待更多数据
	 * @param timeout
	 */
	void waitMoreData(long timeout) throws InterruptedException;
}
