package com.life.audiotageditor.model;

public class AudioFolderInfo implements IAudioModelInfo {

	protected int flags = 2;
	protected String path;

	public AudioFolderInfo(String path) {
		this.path = path;
	}

	@Override
	public String getName() {
		// TODO
		return path.substring(path.lastIndexOf(SEPARATOR) + 1);
	}

	@Override
	public int getFlags() {
		return flags;
	}

	@Override
	public int getType() {
		return flags;
	}
}
