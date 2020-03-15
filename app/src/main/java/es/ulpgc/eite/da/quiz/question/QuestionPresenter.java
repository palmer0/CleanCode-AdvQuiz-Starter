package es.ulpgc.eite.da.quiz.question;

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

    // call the model
    state = model.getQuestionData();

    disableNextButton();
    view.get().resetReply();
  }

  private void disableNextButton() {
    state.optionEnabled=true;
    state.cheatEnabled=true;
    state.nextEnabled=false;

  }

  private void enableNextButton() {
    state.optionEnabled=false;
    //state.cheatEnabled=false;
    state.nextEnabled=true;
  }

  @Override
  public void onRestart() {

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
  public void onResume() {
    // Log.e(TAG, "onResume()");

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
