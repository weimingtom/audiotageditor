package com.life.audiotageditor.model;

public class AudioFolder extends AudioContainer implements IAudioFolder {

	protected AudioFolder(String path, AudioModelManager manager) {
		super(path, manager);
	}

	public void create() {

	}

	@Override
	public int getType() {
		return AUDIO_FOLDER;
	}

	@Override
	public Object getAdapter(Class<?> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

}
