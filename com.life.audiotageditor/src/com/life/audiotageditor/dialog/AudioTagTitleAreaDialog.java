package com.life.audiotageditor.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.life.audiotageditor.audio.AudioTag;
import com.life.audiotageditor.model.AudioFolder;
import com.life.audiotageditor.model.AudioModel;
import com.life.audiotageditor.model.AudioModelManager;
import com.life.audiotageditor.model.IAudioFile;
import com.life.audiotageditor.model.IAudioModel;
import com.life.audiotageditor.utils.AudioFileUtil;
import com.life.audiotageditor.utils.StringUtil;
import com.life.audiotageditor.views.AudioView;

public class AudioTagTitleAreaDialog extends TitleAreaDialog {
	private Text audioFolderText;
	private Text artistText;
	private Text albumText;
	private Text yearText;
	private Text genreText;
	private Text commentText;
	private Text albumArtistText;
	private Text audioTagDetailText;

	private Shell parentShell;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public AudioTagTitleAreaDialog(Shell parentShell) {
		super(parentShell);
		this.parentShell = parentShell;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText(Messages.AudioTagTitleAreaDialog_batchedit_dialog_title);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage(Messages.AudioTagTitleAreaDialog_batchedit_dialog_message);
		setTitle(Messages.AudioTagTitleAreaDialog_batchedit_dialog_title);
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label audioFolderLabel = new Label(container, SWT.NONE);
		FormData audioFolderLabelFormData = new FormData();
		audioFolderLabelFormData.left = new FormAttachment(0, 6);
		audioFolderLabelFormData.top = new FormAttachment(0, 13);
		audioFolderLabel.setLayoutData(audioFolderLabelFormData);
		audioFolderLabel
				.setText(Messages.AudioTagTitleAreaDialog_audit_folder_label);

		audioFolderText = new Text(container, SWT.BORDER);
		FormData audioFolderTextFormData = new FormData();
		audioFolderTextFormData.left = new FormAttachment(15);
		audioFolderTextFormData.top = new FormAttachment(0, 10);
		audioFolderText.setLayoutData(audioFolderTextFormData);

		Button audioFolderButton = new Button(container, SWT.NONE);
		audioFolderTextFormData.right = new FormAttachment(audioFolderButton,
				-6);
		FormData audioFolderButtonFormData = new FormData();
		audioFolderButtonFormData.top = new FormAttachment(audioFolderLabel,
				-5, SWT.TOP);
		audioFolderButtonFormData.right = new FormAttachment(100, -6);
		audioFolderButton.setLayoutData(audioFolderButtonFormData);
		audioFolderButton
				.setText(Messages.AudioTagTitleAreaDialog_audio_folder_button);
		audioFolderButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseDown(MouseEvent e) {
				String path = openFolderDialog(parentShell);
				if (path == null || path.isEmpty()) {
					return;
				}
				audioFolderText.setText(path);
				IAudioModel[] members = ((AudioFolder) ((AudioModel) AudioModelManager
						.instance().getRoot()).getFolder(StringUtil
						.formatPath(path))).members();
				StringBuilder builder = new StringBuilder();
				int i = 1;
				for (IAudioModel member : members) {
					if (member instanceof IAudioFile) {
						builder.append(i);
						builder.append("-"); //$NON-NLS-1$
						builder.append(member.getName());
						builder.append("\r\n"); //$NON-NLS-1$

						i++;
					}
				}
				audioTagDetailText.setText(builder.toString());
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		Label artistLabel = new Label(container, SWT.NONE);
		FormData artistLabelFormData = new FormData();
		artistLabelFormData.top = new FormAttachment(audioFolderLabel, 12);
		artistLabelFormData.left = new FormAttachment(0, 6);
		artistLabel.setLayoutData(artistLabelFormData);
		artistLabel.setText(Messages.AudioTagTitleAreaDialog_artist_label);

		artistText = new Text(container, SWT.BORDER);
		FormData artistTextFormData = new FormData();
		artistTextFormData.top = new FormAttachment(audioFolderText, 6);
		artistTextFormData.left = new FormAttachment(15);
		artistTextFormData.right = new FormAttachment(50);
		artistText.setLayoutData(artistTextFormData);

		Label albumLabel = new Label(container, SWT.NONE);
		FormData albumLabelFormData = new FormData();
		albumLabelFormData.left = new FormAttachment(50, 6);
		albumLabelFormData.bottom = new FormAttachment(artistLabel, 0,
				SWT.BOTTOM);
		albumLabel.setLayoutData(albumLabelFormData);
		albumLabel.setText(Messages.AudioTagTitleAreaDialog_album_label);

		albumText = new Text(container, SWT.BORDER);
		FormData albumTextFormData = new FormData();
		albumTextFormData.right = new FormAttachment(100, -6);
		albumTextFormData.top = new FormAttachment(audioFolderText, 6);
		albumTextFormData.left = new FormAttachment(65);
		albumText.setLayoutData(albumTextFormData);

		Label yearLabel = new Label(container, SWT.NONE);
		FormData yearLabelFormData = new FormData();
		yearLabelFormData.top = new FormAttachment(artistLabel, 12);
		yearLabelFormData.left = new FormAttachment(0, 6);
		yearLabel.setLayoutData(yearLabelFormData);
		yearLabel.setText(Messages.AudioTagTitleAreaDialog_year_label);

		yearText = new Text(container, SWT.BORDER);
		FormData yearTextFormData = new FormData();
		yearTextFormData.top = new FormAttachment(artistText, 6);
		yearTextFormData.left = new FormAttachment(15);
		yearTextFormData.right = new FormAttachment(50);
		yearText.setLayoutData(yearTextFormData);

		Label genreLabel = new Label(container, SWT.NONE);
		FormData genreLabelFormData = new FormData();
		genreLabelFormData.bottom = new FormAttachment(yearLabel, 0, SWT.BOTTOM);
		genreLabelFormData.left = new FormAttachment(50, 6);
		genreLabel.setLayoutData(genreLabelFormData);
		genreLabel.setText(Messages.AudioTagTitleAreaDialog_genre_label);

		genreText = new Text(container, SWT.BORDER);
		FormData genreTextFormData = new FormData();
		genreTextFormData.right = new FormAttachment(100, -6);
		genreTextFormData.top = new FormAttachment(albumText, 6);
		genreTextFormData.left = new FormAttachment(65);
		genreText.setLayoutData(genreTextFormData);

		Label commentLabel = new Label(container, SWT.NONE);
		FormData commentLabelFormData = new FormData();
		commentLabelFormData.top = new FormAttachment(yearLabel, 12);
		commentLabelFormData.left = new FormAttachment(0, 6);
		commentLabel.setLayoutData(commentLabelFormData);
		commentLabel.setText(Messages.AudioTagTitleAreaDialog_comment_label);

		commentText = new Text(container, SWT.BORDER);
		FormData commentTextFormData = new FormData();
		commentTextFormData.top = new FormAttachment(yearText, 6);
		commentTextFormData.left = new FormAttachment(15);
		commentTextFormData.right = new FormAttachment(50);
		commentText.setLayoutData(commentTextFormData);

		Label albumArtistLabel = new Label(container, SWT.NONE);
		FormData albumArtistLabelFormData = new FormData();
		albumArtistLabelFormData.bottom = new FormAttachment(commentLabel, 0,
				SWT.BOTTOM);
		albumArtistLabelFormData.left = new FormAttachment(50, 6);
		albumArtistLabel.setLayoutData(albumArtistLabelFormData);
		albumArtistLabel
				.setText(Messages.AudioTagTitleAreaDialog_album_artist_label);

		albumArtistText = new Text(container, SWT.BORDER);
		FormData albumArtistTextFormData = new FormData();
		albumArtistTextFormData.right = new FormAttachment(100, -6);
		albumArtistTextFormData.top = new FormAttachment(genreText, 6);
		albumArtistTextFormData.left = new FormAttachment(65);
		albumArtistText.setLayoutData(albumArtistTextFormData);

		Group audioTagDetailGroup = new Group(container, SWT.NONE);
		audioTagDetailGroup
				.setText(Messages.AudioTagTitleAreaDialog_audio_tag_detail_group);
		audioTagDetailGroup.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData audioTagDetailGroupFormData = new FormData();
		audioTagDetailGroupFormData.bottom = new FormAttachment(100, -10);
		audioTagDetailGroupFormData.right = new FormAttachment(100, -6);
		audioTagDetailGroupFormData.top = new FormAttachment(commentLabel, 6);
		audioTagDetailGroupFormData.left = new FormAttachment(0, 6);
		audioTagDetailGroup.setLayoutData(audioTagDetailGroupFormData);

		Composite composite = new Composite(audioTagDetailGroup, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));

		audioTagDetailText = new Text(composite, SWT.BORDER | SWT.MULTI);

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 500);
	}

	@Override
	protected void okPressed() {
		String audioFolderTextValue = audioFolderText.getText();
		String audioTagDetailTextValue = audioTagDetailText.getText();
		if (audioFolderTextValue != null
				&& !(audioTagDetailTextValue.isEmpty())) {
			AudioTag audioTag = new AudioTag();
			audioTag.setArtist(artistText.getText());
			audioTag.setAlbum(albumText.getText());
			audioTag.setYear(yearText.getText());
			audioTag.setGenre(genreText.getText());
			audioTag.setComment(commentText.getText());
			audioTag.setAlbumArtist(albumArtistText.getText());
			AudioFileUtil.saveAudioFile(audioFolderTextValue,
					audioTagDetailTextValue, audioTag);

			AudioView audioView = (AudioView) PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.findView(AudioView.ID);
			AudioModel audioModel = (AudioModel) AudioModelManager.instance()
					.getRoot();

			AudioFolder audioFolder = (AudioFolder) audioModel
					.getFolder(StringUtil.formatPath(audioFolderTextValue));
			audioView.getTreeViewer().setInput(audioFolder);
			audioView.getTreeViewer().setSelection(
					new StructuredSelection(audioFolder.members()[0]), true);
		}
		super.okPressed();
	}

	private String openFolderDialog(Shell shell) {
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);
		dialog.setText(Messages.AudioTagTitleAreaDialog_dialog_text);
		return dialog.open();
	}
}
