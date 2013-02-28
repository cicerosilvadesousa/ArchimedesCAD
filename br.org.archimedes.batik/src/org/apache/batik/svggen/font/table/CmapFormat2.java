/*

   Copyright 2001  The Apache Software Foundation 

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */
package org.apache.batik.svggen.font.table;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @version $Id: CmapFormat2.java,v 1.4 2004/09/01 09:35:23 deweese Exp $
 * @author <a href="mailto:david@steadystate.co.uk">David Schweinsberg</a>
 */
public class CmapFormat2 extends CmapFormat {

	protected CmapFormat2(RandomAccessFile raf) throws IOException {
		super(raf);
		format = 2;
	}

	public int getFirst() {
		return 0;
	}

	public int getLast() {
		return 0;
	}

	public int mapCharCode(int charCode) {
		return 0;
	}
}
