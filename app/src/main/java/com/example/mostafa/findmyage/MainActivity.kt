package com.example.mostafa.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePicker.maxDate = Calendar.getInstance().timeInMillis
        datePicker.firstDayOfWeek=Calendar.SATURDAY

        button.setOnClickListener{

            var YearNow=Calendar.getInstance().get(Calendar.YEAR)
            var MonthNow=Calendar.getInstance().get(Calendar.MONTH)
            var DayOfMonthNow=Calendar.getInstance().get(Calendar.DAY_OF_MONTH)

            val GivenYear=datePicker.year
            val GivenMonth=datePicker.month
            val GivenDayOFMonth=datePicker.dayOfMonth

            var resutYear=0
            var resutMonth=0
            var resutDay=0

            if(DayOfMonthNow < GivenDayOFMonth)
            {
                MonthNow--
                DayOfMonthNow+=30

                resutDay=DayOfMonthNow-GivenDayOFMonth
            }
            else if(DayOfMonthNow >= GivenDayOFMonth)
            {
                resutDay=DayOfMonthNow-GivenDayOFMonth
            }
            if (MonthNow < GivenMonth)
            {
                YearNow--
                MonthNow+=12

                resutMonth=MonthNow-GivenMonth
            }
            else if (MonthNow >= GivenMonth)
            {
                resutMonth=MonthNow-GivenMonth
            }
            resutYear=YearNow-GivenYear
            textView.text = "$resutYear years & $resutMonth months & $resutDay days"
        }

    }
}
