package es.ulpgc.eite.da.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private WeakReference<CheatContract.View> view;
  private CheatState state;
  private CheatContract.Model model;
  private CheatContract.Router router;

  public CheatPresenter(CheatState state) {
    this.state = state;
  }


  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");

    // reset state to tests
    state.answerEnabled=true;
    state.answerCheated=false;
    state.answer = null;

    // update the view
    view.get().resetAnswer();
  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");

    //TODO: falta implementacion
  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    //TODO: falta implementacion

    // use passed state if is necessary
    QuestionToCheatState savedState = router.getStateFromQuestionScreen();
    if (savedState != null) {

      // update the state

    }

    // update the view
    view.get().displayAnswer(state);

  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
  }

  @Override
  public void onBackPressed() {
    Log.e(TAG, "onBackPressed()");

    //TODO: falta implementacion

  }

  @Override
  public void onWarningButtonClicked(int option) {
    Log.e(TAG, "onWarningButtonClicked()");

    //TODO: falta implementacion
    //option=1 => yes, option=0 => no

  }


  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }
}
