import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Programa {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Set<Integer> cursoA = new HashSet<>(); // Não importa a ordem, por isso usamos o mais rápido
        Set<Integer> cursoB = new HashSet<>();
        Set<Integer> cursoC = new HashSet<>();

        System.out.print("Quantos alunos serão adicionados ao curso A: ");
        int qtdCursoA = Integer.parseInt(teclado.nextLine().trim());
        for (int i = 0; i < qtdCursoA; i++) {
            System.out.print("número da matricula do " + (i + 1) + "ª aluno: ");
            cursoA.add(Integer.parseInt(teclado.nextLine().trim()));
        }
        System.out.println();
        System.out.print("Quantos alunos serão adicionados ao curso B: ");
        int qtdCursoB = Integer.parseInt(teclado.nextLine().trim());
        for (int i = 0; i < qtdCursoB; i++) {
            System.out.print("número da matricula do " + (i + 1) + "ª aluno: ");
            // Observar quem adiciono na hora de copiar, tinha copiado tudo como cursoA
            cursoB.add(Integer.parseInt(teclado.nextLine().trim()));
        }
        System.out.println();
        System.out.print("Quantos alunos serão adicionados ao curso C: ");
        int qtdCursoC = Integer.parseInt(teclado.nextLine().trim());
        for (int i = 0; i < qtdCursoC; i++) {
            System.out.print("número da matricula do " + (i + 1) + "ª aluno: ");
            cursoB.add(Integer.parseInt(teclado.nextLine().trim()));
        }
        System.out.println();
        Set<Integer> totalEstudantes = new HashSet<>();
        totalEstudantes.addAll(cursoA);
        totalEstudantes.addAll(cursoB);
        totalEstudantes.addAll(cursoC);
        System.out.println("Total de estudantes: " + totalEstudantes.size());


        teclado.close();
    }

    
}
