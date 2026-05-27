package application;

import model.entities.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner keyboard = new Scanner(System.in);
        Scanner fileReader = null;
        // Coletar informações para criar pasta e arquivo
        System.out.print("Onde deseja criar a pasta e o arquivo: ");
        String path = keyboard.nextLine().trim();
        // Pasta
        System.out.print("Nome da pasta para armazenar os dados do estudante: ");
        String folderName = keyboard.nextLine().trim();
        // Arquivo
        System.out.println("Nome da arquivo para armazenar os dados do estudante: ");
        String fileName = keyboard.nextLine().trim() + ".csv";

        // Criação do pasta
        File folderIn = new File(path + File.separator + folderName);
        System.out.println("Status da pasta: " + formatFolderCreationStatus(folderIn));

        // Criação do caminho do arquivo
        String filePath = path + File.separator + folderName + File.separator + fileName;
        File fileIn = new File(filePath);

        if (!fileIn.exists()) {
            // Coleta os dados do estudante
            System.out.println("Dados do estudante: ");
            System.out.print("Nome: ");
            String name = keyboard.nextLine().trim();
            System.out.print("ID: ");
            String id = keyboard.nextLine().trim();
            System.out.println("Digite as nota do aluno: ");
            System.out.print("Nota 1: ");
            Double score1 = Double.parseDouble(keyboard.nextLine().trim());
            System.out.print("Nota 2: ");
            Double score2 = Double.parseDouble(keyboard.nextLine().trim());
            System.out.print("Nota 3: ");
            Double score3 = Double.parseDouble(keyboard.nextLine().trim());
            Student student = new Student(name, id, score1, score2, score3);
            System.out.println();
            System.out.println(student);

            // Usa a nova função para criar o arquivo e exibir o status
            System.out.println("Status do arquivo: " + formatFileCreationStatus(fileIn, filePath, student));
            // Criando dados de saída.
            File folderOut = new File(path + File.separator + "Saída");
            System.out.println("Status da pasta: " + formatFolderCreationStatus(folderOut));

            // Criando arquivo de saída.
            String filePathOut = folderOut + File.separator + "Boletim.csv";
            File fileOut = new File(filePathOut);
            System.out.println("Status do arquivo: " + formatFileCreationStatus(fileOut, filePathOut, student));

            keyboard.close();
        } else {
            System.out.println("Arquivos de entrada já existem.");
            System.out.println("Criando arquivos de saída");

            // Criando pasta saída
            File folderOut = new File(path + File.separator + "Saída");
            System.out.println("Status da pasta: " + formatFolderCreationStatus(folderOut));

            // Criando arquivo boletim atualizado
            File reportCardFile = new File(path + File.separator + "Saída" + File.separator + "Boletim.csv");

            try {
                fileReader = new Scanner(fileIn);
                String[] lineName = fileReader.nextLine().split(":");
                String[] lineId = fileReader.nextLine().split(":");
                String[] lineScore1 = fileReader.nextLine().split(":");
                String[] lineScore2 = fileReader.nextLine().split(":");
                String[] lineScore3 = fileReader.nextLine().split(":");

                Student student = new Student(lineName[1].trim(), lineId[1].trim(), Double.parseDouble(lineScore1[1].trim()), Double.parseDouble(lineScore2[1].trim()), Double.parseDouble(lineScore3[1].trim()));
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportCardFile))) {
                    bw.write(student.toString());
                    bw.write(student.finalScoreStatus());
                    bw.newLine();
                } catch (Exception e) {
                    System.out.println("Erro ao criar o arquivo de saída.");
                }

            } catch (Exception e) {

            }

        }
    }

    public static int checkOrCreateFile(File file, String filePath, Student student) {
        if (!file.isFile()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
                bw.write(student.toString());
                bw.newLine();
                return 1; // Sucesso
            } catch (IOException e) {
                return 2; // Erro
            }
        } else {
            return 3; // Já existe
        }
    }

    public static String formatFileCreationStatus(File file, String filePath, Student student) {
        int status = checkOrCreateFile(file, filePath, student);
        if (status == 1) {
            return "Arquivo criado com sucesso!";
        } else if (status == 2) {
            return "Erro ao criar o arquivo.";
        } else {
            return "Arquivo já existe.";
        }
    }


    public static int checkOrCreateFolder(File folder) {
        if (!folder.exists()) {
            boolean result = folder.mkdir();
            if (result) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

    public static String formatFolderCreationStatus(File folder) {
        int status = checkOrCreateFolder(folder);
        if (status == 1) {
            return "Pasta criada com sucesso!";
        } else if (status == 2) {
            return "Pasta não foi criada.";
        } else {
            return "Pasta já existe.";
        }
    }

}
