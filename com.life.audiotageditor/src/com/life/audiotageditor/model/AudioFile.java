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

import java.io.InputStream;

public class AudioFile extends AudioModel implements IAudioFile {

	protected AudioFile(String path, AudioModelManager manager) {
		super(path, manager);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public InputStream getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream setContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		return AUDIO_FILE;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return super.getAdapter(adapter);
	}

}
