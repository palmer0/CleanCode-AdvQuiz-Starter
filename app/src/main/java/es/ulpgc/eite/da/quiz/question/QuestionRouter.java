package es.ulpgc.eite.da.quiz.question;

import es.ulpgc.eite.da.quiz.app.AppMediator;
import es.ulpgc.eite.da.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.da.quiz.app.QuestionToCheatState;

public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  private AppMediator mediator;

  public QuestionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passStateToCheatScreen(QuestionToCheatState state) {

    //TODO: falta implementacion

  }

  @Override
  public CheatToQuestionState getStateFromCheatScreen() {

    //TODO: falta implementacion

    return null;
  }
}
