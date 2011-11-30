package com.life.audiotageditor.audio;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class AudioTag {

	public static AudioTag getAudioTag(AudioFile audioFile) {
		return new AudioTag(audioFile);
	}

	public AudioTag(AudioFile audioFile) {
		if (audioFile == null) {
			return;
		}
		Tag tag = audioFile.getTag();
		if (tag == null) {
			return;
		}
		this.title = tag.getFirst(FieldKey.TITLE);
		this.artist = tag.getFirst(FieldKey.ARTIST);
		this.album = tag.getFirst(FieldKey.ALBUM);
		this.year = tag.getFirst(FieldKey.YEAR);
		this.track = tag.getFirst(FieldKey.TRACK);
		this.genre = tag.getFirst(FieldKey.GENRE);
		this.comment = tag.getFirst(FieldKey.COMMENT);
		this.albumArtist = tag.getFirst(FieldKey.ALBUM_ARTIST);

	}

	private String title = "";
	private String artist = "";
	private String album = "";
	private String year = "";
	private String track = "";
	private String genre = "";
	private String comment = "";
	private String albumArtist = "";

	private String fileName = "";
	private String path = "";
	private String tag = "";
	private String codec = "";
	private String bitrate = "";
	private String frequency = "";
	private String length = "";
	private String modified = "";

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAlbumArtist() {
		return albumArtist;
	}

	public void setAlbumArtist(String albumArtist) {
		this.albumArtist = albumArtist;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getCodec() {
		return codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public String getBitrate() {
		return bitrate;
	}

	public void setBitrate(String bitrate) {
		this.bitrate = bitrate;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

}
