/****************************************************************************
 * Copyright (C) 2012-2015 HS Coburg.
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

package org.openecard.scio;

import java.security.NoSuchAlgorithmException;
import org.openecard.common.ifd.scio.SCIOTerminals;


/**
 * NFC specific implementation of the TerminalFactory
 *
 * @author Dirk Petrautzki 
 */
public class NFCFactory implements org.openecard.common.ifd.scio.TerminalFactory {

    private static final String ALGORITHM = "nfc";

    public NFCFactory() throws NoSuchAlgorithmException {
//	NfcManager nfcManager = (NfcManager) this.getSystemService(Context.NFC_SERVICE);
//	NfcAdapter adapter = nfcManager.getDefaultAdapter();
//	if (adapter == null || !adapter.isEnabled()) {
//	    MessageDialog dialog = gui.obtainMessageDialog();
//	    String message = lang.translationForKey("android.error.nfc_error");
//	    String title = lang.translationForKey("error");
//	    dialog.showMessageDialog(message, title, DialogType.ERROR_MESSAGE);
//	    return;
//	}
    }

    @Override
    public String getType() {              
	return ALGORITHM;
    }

    @Override
    public SCIOTerminals terminals() {
	return new NFCCardTerminals();
    }
/*
    @Override
    public void stop() {
    }

    @Override
    public void start(Object o) {
    }
*/

}
