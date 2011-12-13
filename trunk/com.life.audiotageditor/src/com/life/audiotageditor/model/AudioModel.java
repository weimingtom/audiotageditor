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

import org.eclipse.ui.views.properties.IPropertySource;

import com.life.audiotageditor.property.AudioModelProperySource;

public class AudioModel implements IAudioModel {

	String path;
	AudioModelManager manager;

	public AudioModel(AudioModelManager manager) {
		this.manager = manager;
	}

	public AudioModel(String path, AudioModelManager manager) {
		this.path = path;
		this.manager = manager;
	}

	public IAudioFolder getFolder(String path) {
		return (IAudioFolder) manager.newResource(path, AUDIO_FOLDER);
	}

	public IAudioFile getFile(String path) {
		return (IAudioFile) manager.newResource(path, AUDIO_FILE);
	}

	@Override
	public void accept(IResourceVisitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object target) {
		if (this == target)
			return true;
		if (!(target instanceof AudioModel))
			return false;
		AudioModel resource = (AudioModel) target;
		return getType() == resource.getType() && path.equals(resource.path);
	}

	@Override
	public boolean exists() {
		AudioModelInfo info = (AudioModelInfo) getAudioModelInfo();
		return exists(getFlags(info));
	}

	public boolean exists(int flags) {
		return flags != NULL_FLAG;
	}

	@Override
	public String getFullPath() {
		return path;
	}

	@Override
	public String getName() {
		return getAudioModelInfo().getName();
	}

	public int getFlags(AudioModelInfo info) {
		return (info == null) ? NULL_FLAG : info.getFlags();
	}

	public IAudioModelInfo getAudioModelInfo() {
		return manager.getResourceInfo(path);
	}

	@Override
	public int getType() {
		return AUDIO_ROOT;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (adapter.equals(IPropertySource.class)) {
			return new AudioModelProperySource(this);
		}
		return null;
	}

}
