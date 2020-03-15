package es.ulpgc.eite.da.quiz.question;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = QuestionModel.class.getSimpleName();

  private final String[] quizArray;
  private int quizIndex;

  public QuestionModel(String[] quizArray) {
    this.quizArray=quizArray;
  }


  @Override
  public QuestionState getQuestionData() {
    // Log.e(TAG, "getQuestionData()");

    QuestionState data = new QuestionState();
    data.question=quizArray[quizIndex];
    data.option1=quizArray[quizIndex+1];
    data.option2=quizArray[quizIndex+2];
    data.option3=quizArray[quizIndex+3];
    data.quizIndex = quizIndex;

    return data;
  }

  @Override
  public boolean isCorrectOption(int option) {
    int answer = Integer.valueOf(quizArray[quizIndex+4]);

    if(answer == option) {
      return true;
    }

    return false;
  }
}
