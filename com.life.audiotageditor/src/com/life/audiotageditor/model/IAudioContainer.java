package com.life.audiotageditor.model;

public interface IAudioContainer extends IAudioModel, IAdaptable {

	public IAudioFolder getFolder(String name);

	public IAudioFile getFile(String name);

	public boolean exists(String path);

	public IAudioModel[] members();
}