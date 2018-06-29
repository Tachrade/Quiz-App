package habeebsalami.sms2profit.com.habeebsalami;


public class Question {

    // array of questions for the quiz app
    private String textQuestions[] = {
            "1. Which type of computer system is used for whether forecasting ?",
            "2. Select the output device from the following list:",
            "3. Which key will you use to print $ on the screen ?",
            "4. What year did Google acquire Android ?",
            "5. Which of the following is a not a valid file name ?",
            "6. Which of the following is a not a type of media storage ?",
            "7. What is the informal corporate motto for Google ?",
            "8. Which of the following is a programming language?",
            "9. What is XML ?",
            "10. The name Google originated from a misspelling of:"
    };
    // array of multiple choice for each questions in the app
    private String multipleChoice[][] = {
            {"Minicomputer", "Supercomputer", "Personal computer", "Mainframe computer"},
            {"Mouse", "Scanner", "Microphone", "Speaker"},
            {"Ctrl + $", "Alt + $", "Shift + $", "Caps Lock + $"},
            {"2006", "2005", "2000", "2004"},
            {"MyNotes_1", "MyNotes1", "My-Notes", "My:Notes"},
            {"Graphic Storage", "Text Sorage", "Data Storage", "Time Storage"},
            {"Always First", "Never Give Up", "Don't Be Evil", "Always Focus"},
            {"BreakUp", "Java", "BackRub", "Activity"},
            {"Extensive Mark Language", "Expensive Markup Language", "Extensible Markup Language", "Xamarin Markup Law"},
            {"Googleol", "Googoal", "Googuol", "Googol"}
    };

    //array of correct questions
    private String mCorrectAnswers[] = {
            "Supercomputer", "Speaker", "Shift + $", "2005", "My:Notes", "Time Storage", "Don't Be Evil", "Java",
            "Extensible Markup Language", "Googol"
    };

    //method returns number of questions
    public int getLength() {
        return textQuestions.length;
    }

    //Method returns question from array text questions based on array index
    public String getQuestion(int a) {
        String question = textQuestions[a];
        return question;
    }

    //method returns a single multiple choice item for questio based on array index,
    //based on number of multiple choice item n the list - 1,2,3,4 an argument

    public String getChoice(int index, int num) {
        String choice0 = multipleChoice[index][num - 1];
        return choice0;
    }

    //method returns correct answer for the questions based on array index
    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}

