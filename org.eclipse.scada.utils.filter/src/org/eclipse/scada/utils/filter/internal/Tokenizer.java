/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.filter.internal;

import java.util.Iterator;

import org.eclipse.scada.utils.filter.internal.Tokens.Token;
import org.eclipse.scada.utils.filter.internal.Tokens.TokenAssertion;
import org.eclipse.scada.utils.filter.internal.Tokens.TokenAttribute;
import org.eclipse.scada.utils.filter.internal.Tokens.TokenOperator;
import org.eclipse.scada.utils.filter.internal.Tokens.TokenValue;

public class Tokenizer implements Iterable<Token>, Iterator<Token>
{

    public static class TokenizeException extends RuntimeException
    {

        private static final long serialVersionUID = 2256865968011732768L;

        public TokenizeException ()
        {
            super ();
        }

        public TokenizeException ( final String message, final Throwable cause )
        {
            super ( message, cause );
        }

        public TokenizeException ( final String message )
        {
            super ( message );
        }

        public TokenizeException ( final Throwable cause )
        {
            super ( cause );
        }
    }

    private final char[] filter;

    private int pos = 0;

    private boolean isAttribute = false;

    private boolean isValue = false;

    private boolean isAssertion = false;

    private StringBuilder buffer;

    public Tokenizer ( final String toParse )
    {
        this.filter = toParse.toCharArray ();
    }

    @Override
    public Iterator<Token> iterator ()
    {
        return this;
    }

    @Override
    public boolean hasNext ()
    {
        return this.filter != null && this.pos < this.filter.length;
    }

    @Override
    public Token next ()
    {
        int overflow = 0;
        for ( ;; )
        {
            overflow += 1;
            if ( this.pos >= this.filter.length || overflow > this.filter.length )
            {
                throw new TokenizeException ( String.format ( Messages.getString ( "Tokenizer.Error.InvalidSyntax" ), this.pos ) ); //$NON-NLS-1$
            }
            final String currentChar = String.valueOf ( this.filter[this.pos] );

            if ( currentChar.equals ( Tokens.tokenLeftParen.getValue () ) ) // left paren
            {
                this.pos += 1;
                this.buffer = new StringBuilder ();
                return Tokens.tokenLeftParen;

            }
            else if ( currentChar.equals ( Tokens.tokenRightParen.getValue () ) ) // right paren
            {
                if ( this.isValue )
                {
                    this.isValue = false;
                    return new TokenValue ( this.buffer.toString () );
                }
                this.pos += 1;
                return Tokens.tokenRightParen;

            }
            else if ( TokenOperator.isOperator ( currentChar ) ) // operator
            {
                this.pos += 1;
                return TokenOperator.getByValue ( currentChar );

            }
            else if ( !this.isAttribute && !this.isAssertion && !this.isValue ) // attribute started
            {
                this.isAttribute = true;
                continue;
            }
            else if ( this.isAttribute && !this.isAssertion && !this.isValue ) // continue or end attribute
            {
                if ( this.pos + 1 >= this.filter.length )
                {
                    throw new TokenizeException ( String.format ( Messages.getString ( "Tokenizer.Error.InvalidSyntax" ), this.pos ) ); //$NON-NLS-1$
                }
                final String lookahead = currentChar + this.filter[this.pos + 1] + ( this.filter.length > this.pos + 2 ? this.filter[this.pos + 2] : "" ); //$NON-NLS-1$
                if ( TokenAssertion.isAssertion ( lookahead ) )
                {
                    this.isAssertion = true;
                    this.isAttribute = false;
                    final TokenAttribute token = new TokenAttribute ( this.buffer.toString () );
                    this.buffer = new StringBuilder ();
                    return token;
                }
                else
                {
                    if ( this.buffer == null )
                    {
                        throw new TokenizeException ( String.format ( Messages.getString ( "Tokenizer.Error.InvalidSyntax" ), this.pos ) ); //$NON-NLS-1$
                    }
                    this.buffer.append ( currentChar );
                    this.pos += 1;
                    continue;
                }
            }
            else if ( this.isAssertion ) // handle assertion
            {
                this.isAttribute = false;
                this.isAssertion = false;
                this.isValue = true;
                final String lookahead2 = currentChar + this.filter[this.pos + 1];
                final String lookahead3 = currentChar + this.filter[this.pos + 1] + ( this.filter.length > this.pos + 2 ? this.filter[this.pos + 2] : "" ); //$NON-NLS-1$
                // special case for presence
                if ( "=*)".equals ( lookahead3 ) ) //$NON-NLS-1$
                {
                    this.pos += 2;
                    return TokenAssertion.getByValue ( "=*" ); //$NON-NLS-1$
                }
                else if ( "=*".equals ( lookahead2 ) ) //$NON-NLS-1$
                {
                    this.pos += 1;
                    return TokenAssertion.getByValue ( "=" ); //$NON-NLS-1$
                }
                // all others are handled regularly
                if ( TokenAssertion.getByValue ( lookahead2 ) != null )
                {
                    this.pos += 2;
                    return TokenAssertion.getByValue ( lookahead2 );
                }
                this.pos += 1;
                return TokenAssertion.getByValue ( currentChar );

            }
            else if ( !this.isAttribute && !this.isAssertion && this.isValue ) // in any other case it is an value
            {
                this.buffer.append ( currentChar );
                this.pos += 1;
                continue;
            }
            throw new TokenizeException ( String.format ( Messages.getString ( "Tokenizer.Error.InvalidSyntax" ), this.pos ) ); //$NON-NLS-1$
        }
    }

    @Override
    public void remove ()
    {
        throw new UnsupportedOperationException ();
    }
}