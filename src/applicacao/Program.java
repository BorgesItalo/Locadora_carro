package applicacao;

import java.lang.invoke.StringConcatFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.AluguelDeCarro;
import entites.Veiculo;
import model.services.ServicoAluguel;
import model.services.TaxaBrasil;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("locadora");
		System.out.print("Marca do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Data retirada veiculo: (dd/MM/yyyy HH:mm)");
		Date retirada = sdf.parse(sc.nextLine());
		System.out.print("Data devolucao veiculo: (dd/MM/yyyy HH:mm)");
		Date devolucao = sdf.parse(sc.nextLine());

		AluguelDeCarro adc = new AluguelDeCarro(retirada, devolucao, new Veiculo(modelo));

		System.out.print("Digite o proço por hora: ");
		double precoHora = sc.nextDouble();
		System.out.print("Digite o proço por dia: ");
		double precoDia = sc.nextDouble();

		ServicoAluguel sa = new ServicoAluguel(precoDia, precoHora, new TaxaBrasil());

		sa.processoFatura(adc);

		System.out.println("FATURA");
		System.out.println("Tempo de aluguel: " + adc.duracaoDias() + " dias");
		System.out.println("Pagamento basico: " + String.format("%.2f", adc.getFatura().getPagameto()));
		System.out.println("Taxa: " + String.format("%.2f", adc.getFatura().getTaxa()));
		System.out.println("Pagamento Total: " + String.format("%.2f", adc.getFatura().getTotalPagamento()));

	}

}
