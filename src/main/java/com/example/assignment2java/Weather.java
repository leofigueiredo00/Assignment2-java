package com.example.assignment2java;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    public static class Main {
        @SerializedName("temp")
        private double temp;

        @SerializedName("pressure")
        private int pressure;

        @SerializedName("humidity")
        private int humidity;

        public double getTemp() {
            return temp;
        }

        public int getPressure() {
            return pressure;
        }

        public int getHumidity() {
            return humidity;
        }
    }
}
