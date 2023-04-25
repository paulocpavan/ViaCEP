import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner leitura = new Scanner(System.in);
        String cep = "";
        List<Endereco> consultaCEPList = new ArrayList<>();

        GeradorDeArquivo gerador = new GeradorDeArquivo();

        while (!cep.equalsIgnoreCase("sair")) {

            ConsultaCEP consultaCEP = new ConsultaCEP();
            System.out.println("Digite um número de CEP para consulta: ");

            cep = leitura.nextLine();

            if(cep.equalsIgnoreCase("sair")){
            break;
            }
            try {
                Endereco novoEndereco = consultaCEP.buscaEndereco(cep);
                System.out.println(novoEndereco);
                consultaCEPList.add(novoEndereco);

                gerador.salvaJson(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicação");
            }
        }
        gerador.close();
    }
}