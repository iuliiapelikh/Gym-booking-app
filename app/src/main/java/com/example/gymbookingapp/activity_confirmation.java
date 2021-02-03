package com.example.gymbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontStyle;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import static android.graphics.Typeface.*;
import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
import static android.text.Spanned.SPAN_EXCLUSIVE_INCLUSIVE;
import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;
import static android.text.Spanned.SPAN_INTERMEDIATE;
import static android.text.Spanned.SPAN_POINT_POINT;

public class activity_confirmation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        String text1 = "Your booking at ";
        String text2 = " is confirmed for ";
        String text3 = " at ";
        String text4 = text1 + name.name + " " + location.location + text2 + date1.date1 + text3 + time.time;
        Spannable spannable = new SpannableString(text4);
        spannable.setSpan(new RelativeSizeSpan(1.1f), 16, 45, SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(new RelativeSizeSpan(1.1f), 62, 70, SPAN_INCLUSIVE_INCLUSIVE);
        spannable.setSpan(new RelativeSizeSpan(1.1f), 73, 79, SPAN_INCLUSIVE_INCLUSIVE);
        textView1.setText(spannable, TextView.BufferType.SPANNABLE);
    }
}