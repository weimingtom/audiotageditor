package com.life.audiotageditor.model;

import org.eclipse.core.runtime.IAdaptable;

public interface IAudioContainer extends IAudioModel, IAdaptable {

	public IAudioFolder getFolder(String name);

	public IAudioFile getFile(String name);

	public boolean exists(String path);

	public IAudioModel[] members();
}