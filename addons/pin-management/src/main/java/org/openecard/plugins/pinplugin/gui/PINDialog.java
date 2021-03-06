/****************************************************************************
 * Copyright (C) 2014 ecsec GmbH.
 * All rights reserved.
 * Contact: ecsec GmbH (info@ecsec.de)
 * 
 * This file is part of the Open eCard App.
 * 
 * GNU General Public License Usage
 * This file may be used under the terms of the GNU General Public
 * License version 3.0 as published by the Free Software Foundation
 * and appearing in the file LICENSE.GPL included in the packaging of
 * this file. Please review the following information to ensure the
 * GNU General Public License version 3.0 requirements will be met:
 * http://www.gnu.org/copyleft/gpl.html.
 * 
 * Other Usage
 * Alternatively, this file may be used in accordance with the terms
 * and conditions contained in a signed written agreement between
 * you and ecsec GmbH.
 * 
 ***************************************************************************/

package org.openecard.plugins.pinplugin.gui;

import iso.std.iso_iec._24727.tech.schema.ConnectionHandleType;
import org.openecard.common.interfaces.Dispatcher;
import org.openecard.gui.UserConsent;
import org.openecard.gui.UserConsentNavigator;
import org.openecard.gui.definition.UserConsentDescription;
import org.openecard.gui.executor.ExecutionEngine;
import org.openecard.plugins.pinplugin.RecognizedState;

/**
 *
 * @author Hans-Martin Haase
 */
public class PINDialog {

    private final UserConsent gui;
    private final ConnectionHandleType conHandle;
    private final RecognizedState state;
    private final boolean capturePin;
    private final Dispatcher dispatcher;

    public PINDialog(UserConsent gui, Dispatcher dispatcher, ConnectionHandleType cHandle, RecognizedState pinState,
	    boolean capturePin) {
	this.gui = gui;
	this.conHandle = cHandle;
	this.state = pinState;
	this.capturePin = capturePin;
	this.dispatcher = dispatcher;
    }

    /**
     * Shows this Dialog.
     */
    public void show() {
	UserConsentNavigator ucr = gui.obtainNavigator(createUserConsentDescription());
	ExecutionEngine exec = new ExecutionEngine(ucr);
	exec.process();
    }

    private UserConsentDescription createUserConsentDescription() {
	UserConsentDescription uc = new UserConsentDescription("PIN Operation");
	GenericPINStep gPINStep = new GenericPINStep("GenericPINStepID", "GenericPINStep", capturePin, state);
	gPINStep.setAction(new GenericPINAction("PIN Management", state, conHandle, dispatcher, gPINStep, capturePin));
	uc.getSteps().add(gPINStep);

	return uc;
    }

}
