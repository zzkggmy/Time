package com.kai.time.view

import android.app.ProgressDialog
import android.content.Context
import com.kai.time.R
import com.kai.time.utils.mContext

class LoadingProgress(context: Context) {
    private val progressDialog: ProgressDialog by lazy { ProgressDialog(context) }

    fun showLoding() {
        progressDialog.setMessage(mContext.getString(R.string.loading))
        progressDialog.show()
    }

    fun dismissLoding() {
        progressDialog.dismiss()
    }
}
