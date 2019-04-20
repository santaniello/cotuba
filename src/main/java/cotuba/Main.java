package cotuba;

import java.nio.file.Path;
import java.util.List;

public class Main {

	public static void main(String[] args) {
        LeitorOpcoes leitorOpcoes = new LeitorOpcoes(args);
        Path diretorioDosMD = leitorOpcoes.getDiretorioDosMD();
        String formato = leitorOpcoes.getFormato();
        Path arquivoDeSaida = leitorOpcoes.getArquivoDeSaida();
        boolean modoVerboso =  leitorOpcoes.isModoVerboso();
		RenderizadorMdParaHtml renderizador = new RenderizadorMdParaHtml();
		List<Capitulo> capitulos = renderizador.renderiza(diretorioDosMD);
		Ebook ebook = new Ebook();
		ebook.setCapitulos(capitulos);
		ebook.setTitulo("Primeiro ebook pelo catuba");
		ebook.setFormato(formato);
		ebook.setArquivoDeSaida(arquivoDeSaida);

		if ("pdf".equals(formato)) {
				GeradorPDF geradorPDF = new	GeradorPDF();
				geradorPDF.gera(ebook);

			} else if ("epub".equals(formato)) {
				GeradorEPUB geradorEPUB = new GeradorEPUB();
				geradorEPUB.gera(ebook);
			} else {
				throw new RuntimeException("Formato do ebook inválido: " + formato);
			}
			System.out.println("Arquivo gerado com sucesso: " + arquivoDeSaida);
	}

}
