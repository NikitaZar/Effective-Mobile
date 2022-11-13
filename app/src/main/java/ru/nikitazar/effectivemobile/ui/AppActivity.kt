package ru.nikitazar.effectivemobile.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nikitazar.effectivemobile.R

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }
}