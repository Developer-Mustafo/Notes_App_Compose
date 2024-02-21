package uz.coder.notesapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import uz.coder.notesapp.R

@Composable
fun Notes(navController: NavController,backStackEntry: NavBackStackEntry){
    Column(modifier = Modifier.fillMaxSize().background(colorResource(R.color.background))) {
        val name = remember {backStackEntry.arguments?.getString("name")?:""}
        val notes = remember {backStackEntry.arguments?.getString("notes")?:""}
        Text(text = name, fontSize = 25.sp, color = Color.White)
        Text(text = notes, fontSize = 25.sp, color = Color.White)
    }
}