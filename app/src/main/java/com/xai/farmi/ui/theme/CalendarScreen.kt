package com.xai.farmi.ui.theme

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun CalendarScreen() {
    val context = LocalContext.current
    var selectedDate by remember { mutableStateOf("날짜를 선택하세요") }

    // DatePickerDialog를 위한 Calendar 객체 생성
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // DatePickerDialog 설정
    val datePickerDialog = DatePickerDialog(
        context,
        { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            selectedDate = "$selectedYear-${selectedMonth + 1}-$selectedDayOfMonth"
        }, year, month, day
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 캘린더 타이틀
        Text(
            text = "캘린더",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // 선택된 날짜 텍스트
        Text(
            text = "선택된 날짜: $selectedDate",
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(8.dp)
        )

        // 날짜 선택 버튼
        Button(
            onClick = { datePickerDialog.show() },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onBackground),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(text = "날짜 선택하기", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }

        // 날짜 선택 버튼과 박스 사이 간격 추가
        Spacer(modifier = Modifier.height(24.dp))

        // 병명과 버튼들을 묶은 네모 박스
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .border(2.dp, Color.Gray, shape = RoundedCornerShape(16.dp)) // 네모 박스 테두리
                .padding(16.dp) // 내부 패딩
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // 진단 결과 텍스트
                Text(
                    text = "귤병",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // AI 설명 보기 및 다시 진단 하기 버튼
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    CustomButton(text = "AI 설명 보기", backgroundColor = MaterialTheme.colorScheme.primary) {
                        // TODO: AI 설명 보기 기능 구현
                    }

                    CustomButton(text = "다시 진단 하기", backgroundColor = MaterialTheme.colorScheme.secondary) {
                        // TODO: 다시 진단하기 기능 구현
                    }
                }
            }
        }
    }
}

@Composable
fun CustomButton(text: String, backgroundColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(150.dp)
            .height(60.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CalendarScreenPreview() {
    FarmiTheme {
        CalendarScreen()
    }
}
