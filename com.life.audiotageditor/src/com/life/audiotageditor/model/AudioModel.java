package com.life.audiotageditor.model;

public class AudioModel implements IAudioModel {

	String path;
	AudioModelManager manager;

	public AudioModel(AudioModelManager manager) {
		this.manager = manager;
	}

	public AudioModel(String path, AudioModelManager manager) {
		this.path = path;
		this.manager = manager;
	}

	public IAudioFolder getFolder(String path) {
		return (IAudioFolder) manager.newResource(path, AUDIO_FOLDER);
	}

	public IAudioFile getFile(String path) {
		return (IAudioFile) manager.newResource(path, AUDIO_FILE);
	}

	@Override
	public void accept(IResourceVisitor visitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean equals(Object target) {
		if (this == target)
			return true;
		if (!(target instanceof AudioModel))
			return false;
		AudioModel resource = (AudioModel) target;
		return getType() == resource.getType() && path.equals(resource.path);
	}

	@Override
	public boolean exists() {
		AudioModelInfo info = (AudioModelInfo) getAudioModelInfo();
		return exists(getFlags(info));
	}

	public boolean exists(int flags) {
		return flags != NULL_FLAG;
	}

	@Override
	public String getFullPath() {
		return path;
	}

	@Override
	public String getName() {
		return getAudioModelInfo().getName();
	}

	public int getFlags(AudioModelInfo info) {
		return (info == null) ? NULL_FLAG : info.getFlags();
	}

	public IAudioModelInfo getAudioModelInfo() {
		return manager.getResourceInfo(path);
	}

	@Override
	public Object getAdapter(Class<?> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() {
		return AUDIO_ROOT;
	}

}
