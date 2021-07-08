package br.com.testes_automatizados_kotlin

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author RubioAlves
 * Created 30/06/2021 at 11:01
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun shouldShowErrorOnMandatoryField_whenNameFieldIsEmpty() {
        Espresso.onView(ViewMatchers.withId(R.id.buttonNome)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.textViewCampoObrigatorio)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun shouldAddNameToList_whenNameFieldValid(){
        Espresso.onView(ViewMatchers.withId(R.id.editTextNome)).perform(ViewActions.typeText("Marcelo"))
        Espresso.onView(ViewMatchers.withId(R.id.buttonNome)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollTo<ItemAdapter.ItemAdapterViewHolder>(
            ViewMatchers.withText("Marcelo")))
        Espresso.onView(ViewMatchers.withText("Marcelo")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }



}