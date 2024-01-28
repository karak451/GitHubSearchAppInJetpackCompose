package com.representation.githubsearchappinjetpackcompose.View.KeresesViewElemek

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.representation.githubsearchappinjetpackcompose.ViewModel.KeresesViewModel
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.representation.githubsearchappinjetpackcompose.ui.theme.feher
import com.representation.githubsearchappinjetpackcompose.ui.theme.sotetSzurke
import com.representation.githubsearchappinjetpackcompose.ui.theme.vilagosSzurke


@Composable
fun KeresoMezo(kvm: KeresesViewModel, width: Float){


    val focusManager = LocalFocusManager.current
    var keresoMezoInput by remember {
        mutableStateOf(TextFieldValue(text = ""))
    }
    var minositoMezoInput by remember {
        mutableStateOf(TextFieldValue(text = ""))
    }
    var reszletes by remember { mutableStateOf(false) }


    Column(modifier = Modifier) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .background(vilagosSzurke, shape = RoundedCornerShape(5.dp))
                    .padding(5.dp)
                    .height(50.dp)
                    .width((width * 0.76).dp)
            ) {
            OutlinedTextField(
                value = keresoMezoInput,
                onValueChange = { newValue ->
                    keresoMezoInput = newValue
                },
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(5.dp))
                    .background(vilagosSzurke)
                    .padding(0.dp)
                    .align(Alignment.BottomStart),
                keyboardActions = KeyboardActions(onDone = {
                    focusManager.clearFocus()
                }),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                maxLines = 1
            )
                Box(){
                    Text(
                        text = "Repository keresése",
                        fontSize = 12.sp,
                        modifier = Modifier
                            .offset(x = 15.dp, y = -5.dp)
                            .background(vilagosSzurke)
                            .padding(start = 5.dp, end = 5.dp)
                    )
                }

        }

            Text(
                text = "Keress!",
                color = feher,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width((width*0.2).dp)
                    .height(60.dp)
                    .background(Color.Gray, shape = RoundedCornerShape(5.dp))
                    .padding(top = 15.dp)
                    .clickable {
                        kvm.keresoMezoQuery = keresoMezoInput.text
                        if(reszletes){
                            kvm.minositoMezoQuery = minositoMezoInput.text
                        }
                        kvm.fetchGitHubReopositories()
                        focusManager.clearFocus()
                    }
            )

        } //:első sor

        if (reszletes) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "nyelv:",
                        color = vilagosSzurke
                    )
                    TextField(
                        value = minositoMezoInput,
                        onValueChange = { minositoMezoInput = it },
                        label = null,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                            .width((width * 0.62).dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(vilagosSzurke)
                    )
                }

                Text(
                    text = "elrejt",
                    color = vilagosSzurke,
                    modifier = Modifier.clickable {
                        reszletes = false
                    }
                )

            }
        } else {
            Text(
                text = "részletes keresés",
                color = vilagosSzurke,
                modifier = Modifier
                    .clickable {
                        reszletes = true
                    }
            )
        }

    }

}