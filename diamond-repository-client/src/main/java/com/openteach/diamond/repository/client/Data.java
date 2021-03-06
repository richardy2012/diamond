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
package com.openteach.diamond.repository.client;

import java.io.Serializable;

/**
 * 
 * @author sihai
 *
 */
public class Data implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2326678071487608634L;

	/**
	 * 
	 */
	private Key	   key;
	
	/**
	 * 
	 */
	private Serializable value;

	public Data(Key key, Serializable value) {
		this.key = key;
		this.value = value;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Serializable getValue() {
		return value;
	}

	public void setValue(Serializable value) {
		this.value = value;
	}
}