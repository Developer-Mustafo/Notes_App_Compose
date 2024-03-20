package uz.coder.notesapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import uz.coder.notesapp.R
import uz.coder.notesapp.models.Notes
import uz.coder.notesapp.sealed.NotesScreens
import uz.coder.notesapp.viewModel.NotesViewModel

@Composable
fun HomeScreen(navigation:NavController?=null,viewModel:NotesViewModel){
    val list = remember { viewModel.getList() }
    Scaffold(floatingActionButton = { FAB(navigation)}) {paddingValues ->
        RecycleView(list,navigation,paddingValues)
    }
}
@Composable
private fun FAB (navigation: NavController?){
    FloatingActionButton(onClick = {navigation?.navigate(NotesScreens.Add.route)}){
        Icon(imageVector = Icons.Default.Add,contentDescription = null)
    }
}

@Composable
private fun RecycleView(list: List<Notes>,navigation: NavController?,paddingValues: PaddingValues) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) { items(items = list){
        ItemNotes(it,navigation)
    } }
}

@Composable
private fun ItemNotes(notes: Notes,navigation: NavController?) {
    Card(modifier = Modifier.padding(10.dp)) {
        Column(modifier = Modifier.background(colorResource(R.color.background)).clickable { navigation?.navigate(NotesScreens.Notes.route+"/${notes.name}/${notes.notes}") }.padding(20.dp).fillMaxWidth()) {
            Text(text = notes.name, modifier = Modifier.fillMaxWidth(), fontSize = 25.sp, color = Color.White)
            Text(text = notes.notes, modifier = Modifier.fillMaxWidth(), fontSize = 25.sp, color = Color.White)
        }
    }
}
