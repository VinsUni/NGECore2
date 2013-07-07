/*******************************************************************************
 * Copyright (c) 2013 <Project SWG>
 * 
 * This File is part of NGECore2.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Using NGEngine to work with NGECore2 is making a combined work based on NGEngine. 
 * Therefore all terms and conditions of the GNU Lesser General Public License cover the combination.
 ******************************************************************************/
package protocol.swg;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.mina.core.buffer.IoBuffer;


public class GetMapLocationsResponseMessage extends SWGMessage {
	
	public GetMapLocationsResponseMessage(String planet, String name) {
		ByteBuffer result = ByteBuffer.allocate(496).order(ByteOrder.LITTLE_ENDIAN);
		
		result.putShort((short) 8);
		result.putInt(0x9F80464C);
		result.put(getAsciiString(planet));
		
		// List
		for (int i = 0; i < 3; i++) {
			// blank list 1 + 2, no idea why they are needed
			result.putInt(23 + name.length() * 2);

			result.putLong(100);  // ID
			result.put(getUnicodeString(name));
			result.putFloat(0);	  // x
			result.putFloat(0);   // y
			result.put((byte) 2); // category
			result.put((byte) 0); // sub category
			result.put((byte) 0); // is active
		}
		
		result.putInt(0);
		result.putInt(0);	// 3 unks
		result.putInt(0);
		
		data = result.array();
	}
	
	public void deserialize(IoBuffer data) {
		
	}
	
	public IoBuffer serialize() {
		return IoBuffer.wrap(data);
	}
}
