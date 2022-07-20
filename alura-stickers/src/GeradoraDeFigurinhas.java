import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.InputStream;

import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura img
        // InputStream input = new FileInputStream((new File("img/anya.jpg")));
      //  inputStream = new URL(inputStream).openStream();
        BufferedImage imgOriginal = ImageIO.read(inputStream);
        // criar nova img com transparencia e redimensionada
        int largura = imgOriginal.getWidth();
        int altura = imgOriginal.getHeight();
        int centroImg = imgOriginal.getWidth() / 3;
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT); // usado para
                                                                                                      // criar nova
                                                                                                      // Imagem

        // copiar a img original p/ nova img {memória}

        Graphics graphics = (Graphics) novaImagem.getGraphics();
        graphics.drawImage(imgOriginal, 0, 0, null);

        // configurar font
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);
        // escrever frase

        graphics.drawString("Olar", centroImg, novaAltura - 100);

        // salvar como arquivo
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}
