package com.life.audiotageditor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.life.audiotageditor.messages"; //$NON-NLS-1$
	public static String ApplicationWorkbenchWindowAdvisor_audio_tag_editor_title;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
