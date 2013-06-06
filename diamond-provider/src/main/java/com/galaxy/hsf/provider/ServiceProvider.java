/**
 * High-Speed Service Framework (HSF)
 * 
 */
package com.galaxy.hsf.provider;

import com.galaxy.diamond.metadata.ServiceMetadata;
import com.galaxy.hsf.common.exception.HSFException;
import com.galaxy.hsf.common.lifecycle.LifeCycle;


/**
 * 
 * @author sihai
 *
 */
public interface ServiceProvider extends LifeCycle {

	/**
	 * 
	 * @return
	 */
	ServiceMetadata getMetadata();
	
	/**
	 * 
	 * @param methodName
	 * @param parameterTypes
	 * @param args
	 * @return
	 * @throws HSFException
	 */
	Object invoke(String methodName, String[] parameterTypes, Object ... args) throws HSFException;
}
