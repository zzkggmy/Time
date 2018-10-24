package com.kai.time.utils

import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class ItemTouchHelperCallback : ItemTouchHelper.Callback() {


    override fun isItemViewSwipeEnabled(): Boolean {
        return super.isItemViewSwipeEnabled()
    }

    override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int {
        return makeMovementFlags(0, ItemTouchHelper.START)
    }

    override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

    }

    override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }

    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
        super.clearView(recyclerView, viewHolder)
    }
}

