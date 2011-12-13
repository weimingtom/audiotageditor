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
