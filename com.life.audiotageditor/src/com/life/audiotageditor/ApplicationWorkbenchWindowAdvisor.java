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
package com.life.audiotageditor;

import java.io.File;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.life.audiotageditor.constants.Constants;
import com.life.audiotageditor.editor.AudioTagEditor;
import com.life.audiotageditor.input.AudioInput;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.AudioModelManager;
import com.life.audiotageditor.model.IAudioFile;
import com.life.audiotageditor.utils.StringUtil;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		Rectangle screenSize = Display.getDefault().getClientArea();
		configurer
				.setInitialSize(new Point(screenSize.width, screenSize.height));
		configurer.setTitle(Messages.ApplicationWorkbenchWindowAdvisor_audio_tag_editor_title); 
	}

	@Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub
		super.postWindowOpen();
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench.getPerspectiveRegistry().getDefaultPerspective()
				.equals(Perspective.PERSPECTIVE_ID)) {

			String path = new File(Constants.STRING_NONE).getAbsolutePath();
			IAudioFile audioFile = ((AudioModel) AudioModelManager.instance()
					.getRoot()).getFile(StringUtil.formatPath(path));
			if (path != null) {
				IWorkbenchPage page = workbench.getActiveWorkbenchWindow()
						.getActivePage();
				try {
					page.openEditor(new AudioInput((AudioModel) audioFile),
							AudioTagEditor.ID);
				} catch (PartInitException e) {
					throw new RuntimeException(e);
				}
			}
		}

	}
}
