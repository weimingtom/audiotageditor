package com.life.audiotageditor.dialog;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.life.audiotageditor.dialog.messages"; //$NON-NLS-1$
	public static String AudioTagTitleAreaDialog_album_artist_label;
	public static String AudioTagTitleAreaDialog_album_label;
	public static String AudioTagTitleAreaDialog_artist_label;
	public static String AudioTagTitleAreaDialog_audio_folder_button;
	public static String AudioTagTitleAreaDialog_audio_tag_detail_group;
	public static String AudioTagTitleAreaDialog_audit_folder_label;
	public static String AudioTagTitleAreaDialog_batchedit_dialog_message;
	public static String AudioTagTitleAreaDialog_batchedit_dialog_title;
	public static String AudioTagTitleAreaDialog_comment_label;
	public static String AudioTagTitleAreaDialog_dialog_text;
	public static String AudioTagTitleAreaDialog_genre_label;
	public static String AudioTagTitleAreaDialog_year_label;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
