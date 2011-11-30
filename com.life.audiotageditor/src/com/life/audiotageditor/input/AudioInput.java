package com.life.audiotageditor.input;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import com.life.audiotageditor.model.AudioModel;

public class AudioInput implements IEditorInput {

	private AudioModel audioModel;

	public AudioModel getAudioModel() {
		return audioModel;
	}

	public AudioInput(AudioModel audioModel) {
		this.audioModel = audioModel;
	}

	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return audioModel.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return audioModel.getName();
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

}
