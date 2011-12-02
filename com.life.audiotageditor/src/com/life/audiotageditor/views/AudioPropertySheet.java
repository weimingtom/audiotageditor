package com.life.audiotageditor.views;

import org.eclipse.ui.part.IPage;
import org.eclipse.ui.views.properties.PropertySheet;

public class AudioPropertySheet extends PropertySheet {

	public static final String ID = "com.life.audiotageditor.views.AudioPropertySheet";

	@Override
	public IPage getCurrentPage() {
		return super.getCurrentPage();

		// if (super.getCurrentPage() == null) {
		// return null;
		// }
		// PropertySheetPage propertySheetPage = new PropertySheetPage() {
		// @Override
		// public void createControl(Composite parent) {
		// // 设置一个使用描述来排序的Sorter
		// PropertySheetSorter sorter = new PropertySheetSorter() {
		// public int compare(IPropertySheetEntry entryA,
		// IPropertySheetEntry entryB) {
		// // 使用IPropertySheetEntry的description排序.
		// return getCollator().compare(entryA.getDescription(),
		// entryB.getDescription());
		// }
		// };
		// this.setSorter(sorter);
		//
		// super.createControl(parent);
		// }
		// };
		// return propertySheetPage;
	}

}
