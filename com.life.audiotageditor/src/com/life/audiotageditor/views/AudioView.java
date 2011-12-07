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
package com.life.audiotageditor.views;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.life.audiotageditor.trees.AudioContentProvider;
import com.life.audiotageditor.trees.AudioLabelProvider;

public class AudioView extends ViewPart {

	public static final String ID = "com.life.audiotageditor.views.AudioView"; //$NON-NLS-1$

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