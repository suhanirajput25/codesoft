package tasks;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] questions = {
                "How many countries in the world?\nA: 195\nB: 200\nC: 165\nD: 175 ",
                "How many continents in the world?\nA: 5\nB: 7\nC: 6\nD: 15 ",
                "What is the capital of France?\nA: London\nB: Berlin\nC: Paris\nD: Madrid ",
                "Who wrote 'Romeo and Juliet'?\nA: Charles Dickens\nB: William Shakespeare\nC: Jane Austen\nD: Mark Twain ",
                "What is the largest mammal on Earth?\nA: Elephant\nB: Giraffe\nC: Blue Whale\nD: Polar Bear ",
                "In which year did Christopher Columbus reach the Americas?\nA: 1492\nB: 1607\nC: 1776\nD: 1812 ",
                "What is the capital of Japan?\nA: Seoul\nB: Tokyo\nC: Beijing\nD: Bangkok ",
                "Which planet is known as the 'Red Planet'?\nA: Mars\nB: Venus\nC: Jupiter\nD: Saturn ",
                "Who is the author of 'To Kill a Mockingbird'?\nA: J.K. Rowling\nB: Harper Lee\nC: George Orwell\nD: Ernest Hemingway ",
                "What is the chemical symbol for gold?\nA: Au\nB: Ag\nC: Fe\nD: Cu "
        };

        String[] answer = {
                "195", "7", "Paris", "William Shakespeare", "Blue Whale", "1492", "Tokyo", "Mars", "Harper Lee", "Au"
        };
        
        int score = 0;
        String[] userAnswer = new String[questions.length];
        boolean timeUp = false;
        System.out.println("write complete answer");
        System.out.println("you have 1 min for each question");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question number : " + (i + 1));
            System.out.println(questions[i]);

            Timer questionTimer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    questionTimer.cancel();
                }
            };
            questionTimer.schedule(task, 60000);
           
            try {
                userAnswer[i] = sc.nextLine();

                // Compare user's answer with the correct answer
                if (userAnswer[i].equalsIgnoreCase(answer[i])) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong. The correct answer is: " + answer[i]);
                }
            } catch (Exception e) {
                System.out.println("Exception occurred: " + e.getMessage());
            } finally {
                questionTimer.cancel(); // Cancel the timer since the user has answered the question
            }
        }

        System.out.println("Your total score is " + score + " out of 10");
        System.out.println("Here are your answers:");

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println("Your answer: " + userAnswer[i]);
        }
    }
}