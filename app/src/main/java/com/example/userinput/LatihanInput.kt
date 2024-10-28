package com.example.userinput

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.provider.FontsContractCompat.Columns

@Preview(showBackground = true)
@Composable

fun LatihanInput(modifier: Modifier = Modifier) {
    var Nama by remember { mutableStateOf("") }
    var Email by remember { mutableStateOf("") }
    var Alamat by remember { mutableStateOf("") }
    var notelepon by remember { mutableStateOf("") }

    var dataGender = listOf("Laki Laki", "Perempuan")
    var gender by remember { mutableStateOf("") }
    var ConfGender by remember { mutableStateOf("") }

    var ConfNama by remember { mutableStateOf("") }
    var ConfEmail by remember { mutableStateOf("") }
    var ConfAlamat by remember { mutableStateOf("") }
    var Confnotelepon by remember { mutableStateOf("") }
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = Nama,
            onValueChange = { Nama = it },
            label = {
                Text(text = "Nama")
            },
            placeholder = {
                Text(text = "isi nama anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                dataGender.forEach { SelectedGender ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = gender == SelectedGender,
                            onClick = { gender = SelectedGender }
                        )
                        Text("$SelectedGender")
                    }
                }
            }
        }
        TextField(
            value = Email,
            onValueChange = { Email = it },
            label = {
                Text(text = "Email")
            },
            placeholder = {
                Text(text = "isi Email anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = Alamat,
            onValueChange = { Alamat = it },
            label = {
                Text(text = "Alamat")
            },
            placeholder = {
                Text(text = "isi Alamat anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )
        TextField(
            value = notelepon,
            onValueChange = { notelepon = it },
            label = {
                Text(text = "notelepon")
            },
            placeholder = {
                Text(text = "isi notelepon anda")
            },
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Button(onClick = {
            ConfNama = Nama
            ConfEmail = Email
            ConfAlamat = Alamat
            Confnotelepon = notelepon
            ConfGender = gender
        }) {
            Text(text = "Simpan")
        }
        TampilInput(
            param = "Nama",
            argu = ConfNama
        )
        TampilInput(
            param = "Email",
            argu = ConfEmail
        )
        TampilInput(
            param = "Alamat",
            argu = ConfAlamat
        )
        TampilInput(
            param = "notelepon",
            argu = Confnotelepon
        )
        TampilInput(
            param = "Gender",
            argu = ConfGender
        )
    }
}

@Composable
fun TampilInput(
    param: String, argu: String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = param,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ": ",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}


