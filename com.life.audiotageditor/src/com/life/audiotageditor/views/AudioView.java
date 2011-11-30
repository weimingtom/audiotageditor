package com.life.audiotageditor.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import com.life.audiotageditor.editor.AudioTagEditor;
import com.life.audiotageditor.input.AudioInput;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.trees.AudioContentProvider;
import com.life.audiotageditor.trees.AudioLabelProvider;

public class AudioView extends ViewPart {

	public static final String ID = "com.life.audiotageditor.views.AudioView";

	private TreeViewer treeViewer;

	public TreeViewer getTreeViewer() {
		return this.treeViewer;
	}

	@Override
	public void createPartControl(Composite parent) {
		treeViewer = new TreeViewer(parent, SWT.SINGLE | SWT.BORDER);
		treeViewer.setLabelProvider(new AudioLabelProvider());
		treeViewer.setContentProvider(new AudioContentProvider());

		addListener();
		getSite().setSelectionProvider(treeViewer);
	}

	private void addListener() {
		treeViewer.getTree().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				try {
					IDE.openEditor(getSite().getPage(), new AudioInput(
							(AudioModel) ((Tree) event.getSource()).getData()),
							AudioTagEditor.ID);
				} catch (PartInitException e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}