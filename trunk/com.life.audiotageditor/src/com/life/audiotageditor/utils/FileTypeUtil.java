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
package com.life.audiotageditor.utils;

import java.io.File;
import java.util.Arrays;

import com.life.audiotageditor.constants.Constants;
import com.life.audiotageditor.model.IAudioModel;

public class FileTypeUtil {
	public static int getFileType(String path) {
		if (path == null || path.isEmpty()) {
			return IAudioModel.NULL_FLAG;
		}
		File file = new File(path);
		if (file.isDirectory()) {
			return IAudioModel.AUDIO_FOLDER;
		}

		String fileName = file.getName();
		String fileNameExtension = fileName.lastIndexOf(".") > 0 ? fileName
				.substring(fileName.lastIndexOf(".")) : Constants.STRING_NONE;
		if (file.isFile() && isAudioFile(fileNameExtension)) {
			return IAudioModel.AUDIO_FILE;
		}
		return IAudioModel.NULL_FLAG;
	}

	public static boolean isAudioFile(String fileExtension) {
		if (fileExtension == null || fileExtension.isEmpty()) {
			return false;
		}

		return Arrays.asList(Constants.FILE_TYPE.split("[,]")).contains(
				fileExtension.toLowerCase());
	}
}
