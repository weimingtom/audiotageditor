package com.life.audiotageditor.property;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.life.audiotageditor.property.messages"; //$NON-NLS-1$
	public static String AudioModelProperySource_bit_rate;
	public static String AudioModelProperySource_codes;
	public static String AudioModelProperySource_file_name;
	public static String AudioModelProperySource_frequency;
	public static String AudioModelProperySource_length;
	public static String AudioModelProperySource_modified;
	public static String AudioModelProperySource_path;
	public static String AudioModelProperySource_tag;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
