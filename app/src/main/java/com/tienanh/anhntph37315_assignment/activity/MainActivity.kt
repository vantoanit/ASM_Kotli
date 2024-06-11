package com.tienanh.anhntph37315_assignment.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tienanh.anhntph37315_assignment.nav.ScreenNav


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

               ScreenNav()

        }
    }
}