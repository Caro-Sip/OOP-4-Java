package lab02;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex3_HealthQuestions {
    public static void main(String[] args){
        HealthScreening screening = new HealthScreening();
        screening.conductScreening();
        screening.displayResults();
    }
}

class HealthScreening{
    List<HealthQnA> questions;
    
    public HealthScreening() {
        questions = new ArrayList<>();
        initializeQuestions();
    }
    
    private void initializeQuestions() {
        questions.add(new HealthQnA(1, "Feeling feverish and/or having chills?", ""));
        questions.add(new HealthQnA(2, "Has there been any use of fever reducing medication within the last 24 hours not due to another health condition?", ""));
        questions.add(new HealthQnA(3, "A new cough that is not due to another health condition?", ""));
        questions.add(new HealthQnA(4, "New chills that are not due to another health condition?", ""));
        questions.add(new HealthQnA(5, "A new sore throat that is not due to another health condition?", ""));
        questions.add(new HealthQnA(6, "A new loss of taste or smell?", ""));
        questions.add(new HealthQnA(7, "Have you had a positive test for the virus that causes COVID-19 disease within the past 10 days?", ""));
        questions.add(new HealthQnA(8, "In the past 14 days, have you had close contact (within about 6 feet for 15 minutes or more) with someone with suspected or confirmed COVID-19?", ""));
    }
    
    public void conductScreening() {
        System.out.println("==== Covid-19 Screen Health ===");
        Scanner scanner = new Scanner(System.in);
        
        for (HealthQnA qa : questions) {
            System.out.print("Q" + qa.getId() + ". " + qa.getQuestion() + " ");
            String answer = scanner.nextLine().trim();
            qa.setAnswer(answer);
        }
        scanner.close();
    }
    
    public void displayResults() {
        System.out.println("===================");
        System.out.println("|Questions|Answers |");
        System.out.println("===================");
        
        for (HealthQnA qa : questions) {
            String qId = String.format("%-9s", "Q" + qa.getId());
            String answer = String.format("%-7s", qa.getAnswer());
            System.out.println("|" + qId + "|" + answer + "|");
            System.out.println("-------------------");
        }
    }
}

class HealthQnA {
    private int id;
    private String question;
    private String answer;
    
    public HealthQnA(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}