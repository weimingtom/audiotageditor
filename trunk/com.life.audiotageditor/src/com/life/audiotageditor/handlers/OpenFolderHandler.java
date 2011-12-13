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
package com.life.audiotageditor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.AudioModelManager;
import com.life.audiotageditor.utils.StringUtil;
import com.life.audiotageditor.views.AudioView;

public class OpenFolderHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public OpenFolderHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		String path = openFolderDialog(window);
		if (path == null || path.isEmpty()) {
			return null;
		}
		AudioView audioView = (AudioView) window.getActivePage().findView(
				AudioView.ID);
		AudioModel audioModel = (AudioModel) AudioModelManager.instance()
				.getRoot();

		AudioFolder audioFolder = (AudioFolder) audioModel.getFolder(StringUtil
				.formatPath(path));
		audioView.getTreeViewer().setInput(audioFolder);
		audioView.getTreeViewer().setSelection(
				new StructuredSelection(audioFolder.members()[0]), true);
		return null;
	}

	private String openFolderDialog(IWorkbenchWindow window) {
		DirectoryDialog dialog = new DirectoryDialog(window.getShell(),
				SWT.OPEN);
		dialog.setText(Messages.OpenFolderHandler_dialog_text);
		return dialog.open();
	}
}
