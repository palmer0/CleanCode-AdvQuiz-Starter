package es.ulpgc.eite.da.quiz.app;

import android.app.Application;

import es.ulpgc.eite.da.quiz.question.QuestionState;

public class AppMediator extends Application {

  private QuestionState questionState= new QuestionState();

  /*
  private QuestionState questionState;

  @Override
  public void onCreate() {
    super.onCreate();

    questionState = new QuestionState();
  }
  */

  public QuestionState getQuestionState() {
    return questionState;
  }
}
