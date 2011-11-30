package com.life.audiotageditor.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ViewPart;

import com.life.audiotageditor.tables.AudioTagContentProvider;
import com.life.audiotageditor.tables.AudioTagLabelProvider;

public class AudioTagView extends ViewPart implements ISelectionListener {

	public static final String ID = "com.life.audiotageditor.views.AudioTagView"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private TableViewer tableViewer;
	private Table table;

	public AudioTagView() {
	}

	/**
	 * Create contents of the view part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = toolkit.createComposite(parent, SWT.NONE);
		toolkit.paintBordersFor(container);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));

		tableViewer = new TableViewer(container, SWT.MULTI | SWT.FULL_SELECTION
				| SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table = tableViewer.getTable();

		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);

		TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
		newColumnTableColumn.setWidth(80);
		newColumnTableColumn.setText("ID");

		TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_1.setWidth(300);
		newColumnTableColumn_1.setText("Name");

		tableViewer.setContentProvider(new AudioTagContentProvider());
		tableViewer.setLabelProvider(new AudioTagLabelProvider());
		tableViewer.setInput(null);

		getSite().getPage().addSelectionListener(AudioView.ID, this);
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {

		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			tableViewer.setInput(treeSelection.getFirstElement());
		}

	}

}
