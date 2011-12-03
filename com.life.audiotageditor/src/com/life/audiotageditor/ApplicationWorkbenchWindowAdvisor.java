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
		configurer.setTitle("Audio Tag Editor"); //$NON-NLS-1$
	}

	@Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub
		super.postWindowOpen();
		IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench.getPerspectiveRegistry().getDefaultPerspective()
				.equals(Perspective.PERSPECTIVE_ID)) {

			String path = new File("").getAbsolutePath();
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
