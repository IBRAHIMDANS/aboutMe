package com.android.example.AboutMe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        done_button.setOnClickListener {
            clickHanderFunction(it)
        }
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }
    }

    fun showImage(view: View) = if (imageView2.visibility == View.GONE) {
        imageView2.visibility = View.VISIBLE
        showOrHide.setText(" Hide my head 😉 ")
    } else {
        imageView2.visibility = View.GONE
        showOrHide.setText(" Show my head 🙃 ")
    }
    private fun clickHanderFunction(view: View) {
    }
    private fun addNickname(view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun updateNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            updateNickname(it)
        }
        editText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
