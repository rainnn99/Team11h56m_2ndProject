-- 데이터베이스 생성
drop table if exists letsdigin_test CASCADE;
CREATE SCHEMA letsdigin_test;

-- 음식 테이블
CREATE TABLE food (
    food_small_scale_classification VARCHAR(12) NOT NULL,
    food_no INT,
    food_large_scale_classification VARCHAR(9),
    food_medium_scale_classification VARCHAR(9),
    serving_size_g INT,
    calorie_g FLOAT,
    protein_g FLOAT,
    fat_g FLOAT,
    carbohydrate_g FLOAT,
    salt_mg FLOAT,
    PRIMARY KEY (food_small_scale_classification)
);

-- 고객 테이블
CREATE TABLE customer (
    id VARCHAR(10) NOT NULL,
    password VARCHAR(15),
    name VARCHAR(20),
    phone_number VARCHAR(20),
    coupon INT DEFAULT 0,
    roles VARCHAR(10) DEFAULT USER,
    PRIMARY KEY (id)
);

-- 비선호음식 테이블
CREATE TABLE dislike_food (
    customer_id VARCHAR(12),
    food_small_scale_classification VARCHAR(12),
    PRIMARY KEY (customer_id, food_small_scale_classification),
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (food_small_scale_classification) REFERENCES food(food_small_scale_classification)
);

-- 커뮤니티 테이블
CREATE TABLE community (
    serial_number INT AUTO_INCREMENT,
    customer_id VARCHAR(12),
    title TEXT,
    main_text TEXT,
    PRIMARY KEY (serial_number),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- 캘린더 테이블
CREATE TABLE calendar (
    user_id VARCHAR(12),
    eaten_day DATE,
    taken_food TEXT,
    eaten_time INT,
    PRIMARY KEY (user_id, eaten_day, eaten_time),
    UNIQUE (user_id, eaten_day, eaten_time)
);
