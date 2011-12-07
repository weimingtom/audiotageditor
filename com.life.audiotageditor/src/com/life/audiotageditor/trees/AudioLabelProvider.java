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

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.life.audiotageditor.Activator;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;

public class AudioLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof AudioModel) {
			AudioModel audioModel = ((AudioModel) element);
			if (audioModel instanceof AudioFolder) {
				return Activator.getImageDescriptor("icons/folder.gif") //$NON-NLS-1$
						.createImage();
			}
			if (audioModel instanceof AudioFile) {
				return Activator.getImageDescriptor("icons/file.gif") //$NON-NLS-1$
						.createImage();
			}
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof AudioModel) {
			return ((AudioModel) element).getName();
		}
		return super.getText(element);
	}

}
