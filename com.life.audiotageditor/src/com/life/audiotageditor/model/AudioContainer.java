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

import java.io.File;

import com.life.audiotageditor.utils.StringUtil;

public abstract class AudioContainer extends AudioModel implements
		IAudioContainer {

	protected AudioContainer(String path, AudioModelManager manager) {
		super(path, manager);
	}

	@Override
	public boolean exists(String path) {
		return super.manager.getResourceInfo(getFullPath()) != null;
	}

	@Override
	public IAudioFolder getFolder(String name) {
		return (IAudioFolder) super.manager.newResource(getFullPath()
				+ SEPARATOR + name, AUDIO_FILE);
	}

	@Override
	public IAudioFile getFile(String name) {
		return (IAudioFile) super.manager.newResource(getFullPath() + SEPARATOR
				+ name, AUDIO_FOLDER);
	}

	@Override
	public IAudioModel[] members() {
		return getChildren();
	}

	@Override
	public String getFullPath() {
		return super.getFullPath();
	}

	protected IAudioModel[] getChildren() {
		File[] children = new File(getFullPath()).listFiles();
		AudioModel[] result = new AudioModel[children.length];
		int found = 0;
		for (int i = 0; i < children.length; i++) {
			IAudioModelInfo info = manager.getResourceInfo(StringUtil
					.formatPath(children[i].getPath()));
			if (info == null) {
				continue;
			}
			result[found++] = manager.newResource(
					StringUtil.formatPath(children[i].getPath()),
					info.getType());
		}
		if (found == result.length)
			return result;
		AudioModel[] trimmedResult = new AudioModel[found];
		System.arraycopy(result, 0, trimmedResult, 0, found);
		return trimmedResult;
	}

}
