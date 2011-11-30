package com.life.audiotageditor.model;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import com.life.audiotageditor.audio.AudioTag;

public class AudioFileInfo implements IAudioModelInfo {

	protected int flags = 1;
	protected String path;

	public AudioFileInfo(String path) {
		this.path = path;
	}

	public synchronized AudioTag getAudioTag() {
		try {
			return new AudioTag(AudioFileIO.read(new File(path)));
		} catch (CannotReadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TagException e) {
			e.printStackTrace();
		} catch (ReadOnlyFileException e) {
			e.printStackTrace();
		} catch (InvalidAudioFrameException e) {
			e.printStackTrace();
		}
		return null;
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
