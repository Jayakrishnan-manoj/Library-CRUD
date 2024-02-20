package com.example.librarycrud.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.librarycrud.room.BookEntity
import com.example.librarycrud.viewmodel.BookViewModel
import org.w3c.dom.Text

@Composable
fun UpdateScreen(viewModel: BookViewModel, bookId: String?) {

    var inputBook by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Update The Existing Book", fontSize = 24.sp)

        OutlinedTextField(
            modifier = Modifier.padding(top = 16.dp),
            value = inputBook,
            onValueChange = { newValue -> inputBook = newValue },
            label = {
                Text(
                    text = "Update Book Name"
                )
            },
            placeholder = { Text(text = "New Book Name") }
        )

        Button(
            onClick = {
                var newBook = BookEntity(bookId!!.toInt(), inputBook)
                viewModel.updateBook(newBook)

            },
            modifier = Modifier.padding(16.dp), colors = ButtonDefaults.buttonColors(Color.Red),
        ) {
            Text(text = "Update Book")
        }

    }
}