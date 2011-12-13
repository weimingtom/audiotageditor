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

import org.eclipse.core.runtime.IAdaptable;

public interface IAudioModel extends IAdaptable {

	static final int NULL_FLAG = -1;

	public static final int AUDIO_FILE = 1;
	public static final int AUDIO_FOLDER = 2;
	public static final int AUDIO_ROOT = 3;

	public static final int NONE = 0;

	public static final char SEPARATOR = '/';

	public void accept(IResourceVisitor visitor);

	public boolean equals(Object target);

	public boolean exists();

	public String getFullPath();

	public String getName();

	public int getType();

}
