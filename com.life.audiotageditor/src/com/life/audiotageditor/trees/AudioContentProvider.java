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
