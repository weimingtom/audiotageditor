package com.life.audiotageditor.editor;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.life.audiotageditor.editor.messages"; //$NON-NLS-1$
	public static String AudioTagPage_album_artist_column;
	public static String AudioTagPage_album_column;
	public static String AudioTagPage_artist_column;
	public static String AudioTagPage_audio_tag_page_title;
	public static String AudioTagPage_comment_column;
	public static String AudioTagPage_genre_column;
	public static String AudioTagPage_name_column;
	public static String AudioTagPage_title_column;
	public static String AudioTagPage_track_column;
	public static String AudioTagPage_year_column;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
