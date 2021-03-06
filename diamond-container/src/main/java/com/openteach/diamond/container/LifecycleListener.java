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
 * 
 */
package com.openteach.diamond.container;

import com.openteach.diamond.common.exception.DiamondException;

/**
 * 
 * @author sihai
 *
 */
public interface LifecycleListener {

	public static final String BEFORE_START_EVENT = "before_start";
	
	public static final String AFTER_START_EVENT = "after_start";
	
	public static final String BEFORE_STOP_EVENT = "before_stop";
	
	public static final String AFTER_STOP_EVENT = "after_stop";
	
	void fire(String event) throws DiamondException;
}