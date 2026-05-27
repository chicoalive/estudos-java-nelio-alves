package model.entities;

public class Student {
    // Attributes
    private String name;
    private String id;
    private Double score1;
    private Double score2;
    private Double score3;

    // Constructors
    public Student() {
    }

    public Student(String name, String id, Double score1, Double score2, Double score3) {
        this.name = name;
        this.id = id;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getScore1() {
        return score1;
    }

    public void setScore1(Double score1) {
        this.score1 = score1;
    }

    public Double getScore2() {
        return score2;
    }

    public void setScore2(Double score2) {
        this.score2 = score2;
    }

    public Double getScore3() {
        return score3;
    }

    public void setScore3(Double score3) {
        this.score3 = score3;
    }

    // Methods

    public double finalScore() {
        return (score1 + score2 + score3) / 3.0;
    }

    public String finalScoreStatus() {
        if (finalScore() >= 7) {
            return "Parabéns! Você foi aprovado!";
        } else if (finalScore() >= 5 && finalScore() < 7) {
            return "Você esta em recuperação!";
        } else {
            return "Lamentamos, mas você foi reprovado!";

        }
    }

    // Returns

    @Override
    public String toString() {
        return "Aluno: " + name + "\n"
                + "Matricula: " + id + "\n"
                + "1º Nota: " + String.format("%.2f", score1) + "\n"
                + "2º Nota: " + String.format("%.2f", score2) + "\n"
                + "3º Nota: " + String.format("%.2f", score3) + "\n";

    }
}
