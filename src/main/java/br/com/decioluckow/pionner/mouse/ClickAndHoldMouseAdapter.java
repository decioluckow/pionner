package br.com.decioluckow.pionner.mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickAndHoldMouseAdapter extends MouseAdapter {

	private MouseAction clickAction;
	private MouseAction holdAction;
	private Thread thread;
	private PressTimeRunnable runnable;

	public ClickAndHoldMouseAdapter(MouseAction clickAction, MouseAction holdAction) {
		this.clickAction = clickAction;
		this.holdAction = holdAction;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		runnable = new PressTimeRunnable(holdAction);
		thread = new Thread(runnable);
		thread.start();
	}

	@Override
	public final void mouseReleased(MouseEvent e) {
		runnable.release();
		if (!runnable.isExecuted()) {
			clickAction.execute();
		}
	}

	class PressTimeRunnable implements Runnable {

		private static final long ONE_SECOND_IN_MILLIS = 1000l;

		private MouseAction holdAction;
		private boolean executed = false;
		private boolean released = false;

		public PressTimeRunnable(MouseAction holdAction) {
			this.holdAction = holdAction;
		}

		public void release() {
			released = true;
		}
		
		public boolean isExecuted() {
			return executed;
		}

		@Override
		public void run() {
			sleep(ONE_SECOND_IN_MILLIS);
			if (holdAction != null && !released) {
				holdAction.execute();
				executed = true;
			}
		}

		private void sleep(long time) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
