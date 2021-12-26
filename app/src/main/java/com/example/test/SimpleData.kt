package com.example.test

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator

class SimpleData(var number: Int, var message: String?) : Parcelable {
    constructor(src: Parcel): this(src.readInt(), src.readString())

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(number)
        dest.writeString(message)
    }

    companion object {
        @JvmField
        val CREATOR: Creator<*> = object : Creator<Any?> {
            override fun createFromParcel(src: Parcel): SimpleData? {
                return SimpleData(src)
            }

            override fun newArray(size: Int): Array<SimpleData?> {
                return arrayOfNulls(size)
            }
        }
    }
}
