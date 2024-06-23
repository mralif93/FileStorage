package com.my.muhammadaliftajudin.filestorage

import android.os.Environment

object CommonUtil {
    fun isReadable():Boolean {
        var mExternalStorangeAvailable = false
        try {
            val state = Environment.getExternalStorageState()

            if (Environment.MEDIA_MOUNTED.equals(state)){
                mExternalStorangeAvailable = true
            } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
                mExternalStorangeAvailable = true
            } else {
                mExternalStorangeAvailable = false
            }
        } catch (e:Exception){
            print(e.message)
        }

        return mExternalStorangeAvailable
    }
}