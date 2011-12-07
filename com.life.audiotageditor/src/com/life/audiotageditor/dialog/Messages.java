/**
 * This file is part of ${project_name}.
 * 
 * ${project_name} is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * ${project_name} is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * ${project_name}. If not, see <http://www.gnu.org/licenses/>.
 * 
 * @see http://www.gnu.org/licenses/lgpl.txt
 * @author art <lijianghui2000@gmail.com>
 */
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
