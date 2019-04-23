import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.BiConsumer;

public class PionnerMouseAdapter extends MouseAdapter {
	
	private BiConsumer<MouseEvent, Integer> consumer;
	private long startPressed = 0;

	public PionnerMouseAdapter(final BiConsumer<MouseEvent, Integer> consumer) {
		this.consumer = consumer;
	}
	
	public final void mousePressed(MouseEvent e) {
		startPressed = System.currentTimeMillis();
	}

	@Override
	public final void mouseReleased(MouseEvent e) {
		int seconds = (int) ((System.currentTimeMillis() - startPressed) / 1000);
		click(e, seconds);
	}

	protected void click(MouseEvent e, int seconds) {
		consumer.accept(e, seconds);
	}
}
