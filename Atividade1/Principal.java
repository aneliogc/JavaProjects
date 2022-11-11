package padrao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] palavras = new String[] {"Farewell", "Society", "Milhe", "Partner", "Sniff", "Fairy", "Dry", "kidney", "Knowledge", "Fence", "Poor", "Winter", "Edge", "Forecast", "Leaf"};
        String[] traducoes = new String[] {"Adeus", "Sociedade", "Milha", "Parceiro", "Farejar", "Fada", "Seco", "Rim", "Conhecimento", "Cerca", "Pobre", "Inverno", "Borda", "Previsao", "Folha"};

        List<Palavra> list = new ArrayList<>();
         
        Random gerador = new Random();
    
        for(int i=0; i<palavras.length; i++){
            list.add(new Palavra(palavras[i], traducoes[i]));
        }

        List<Palavra> copiaList = new ArrayList<>(list);

        int acertos = 0;
        int i = gerador.nextInt(copiaList.size());
        List<Palavra> respostasIncorretas =  new ArrayList<>();
        System.out.println("-----------------------------");
        while(copiaList.size() != 0){
            System.out.println("Palavra: " + copiaList.get(i).getNome());
            System.out.print("Digite a traducao: ");
            String resposta = sc.nextLine();

            if(resposta.toLowerCase().equals(copiaList.get(i).getTraducao().toLowerCase())){
                System.out.println("Correto!");
                acertos++;
            }
            else{
                System.out.println("Resposta incorreta!");
                respostasIncorretas.add(copiaList.get(i));
            }
            System.out.println("-----------------------------");

            copiaList.remove(i);

            if(copiaList.size() != 0){
                i = gerador.nextInt(copiaList.size());
            }
            
        }
        
        imprimirResultado(acertos, list.size());

        sc.close();
    }

    public static void imprimirResultado(int acertos, int numeroPerguntas){
        double porcentagemDeAcerto = (acertos * 100.0) / numeroPerguntas;
        System.out.println();
        System.out.println("*****************************************");
        System.out.print("*");
        System.out.printf("%40s", "*");
        System.out.println();
        System.out.printf("%-40s", "*     VOCE ACERTOU " + acertos + " DE " + numeroPerguntas + " PALAVRAS!");
        System.out.printf("%-40s", "*");
        System.out.println();
        System.out.printf("%-40s", "*     PORCENTAGEM DE ACERTO: " + String.format("%.0f", porcentagemDeAcerto) + "%");
        System.out.printf("%-40s", "*");
        System.out.println();
        System.out.print("*");
        System.out.printf("%40s", "*");
        System.out.println();
        System.out.println("*****************************************");
    }
}
