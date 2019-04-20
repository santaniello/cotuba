package cotuba.cli;

import cotuba.application.Cotuba;
import cotuba.cli.LeitorOpcoes;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
        LeitorOpcoes leitorOpcoes = new LeitorOpcoes(args);

		Path diretorioDosMD = leitorOpcoes.getDiretorioDosMD();
		String formato = leitorOpcoes.getFormato();
		Path arquivoDeSaida = leitorOpcoes.getArquivoDeSaida();
		boolean modoVerboso = leitorOpcoes.isModoVerboso();
		try{
			Cotuba cotuba = new Cotuba();
			cotuba.executa(formato, diretorioDosMD, arquivoDeSaida);
			System.out.println("Arquivo gerado com sucesso: "	+ arquivoDeSaida);
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			if(modoVerboso) {
				ex.printStackTrace();
			}
			System.exit(1);
		}
	}
}
