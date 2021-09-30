package model.services;

import entites.AluguelDeCarro;
import entites.Fatura;

import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class ServicoAluguel {
	private Double precoDia;
	private Double precohora;
	
	private TaxaBrasil taxaBrasil;

	public ServicoAluguel(Double precoDia, Double precohora, TaxaBrasil taxaBrasil) {
		super();
		this.precoDia = precoDia;
		this.precohora = precohora;
		this.taxaBrasil = taxaBrasil;
	}
	
	
	public void processoFatura(AluguelDeCarro alugueldecarro) {
		long t1 = alugueldecarro.getRetirada().getTime();
		long t2 = alugueldecarro.getDevolucao().getTime();
		
		double horas = (double )(t2 - t1) / 1000 / 60 / 60;
		double pagamentoBasico;
		if (horas <= 12.0) {
			pagamentoBasico = Math.ceil(horas) * precohora;
			
			
		}else {
			pagamentoBasico = Math.ceil(horas / 24) * precoDia;
		}
	
		double taxa = taxaBrasil.taxa(pagamentoBasico);
		alugueldecarro.setFatura(new Fatura(pagamentoBasico, taxa)) ;
		
		
	}
	
}
