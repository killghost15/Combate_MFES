package gui;

import javax.swing.JButton;

import combate.generated.Cell;

public class MyButton extends JButton {
	private Cell cell;
	
	public MyButton(){}

	public Cell getCell() {
		return cell;
	}

	public void setCell(Cell cell) {
		this.cell = cell;
	}


	
}
