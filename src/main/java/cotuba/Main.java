package cotuba;

import java.nio.file.Path;

public class Main {

	public static void main(String[] args) {
        LeitorOpcoes leitorOpcoes = new LeitorOpcoes(args);

        Path diretorioDosMD = leitorOpcoes.getDiretorioDosMD();
        String formato = leitorOpcoes.getFormato();
        Path arquivoDeSaida = leitorOpcoes.getArquivoDeSaida();
        boolean modoVerboso =  leitorOpcoes.isModoVerboso();

			if ("pdf".equals(formato)) {
				GeradorPDF geradorPDF = new	GeradorPDF();
				geradorPDF.gera(diretorioDosMD, arquivoDeSaida);

			} else if ("epub".equals(formato)) {
				GeradorEPUB geradorEPUB = new GeradorEPUB();
				geradorEPUB.gera(diretorioDosMD, arquivoDeSaida);
			} else {
				throw new RuntimeException("Formato do ebook inválido: " + formato);
			}

			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);


	}

}
