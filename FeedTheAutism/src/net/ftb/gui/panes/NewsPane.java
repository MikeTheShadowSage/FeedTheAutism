package net.ftb.gui.panes;

import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.ftb.data.Settings;
import net.ftb.gui.LaunchFrame;
import net.ftb.log.Logger;

public class NewsPane extends JPanel implements ILauncherPane {
	private static final long serialVersionUID = 1L;

	private JEditorPane news;
	private JScrollPane newsPanel;

	public NewsPane() {
		super();
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		news = new JEditorPane();
		news.setEditable(false);
		newsPanel = new JScrollPane(news);
		newsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		newsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		newsPanel.setBounds(10, 10, 790, 290);
		this.add(newsPanel);
	}

	@Override
	public void onVisible() {
		try {
			news.setPage("http://mtss.blindrein.com/getdate");
			Settings.getSettings().setNewsDate();
			Settings.getSettings().save();
			LaunchFrame.getInstance().setTabbedPaneIcons();
		} catch (IOException e1) {
			Logger.logError(e1.getMessage(), e1);
		}
	}
}