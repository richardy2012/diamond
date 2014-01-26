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
package com.openteach.diamond.osgi;

import com.openteach.diamond.common.exception.DiamondException;

/**
 * 
 * @author sihai
 *
 */
public class BundleDownloader {
	
	public static void download(String bundleName , String outputDir) throws DiamondException{
		int ret = BundleDownClient.download(bundleName, outputDir);
		if(BundleDownClient.DOWN_SUCCESS != ret){
			throw new DiamondException(String.format("下载Bundle文件:%s失败,错误代码为:%d", bundleName, ret));
		}
	}
	
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			BundleDownloader.download("hsf.xfire.lib-1.6.0.jar.plugin", "D:/download");
			long end = System.currentTimeMillis();
			System.out.println("用时："+(end-start)+"ms");
		} catch (DiamondException e) {
			e.printStackTrace();
		}
	}
}