/**
 * Copyright (c) 2006, 2009 Hugo Corbucci and others.<br>
 * All rights reserved. This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html<br>
 *<br>
 * Contributors:<br>
 * Bruno da Hora and Ricardo Sider - initial API and implementation<br>
 * <br>
 * This file was created on 31/03/2009, 17:30:20.<br>
 * It is part of br.org.archimedes.io.svg.elements on the br.org.archimedes.io.svg.tests project.<br>
 */

package br.org.archimedes.io.svg.elements;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Before;
import org.junit.Test;

import br.org.archimedes.Tester;
import br.org.archimedes.model.Point;
import br.org.archimedes.text.Text;

/**
 * @author Bruno da Hora and Ricardo Sider
 */
public class TextExporterTest extends Tester {

    private Text text;

    private TextExporter exporter;

    private ByteArrayOutputStream stream;


    @Before
    public void setUp () throws Exception {

        text = new Text("Testando exportador", new Point(0.0, 0.0), 2.0);
        exporter = new TextExporter();
        stream = new ByteArrayOutputStream();
    }

    @Test
    public void exportTextAsSVG () throws Exception {

        exporter.exportElement(text, stream);
        
        String expected = "<text x=\"0.0\" y=\"0.0\" font-size=\"2.0\" font-family=\"Courier\">Testando exportador</text>";
        expected = expected.replaceAll("\\s", "");

        String result = stream.toString().replaceAll("\\s", "");
        assertEquals(expected, result);
    }
}
