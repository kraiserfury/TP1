package augustco.tp1project;

import java.util.Arrays;
import java.util.Scanner;
        
public class TP1 {

	private static String[] nomes;
	private static float[] nota1;
	private static float[] nota2;
	
	private static final int QTDE = 3;
	private static final Integer[] OPCOES = {1,2,3,4};	
	
       private static float calcMedia(int id){
		return (nota1[id] + nota2[id])/2;
	}

	private static String obterSituacao(float ms){
				if(ms > 7) {
				return "Aprovado";
			}else if (ms < 4) {
				return "Reprovado"; 
			} else {
                                return "Prova Final";
                                }         
        }
                
	private static void imprimir(int id) {
            
            float mediaSimples = calcMedia(id);
            
            String situacao = obterSituacao(mediaSimples);
            
		System.out.printf("{%d} %s - %.2f - %.2f :: Media = %.2f (%s)\n", 
				id, nomes[id], nota1[id], nota2[id], mediaSimples, situacao);
	}
	
	private static void imprimir() {
		for (int i = 0; i < QTDE; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}
        
	public static void main(String[] args) {
		nomes = new String[QTDE];
		nota1 = new float[QTDE];
		nota2 = new float[QTDE];
	
            try (Scanner in = new Scanner(System.in)) {
                int i = 0;
                int opcao;
                do {
                    System.out.println("[1] Registrar nota dos aluno");
                    System.out.println("[2] Consultar boletim de um aluno");
                    System.out.println("[3] Consultar notas da turma.");
                    System.out.println("[4] Sair.");
                    System.out.print("Informe a opção desejada: ");
                    
                    opcao = in.nextInt();
                    
                    if(Arrays.asList(OPCOES).contains(opcao)) {
                        
                        switch (opcao) {
                            case 1: {
                                if(i < QTDE) {
                                    System.out.println("Informe o nome do aluno:");
                                    nomes[i] = in.next();
                                    
                                    System.out.println("Informe a nota1:");
                                    nota1[i] = in.nextInt();
                                    
                                    System.out.println("Informe a nota2:");
                                    nota2[i] = in.nextFloat();
                                    
                                    System.out.println("... Inclusão realizada ...");
                                    imprimir(i);
                                    System.out.println("...... com sucesso! ......");
                                    
                                    i++;
                                }else {
                                    System.out.println("Impossivel cadastrar um novo funcionario!!!");
                                }
                            }
                            
                            case 2: {
                                System.out.print("Consultar boletim de um aluno: ");
                                int id = in.nextInt();
                                
                                if(id >= 0 && id < i) {
                                    System.out.println("... Aluno ...");
                                    imprimir(id);
                                    System.out.println("...................");
                                }else {
                                    System.out.println("Identificação inválida!!!");
                                }
                            }
                            
                            case 3: {
                                System.out.println("... Consultar notas da turma ...");
                                imprimir();
                                System.out.println(".............................");
                            }
                        }
                    }else {
                        System.out.println("Opção inválida!!!");
                    }
                } while (opcao != 4);
                
                System.out.println("Sistema finalizado com sucesso!!!");
            }
	}
}