package com.yuyakaido.android.cardstackview.sample

import androidx.recyclerview.widget.DiffUtil
import tn.esprit.smartpet.model.User

class SpotDiffCallback(
        private val old: List<Spot>,
        private val new: List<Spot>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition].idd == new[newPosition].idd
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return old[oldPosition] == new[newPosition]
    }

}
