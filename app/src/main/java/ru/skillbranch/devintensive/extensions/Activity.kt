package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.support.v4.content.ContextCompat.getSystemService
import android.view.inputmethod.InputMethodManager
import android.opengl.ETC1.getHeight
import android.view.ViewGroup
import ru.skillbranch.devintensive.R


/**
 * Created by Artur (gaket) on 2019-07-14.
 */
fun Activity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Activity.isKeyboardVisible(): Boolean {
    val activityRoot = findViewById<ViewGroup>(R.id.activity_root)
    val rootView = getWindow().getDecorView().getRootView()
    val r = Rect()
    rootView.getWindowVisibleDisplayFrame(r)
    return activityRoot.getHeight() - (r.bottom - r.top) > 100
}