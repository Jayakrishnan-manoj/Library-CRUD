package com.example.librarycrud.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.librarycrud.room.BookEntity
import com.example.librarycrud.viewmodel.BookViewModel
import org.w3c.dom.Text

@Composable
fun UpdateScreen(viewModel: BookViewModel, bookId: String?) {

    var inputBook by remember {
        mutableStateOf("")
    }

    Column {
        OutlinedTextField(
            value = inputBook,
            onValueChange = { newValue -> inputBook = newValue },
            label = {
                Text(
                    text = "Update Book Name"
                )
            },
            placeholder = { Text(text = "New Book Name") }
        )

        Button(onClick = {
            var newBook = BookEntity(bookId!!.toInt(), inputBook)
            viewModel.updateBook(newBook)

        }) {
            Text(text = "Update Book")
        }

    }
}