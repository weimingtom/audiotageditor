package com.life.audiotageditor;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.life.audiotageditor.views.AudioPropertySheet;
import com.life.audiotageditor.views.AudioView;

public class Perspective implements IPerspectiveFactory {

	public static final String PERSPECTIVE_ID = "com.life.audiotageditor.perspective";

	public void createInitialLayout(IPageLayout layout) {

		String editor = layout.getEditorArea();

		layout.addView(AudioView.ID, layout.LEFT, 0.3f, editor);
		layout.addView(AudioPropertySheet.ID, layout.BOTTOM, 0.7f, editor);
	}
}
