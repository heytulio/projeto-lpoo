package model.entities;

import java.util.Objects;

import model.entities.enums.TipoDePlano;

public class Plano {
	Double price;
	private TipoDePlano plano;

	public Plano(TipoDePlano plano) {
		this.plano = plano;
		TipoDePlano basico=TipoDePlano.valueOf("BASICO") ;
		TipoDePlano essencial=TipoDePlano.valueOf("ESSENCIAL") ;
		TipoDePlano premium=TipoDePlano.valueOf("PREMIUM") ;
		
		if (plano.equals(basico)) {
			price = 100.0;
		}else if (plano.equals(essencial)) {
			price = 200.0;
		}else if (plano.equals(premium)) {
			price = 300.0;
		}
	}

	@Override
	public String toString() {
		return "" + plano;
	}

	@Override
	public int hashCode() {
		return Objects.hash(plano);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plano other = (Plano) obj;
		return plano == other.plano;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public TipoDePlano getPlano() {
		return plano;
	}

	public void setPlano(TipoDePlano plano) {
		this.plano = plano;
	}

}
