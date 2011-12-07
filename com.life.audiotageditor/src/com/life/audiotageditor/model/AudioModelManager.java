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
package com.life.audiotageditor.model;

import com.life.audiotageditor.utils.FileTypeUtil;

public class AudioModelManager {

	private AudioModel audioModel;

	private static AudioModelManager manager = new AudioModelManager();

	public static AudioModelManager instance() {
		return manager;
	}

	public IAudioModel getRoot() {
		if (this.audioModel == null) {
			audioModel = new AudioModel(manager);
		}
		return this.audioModel;
	}

	public IAudioModelInfo getResourceInfo(String path) {
		switch (FileTypeUtil.getFileType(path)) {
		case IAudioModel.AUDIO_FOLDER:
			return new AudioFolderInfo(path);
		case IAudioModel.AUDIO_FILE:
			return new AudioFileInfo(path);
		}
		return null;
	}

	public AudioModel newResource(String path, int type) {
		switch (type) {
		case IAudioModel.AUDIO_FOLDER:
			return new AudioFolder(path, this);
		case IAudioModel.AUDIO_FILE:
			return new AudioFile(path, this);
		}
		return null;
	}
}
