package team_11h56m.letsdigin.dto;

import jakarta.persistence.Id;

public class FoodDTO {
    public static class foodDTO {
        @Id
        private String date;
        private String food1;
        private String food2;
        private String food3;
        private double calorie1;
        private double calorie2;
        private double calorie3;

        public void setDate(String date) {
            this.date = date;
        }

        public String getDate() {
            return date;
        }

        public String getFood1() {
            return food1;
        }

        public void setFood1(String food1) {
            this.food1 = food1;
        }

        public String getFood2() {
            return food2;
        }

        public void setFood2(String food2) {
            this.food2 = food2;
        }

        public String getFood3() {
            return food3;
        }

        public void setFood3(String food3) {
            this.food3 = food3;
        }

        public double getCalorie1() {
            return calorie1;
        }

        public void setCalorie1(double calorie1) {
            this.calorie1 = calorie1;
        }

        public double getCalorie2() {
            return calorie2;
        }

        public void setCalorie2(double calorie2) {
            this.calorie2 = calorie2;
        }

        public double getCalorie3() {
            return calorie3;
        }

        public void setCalorie3(double calorie3) {
            this.calorie3 = calorie3;
        }

    }
}
