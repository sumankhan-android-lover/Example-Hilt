package com.webskitters.client.testhiltexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.webskitters.client.testhiltexample.R
import com.webskitters.client.testhiltexample.utils.dialog.showNotesAlertDialog
import com.webskitters.client.testhiltexample.utils.showVLog
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    private var notesDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initListener()
    }

    private fun initListener() {
        openDialog.setOnClickListener {
            showCustomDialog()
        }
    }

    private fun showCustomDialog() {
        if (notesDialog == null)
        ////////////////////////////////////////////////////////////////
        //  making Alert dialog - admire beauty of kotlin
        ////////////////////////////////////////////////////////////////
            notesDialog = showNotesAlertDialog {

                cancelable = false

                closeIconClickListener {
                    showVLog("Notes Dialog close icon clicked")
                }

                doneIconClickListener {
                    showVLog("Notes Dialog done icon clicked")
                }
            }
        //  and showing
        notesDialog?.show()
    }
}