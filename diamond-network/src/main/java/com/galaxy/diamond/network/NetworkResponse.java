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
package com.galaxy.diamond.network;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import com.galaxy.diamond.network.exception.NetworkException;
import com.galaxy.diamond.network.waverider.command.Command;
import com.galaxy.diamond.network.waverider.network.Packet;

/**
 * 
 * @author sihai
 *
 */
public class NetworkResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7640010423289981296L;

	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	private Object payload;
	
	/**
	 * 
	 * @param id
	 * @param payload
	 */
	public NetworkResponse(String id, Object payload) {
		this.id = id;
		this.payload = payload;
	}
	
	public String getId() {
		return id;
	}

	public Object getPayload() {
		return payload;
	}
	
	/**
	 * XXX 目前直接用java的序列化
	 * @return
	 * @throws NetworkException
	 */
	public ByteBuffer marshall() throws NetworkException {
		ByteArrayOutputStream bout = null;
		DeflaterOutputStream dout = null;
		ObjectOutputStream oout = null;
		try {
			bout = new ByteArrayOutputStream();
			//dout = new DeflaterOutputStream(bout, new Deflater(Deflater.BEST_SPEED));
			oout = new ObjectOutputStream(bout);
			oout.writeObject(this);
			return ByteBuffer.wrap(bout.toByteArray());
		} catch (IOException e) {
			throw new NetworkException("OOPS, OMG Not possible", e);
		} finally {
			try {
				if (oout != null) {
					oout.close();
				}

				if (dout != null) {
					dout.close();
				}

				if (bout != null) {
					bout.close();
				}
			} catch (IOException ex) {
				throw new NetworkException("OOPS, OMG Not possible", ex);
			}
		}
	}
	
	/**
	 * XXX 目前直接用java的序列化
	 * @param buffer
	 * @return
	 * @throws NetworkException
	 */
	public static NetworkResponse unmarshall(ByteBuffer buffer) throws NetworkException {
		ByteArrayInputStream bin = null;
		InflaterInputStream iin = null;
		ObjectInputStream oin = null;

		try {
			bin = new ByteArrayInputStream(buffer.array(), Packet.getHeaderSize() + Command.getHeaderSize(), buffer.remaining());
			//iin = new InflaterInputStream(bin);
			oin = new ObjectInputStream(bin);
			return (NetworkResponse)oin.readObject();
		} catch (IOException e) {
			throw new NetworkException("OOPS, OMG Not possible", e);
		} catch (ClassNotFoundException e) {
			throw new NetworkException("OOPS", e);
		} finally {
			try {
				if (oin != null)
					oin.close();

				if (iin != null)
					iin.close();

				if (bin != null)
					bin.close();

				oin = null;
				iin = null;
				bin = null;
			} catch (IOException ex) {
				throw new NetworkException("OOPS, OMG Not possible", ex);
			}
		}
	}
}
