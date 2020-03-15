package es.ulpgc.eite.da.quiz.question;

public class QuestionModel implements QuestionContract.Model {

  public static String TAG = QuestionModel.class.getSimpleName();

  private final String[] quizArray;
  //private final String emptyReply, correctReply, incorrectReply;
  private int quizIndex;

  public QuestionModel(String[] quizArray) {
    this.quizArray=quizArray;
  }

  /*
  public QuestionModel(
      String[] quiz, String empty, String correct, String incorrect ) {

    quizArray=quiz;
    emptyReply= empty;
    correctReply = correct;
    incorrectReply = incorrect;
  }
  */

  @Override
  public QuestionState getQuestionData() {
    // Log.e(TAG, "getQuestionData()");

    QuestionState state = new QuestionState();
    state.question=quizArray[quizIndex];
    //quizIndex++;
    state.option1=quizArray[quizIndex+1];
    //quizIndex++;
    state.option2=quizArray[quizIndex+2];
    //quizIndex++;
    state.option3=quizArray[quizIndex+3];
    //quizIndex++;
    //state.answer =quizArray[quizIndex+4];
    //quizIndex++;
    state.quizIndex = quizIndex;
    //state.reply=emptyReply;

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
