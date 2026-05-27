package application;

import entities.RegularStudent;
import entities.Student;
import entities.VipStudent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        List<Student> studentslist = new ArrayList<>();

        // DateTimeFormatter (da nova API java.time, Java 8+) substitui o antigo SimpleDateFormat (java.util).
        // Ele é imutável e thread-safe, sendo a abordagem mais atual e recomendada para formatar datas.
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("== Academia de muscologia! ==");
        System.out.println();

        System.out.print("Quantos alunos deseja registrar: ");
        int quantity = Integer.parseInt(scanner.nextLine().trim());
        System.out.println();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Dados do " + (i + 1) + "º Aluno:");
            System.out.print("Tipo de conta (regular/vip): ");
            String type = scanner.nextLine().trim();
            // Validando a resposta
            while (!type.equalsIgnoreCase("regular") && !type.equalsIgnoreCase("vip")) {
                System.out.print("Resposta inválida! Digite 'regular ou 'vip': ");
                type = scanner.nextLine().trim();
                System.out.println();
            }
            System.out.print("Nome: ");
            String name = scanner.nextLine().trim();

            System.out.print("Data de nascimento (DD/MM/YYYY): ");
            String dateString = scanner.nextLine().trim();
            
            // A conversão de String para Data agora é feita diretamente na classe LocalDate usando parse().
            // Diferente do SimpleDateFormat que exigia chamar sdf.parse() e poderia lançar um ParseException,
            // o LocalDate.parse lança um DateTimeParseException (exceção não-checada), por isso não precisamos mais do 'throws' na assinatura do método main.
            LocalDate dateOfBirth = LocalDate.parse(dateString, fmt);

            // Como são os mesmo dados para os tipos de Studante, não faz sentido repetir.
            System.out.print("Mensalidade base: ");
            String feeString = scanner.nextLine().trim();
            double monthlyFee = Double.parseDouble(feeString);
            System.out.print("Tempo de academia (em meses): ");
            String timeString = scanner.nextLine().trim();
            int months = Integer.parseInt(timeString);

            if (type.equalsIgnoreCase("regular")) {
                // Cadastro de Aluno Regular
                RegularStudent regularStudent = new RegularStudent(name, dateOfBirth, monthlyFee, months);
                studentslist.add(regularStudent);

            } else if (type.equalsIgnoreCase("vip")) {
                // Cadastro de Aluno VIP
                VipStudent vipStudent = new VipStudent(name, dateOfBirth, monthlyFee, months);
                studentslist.add(vipStudent);
            }
            System.out.println(); // Pular linha entre os cadastros de alunos para ficar mais organizado
        }

        System.out.println();
        for (Student student : studentslist) {
            System.out.println(student);
            System.out.println();
        }
        scanner.close();
    }
}
