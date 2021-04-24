package com.example.samplebottomsheet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.first_bottom_sheet.*


class MainActivity : AppCompatActivity() {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)

        button.setOnClickListener {
            bottomSheetBehavior.state =
                if(bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED)
                BottomSheetBehavior.STATE_COLLAPSED else BottomSheetBehavior.STATE_EXPANDED
        }

        bottomSheetBehavior.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                button.text = when(newState){
                    BottomSheetBehavior.STATE_EXPANDED -> "Close Sheet"
                    BottomSheetBehavior.STATE_COLLAPSED -> "Open Sheet"
                    else -> "What state now?"
                }
            }
        })

        button2.setOnClickListener {
            MyDialogBottomSheet().show(
                supportFragmentManager,
                ""
            )
        }

    }
}