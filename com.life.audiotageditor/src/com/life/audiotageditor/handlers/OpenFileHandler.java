package com.life.audiotageditor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.AudioModelManager;
import com.life.audiotageditor.utils.StringUtil;
import com.life.audiotageditor.views.AudioView;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class OpenFileHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public OpenFileHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		String path = openFileDialog(window);
		if (path == null || path.isEmpty()) {
			return null;
		}
		AudioView audioView = (AudioView) window.getActivePage().findView(
				AudioView.ID);
		AudioModel audioModel = (AudioModel) AudioModelManager.instance()
				.getRoot();
		AudioFile audioFile = (AudioFile) audioModel.getFile(StringUtil
				.formatPath(path));
		audioView.getTreeViewer().setInput(audioFile);
		audioView.getTreeViewer().setSelection(
				new StructuredSelection(audioFile), true);
		return null;
	}

	private String openFileDialog(IWorkbenchWindow window) {
		FileDialog dialog = new FileDialog(window.getShell(), SWT.OPEN);
		dialog.setText("Audio File");
		dialog.setFilterExtensions(new String[] { "*.mp3", "*.MP3" });
		return dialog.open();
	}
}
