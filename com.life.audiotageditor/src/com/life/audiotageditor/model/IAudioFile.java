package com.life.audiotageditor.model;

import java.io.InputStream;

public interface IAudioFile extends IAudioModel, IAdaptable {

	public void create();

	public InputStream getContents();

	public String getFullPath();

	public String getName();

	public InputStream setContents();
}
