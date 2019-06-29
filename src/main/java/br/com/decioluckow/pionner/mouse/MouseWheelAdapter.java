package br.com.decioluckow.pionner.mouse;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.function.BiConsumer;

public class MouseWheelAdapter implements MouseWheelListener {

	private int amount = 0;
	
	private BiConsumer<MouseWheelEvent, Integer> function;

	public MouseWheelAdapter(BiConsumer<MouseWheelEvent, Integer> function) {
		this.function = function;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			amount++;
		} else {
			amount--;
		}
		function.accept(e, amount);
	}
}