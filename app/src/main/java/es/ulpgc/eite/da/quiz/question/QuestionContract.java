package es.ulpgc.eite.da.quiz.question;

import java.lang.ref.WeakReference;

public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayQuestion(QuestionViewModel viewModel);
    void resetReply();
    void updateReply(boolean isCorrect);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResume();
    void onStart();
    void onRestart();
    void onOptionButtonClicked(int option);
  }

  interface Model {
    QuestionState getQuestionData();
    boolean isCorrectOption(int option);
  }

  interface Router {
    void navigateToNextScreen();
    void passDataToNextScreen(QuestionState state);
    QuestionState getDataFromPreviousScreen();
  }
}
