package com.webskitters.client.testhiltexample.utils.dialog

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

/*
 * Notes Dialog
 */
inline fun Activity.showNotesAlertDialog(func: NotesDialogHelper.() -> Unit): AlertDialog =
    NotesDialogHelper(this).apply {
        func()
    }.create()

inline fun Fragment.showNotesAlertDialog(func: NotesDialogHelper.() -> Unit): AlertDialog =
    NotesDialogHelper(this.requireContext()).apply {
        func()
    }.create()

/*
 * TimeChooser Dialog
 */
//inline fun Activity.showTimeChooserAlertDialog(func: TimeChooserDialogHelper.() -> Unit): AlertDialog =
//    TimeChooserDialogHelper(this).apply {
//        func()
//    }.create()
//
//inline fun Fragment.showTimeChooserAlertDialog(func: TimeChooserDialogHelper.() -> Unit): AlertDialog =
//    TimeChooserDialogHelper(this.context!!).apply {
//        func()
//    }.create()