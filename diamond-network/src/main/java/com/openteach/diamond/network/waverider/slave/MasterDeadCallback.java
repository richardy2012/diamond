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
package com.openteach.diamond.network.waverider.slave;

import com.openteach.diamond.network.waverider.SlaveWorker;

/**
 * <p>
 * Slave离开回调上层
 * </p>
 * 
 * @author <a href="mailto:sihai@taobao.com">sihai</a>
 *
 */
public interface MasterDeadCallback {
	
	/**
	 * Master挂掉通知
	 */
	void callback();
}
