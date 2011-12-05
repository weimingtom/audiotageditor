package com.life.audiotageditor.editor;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.life.audiotageditor.audio.AudioTag;
import com.life.audiotageditor.constants.Constants;
import com.life.audiotageditor.model.AudioFile;
import com.life.audiotageditor.model.AudioFileInfo;
import com.life.audiotageditor.tables.AudioTagContentProvider;
import com.life.audiotageditor.tables.AudioTagLabelProvider;
import com.life.audiotageditor.utils.AudioFileUtil;
import com.life.audiotageditor.utils.ReflectUtil;
import com.life.audiotageditor.views.AudioView;

public class AudioTagPage extends FormPage implements ISelectionListener {

	public static final String ID = "com.life.audiotageditor.editor.AudioTagPage"; //$NON-NLS-1$
	public static final String TITLE = Messages.AudioTagPage_audio_tag_page_title;
	private TableViewer tableViewer;
	private Table table;

	public AudioTagPage(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	class AudioTagCellModifier implements ICellModifier {

		@Override
		public boolean canModify(Object element, String property) {
			if (property.equals("name")) { //$NON-NLS-1$
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
			return Constants.STRING_NONE;
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
				if (value.equals(ReflectUtil.getProperty(audioTag, property))) {
					return;
				}
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
		nameColumn.setText(Messages.AudioTagPage_name_column);

		TableColumn titleColumn = new TableColumn(table, SWT.NONE);
		titleColumn.setWidth(150);
		titleColumn.setText(Messages.AudioTagPage_title_column);

		TableColumn artistColumn = new TableColumn(table, SWT.NONE);
		artistColumn.setWidth(150);
		artistColumn.setText(Messages.AudioTagPage_artist_column);

		TableColumn albumColumn = new TableColumn(table, SWT.NONE);
		albumColumn.setWidth(200);
		albumColumn.setText(Messages.AudioTagPage_album_column);

		TableColumn yearColumn = new TableColumn(table, SWT.NONE);
		yearColumn.setWidth(150);
		yearColumn.setText(Messages.AudioTagPage_year_column);

		TableColumn trackColumn = new TableColumn(table, SWT.NONE);
		trackColumn.setWidth(50);
		trackColumn.setText(Messages.AudioTagPage_track_column);

		TableColumn genreColumn = new TableColumn(table, SWT.NONE);
		genreColumn.setWidth(100);
		genreColumn.setText(Messages.AudioTagPage_genre_column);

		TableColumn commentColumn = new TableColumn(table, SWT.NONE);
		commentColumn.setWidth(100);
		commentColumn.setText(Messages.AudioTagPage_comment_column);

		TableColumn albumArtistColumn = new TableColumn(table, SWT.NONE);
		albumArtistColumn.setWidth(200);
		albumArtistColumn.setText(Messages.AudioTagPage_album_artist_column);

		table.setSortColumn(trackColumn);
		// table.setSortDirection(SWT.UP);

		tableViewer.setContentProvider(new AudioTagContentProvider());
		tableViewer.setLabelProvider(new AudioTagLabelProvider());
		tableViewer.setInput(null);

		tableViewer.setColumnProperties(new String[] { "name", "title", //$NON-NLS-1$ //$NON-NLS-2$
				"artist", "album", "year", "track", "genre", "comment", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
				"albumArtist" }); //$NON-NLS-1$
		CellEditor[] cellEditors = new CellEditor[9];
		for (int i = 1; i < 9; i++) {
			cellEditors[i] = new TextCellEditor(tableViewer.getTable());
			if (i == 5) {
				((Text) cellEditors[i].getControl())
						.addVerifyListener(new VerifyListener() {
							@Override
							public void verifyText(VerifyEvent e) {
								boolean b = (e.text.matches("[0-9]")); //$NON-NLS-1$
								e.doit = b;
							}
						});
			}
		}
		tableViewer.setCellEditors(cellEditors);
		tableViewer.setCellModifier(new AudioTagCellModifier());

		getSite().getPage().addSelectionListener(AudioView.ID, this);

		getSite().setSelectionProvider(tableViewer);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof TreeSelection) {
			TreeSelection treeSelection = (TreeSelection) selection;
			tableViewer.setInput(treeSelection.getFirstElement());
		}
	}
}
