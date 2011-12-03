package com.life.audiotageditor.utils;

import java.io.File;
import java.io.IOException;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.id3.ID3v23Tag;

import com.life.audiotageditor.audio.AudioTag;

public class AudioFileUtil {

	public static void saveAudioFile(String path, AudioTag audioTag) {
		try {
			AudioFile audioFile = AudioFileIO.read(new File(path));
			Tag tagv1 = new ID3v1Tag();
			tagv1.setField(FieldKey.TITLE, audioTag.getTitle());
			tagv1.setField(FieldKey.ARTIST, audioTag.getArtist());
			tagv1.setField(FieldKey.ALBUM, audioTag.getAlbum());
			tagv1.setField(FieldKey.YEAR, audioTag.getYear());
			tagv1.setField(FieldKey.GENRE, audioTag.getGenre());
			tagv1.setField(FieldKey.COMMENT, audioTag.getComment());
//			tagv1.setField(FieldKey.ALBUM_ARTIST, audioTag.getAlbumArtist());
			audioFile.setTag(tagv1);

			Tag tagv23 = new ID3v23Tag();
			tagv23.setField(FieldKey.ALBUM, audioTag.getAlbum());
			tagv23.setField(FieldKey.TITLE, audioTag.getTitle());
			tagv23.setField(FieldKey.ARTIST, audioTag.getArtist());
			if (!audioTag.getTrack().isEmpty()) {
				tagv23.setField(FieldKey.TRACK, audioTag.getTrack());
			}
			tagv23.setField(FieldKey.YEAR, audioTag.getYear());
			tagv23.setField(FieldKey.GENRE, audioTag.getGenre());
			tagv23.setField(FieldKey.COMMENT, audioTag.getComment());
			tagv23.setField(FieldKey.ALBUM_ARTIST, audioTag.getAlbumArtist());
			audioFile.setTag(tagv23);

			AudioFileIO.write(audioFile);
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
		} catch (CannotWriteException e) {
			e.printStackTrace();
		}
	}
}
