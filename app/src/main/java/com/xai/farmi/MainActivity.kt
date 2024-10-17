package com.xai.farmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xai.farmi.ui.theme.CalendarScreen
import com.xai.farmi.ui.theme.FarmiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarmiTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "buttons_screen" // 시작 화면을 버튼 화면으로 설정
    ) {
        composable("buttons_screen") {
            ButtonsScreen(navController = navController)
        }
        composable("calendar_screen") {
            CalendarScreen() // 이미 구현된 캘린더 스크린을 호출
        }
    }
}

@Composable
fun ButtonsScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Farmi",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        CustomButton(text = "AI 진단", backgroundColor = MaterialTheme.colorScheme.secondary) {
            // TODO: AI 진단 버튼 동작 추가
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(text = "귤", backgroundColor = MaterialTheme.colorScheme.primary) {
            navController.navigate("calendar_screen") // 캘린더 화면으로 이동
        }
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(text = "키위", backgroundColor = MaterialTheme.colorScheme.primary) {
            navController.navigate("calendar_screen") // 캘린더 화면으로 이동
        }
    }
}

@Composable
fun CustomButton(text: String, backgroundColor: Color, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(horizontal = 8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onPrimary,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonsScreenPreview() {
    FarmiTheme {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController)
    }
}
