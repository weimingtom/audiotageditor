package com.life.audiotageditor.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.life.audiotageditor.dialog.AudioTagTitleAreaDialog;
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
public class BatchEditHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public BatchEditHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil
				.getActiveWorkbenchWindowChecked(event);
		AudioTagTitleAreaDialog audioTagTitleAreaDialog = new AudioTagTitleAreaDialog(
				window.getShell());
		audioTagTitleAreaDialog.open();
		return null;
	}
}
