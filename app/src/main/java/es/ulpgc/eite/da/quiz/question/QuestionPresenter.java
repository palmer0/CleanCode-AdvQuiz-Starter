package es.ulpgc.eite.da.quiz.question;

import android.util.Log;

import java.lang.ref.WeakReference;

public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private WeakReference<QuestionContract.View> view;
  private QuestionState state;
  private QuestionContract.Model model;
  private QuestionContract.Router router;

  public QuestionPresenter(QuestionState state) {
    this.state = state;
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // call the model
    state.question = model.getQuestion();
    state.option1 = model.getOption1();
    state.option2 = model.getOption2();
    state.option3 = model.getOption3();

    disableNextButton();
    view.get().resetReply();
  }


  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    // update the model
    model.setQuizIndex(state.quizIndex);
  }


  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    QuestionState savedState = router.getDataFromPreviousScreen();
    if (savedState != null) {

      // update view and model state
      state = savedState;
    }

    // update the view
    view.get().displayQuestion(state);

  }

  @Override
  public void onOptionButtonClicked(int option) {

    enableNextButton();

    boolean isCorrect = model.isCorrectOption(option);
    if(isCorrect) {
      state.cheatEnabled=false;
    } else {
      state.cheatEnabled=true;
    }

    view.get().updateReply(isCorrect);
    onResume();
  }

  @Override
  public void onNextButtonClicked() {
    //TODO: falta implementacion

  }

  @Override
  public void onCheatButtonClicked() {
    //TODO: falta implementacion

  }


  private void disableNextButton() {
    state.optionEnabled=true;
    state.cheatEnabled=true;
    state.nextEnabled=false;

  }

  private void enableNextButton() {
    state.optionEnabled=false;
    state.nextEnabled=true;
  }

  @Override
  public void injectView(WeakReference<QuestionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(QuestionContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(QuestionContract.Router router) {
    this.router = router;
  }
}
