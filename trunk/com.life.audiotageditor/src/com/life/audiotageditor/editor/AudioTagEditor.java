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
package com.life.audiotageditor.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

public class AudioTagEditor extends FormEditor {

	public static final String ID = "com.life.audiotageditor.editor.AudioTagEditor"; //$NON-NLS-1$

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
