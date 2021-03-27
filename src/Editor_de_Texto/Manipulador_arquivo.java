package Editor_de_Texto;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Manipulador_arquivo {
    private JFileChooser fileChooser;
    private String caminho_arquivo = "";

    public void salva_arquivo(String texto, Path caminho) throws IOException {
        //Path caminho = Paths.get(file.getPath());
        Files.write(caminho, texto.getBytes());
    }
}
