import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.BiConsumer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Pionner extends JFrame {

	private static final long serialVersionUID = 559351996957400730L;

	private JTextField display = buildTextField("display", 370, 146, 420, 70);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public void start() throws URISyntaxException {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		ImageIcon icon = new ImageIcon(
				Paths.get(Pionner.class.getResource("pionner.jpg").toURI()).toFile().getAbsolutePath());
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		JLabel image = new JLabel(icon);
		image.setBounds(0, 0, width, height);

		panel.add(buildClickableArea("src", 237, 146, 70, 35, (e, s) -> {
			clicksrc(e, s);
		}));
		panel.add(buildClickableArea("return", 239, 197, 70, 35, (e, s) -> {
			clickreturn(e, s);
		}));
		panel.add(buildClickableArea("b1", 488, 256, 50, 25, (e, s) -> {
			clickb1(e, s);
		}));
		panel.add(buildClickableArea("b2", 545, 256, 50, 25, (e, s) -> {
			clickb2(e, s);
		}));
		panel.add(buildClickableArea("b3", 604, 256, 50, 25, (e, s) -> {
			clickb3(e, s);
		}));
		panel.add(buildClickableArea("b4", 656, 256, 50, 25, (e, s) -> {
			clickb4(e, s);
		}));
		panel.add(buildClickableArea("b5", 713, 256, 50, 25, (e, s) -> {
			clickb5(e, s);
		}));
		panel.add(buildClickableArea("b6", 765, 256, 50, 25, (e, s) -> {
			clickb6(e, s);
		}));
		panel.add(buildClickableArea("back", 360, 257, 50, 20, (e, s) -> {
			clickback(e, s);
		}));
		panel.add(buildClickableArea("foward", 423, 257, 50, 20, (e, s) -> {
			clickforward(e, s);
		}));
		panel.add(buildClickableArea("search", 274, 251, 60, 30, (e, s) -> {
			clicksearch(e, s);
		}));
		panel.add(buildClickableArea("mute", 91, 88, 40, 40, (e, s) -> {
			clickmute(e, s);
		}));
		panel.add(buildClickableArea("dispoff", 93, 239, 40, 40, (e, s) -> {
			clickdispoff(e, s);
		}));
		panel.add(buildClickableArea("eq", 170, 255, 70, 30, (e, s) -> {
			clickeq(e, s);
		}));
		panel.add(buildRollArea("roll", 130, 145, 80, 80, (e, a) -> {
			rollMouseWheel(e, a);
		}));
		panel.add(display);

		panel.add(image);
		super.setSize(width, height);
		super.add(panel);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		super.setVisible(true);
		super.setTitle("Pionner MVH-X195UI");
	}

	public JPanel buildRollArea(String name, int x, int y, int w, int h,
			BiConsumer<MouseWheelEvent, Integer> function) {
		JPanel rollArea = new JPanel();
		rollArea.setName(name);
		rollArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rollArea.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
		rollArea.setBounds(x, y, w, h);
		rollArea.addMouseWheelListener(new PionnerMouseWheel(function));
		rollArea.setOpaque(false);
		return rollArea;
	}

	public JPanel buildClickableArea(String name, int x, int y, int w, int h,
			BiConsumer<MouseEvent, Integer> function) {
		JPanel clickableArea = new JPanel();
		clickableArea.setName(name);
		clickableArea.setCursor(new Cursor(Cursor.HAND_CURSOR));
		clickableArea.setBounds(x, y, w, h);
		clickableArea.addMouseListener(new PionnerMouseAdapter(function));
		clickableArea.setOpaque(false);
		return clickableArea;
	}

	public JTextField buildTextField(String name, int x, int y, int w, int h) {
		JTextField textField = new JTextField();
		textField.setName(name);
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setCursor(new Cursor(Cursor.HAND_CURSOR));
		textField.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
		textField.setBounds(x, y, w, h);
		return textField;
	}

	private void clicksrc(MouseEvent e, int seconds) {
		print("acionou src por " + seconds);
	}

	private void clickreturn(MouseEvent e, int seconds) {
		print("acionou return por " + seconds);
	}

	private void clickb1(MouseEvent e, int seconds) {
		print("acionou b1 por " + seconds);
	}

	private void clickb2(MouseEvent e, int seconds) {
		print("acionou b2 por " + seconds);
	}

	private void clickb3(MouseEvent e, int seconds) {
		print("acionou b3 por " + seconds);
	}

	private void clickb4(MouseEvent e, int seconds) {
		print("acionou b4 por " + seconds);
	}

	private void clickb5(MouseEvent e, int seconds) {
		print("acionou b5 por " + seconds);
	}

	private void clickb6(MouseEvent e, int seconds) {
		print("acionou b6 por " + seconds);
	}

	private void clickback(MouseEvent e, int seconds) {
		print("acionou back por " + seconds);
	}

	private void clickforward(MouseEvent e, int seconds) {
		print("acionou forward por " + seconds);
	}

	private void clicksearch(MouseEvent e, int seconds) {
		print("acionou search por " + seconds);
	}

	private void clickmute(MouseEvent e, int seconds) {
		print("acionou mute por " + seconds);
	}

	private void clickdispoff(MouseEvent e, int seconds) {
		print("acionou dispoff por " + seconds);
	}

	private void clickeq(MouseEvent e, int seconds) {
		print("acionou eq por " + seconds);
	}

	private void rollMouseWheel(MouseWheelEvent e, Integer amount) {
		print("rolou por " + amount);
	}

	private void print(String text) {
		display.setText(dateFormat.format(new Date()) + " " + text);
	}
}