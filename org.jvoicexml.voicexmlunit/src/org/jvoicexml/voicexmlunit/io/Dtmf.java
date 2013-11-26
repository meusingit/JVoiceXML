/*
 * File:    $HeadURL$
 * Version: $LastChangedRevision$
 * Date:    $Date$
 * Author:  $LastChangedBy$
 *
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2013 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.voicexmlunit.io;

import org.jvoicexml.event.error.NoresourceError;
import org.jvoicexml.event.plain.ConnectionDisconnectHangupEvent;
import org.jvoicexml.xml.ssml.SsmlDocument;
import org.junit.Assert;

public class Dtmf extends Statement implements InputMessage {
    private char dtmf;

    public Dtmf(char dtmf) {
        super("DTMF '" + dtmf + "'");
        this.dtmf = dtmf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void send(Recording record) {
        if (record == null) {
            return;
        }

        try {
            record.input(dtmf);
        } catch (NoresourceError | ConnectionDisconnectHangupEvent e) {
            e.printStackTrace();
            Assert.fail("Send: " + toString());
        }
    }
}
