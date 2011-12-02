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

	private static final String FILE_NAME = "fileName";
	private static final String PATH = "path";
	private static final String TAG = "tag";
	private static final String CODEC = "codec";
	private static final String BIT_RATE = "bitRate";
	private static final String FREQUENCY = "frequency";
	private static final String LENGTH = "length";
	private static final String MODIFIED = "modified";

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
			descriptors[0] = new TextPropertyDescriptor(FILE_NAME, "FileName");
			descriptors[1] = new TextPropertyDescriptor(PATH, "Path");
			return descriptors;
		}
		if (audioModel instanceof AudioFile) {
			IPropertyDescriptor[] descriptors = new IPropertyDescriptor[8];
			descriptors[0] = new TextPropertyDescriptor(FILE_NAME, "FileName");
			descriptors[1] = new TextPropertyDescriptor(PATH, "Path");
			descriptors[2] = new TextPropertyDescriptor(TAG, "Tag");
			descriptors[3] = new TextPropertyDescriptor(CODEC, "Codec");
			descriptors[4] = new TextPropertyDescriptor(BIT_RATE, "BitRate");
			descriptors[5] = new TextPropertyDescriptor(FREQUENCY, "Frequency");
			descriptors[6] = new TextPropertyDescriptor(LENGTH, "Length");
			descriptors[7] = new TextPropertyDescriptor(MODIFIED, "Modified");
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
