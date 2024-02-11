package com.example.laboratoryworkapplication.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.laboratoryworkapplication.R

fun Fragment.navigationPopBackStack(countBack: Int = 1) {
    if (countBack == 1) {
        parentFragmentManager.popBackStack()
    } else if (parentFragmentManager.backStackEntryCount >= countBack) {
        val id = parentFragmentManager.getBackStackEntryAt(
            parentFragmentManager.backStackEntryCount - countBack
        ).id
        parentFragmentManager.popBackStack(id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    } else {
        throw IllegalArgumentException("Size backstack less then countBack:$countBack")
    }
}

fun Fragment.navigationGoTo(
    isAddBackStack: Boolean = true, createFragment: () -> Fragment,
    idContainer: Int = R.id.container
) {
    val fragment = createFragment.invoke()
    val transaction = parentFragmentManager
        .beginTransaction()
        .replace(
            idContainer,
            fragment,
            fragment.toString()
        )
    if (isAddBackStack) {
        transaction.addToBackStack(null)
    }
    transaction.commitAllowingStateLoss()
}

fun AppCompatActivity.navigationGoTo(
    createFragment: () -> Fragment,
    idContainer: Int = R.id.container
) {
    val fragment = createFragment.invoke()
    supportFragmentManager
        .beginTransaction()
        .replace(
            idContainer,
            fragment,
            fragment.toString()
        )
        .commitAllowingStateLoss()
}