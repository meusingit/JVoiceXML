/*
 * JVoiceXML - A free VoiceXML implementation.
 *
 * Copyright (C) 2007-2019 JVoiceXML group - http://jvoicexml.sourceforge.net
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Library General Public
 *  License as published by the Free Software Foundation; either
 *  version 2 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Library General Public License for more details.
 *
 *  You should have received a copy of the GNU Library General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package org.jvoicexml.implementation.text;

import java.util.List;

import org.apache.log4j.Logger;
import org.jvoicexml.client.text.TextConnectionInformation;
import org.jvoicexml.event.error.NoresourceError;
import org.jvoicexml.implementation.ResourceFactory;
import org.jvoicexml.implementation.UserInputImplementation;
import org.jvoicexml.implementation.grammar.GrammarParser;
import org.jvoicexml.xml.srgs.ModeType;

/**
 * Demo implementation of a {@link org.jvoicexml.implementation.ResourceFactory}
 * for the {@link UserInputImplementation} based on a simple text interface.
 *
 * @author Dirk Schnelle-Walka
 * @since 0.6
 */
public final class TextUserInputImplementationFactory
        implements ResourceFactory<UserInputImplementation> {
	/** Logger for this class. */
    private static final Logger LOGGER = Logger
            .getLogger(TextUserInputImplementationFactory.class);
    
    /** Number of instances that this factory will create. */
    private int instances;

    /** The configured grammar parser. */
    private List<GrammarParser<?>> parsers;

    /**
     * Constructs a new object.
     */
    public TextUserInputImplementationFactory() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModeType getModeType() {
        return ModeType.VOICE;
    }

    /**
     * Sets the grammar parsers to use.
     * 
     * @param grammarParsers
     *            the grammar parsers to use
     * @since 0.7.8
     */
    public void setGrammarParsers(final List<GrammarParser<?>> grammarParsers) {
        parsers = grammarParsers;
        for (GrammarParser<?> parser : parsers) {
            LOGGER.info("added grammar parser '" + parser.getClass()
                + "' for grammar type '" + parser.getType() +"'");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserInputImplementation createResource() throws NoresourceError {
        final TextUserInputImplementation input = new TextUserInputImplementation();
        input.setGrammarParsers(parsers);
        return input;
    }

    /**
     * Sets the number of instances that this factory will create.
     * 
     * @param number
     *            Number of instances to create.
     */
    public void setInstances(final int number) {
        instances = number;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getInstances() {
        return instances;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getType() {
        return TextConnectionInformation.TYPE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<UserInputImplementation> getResourceType() {
        return UserInputImplementation.class;
    }
}
