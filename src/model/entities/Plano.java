package model.entities;

import java.util.Objects;

import model.entities.enums.TipoDePlano;

public class Plano {
	Double price;
	private TipoDePlano plano;
	private Integer countT;

	public Plano(TipoDePlano plano) {
		this.plano = plano;
		TipoDePlano basico = TipoDePlano.valueOf("BASICO");
		TipoDePlano essencial = TipoDePlano.valueOf("ESSENCIAL");
		TipoDePlano premium = TipoDePlano.valueOf("PREMIUM");

		if (plano.equals(basico)) {
			price = 100.0;
			countT = 1;
		} else if (plano.equals(essencial)) {
			price = 200.0;
			countT = 3;
		} else if (plano.equals(premium)) {
			price = 300.0;
			countT = 999;
		}
	}

	public Integer getCountT() {
		return countT;
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

	public void setCountT(Integer countT) {
		this.countT = countT;
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
		TipoDePlano basico = TipoDePlano.valueOf("BASICO");
		TipoDePlano essencial = TipoDePlano.valueOf("ESSENCIAL");
		TipoDePlano premium = TipoDePlano.valueOf("PREMIUM");

		if (plano.equals(basico)) {
			price = 100.0;
			countT = 1;
		} else if (plano.equals(essencial)) {
			price = 200.0;
			countT = 3;
		} else if (plano.equals(premium)) {
			price = 300.0;
			countT = 999;
		}
	}

}
