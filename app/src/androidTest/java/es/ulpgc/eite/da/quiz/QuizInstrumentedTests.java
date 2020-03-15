package es.ulpgc.eite.da.quiz;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.da.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class QuizInstrumentedTests {



  @Rule
  public ActivityTestRule<QuestionActivity> activityTestRule =
      new ActivityTestRule(QuestionActivity.class );


  Context context =
      InstrumentationRegistry.getInstrumentation().getTargetContext();

  String[] quiz = context.getResources().getStringArray(R.array.quiz_array);
  String correct = context.getString(R.string.correct_reply);
  String incorrect = context.getString(R.string.incorrect_reply);
  String empty = context.getString(R.string.empty_reply);

  @Test
  public void firstQuestionCorrect() {

    //GIVEN 
    //encontrándonos en pantalla Question
    //después de cargar pregunta del cuestionario
    //mostraremos botones Option y Cheat activados
    //mostraremos botón Next desactivado

    (onView(withId(R.id.qestionTextView))).check(matches(withText(quiz[0])));
    (onView(withId(R.id.option1Button))).check(matches(withText(quiz[1])));
    (onView(withId(R.id.option2Button))).check(matches(withText(quiz[2])));
    (onView(withId(R.id.option3Button))).check(matches(withText(quiz[3])));
    (onView(withId(R.id.replyTextView))).check(matches(withText(empty)));
    (onView(withId(R.id.option1Button))).check(matches(isEnabled()));
    (onView(withId(R.id.option2Button))).check(matches(isEnabled()));
    (onView(withId(R.id.option3Button))).check(matches(isEnabled()));
    (onView(withId(R.id.cheatButton))).check(matches(isEnabled()));
    (onView(withId(R.id.nextButton))).check(matches(not(isEnabled())));

    //WHEN 
    //al pulsar botón Option
    (onView(withId(R.id.option3Button))).perform(click());

    //THEN 
    //mostraremos mensaje Correct o Incorrect dependiendo
    //si respuesta del usuario corresponde con respuesta correcta o no
    //mostraremos botones Option y Cheat desactivados
    //mostraremos botón Next activado
    (onView(withId(R.id.qestionTextView))).check(matches(withText(quiz[0])));
    (onView(withId(R.id.option1Button))).check(matches(withText(quiz[1])));
    (onView(withId(R.id.option2Button))).check(matches(withText(quiz[2])));
    (onView(withId(R.id.option3Button))).check(matches(withText(quiz[3])));
    (onView(withId(R.id.replyTextView))).check(matches(withText(correct)));
    (onView(withId(R.id.option1Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.option2Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.option3Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.cheatButton))).check(matches(not(isEnabled())));
    (onView(withId(R.id.nextButton))).check(matches(isEnabled()));
  }


  @Test
  public void firstQuestionIncorrect() {

    //GIVEN 
    //encontrándonos en pantalla Question
    //después de cargar pregunta del cuestionario
    //mostraremos botones Option y Cheat activados
    //mostraremos botón Next desactivado

    (onView(withId(R.id.qestionTextView))).check(matches(withText(quiz[0])));
    (onView(withId(R.id.option1Button))).check(matches(withText(quiz[1])));
    (onView(withId(R.id.option2Button))).check(matches(withText(quiz[2])));
    (onView(withId(R.id.option3Button))).check(matches(withText(quiz[3])));
    (onView(withId(R.id.replyTextView))).check(matches(withText(empty)));
    (onView(withId(R.id.option1Button))).check(matches(isEnabled()));
    (onView(withId(R.id.option2Button))).check(matches(isEnabled()));
    (onView(withId(R.id.option3Button))).check(matches(isEnabled()));
    (onView(withId(R.id.cheatButton))).check(matches(isEnabled()));
    (onView(withId(R.id.nextButton))).check(matches(not(isEnabled())));

    //WHEN 
    //al pulsar botón Option
    (onView(withId(R.id.option2Button))).perform(click());

    //THEN 
    //mostraremos mensaje Correct o Incorrect dependiendo
    //si respuesta del usuario corresponde con respuesta correcta o no
    //mostraremos botones Option y Cheat desactivados
    //mostraremos botón Next activado
    (onView(withId(R.id.qestionTextView))).check(matches(withText(quiz[0])));
    (onView(withId(R.id.option1Button))).check(matches(withText(quiz[1])));
    (onView(withId(R.id.option2Button))).check(matches(withText(quiz[2])));
    (onView(withId(R.id.option3Button))).check(matches(withText(quiz[3])));
    (onView(withId(R.id.replyTextView))).check(matches(withText(incorrect)));
    (onView(withId(R.id.option1Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.option2Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.option3Button))).check(matches(not(isEnabled())));
    (onView(withId(R.id.cheatButton))).check(matches(isEnabled()));
    (onView(withId(R.id.nextButton))).check(matches(isEnabled()));
  }
}
