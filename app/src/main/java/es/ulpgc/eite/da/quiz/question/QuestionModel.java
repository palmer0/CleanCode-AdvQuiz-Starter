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

    QuestionState state = new QuestionState();
    state.question=quizArray[quizIndex];
    state.option1=quizArray[quizIndex+1];
    state.option2=quizArray[quizIndex+2];
    state.option3=quizArray[quizIndex+3];
    state.quizIndex = quizIndex;

    return state;
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
