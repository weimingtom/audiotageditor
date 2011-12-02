package com.life.audiotageditor.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

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

		getSite().setSelectionProvider(treeViewer);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}