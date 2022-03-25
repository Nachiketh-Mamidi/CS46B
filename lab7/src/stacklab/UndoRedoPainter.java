package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	// Called when the user pushes the Undo button.
	void undo()
	{
		
		getHistory().isEmpty();
		Circle c = getHistory().peek();
		getHistory().pop();
		repaint();
		getUndoHistory().push(c);
	
		try {
			getHistory().peek();
		} catch (EmptyStackException x) {
			setUndoButtonEnabled(false);
		}
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		getUndoHistory().isEmpty();
		Circle c = getUndoHistory().lastElement();
		getUndoHistory().pop();
		repaint();
		getHistory().push(c);
		
		try {
			getUndoHistory().peek();
		} catch (EmptyStackException x) {
			setRedoButtonEnabled(false);
		}
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
