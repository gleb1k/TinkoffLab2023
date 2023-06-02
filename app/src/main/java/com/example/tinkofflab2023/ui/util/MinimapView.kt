package com.example.tinkofflab2023.ui.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.res.ResourcesCompat
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.ui.model.MatchBuildingsState


class MinimapView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : androidx.appcompat.widget.AppCompatImageView(context, attrs) {

    private var buildingsState: MatchBuildingsState? = null

    private val radiantPaint: Paint = Paint().apply {
        color = ResourcesCompat.getColor(resources, R.color.radiant_green_minimap, null)
        style = Paint.Style.FILL
    }

    private val direPaint: Paint = Paint().apply {
        color = ResourcesCompat.getColor(resources, R.color.dire_red, null);
        style = Paint.Style.FILL
    }

    private val borderPaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 1f
    }

    fun set(bs: MatchBuildingsState) {
        buildingsState = bs
        invalidate()
    }

    private val ancient: RectF = RectF()
    private val barrack: RectF = RectF()
    private val tower: RectF = RectF()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val size = width
        val unit = size * 0.01f

        val ancientSize = 5f * unit
        val barrackSize = 2.0f * unit
        val towerHeight = 2.5f * unit
        val towerWidth = 2.5f * unit
        // minimap
        val mapDrawable = AppCompatResources.getDrawable(context, (R.drawable.minimap))
        mapDrawable?.setBounds(0, 0, width, height)
        mapDrawable?.draw(canvas)

        fun drawAncient(x: Int, y: Int, paint: Paint) {
            ancient.set(
                x * unit,
                y * unit,
                x * unit + ancientSize,
                y * unit + ancientSize,
            )
            canvas.drawRect(ancient, paint)
            canvas.drawRect(ancient, borderPaint)
        }

        fun drawBarrack(x: Double, y: Double, paint: Paint, rotation: Float = 0f) {
            canvas.save();
            canvas.rotate(rotation, (size / 2).toFloat(), (size / 2).toFloat())
            barrack.set(
                x.toFloat() * unit,
                y.toFloat() * unit,
                x.toFloat() * unit + barrackSize,
                y.toFloat() * unit + barrackSize
            )
            canvas.drawRect(barrack, paint)
            canvas.drawRect(barrack, borderPaint)
            canvas.restore();
        }

        fun drawTower(x: Double, y: Double, paint: Paint) {
            tower.set(
                x.toFloat() * unit,
                y.toFloat() * unit,
                x.toFloat() * unit + towerWidth,
                y.toFloat() * unit + towerHeight,
            )
            canvas.drawRect(tower, paint)
            canvas.drawRect(tower, borderPaint)
        }


        buildingsState?.let {
            val radiantTowers = it.towerStatusRadiant
            val direTowers = it.towerStatusDire
            val radiantBarracks = it.barracksStatusRadiant
            val direBarracks = it.barracksStatusDire


            // radiant ancient
            if (it.radiantWin)
                drawAncient(12, 79, radiantPaint)

            // dire ancient
            if (!it.radiantWin)
                drawAncient(82, 16, direPaint)

            // radiant region
            // ancient_top
            if (radiantTowers["ancient_top"] == "1")
                drawTower(15.0, 76.1, radiantPaint)
            // ancient_bottom
            if (radiantTowers["ancient_bottom"] == "1")
                drawTower(17.4, 78.5, radiantPaint)

            // radiant top
            // ranged
            if (radiantBarracks["top_ranged"] == "1")
                drawBarrack(8.5, 72.0, radiantPaint)
            // melee
            if (radiantBarracks["top_melee"] == "1")
                drawBarrack(11.5, 72.0, radiantPaint)
            //t3
            if (radiantTowers["top_tier_3"] == "1")
                drawTower(9.5, 69.0, radiantPaint)
            //t2
            if (radiantTowers["top_tier_2"] == "1")
                drawTower(11.5, 55.0, radiantPaint)
            //t1
            if (radiantTowers["top_tier_1"] == "1")
                drawTower(12.0, 37.0, radiantPaint)

            //radiant mid
            // ranged
            if (radiantBarracks["middle_ranged"] == "1")
                drawBarrack(19.4, 73.0, radiantPaint)
            // melee
            if (radiantBarracks["middle_melee"] == "1")
                drawBarrack(22.0, 75.0, radiantPaint)
            //t3
            if (radiantTowers["middle_tier_3"] == "1")
                drawTower(22.0, 72.0, radiantPaint)
            //t2
            if (radiantTowers["middle_tier_2"] == "1")
                drawTower(28.0, 66.0, radiantPaint)
            //t1
            if (radiantTowers["middle_tier_1"] == "1")
                drawTower(41.0, 55.9, radiantPaint)

            //radiant bottom
            if (radiantBarracks["bottom_ranged"] == "1")
                drawBarrack(24.0, 84.0, radiantPaint)
            if (radiantBarracks["bottom_melee"] == "1")
                drawBarrack(24.0, 87.0, radiantPaint)
            //t3
            if (radiantTowers["bottom_tier_3"] == "1")
                drawTower(26.0, 85.0, radiantPaint)
            //t2
            if (radiantTowers["bottom_tier_2"] == "1")
                drawTower(47.0, 85.0, radiantPaint)
            //t1
            if (radiantTowers["bottom_tier_1"] == "1")
                drawTower(82.0, 82.0, radiantPaint)
            // endregion


            // dire region
            if (direTowers["ancient_top"] == "1")
                drawTower(81.4, 21.7, direPaint)
            if (direTowers["ancient_bottom"] == "1")
                drawTower(79.0, 19.3, direPaint)
            //dire top
            if (direBarracks["top_ranged"] == "1")
                drawBarrack(73.0, 12.5, direPaint)
            if (direBarracks["top_melee"] == "1")
                drawBarrack(73.0, 15.5, direPaint)
            if (direTowers["top_tier_3"] == "1")
                drawTower(70.0, 13.5, direPaint)
            if (direTowers["top_tier_2"] == "1")
                drawTower(49.0, 12.7, direPaint)
            if (direTowers["top_tier_1"] == "1")
                drawTower(18.0, 14.0, direPaint)

            //dire mid
            if (direBarracks["middle_ranged"] == "1")
                drawBarrack(74.0, 24.5, direPaint)
            if (direBarracks["middle_melee"] == "1")
                drawBarrack(76.0, 26.5, direPaint)
            if (direTowers["middle_tier_3"] == "1")
                drawTower(73.0, 26.5, direPaint)
            if (direTowers["middle_tier_2"] == "1")
                drawTower(65.0, 36.0, direPaint)
            if (direTowers["middle_tier_1"] == "1")
                drawTower(51.0, 44.0, direPaint)

            //dire bottom
            if (direBarracks["bottom_ranged"] == "1")
                drawBarrack(86.0, 30.0, direPaint)
            if (direBarracks["bottom_melee"] == "1")
                drawBarrack(89.0, 30.0, direPaint)
            if (direTowers["bottom_tier_3"] == "1")
                drawTower(87.5, 32.0, direPaint)
            if (direTowers["bottom_tier_2"] == "1")
                drawTower(87.0, 46.0, direPaint)
            if (direTowers["bottom_tier_1"] == "1")
                drawTower(86.0, 63.0, direPaint)
            // endregion
        }
    }

}
