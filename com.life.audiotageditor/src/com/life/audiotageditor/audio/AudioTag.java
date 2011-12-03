package com.life.audiotageditor.audio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class AudioTag {

	private AudioFile audioFile;
	private Tag audioTag;

	public AudioTag(AudioFile audioFile) {
		if (audioFile == null) {
			return;
		}
		this.audioFile = audioFile;
		audioTag = audioFile.getTag();
		if (audioTag == null) {
			return;
		}

		initContent();
	}

	private void initContent() {
		this.title = audioTag.getFirst(FieldKey.TITLE);
		this.artist = audioTag.getFirst(FieldKey.ARTIST);
		this.album = audioTag.getFirst(FieldKey.ALBUM);
		this.year = audioTag.getFirst(FieldKey.YEAR);
		this.track = audioTag.getFirst(FieldKey.TRACK);
		this.genre = audioTag.getFirst(FieldKey.GENRE);
		this.comment = audioTag.getFirst(FieldKey.COMMENT);
		this.albumArtist = audioTag.getFirst(FieldKey.ALBUM_ARTIST);
		
		this.fileName = audioFile.getFile().getName();
		this.path = audioFile.getFile().getPath();
		this.tag = audioTag.getClass().getSimpleName();
		this.codec = audioFile.getAudioHeader().getEncodingType();
		this.bitRate = audioFile.getAudioHeader().getBitRate();
		this.frequency = "";
		this.length = audioFile.getFile().length() + "";
		this.modified = SimpleDateFormat.getDateTimeInstance().format(
				new Date(audioFile.getFile().lastModified()));
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
	private String bitRate = "";
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

	public String getBitRate() {
		return bitRate;
	}

	public void setBitRate(String bitRate) {
		this.bitRate = bitRate;
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