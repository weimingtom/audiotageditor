package com.life.audiotageditor.handlers;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.life.audiotageditor.handlers.messages"; //$NON-NLS-1$
	public static String OpenFileHandler_dialog_text;
	public static String OpenFolderHandler_dialog_text;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
