package cotuba;

import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.domain.Resource;
import nl.siegmann.epublib.epub.EpubWriter;
import nl.siegmann.epublib.service.MediatypeService;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.Heading;
import org.commonmark.node.Node;
import org.commonmark.node.Text;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.stream.Stream;

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
