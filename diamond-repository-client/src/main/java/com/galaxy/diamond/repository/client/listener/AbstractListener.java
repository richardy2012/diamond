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
 * 
 */
package com.galaxy.diamond.repository.client.listener;

import com.galaxy.diamond.repository.client.Key;

/**
 * 
 * @author sihai
 *
 */
public abstract class AbstractListener implements Listener {

	protected Key key;
	
	public AbstractListener(Key key) {
		this.key = key;
	}

	@Override
	public Key getKey() {
		return key;
	}
}
