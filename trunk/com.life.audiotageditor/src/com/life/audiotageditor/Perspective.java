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

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.life.audiotageditor.views.AudioPropertySheet;
import com.life.audiotageditor.views.AudioView;

public class Perspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "com.life.audiotageditor.perspective"; //$NON-NLS-1$

	@SuppressWarnings("static-access")
	public void createInitialLayout(IPageLayout layout) {

		String editor = layout.getEditorArea();

		layout.addView(AudioView.ID, layout.LEFT, 0.3f, editor);
		layout.addView(AudioPropertySheet.ID, layout.BOTTOM, 0.7f, editor);
	}
}
