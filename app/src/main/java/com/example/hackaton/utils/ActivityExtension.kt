package com.example.hackaton.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.example.hackaton.R

fun FragmentActivity.addFragment(
    fragment: Fragment,
    container: Int = R.id.fragment_container,
    addToBackStack: Boolean = false,
    tag: String = fragment.javaClass.simpleName,
    allowStateLoss: Boolean = false
) = supportFragmentManager.commit(allowStateLoss) {
    add(container, fragment, tag)
    if (addToBackStack) addToBackStack(null)
}

fun FragmentActivity.replaceFragmentWithoutBack(
    fragment: Fragment,
    container: Int = R.id.fragment_container,
    tag: String = fragment.javaClass.simpleName,
    allowStateLoss: Boolean = false
) = supportFragmentManager.commit(allowStateLoss) {
    replace(container, fragment, tag)
}