package uz.coder.notesapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.coder.notesapp.R
import uz.coder.notesapp.viewModel.NotesViewModel

@Composable
fun AddScreen(navigation: NavController, viewModel: NotesViewModel){
    val name = remember { mutableStateOf("") }
    val notes = remember { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.background(
        colorResource(R.color.background)
    )) {
        TextField(name.value, onValueChange = {name.value = it}, modifier = Modifier.padding(5.dp,5.dp,5.dp).fillMaxWidth())
        Spacer(modifier = Modifier.height(5.dp))
        TextField(notes.value, onValueChange = {notes.value = it}, modifier = Modifier.fillMaxWidth().padding(5.dp,5.dp,5.dp))
        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            viewModel.add(uz.coder.notesapp.models.Notes(name = name.value, notes = notes.value))
            navigation.popBackStack()
        }, modifier = Modifier.background(colorResource(R.color.background))){
            Text("Save",color = Color.White, fontSize = 25.sp, modifier = Modifier)
        }
    }
}