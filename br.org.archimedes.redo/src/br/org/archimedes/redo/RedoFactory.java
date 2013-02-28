/**
 * Copyright (c) 2006, 2009 Hugo Corbucci and others.<br>
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html<br>
 * <br>
 * Contributors:<br>
 * Hugo Corbucci - initial API and implementation<br>
 * <br>
 * This file was created on 2006/05/08, 10:31:49, by Hugo Corbucci.<br>
 * It is part of package br.org.archimedes.redo on the br.org.archimedes.redo project.<br>
 */
package br.org.archimedes.redo;

import br.org.archimedes.undo.UndoFactory;

public class RedoFactory extends UndoFactory {

	public String begin() {

		setCommand(new RedoCommand());
		return Messages.RedoPerformed;
	}

	public String getName() {

		return "redo"; //$NON-NLS-1$
	}
}
