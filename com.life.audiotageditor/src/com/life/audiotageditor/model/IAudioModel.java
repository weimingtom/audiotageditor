package com.life.audiotageditor.model;

import org.eclipse.core.runtime.IAdaptable;

public interface IAudioModel extends IAdaptable {

	static final int NULL_FLAG = -1;

	public static final int AUDIO_FILE = 1;
	public static final int AUDIO_FOLDER = 2;
	public static final int AUDIO_ROOT = 3;

	public static final int NONE = 0;

	public static final char SEPARATOR = '/';

	public void accept(IResourceVisitor visitor);

	public boolean equals(Object target);

	public boolean exists();

	public String getFullPath();

	public String getName();

	public int getType();

}
