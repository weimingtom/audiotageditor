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
package com.life.audiotageditor.trees;

import org.eclipse.ui.model.WorkbenchContentProvider;

import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.IAudioModel;

public class AudioContentProvider extends WorkbenchContentProvider {

	@Override
	public Object[] getChildren(Object element) {
		if (element instanceof AudioModel) {
			AudioModel audioModel = ((AudioModel) element);
			switch (audioModel.getType()) {
			case IAudioModel.AUDIO_FOLDER:
				return ((AudioFolder) audioModel).members();
			case IAudioModel.AUDIO_FILE:
				return new Object[] { audioModel };
			}
		}
		return super.getChildren(element);
	}

	@Override
	public Object[] getElements(Object element) {
		return getChildren(element);
	}

	@Override
	public Object getParent(Object element) {
		return super.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof AudioModel) {
			return element instanceof AudioFolder;
		}
		return super.hasChildren(element);
	}

}
