package com.life.audiotageditor.model;

import java.io.InputStream;

public class AudioFile extends AudioModel implements IAudioFile {

	protected AudioFile(String path, AudioModelManager manager) {
		super(path, manager);
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public InputStream getContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream setContents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		return AUDIO_FILE;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		return super.getAdapter(adapter);
	}

}
