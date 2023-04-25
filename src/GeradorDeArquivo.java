import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeradorDeArquivo {
    private FileWriter escrita;

    public GeradorDeArquivo() throws IOException {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH.mm.ss");
        String formattedDate = myDateObj.format(myFormatObj);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escrita = new FileWriter(formattedDate + ".json");
        escrita.write("\n");
    }
    public void adicionaCEP(String cep) throws  IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escrita.write(gson.toJson(cep));
        escrita.write("\n");
    }
    public void salvaJson(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escrita.write(gson.toJson(endereco));
        escrita.write("\n");
    }

    public void salvaErro(String mensagem) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        escrita.write(mensagem);
        escrita.write("\n");
    }
    public void close() throws IOException {
        escrita.close();
    }

}
