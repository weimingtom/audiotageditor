package com.life.audiotageditor.model;

import java.io.File;

public class AudioModelManager {

	private AudioModel audioModel;

	private static AudioModelManager manager = new AudioModelManager();

	public static AudioModelManager instance() {
		return manager;
	}

	public IAudioModel getRoot() {
		if (this.audioModel == null) {
			audioModel = new AudioModel(manager);
		}
		return this.audioModel;
	}

	public IAudioModelInfo getResourceInfo(String path) {
		// TODO
		if (path == null || path.isEmpty()) {
			return null;
		}
		File flag = new File(path);
		if (flag.isDirectory()) {
			return new AudioFolderInfo(path);
		}
		if (flag.isFile() && flag.getName().endsWith(".MP3") //$NON-NLS-1$
				|| flag.getName().endsWith(".mp3")) { //$NON-NLS-1$
			return new AudioFileInfo(path);
		}
		return null;
	}

	public AudioModel newResource(String path, int type) {
		switch (type) {
		case IAudioModel.AUDIO_FOLDER:
			return new AudioFolder(path, this);
		case IAudioModel.AUDIO_FILE:
			return new AudioFile(path, this);
		}
		return null;
	}
}
