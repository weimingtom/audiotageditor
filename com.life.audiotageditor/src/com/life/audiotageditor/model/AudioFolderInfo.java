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

public class AudioFolderInfo implements IAudioModelInfo {

	protected int flags = 2;
	protected String path;

	public AudioFolderInfo(String path) {
		this.path = path;
	}

	@Override
	public String getName() {
		// TODO
		return path.substring(path.lastIndexOf(SEPARATOR) + 1);
	}

	@Override
	public int getFlags() {
		return flags;
	}

	@Override
	public int getType() {
		return flags;
	}
}
