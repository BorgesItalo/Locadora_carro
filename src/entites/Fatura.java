package entites;

public class Fatura {

	private Double pagameto;
	private double taxa;

	public Fatura() {

	}

	public Fatura(Double pagameto, double taxa) {

		this.pagameto = pagameto;
		this.taxa = taxa;
	}

	public Double getPagameto() {
		return pagameto;
	}

	public void setPagameto(Double pagameto) {
		this.pagameto = pagameto;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
		this.taxa = taxa;
	}

	public double getTotalPagamento() {
		return getPagameto() + getTaxa();
	}

}
