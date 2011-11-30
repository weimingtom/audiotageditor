package com.life.audiotageditor.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class AudioTagEditor extends FormEditor {

	public static final String ID = "com.life.audiotageditor.editor.AudioTagEditor";

	@Override
	protected void addPages() {
		try {
			addPage(new AudioTagPage(this, AudioTagPage.ID, AudioTagPage.TITLE));
		} catch (PartInitException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
