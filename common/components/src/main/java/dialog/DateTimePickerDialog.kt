package dialog

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Preview
@Composable
private fun DateTimePickerPreview(){
    dateTimePickerDialog(Calendar.getInstance().time) {}.show()
}

@Composable
fun dateTimePickerDialog(date: Date, onDatePicked: (date: Date) -> Unit) : DatePickerDialog {
    val calendar = Calendar.getInstance()
    calendar.time = date
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    return DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
            val dateInString = "$mYear-${mMonth+1}-$mDayOfMonth"
            formatter.parse(dateInString)?.let { onDatePicked(it) }
        }, year, month, day
    )
}