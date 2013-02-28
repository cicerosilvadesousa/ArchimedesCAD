/**
 * Copyright (c) 2007, 2009 Hugo Corbucci and others.<br>
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html<br>
 * <br>
 * Contributors:<br>
 * Hugo Corbucci - initial API and implementation<br>
 * <br>
 * This file was created on 2007/04/22, 12:51:15, by Hugo Corbucci.<br>
 * It is part of package br.org.archimedes.polyline.area on the br.org.archimedes.polyline.area project.<br>
 */
package br.org.archimedes.polyline.area;

import org.eclipse.osgi.util.NLS;

/**
 * Belongs to package br.org.archimedes.polyline.area.
 * 
 * @author nitao
 * 
 */
public class Messages extends NLS {

	private static final String BUNDLE_NAME = "br.org.archimedes.polyline.area.messages"; //$NON-NLS-1$

	public static String Area;

	public static String AreaCancel;

	public static String AreaError;

	public static String Perimeter;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {

	}
}
