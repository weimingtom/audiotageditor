package com.life.audiotageditor.trees;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.life.audiotageditor.Activator;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;

public class AudioLabelProvider extends LabelProvider {

	@Override
	public Image getImage(Object element) {
		if (element instanceof AudioModel) {
			AudioModel audioModel = ((AudioModel) element);
			if (audioModel instanceof AudioFolder) {
				return Activator.getImageDescriptor("icons/folder.gif")
						.createImage();
			}
			if (audioModel instanceof AudioFile) {
				return Activator.getImageDescriptor("icons/file.gif")
						.createImage();
			}
		}
		return super.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof AudioModel) {
			return ((AudioModel) element).getName();
		}
		return super.getText(element);
	}

}
