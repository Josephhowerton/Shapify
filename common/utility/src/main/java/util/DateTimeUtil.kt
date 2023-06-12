package com.fitness.shapify.util

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale



object DateTimeUtil{

    fun getCurrentDate() : Date {
        return Calendar.getInstance().time
    }

    fun getPreviousDate(current: Date) : Date {
        val calendar = Calendar.getInstance()
        calendar.time = current
        calendar.add(Calendar.DATE, -1)
        return calendar.time
    }

    fun getNextDate(current: Date) : Date {
        val calendar = Calendar.getInstance()
        calendar.time = current
        calendar.add(Calendar.DATE, +1)
        return calendar.time
    }

    fun getDayOfWeek(date: Date) : String {
        return when(getDayOfWeekFromDate(date = date)){
            Calendar.MONDAY-> "Monday"
            Calendar.TUESDAY-> "Tuesday"
            Calendar.WEDNESDAY-> "Wednesday"
            Calendar.THURSDAY-> "Thursday"
            Calendar.FRIDAY-> "Friday"
            Calendar.SATURDAY-> "Saturday"
            else -> "Sunday"
        }
    }

    private fun getDayOfWeekFromDate(date: Date) : Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar.get(Calendar.DAY_OF_WEEK)
    }


    fun getWeekTimeline(date: Date = Calendar.getInstance().time) : List<Date> {
        val calendar: Calendar = Calendar.getInstance()
        calendar.time = date
        return when(calendar.get(Calendar.DAY_OF_WEEK)){
            Calendar.MONDAY-> createTimeline(0)
            Calendar.TUESDAY-> createTimeline(Calendar.TUESDAY-Calendar.MONDAY)
            Calendar.WEDNESDAY-> createTimeline(Calendar.WEDNESDAY-Calendar.MONDAY)
            Calendar.THURSDAY-> createTimeline(Calendar.THURSDAY-Calendar.MONDAY)
            Calendar.FRIDAY-> createTimeline(Calendar.FRIDAY-Calendar.MONDAY)
            Calendar.SATURDAY-> createTimeline(Calendar.SATURDAY-Calendar.MONDAY)
            else -> createTimeline(Calendar.SATURDAY-Calendar.MONDAY)
        }
    }

    fun getMonthTimeline() : List<Date> {
        val dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1
        return createTimeline(dayOfMonth)
    }

    private fun createTimeline(numberOfDays: Int) : List<Date> {
        val dateFormat = SimpleDateFormat("ddMMyyyy", Locale.getDefault())
        val dates = mutableListOf<Date>()
        for(index in 0 ..numberOfDays){
            val sDate = dateFormat.format(Calendar.getInstance().time)
            val date = dateFormat.parse(sDate)
            val calendar = Calendar.getInstance()
            if (date != null) {
                calendar.time = date
                calendar.add(Calendar.DATE, -index)
                dates.add(calendar.time)
                Log.e("createTimeline", calendar.time.toString())
            }
        }
        return dates
    }

    fun getMonthTimelineAsWeeklyInterval() : List<List<Date>> {
        val dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)-1

        val monthTimelineList = mutableListOf<List<Date>>()
        var weekTimelineList = mutableListOf<Date>()
        val monthlyTimeline = createTimeline(dayOfMonth)
        for(day in monthlyTimeline) {
            weekTimelineList.add(day)

            if(getDayOfWeekFromDate(date = day) == Calendar.SUNDAY){
                monthTimelineList.add(weekTimelineList)
                weekTimelineList = mutableListOf()
            }
        }

        if(weekTimelineList.size > 0){
            monthTimelineList.add(weekTimelineList)
        }

        return monthTimelineList
    }
}