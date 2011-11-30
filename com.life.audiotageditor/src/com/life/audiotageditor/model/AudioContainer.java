package com.life.audiotageditor.model;

import java.io.File;

import com.life.audiotageditor.utils.StringUtil;

public abstract class AudioContainer extends AudioModel implements
		IAudioContainer {

	protected AudioContainer(String path, AudioModelManager manager) {
		super(path, manager);
	}

	@Override
	public boolean exists(String path) {
		return super.manager.getResourceInfo(getFullPath()) != null;
	}

	@Override
	public IAudioFolder getFolder(String name) {
		return (IAudioFolder) super.manager.newResource(getFullPath()
				+ SEPARATOR + name, AUDIO_FILE);
	}

	@Override
	public IAudioFile getFile(String name) {
		return (IAudioFile) super.manager.newResource(getFullPath() + SEPARATOR
				+ name, AUDIO_FOLDER);
	}

	@Override
	public IAudioModel[] members() {
		return getChildren();
	}

	@Override
	public String getFullPath() {
		return super.getFullPath();
	}

	protected IAudioModel[] getChildren() {
		File[] children = new File(getFullPath()).listFiles();
		AudioModel[] result = new AudioModel[children.length];
		int found = 0;
		for (int i = 0; i < children.length; i++) {
			IAudioModelInfo info = manager.getResourceInfo(StringUtil
					.formatPath(children[i].getPath()));
			if (info == null) {
				continue;
			}
			result[found++] = manager.newResource(
					StringUtil.formatPath(children[i].getPath()),
					info.getType());
		}
		if (found == result.length)
			return result;
		AudioModel[] trimmedResult = new AudioModel[found];
		System.arraycopy(result, 0, trimmedResult, 0, found);
		return trimmedResult;
	}

}
