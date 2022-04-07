package com.example.compose.rally

import androidx.compose.material.Text
import androidx.compose.ui.test.*

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import com.example.compose.rally.ui.theme.RallyTheme
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

@get:Rule
val composeTestRule= createComposeRule()

    //Add Test

    //test in isolation

    @get:Rule
    val composeTestRule1= createAndroidComposeRule(RallyActivity::class.java)

    @Test
     fun myTest(){

        val allScreens=RallyScreen.values().toList()
         composeTestRule.setContent {
              RallyTheme{

                  RallyTopAppBar(allScreens = allScreens, onTabSelected ={} , currentScreen =RallyScreen.Accounts )

                  //finding UI elements
                  //check their UI properties
                  //perform actions

                 // composeTestRule{.finder}{.assertion}.{.action}

              }

         }
//        composeTestRule.onNodeWithContentDescription(RallyScreen.Accounts.name)
//            .assertIsSelectable()
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExist")

        composeTestRule.onNode(hasText(RallyScreen.Accounts.name.uppercase(),ignoreCase = true) and
                hasParent(hasContentDescription(RallyScreen.Accounts.name)),
        useUnmergedTree=true
        ).assertExists()

        //Thread.sleep(5000)
     }


}