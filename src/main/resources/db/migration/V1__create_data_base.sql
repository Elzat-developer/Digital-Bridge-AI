CREATE TABLE IF NOT EXISTS `lessons` (
                                         `id` int auto_increment primary key,
                                         `lesson_name` varchar(255) DEFAULT NULL,
                                         `pazls_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `users` (
                                       `id` int auto_increment primary key,
                                       `authorities` enum('ADMIN','TEACHER','USER') DEFAULT NULL,
                                       `email` varchar(255) DEFAULT NULL,
                                       `name` varchar(255) DEFAULT NULL,
                                       `surname` varchar(255) DEFAULT NULL,
                                       `lastname` varchar(255) DEFAULT NULL,
                                       `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `levels` (
                                        `id` int auto_increment primary key
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `pazls` (
                                       `id` int auto_increment primary key,
                                       `pazl_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `translates` (
                                       `id` int auto_increment primary key,
                                       `exercise` varchar(255) DEFAULT NULL,
                                       `example` varchar(255) DEFAULT NULL,
                                       `result` varchar(255) DEFAULT NULL,
                                       `pazls_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `tests` (
                                       `id` int auto_increment primary key,
                                       `exercise` varchar(255) DEFAULT NULL,
                                       `example` varchar(255) DEFAULT NULL,
                                       `result` varchar(255) DEFAULT NULL,
                                       `pazls_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `audios` (
                                       `id` int auto_increment primary key,
                                       `audio_url` varchar(255) DEFAULT NULL,
                                       `example` varchar(255) DEFAULT NULL,
                                       `result` varchar(255) DEFAULT NULL,
                                       `pazls_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE IF NOT EXISTS `photos` (
                                       `id` int auto_increment primary key,
                                       `photo_url` varchar(255) DEFAULT NULL,
                                       `exercise` varchar(255) DEFAULT NULL,
                                       `example` varchar(255) DEFAULT NULL,
                                       `result` varchar(255) DEFAULT NULL,
                                       `pazls_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;