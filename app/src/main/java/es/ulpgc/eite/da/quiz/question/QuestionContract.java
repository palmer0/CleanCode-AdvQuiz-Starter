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
    void onNextButtonClicked();
    void onCheatButtonClicked();
  }

  interface Model {
    String getQuestion();

    String getOption1();

    String getOption2();

    String getOption3();

    //QuestionState getQuestionData();
    boolean isCorrectOption(int option);
    void setQuizIndex(int index);
  }

  interface Router {
    void navigateToNextScreen();
    void passDataToNextScreen(QuestionState state);
    QuestionState getDataFromPreviousScreen();
  }
}
