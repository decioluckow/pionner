package br.com.decioluckow.pionner;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseWheelEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.decioluckow.pionner.mouse.ClickAndHoldMouseAdapter;
import br.com.decioluckow.pionner.mouse.MouseAction;
import br.com.decioluckow.pionner.mouse.MouseWheelAdapter;

public class Pionner extends JFrame {

	private static final long serialVersionUID = 559351996957400730L;
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss.S");

	private JTextField displayField = buildTextField("display", 370, 146, 420, 70);
	private Display display = null;

	public void start() {
		JPanel panel = new JPanel();
		loadFrontImage(panel);
		panel.add(buildClickableArea("src", 237, 146, 70, 35, this::clicksrc, this::holdsrc));
		panel.add(buildClickableArea("return", 239, 197, 70, 35, this::clickreturn, this::holdreturn));
		panel.add(buildClickableArea("b1", 488, 256, 50, 25, this::clickb1, this::holdb1));
		panel.add(buildClickableArea("b2", 545, 256, 50, 25, this::clickb2, this::holdb2));
		panel.add(buildClickableArea("b3", 604, 256, 50, 25, this::clickb3, this::holdb3));
		panel.add(buildClickableArea("b4", 656, 256, 50, 25, this::clickb4, this::holdb4));
		panel.add(buildClickableArea("b5", 713, 256, 50, 25, this::clickb5, this::holdb5));
		panel.add(buildClickableArea("b6", 765, 256, 50, 25, this::clickb6, this::holdb6));
		panel.add(buildClickableArea("back", 360, 257, 50, 20, this::clickback, this::holdback));
		panel.add(buildClickableArea("foward", 423, 257, 50, 20, this::clickforward, this::holdforward));
		panel.add(buildClickableArea("search", 274, 251, 60, 30, this::clicksearch, this::holdsearch));
		panel.add(buildClickableArea("mute", 91, 88, 40, 40, this::clickmute, this::holdmute));
		panel.add(buildClickableArea("dispoff", 93, 239, 40, 40, this::clickdispoff, this::holddispoff));
		panel.add(buildClickableArea("eq", 170, 255, 70, 30, this::clickeq, this::holdeq));
		panel.add(buildRollArea("roll", 130, 145, 80, 80, this::rollMouseWheel, this::clickroll, this::holdroll));
		panel.add(displayField);
		add(panel);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Pionner MVH-X195UI");
	}

	private void loadFrontImage(JPanel panel)  {
		panel.setLayout(null);
		URI imagePath = loadFrontImageURI();
		ImageIcon image = new ImageIcon(Paths.get(imagePath).toFile().getAbsolutePath());
		int width = image.getIconWidth();
		int height = image.getIconHeight();
		JLabel imageLabel = new JLabel(image);
		imageLabel.setBounds(0, 0, width, height);
		super.setSize(width, height);
		panel.add(imageLabel);
	}

	private URI loadFrontImageURI() {
		try {
			return Pionner.class.getResource("/pionner.jpg").toURI();
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Display getDisplay() {
		if (display == null) {
			display = buildDisplay();
		}
		return display;
	}

	private Display buildDisplay() {
		return new Display() {
			
			@Override
			public void write(String text) {
				displayField.setText(text);
			}
		};
	}

	private JPanel buildRollArea(String name, int x, int y, int w, int h,
			BiConsumer<MouseWheelEvent, Integer> rollAction,
			MouseAction clickAction,
			MouseAction holdAction) {
		JPanel rollArea = new JPanel();
		rollArea.setName(name);
		rollArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rollArea.setBounds(x, y, w, h);
		rollArea.addMouseWheelListener(new MouseWheelAdapter(rollAction));
		rollArea.addMouseListener(new ClickAndHoldMouseAdapter(clickAction, holdAction));
		rollArea.setOpaque(false);
		return rollArea;
	}

	private JPanel buildClickableArea(String name, int x, int y, int w, int h, MouseAction clickAction, MouseAction holdAction) {
		JPanel clickableArea = new JPanel();
		clickableArea.setName(name);
		clickableArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clickableArea.setBounds(x, y, w, h);
		clickableArea.addMouseListener(new ClickAndHoldMouseAdapter(clickAction, holdAction));
		clickableArea.setOpaque(false);
		return clickableArea;
	}

	public JTextField buildTextField(String name, int x, int y, int w, int h) {
		JTextField textField = new JTextField();
		textField.setName(name);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setCursor(new Cursor(Cursor.HAND_CURSOR));
		textField.setBounds(x, y, w, h);
		return textField;
	}

	private void print(String text) {
		getDisplay().write(DATE_FORMAT.format(new Date()) + " - " + text);
	}

	private void clicksrc() {
		print("click src");
	}
	
	private void holdsrc() {
		print("hold src");
	}

	private void clickreturn() {
		print("click return");
	}
	
	private void holdreturn() {
		print("hold return");
	}

	private void clickb1() {
		print("click b1");
	}

	private void holdb1() {
		print("hold b1");
	}

	private void clickb2() {
		print("click b2");
	}
	
	private void holdb2() {
		print("hold b2");
	}

	private void clickb3() {
		print("click b3");
	}
	
	private void holdb3() {
		print("hold b3");
	}

	private void clickb4() {
		print("click b4");
	}
	
	private void holdb4() {
		print("hold b4");
	}

	private void clickb5() {
		print("click b5");
	}
	
	private void holdb5() {
		print("hold b5");
	}

	private void clickb6() {
		print("click b6");
	}
	
	private void holdb6() {
		print("hold b6");
	}

	private void clickback() {
		print("click back");
	}
	
	private void holdback() {
		print("hold back");
	}

	private void clickforward() {
		print("click forward");
	}
	
	private void holdforward() {
		print("hold forward");
	}

	private void clicksearch() {
		print("click search");
	}

	private void holdsearch() {
		print("hold search");
	}

	private void clickmute() {
		print("click mute");
	}
	
	private void holdmute() {
		print("hold mute");
	}

	private void clickdispoff() {
		print("click dispoff");
	}
	
	private void holddispoff() {
		print("hold dispoff");
	}

	private void clickeq() {
		print("click eq");
	}

	private void holdeq() {
		print("hold eq");
	}
	
	private void clickroll() {
		print("click roll");
	}

	private void holdroll() {
		print("hold roll");
	}

	private void rollMouseWheel(MouseWheelEvent e, Integer amount) {
		print("roll por " + amount);
	}

}