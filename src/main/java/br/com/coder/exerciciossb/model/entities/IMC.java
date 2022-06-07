package br.com.coder.exerciciossb.model.entities;

public class IMC {
	private double KG;
	private double height;
	private double IMC;
	
	public IMC(double KG, double height) {
		this.KG = KG;
		this.height = height;
		this.IMC = KG / (height * height);
	}
	
	public String category() {
		if (IMC < 18.5) {
			return "underweight";
		}
		if (IMC < 25 && IMC > 18.5) {
			return "normal";
		}
		if (IMC > 25 && IMC < 29.9) {
			return "overweight";
		}
		if (IMC > 30) {
			return "obesity";
		}
		else {
			return "severe obesity";
		}
		
		
	}
	public void IMCcalc() {
		this.IMC = KG / (height * height);
	}

	public double getKG() {
		return KG;
	}

	public void setKG(double kG) {
		KG = kG;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "KG = " + KG + ", height = " + height + ", IMC: " + String.format("%.2f", IMC)  + " and your category is: " + this.category();
	}
	
}
