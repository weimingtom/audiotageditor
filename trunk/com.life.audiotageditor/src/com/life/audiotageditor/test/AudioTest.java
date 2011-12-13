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
package com.life.audiotageditor.test;

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
import org.junit.Test;

import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.AudioModelManager;
import com.life.audiotageditor.model.IAudioFolder;

public class AudioTest {

	@Test
	public void workspaceTest() {
		AudioModel root = (AudioModel) AudioModelManager.instance().getRoot();
		IAudioFolder audioFolder = root.getFolder("D:/mp3/"); //$NON-NLS-1$

		AudioModel[] audioModels = (AudioModel[]) audioFolder.members();
		for (AudioModel audioModel : audioModels) {

			if (audioModel instanceof AudioFolder) {
				AudioModel[] audioMo = (AudioModel[]) ((AudioFolder) audioModel)
						.members();
				System.out.println(audioMo);
			}
		}
		System.out.println(audioFolder);
	}

	@Test
	public void test() {
		String test = "a:fs/fsdfmp3/"; //$NON-NLS-1$

		boolean result = test
				.matches(".*/|.*[/A-Za-z0-9_].mp3|.*[/A-Za-z0-9_].MP3"); //$NON-NLS-1$
		// boolean result = test.matches(".*/.*.mp3");

		System.out.println(result);
	}

	@Test
	public void mp3TagReadeTest() {
		File testFile = new File("src/com/life/audiotageditor/test/test.mp3"); //$NON-NLS-1$

		try {
			AudioFile audioFile = AudioFileIO.read(testFile);
			Tag tag = audioFile.getTag();
			if (tag instanceof ID3v1Tag) {
				ID3v1Tag v1tag = (ID3v1Tag) tag;
				String title = v1tag.getFirst(FieldKey.TITLE);
				System.out.println(title);
			}
			if (tag instanceof ID3v23Tag) {
				ID3v23Tag v23tag = (ID3v23Tag) tag;
				String title = v23tag.getFirst(FieldKey.TITLE);
				System.out.println(title);
			}
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

	}

	@Test
	public void mp3TagWriteTest() {
		File testFile = new File("src/com/life/audiotageditor/test/test.mp3"); //$NON-NLS-1$

		try {
			AudioFile audioFile = AudioFileIO.read(testFile);
			Tag tagv1 = new ID3v1Tag();
			tagv1.setField(FieldKey.ALBUM, "New Concept Engl"); //$NON-NLS-1$
			tagv1.setField(FieldKey.TITLE, "New Concept Engli"); //$NON-NLS-1$
			tagv1.setField(FieldKey.ARTIST, "New Concept Englis"); //$NON-NLS-1$
			audioFile.setTag(tagv1);

			Tag tagv23 = new ID3v23Tag();
			tagv23.setField(FieldKey.ALBUM, "New Concept En"); //$NON-NLS-1$
			tagv23.setField(FieldKey.TITLE, "New Concept En"); //$NON-NLS-1$
			tagv23.setField(FieldKey.ARTIST, "New Concept "); //$NON-NLS-1$
			tagv23.setField(FieldKey.TRACK, "1"); //$NON-NLS-1$
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
