/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - add negative processing
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Pattern;

import org.eclipse.scada.utils.str.StringHelper;

/**
 * A name provider which will split the name and re-assemble it
 * <p>
 * This name provider will take a name, provided by another name provider, split
 * it into tokens, by the means of a regular expression. After that it will
 * selected tokens, based on the
 * <q>fromStart</q> and
 * <q>fromEnd</q> positions and re-assemble the string using the provided
 * delimiter.
 * </p>
 * <p>
 * If
 * <q>fromStart</q> is positive, tokens before that index will be included.
 * Otherwise they will be rejected.
 * </p>
 * <p>
 * If
 * <q>fromEnd</q> is positive, tokens after that index will be included.
 * Otherwise they will be rejected.
 * </p>
 * <p>
 * Assuming the pattern is
 * <q>-</q> and the delimiter is
 * <q></q>.
 * <table>
 * <tr>
 * <th>Name
 * <th>
 * <th>fromStart</th>
 * <th>fromEnd</th>
 * <th>Result</th>
 * </tr>
 * <tr>
 * <td>1-2-3-4-5</td>
 * <td>2</td>
 * <td>0</td>
 * <td>1.2</td>
 * </tr>
 * <tr>
 * <td>1-2-3-4-5</td>
 * <td>0</td>
 * <td>2</td>
 * <td>4.5</td>
 * </tr>
 * <tr>
 * <td>1-2-3-4-5</td>
 * <td>-2</td>
 * <td>0</td>
 * <td>3.4</td>
 * </tr>
 * <tr>
 * <td>1-2-3-4-5</td>
 * <td>0</td>
 * <td>-2</td>
 * <td>1.2.3</td>
 * </tr>
 * </table>
 * </p>
 */
public class SplitNameProvider implements NameProvider
{

    private final Pattern pattern;

    private final NameProvider nameProvider;

    private final int fromStart;

    private final int fromEnd;

    private final String delimiter;

    /**
     * Create a new split name provider <br/>
     * <p>
     * The parameters fromStart and fromEnd actually define how much to take
     * from the start and from the end.
     * </p>
     *
     * @param nameProvider
     *            the provider of the name to split
     * @param pattern
     *            the pattern
     * @param fromStart
     *            the number of tokens to take from the start
     * @param fromEnd
     *            the number of tokens to take from the end
     * @param delimiter
     *            the delimiter
     */
    public SplitNameProvider ( final NameProvider nameProvider, final Pattern pattern, final int fromStart, final int fromEnd, final String delimiter )
    {
        this.nameProvider = nameProvider;
        this.pattern = pattern;
        this.fromStart = fromStart;
        this.fromEnd = fromEnd;
        this.delimiter = delimiter;
    }

    /**
     * Create a new split name provider <br/>
     * Actually calls
     * {@link #SplitNameProvider(NameProvider, Pattern, int, int, String)} with
     * {@link Pattern#compile(String)}
     *
     * @param nameProvider
     *            the provider of the name to split
     * @param pattern
     *            the pattern
     * @param fromStart
     *            the number of tokens to take from the start
     * @param fromEnd
     *            the number of tokens to take from the end
     * @param delimiter
     *            the delimiter
     */
    public SplitNameProvider ( final NameProvider nameProvider, final String pattern, final int fromStart, final int fromEnd, final String delimiter )
    {
        this ( nameProvider, Pattern.compile ( pattern ), fromStart, fromEnd, delimiter );
    }

    @Override
    public String getName ( final ItemDescriptor descriptor )
    {
        final String name = this.nameProvider.getName ( descriptor );

        final Collection<String> result = new LinkedList<String> ();

        final String[] toks = this.pattern.split ( name );

        for ( int i = 0; i < toks.length; i++ )
        {
            if ( i < this.fromStart && this.fromStart > 0 )
            {
                // we are in the start window, and the start is positive
                result.add ( toks[i] );
                continue;
            }

            if ( i >= toks.length - this.fromEnd && this.fromEnd > 0 )
            {
                // we are in the end window, and the end is positive
                result.add ( toks[i] );
                continue;
            }

            if ( i >= -this.fromStart && this.fromStart < 0 )
            {
                // we are outside the start window, and the start is negative
                result.add ( toks[i] );
                continue;
            }

            if ( i < -this.fromEnd && this.fromEnd < 0 )
            {
                // we are outside of the end window, and the end is negative
                result.add ( toks[i] );
                continue;
            }
        }

        return StringHelper.join ( result, this.delimiter );
    }
}
