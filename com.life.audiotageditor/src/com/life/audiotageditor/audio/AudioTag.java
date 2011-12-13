/**
 * This file is part of ${project_name}.
 * 
 * ${project_name} is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * ${project_name} is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * ${project_name}. If not, see <http://www.gnu.org/licenses/>.
 * 
 * @see http://www.gnu.org/licenses/lgpl.txt
 * @author art <lijianghui2000@gmail.com>
 */
package com.life.audiotageditor.audio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

import com.life.audiotageditor.constants.Constants;

public class AudioTag {

	private AudioFile audioFile;
	private Tag audioTag;

	public AudioTag() {
	}

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
		this.frequency = Constants.STRING_NONE;
		this.length = audioFile.getFile().length() + Constants.STRING_NONE;
		this.modified = SimpleDateFormat.getDateTimeInstance().format(
				new Date(audioFile.getFile().lastModified()));
	}

	private String title = Constants.STRING_NONE;
	private String artist = Constants.STRING_NONE;
	private String album = Constants.STRING_NONE;
	private String year = Constants.STRING_NONE;
	private String track = Constants.STRING_NONE;
	private String genre = Constants.STRING_NONE;
	private String comment = Constants.STRING_NONE;
	private String albumArtist = Constants.STRING_NONE;

	private String fileName = Constants.STRING_NONE;
	private String path = Constants.STRING_NONE;
	private String tag = Constants.STRING_NONE;
	private String codec = Constants.STRING_NONE;
	private String bitRate = Constants.STRING_NONE;
	private String frequency = Constants.STRING_NONE;
	private String length = Constants.STRING_NONE;
	private String modified = Constants.STRING_NONE;

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
