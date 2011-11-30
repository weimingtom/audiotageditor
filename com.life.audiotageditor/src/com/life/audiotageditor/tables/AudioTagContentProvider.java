package com.life.audiotageditor.tables;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.IAudioModel;

public class AudioTagContentProvider implements IStructuredContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object element) {
		if (element instanceof AudioModel) {
			AudioModel audioModel = ((AudioModel) element);
			switch (audioModel.getType()) {
			case IAudioModel.AUDIO_FOLDER:
				return ((AudioFolder) audioModel).members();
			case IAudioModel.AUDIO_FILE:
				return new Object[] { audioModel };
			}
		}
		return new Object[0];
	}

}
