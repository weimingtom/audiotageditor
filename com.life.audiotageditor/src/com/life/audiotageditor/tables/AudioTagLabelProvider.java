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
package com.life.audiotageditor.tables;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.life.audiotageditor.audio.AudioTag;
import com.life.audiotageditor.constants.Constants;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFileInfo;

public class AudioTagLabelProvider extends LabelProvider implements
		ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO
		if (element instanceof AudioFile) {
			AudioFile audioFile = (AudioFile) element;
			AudioTag audioTag = ((AudioFileInfo) (audioFile)
					.getAudioModelInfo()).getAudioTag();
			switch (columnIndex) {
			case 0:
				return audioFile.getName();
			case 1:
				return audioTag.getTitle();
			case 2:
				return audioTag.getArtist();
			case 3:
				return audioTag.getAlbum();
			case 4:
				return audioTag.getYear();
			case 5:
				return audioTag.getTrack();
			case 6:
				return audioTag.getGenre();
			case 7:
				return audioTag.getComment();
			case 8:
				return audioTag.getAlbumArtist();
			default:
				break;
			}
		}
		return Constants.STRING_NONE;
	}
}
