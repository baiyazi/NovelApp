package com.mengfou.entity

import android.os.Parcel
import android.os.Parcelable
import com.mengfou.R
import java.io.Serializable

/**
 * @author 梦否 on 2022/5/8
 * @blog https://mengfou.blog.csdn.net/
 */
data class NovelDetail(
    var id: String?,
    var catId: Int?,
    var catName: String?,
    var picUrl: String?,
    var bookName: String?,
    var authorName: String?,
    var bookDesc: String?,
    var score: String?,
    var wordCount: String?,
    var lastIndexUpdateTime: String?,
    var lastIndexId: String?,
    var lastIndexName: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeValue(catId)
        parcel.writeString(catName)
        parcel.writeString(picUrl)
        parcel.writeString(bookName)
        parcel.writeString(authorName)
        parcel.writeString(bookDesc)
        parcel.writeString(score)
        parcel.writeString(wordCount)
        parcel.writeString(lastIndexUpdateTime)
        parcel.writeString(lastIndexId)
        parcel.writeString(lastIndexName)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getNovelDetailItems(): MutableList<Pair<Int, String>> {
        return mutableListOf<Pair<Int, String>>().apply {
            add(Pair(R.string.id, id?: ERROR))
            add(Pair(R.string.catId, catId.toString()))
            add(Pair(R.string.catName, catName?: ERROR))
            add(Pair(R.string.picUrl, picUrl?: ERROR))
            add(Pair(R.string.bookName, bookName?: ERROR))
            add(Pair(R.string.authorName, authorName?: ERROR))
            add(Pair(R.string.bookDesc, bookDesc?: ERROR))
            add(Pair(R.string.score, score?: ERROR))
            add(Pair(R.string.wordCount, wordCount?: ERROR))
            add(Pair(R.string.lastIndexUpdateTime, lastIndexUpdateTime?: ERROR))
            add(Pair(R.string.lastIndexId, lastIndexId?: ERROR))
            add(Pair(R.string.lastIndexName, lastIndexName?: ERROR))
        }
    }

    companion object CREATOR : Parcelable.Creator<NovelDetail> {
        override fun createFromParcel(parcel: Parcel): NovelDetail {
            return NovelDetail(parcel)
        }

        override fun newArray(size: Int): Array<NovelDetail?> {
            return arrayOfNulls(size)
        }

        val ERROR = "ERROR"
    }
}