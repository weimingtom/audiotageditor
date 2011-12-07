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
package com.life.audiotageditor.property;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.life.audiotageditor.audio.AudioTag;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFileInfo;
import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;

public class AudioModelProperySource implements IPropertySource {

	private static final String FILE_NAME = "fileName"; //$NON-NLS-1$
	private static final String PATH = "path"; //$NON-NLS-1$
	private static final String TAG = "tag"; //$NON-NLS-1$
	private static final String CODEC = "codec"; //$NON-NLS-1$
	private static final String BIT_RATE = "bitRate"; //$NON-NLS-1$
	private static final String FREQUENCY = "frequency"; //$NON-NLS-1$
	private static final String LENGTH = "length"; //$NON-NLS-1$
	private static final String MODIFIED = "modified"; //$NON-NLS-1$

	private AudioModel audioModel;

	public AudioModelProperySource(AudioModel audioModel) {
		this.audioModel = audioModel;
	}

	@Override
	public Object getEditableValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPropertyDescriptor[] getPropertyDescriptors() {
		if (audioModel instanceof AudioFolder) {
			IPropertyDescriptor[] descriptors = new IPropertyDescriptor[2];
			descriptors[0] = new TextPropertyDescriptor(FILE_NAME, Messages.AudioModelProperySource_file_name);
			descriptors[1] = new TextPropertyDescriptor(PATH, Messages.AudioModelProperySource_path);
			return descriptors;
		}
		if (audioModel instanceof AudioFile) {
			IPropertyDescriptor[] descriptors = new IPropertyDescriptor[8];
			descriptors[0] = new TextPropertyDescriptor(FILE_NAME, Messages.AudioModelProperySource_file_name);
			descriptors[1] = new TextPropertyDescriptor(PATH, Messages.AudioModelProperySource_path);
			descriptors[2] = new TextPropertyDescriptor(TAG, Messages.AudioModelProperySource_tag);
			descriptors[3] = new TextPropertyDescriptor(CODEC, Messages.AudioModelProperySource_codes);
			descriptors[4] = new TextPropertyDescriptor(BIT_RATE, Messages.AudioModelProperySource_bit_rate);
			descriptors[5] = new TextPropertyDescriptor(FREQUENCY, Messages.AudioModelProperySource_frequency);
			descriptors[6] = new TextPropertyDescriptor(LENGTH, Messages.AudioModelProperySource_length);
			descriptors[7] = new TextPropertyDescriptor(MODIFIED, Messages.AudioModelProperySource_modified);
			return descriptors;
		}

		return null;
	}

	@Override
	public Object getPropertyValue(Object id) {
		if (id.equals(FILE_NAME)) {
			return audioModel.getName();
		} else if (id.equals(PATH)) {
			return audioModel.getFullPath();
		}
		if (audioModel instanceof AudioFile) {
			AudioTag audioTag = ((AudioFileInfo) ((AudioFile) audioModel)
					.getAudioModelInfo()).getAudioTag();
			if (id.equals(TAG)) {
				return audioTag.getTag();
			} else if (id.equals(CODEC)) {
				return audioTag.getCodec();
			} else if (id.equals(BIT_RATE)) {
				return audioTag.getBitRate();
			} else if (id.equals(FREQUENCY)) {
				return audioTag.getFrequency();
			} else if (id.equals(LENGTH)) {
				return audioTag.getLength();
			} else if (id.equals(MODIFIED)) {
				return audioTag.getModified();
			}
		}
		return null;
	}

	@Override
	public boolean isPropertySet(Object id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetPropertyValue(Object id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object id, Object value) {
		// TODO Auto-generated method stub

	}

}
