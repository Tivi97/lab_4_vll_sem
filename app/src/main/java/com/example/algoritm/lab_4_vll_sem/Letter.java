package com.example.algoritm.lab_4_vll_sem;

/**
 * Created by Algoritm on 19.12.2017.
 */

public class Letter {
            private String name;
        // private String description;
        private int imageResourceId;

        public static final Letter[] letters = {
                new Letter("Aa", R.drawable.a50),

        };
        //Для каждого напитка хранится имя, описание и ресурс изображения
        private Letter(String name, /*String description,*/ int imageResourceId) {
            this.name = name;
            // this.description = description;
            this.imageResourceId = imageResourceId;
        }

        public String getName() {
            return name;
        }
        public int getImageResourceId() {
            return imageResourceId;
        }
        public String toString() {
            return this.name;
        }

}

