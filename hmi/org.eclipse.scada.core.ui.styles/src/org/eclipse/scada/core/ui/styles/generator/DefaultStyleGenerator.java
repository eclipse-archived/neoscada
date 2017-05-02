/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles.generator;

public class DefaultStyleGenerator extends SimpleRuleStyleGenerator
{

    private final Rule[] rules = new Rule[] { //
    this.BLOCK_RULE, //
    this.MANUAL_RULE, //
    this.WARNING_RULE, //
    this.WARNING_ACK_RULE, //
    this.ALARM_RULE, //
    this.ALARM_ACK_RULE, //
    this.ERROR_RULE, //
    this.ERROR_ACK_RULE, //
    this.DISCONNECTED_RULE //
    };

    @Override
    protected Rule[] getRules ()
    {
        return this.rules;
    }

}