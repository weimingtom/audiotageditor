package com.life.audiotageditor.editor;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.life.audiotageditor.audio.AudioTag;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFileInfo;
import com.life.audiotageditor.tables.AudioTagContentProvider;
import com.life.audiotageditor.tables.AudioTagLabelProvider;
import com.life.audiotageditor.utils.AudioFileUtil;
import com.life.audiotageditor.utils.ReflectUtil;
import com.life.audiotageditor.views.AudioView;

public class AudioTagPage extends FormPage implements ISelectionListener {

	public static final String ID = "com.life.audiotageditor.editor.AudioTagPage";
	public static final String TITLE = "Audio Tag Page";
	private TableViewer tableViewer;
	private Table table;

	public AudioTagPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	class AudioTagCellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			if (property.equals("name")) {
				return false;
			}
			return true;
		}

		@Override
		public Object getValue(Object element, String property) {
			if (element instanceof AudioFile) {
				AudioTag audioTag = ((AudioFileInfo) ((AudioFile) element)
						.getAudioModelInfo()).getAudioTag();
				return ReflectUtil.getProperty(audioTag, property);
			}
			return "";
		}

		@Override
		public void modify(Object element, String property, Object value) {
			TableItem tableItem = null;
			if (element instanceof Table) {
				tableItem = ((Table) element).getSelection()[0];
			}
			if (element instanceof TableItem) {
				tableItem = (TableItem) element;
			}
			if (null == tableItem) {
				return;
			}
			AudioFile data = (AudioFile) tableItem.getData();
			if (data instanceof AudioFile) {
				AudioTag audioTag = ((AudioFileInfo) (data).getAudioModelInfo())
						.getAudioTag();
				ReflectUtil.setProperty(audioTag, property, value.toString());
				AudioFileUtil.saveAudioFile(data.getFullPath(), audioTag);
				tableViewer.refresh();
			}
		}

	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		ScrolledForm form = managedForm.getForm();
		Composite body = form.getBody();
		body.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormToolkit toolkit = managedForm.getToolkit();
		Composite content = toolkit.createComposite(body, SWT.NONE);
		content.setLayout(new FillLayout(SWT.HORIZONTAL));

		tableViewer = new TableViewer(content, SWT.MULTI | SWT.FULL_SELECTION
				| SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		table = tableViewer.getTable();

		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setWidth(150);
		nameColumn.setText("Name");

		TableColumn titleColumn = new TableColumn(table, SWT.NONE);
		titleColumn.setWidth(150);
		titleColumn.setText("Title");

		TableColumn artistColumn = new TableColumn(table, SWT.NONE);
		artistColumn.setWidth(150);
		artistColumn.setText("Artist");

		TableColumn albumColumn = new TableColumn(table, SWT.NONE);
		albumColumn.setWidth(200);
		albumColumn.setText("Album");

		TableColumn yearColumn = new TableColumn(table, SWT.NONE);
		yearColumn.setWidth(50);
		yearColumn.setText("Year");

		TableColumn trackColumn = new TableColumn(table, SWT.NONE);
		trackColumn.setWidth(50);
		trackColumn.setText("Track");

		TableColumn genreColumn = new TableColumn(table, SWT.NONE);
		genreColumn.setWidth(100);
		genreColumn.setText("Genre");

		TableColumn commentColumn = new TableColumn(table, SWT.NONE);
		commentColumn.setWidth(100);
		commentColumn.setText("Comment");

		TableColumn albumArtist = new TableColumn(table, SWT.NONE);
		albumArtist.setWidth(200);
		albumArtist.setText("AlbumArtist");

		tableViewer.setContentProvider(new AudioTagContentProvider());
		tableViewer.setLabelProvider(new AudioTagLabelProvider());
		tableViewer.setInput(null);

		tableViewer.setColumnProperties(new String[] { "name", "title",
				"artist", "album", "year", "track", "genre", "comment",
				"albumArtist" });
		CellEditor[] cellEditors = new CellEditor[9];
		for (int i = 1; i < 9; i++) {
			cellEditors[i] = new TextCellEditor(tableViewer.getTable());
		}
		tableViewer.setCellEditors(cellEditors);
		tableViewer.setCellModifier(new AudioTagCellModifier());

		getSite().getPage().addSelectionListener(AudioView.ID, this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			tableViewer.setInput(treeSelection.getFirstElement());
		}
	}
}
