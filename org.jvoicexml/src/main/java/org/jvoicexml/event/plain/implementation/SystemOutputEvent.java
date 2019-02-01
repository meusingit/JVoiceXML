/*
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2008-2019 JVoiceXML group - http://jvoicexml.sourceforge.net
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

package org.jvoicexml.event.plain.implementation;

import org.jvoicexml.event.JVoiceXMLEvent;
import org.jvoicexml.implementation.SystemOutputOutputImplementation;

/**
 * Event generated from the {@link SystemOutputOutputImplementation} implementation. Events are
 * associated to a dedicated event source, i.e. the system output device, and a
 * session.
 * 
 * @author Dirk Schnelle-Walka
 * @since 0.6
 */
@SuppressWarnings("serial")
public class SystemOutputEvent extends JVoiceXMLEvent {
    /** The detail message. */
    public static final String EVENT_TYPE = SystemOutputEvent.class
            .getCanonicalName();

    /** The detailing of this event. */
    private final String detail;

    /** Object that caused the event. */
    private final SystemOutputOutputImplementation source;

    /** The id of the related session. */
    private final String sessionId;

    /**
     * Constructs a new object.
     * 
     * @param output
     *            object that caused the event.
     * @param detailedType
     *            the detailed message
     * @param id
     *            the session id
     * @exception IllegalArgumentException
     *                if an illegal event type is passed.
     */
    public SystemOutputEvent(final SystemOutputOutputImplementation output,
            final String detailedType, final String id)
            throws IllegalArgumentException {
        source = output;
        detail = detailedType;
        sessionId = id;
    }

    /**
     * Retrieves the object that caused the event.
     * 
     * @return the source object.
     */
    public final SystemOutputOutputImplementation getSource() {
        return source;
    }

    /**
     * Retrieves the session id.
     * 
     * @return the session id
     * @since 0.7.5
     */
    public final String getSessionId() {
        return sessionId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEventType() {
        final StringBuilder str = new StringBuilder();
        str.append(EVENT_TYPE);
        if (detail != null) {
            str.append('.');
            str.append(detail);
        }
        return str.toString();
    }
}