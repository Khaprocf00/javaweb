-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for javaweb
CREATE DATABASE IF NOT EXISTS `javaweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `javaweb`;

-- Dumping structure for table javaweb.brand
CREATE TABLE IF NOT EXISTS `brand` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.brand: ~6 rows (approximately)
REPLACE INTO `brand` (`id`, `name`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'dio', NULL, NULL, NULL, NULL),
	(2, 'gucci', NULL, NULL, NULL, NULL),
	(3, 'adidas', NULL, NULL, NULL, NULL),
	(4, 'nice', NULL, NULL, NULL, NULL),
	(5, 'bitis', NULL, NULL, NULL, NULL),
	(7, 'dior', NULL, NULL, NULL, NULL),
	(13, 'diorr', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` date DEFAULT NULL,
  `modifieddate` date DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.category: ~5 rows (approximately)
REPLACE INTO `category` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'Women', 'women', '2023-09-20', '2023-09-20', 't', 't'),
	(2, 'Men', 'men', '2023-09-20', '2023-09-20', 't', 't'),
	(3, 'Footwear', 'footwear', '2023-09-20', '2023-09-20', 't', 't'),
	(4, 'Jewelry', 'jewelry', '2023-09-20', '2023-09-20', 't', 't'),
	(5, 'Lady', 'lady', '2023-09-20', '2023-09-20', 't', 't');

-- Dumping structure for table javaweb.color
CREATE TABLE IF NOT EXISTS `color` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.color: ~2 rows (approximately)
REPLACE INTO `color` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'Black', '#000', NULL, NULL, NULL, NULL),
	(2, 'White', '#ffff', NULL, NULL, NULL, NULL),
	(4, 'Pink', '#e83e8c', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.image
CREATE TABLE IF NOT EXISTS `image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `path` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_image_product` (`product_id`),
  CONSTRAINT `fk_image_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.image: ~0 rows (approximately)

-- Dumping structure for table javaweb.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qty` int DEFAULT '0',
  `price` double NOT NULL,
  `discount` double DEFAULT NULL,
  `category_id` bigint NOT NULL,
  `brand_id` bigint NOT NULL,
  `tag_id` bigint NOT NULL,
  `slider_id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  `shortdescription` varchar(255) NOT NULL,
  `sku` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_category` (`category_id`),
  KEY `fk_product_brand` (`brand_id`),
  KEY `fk_product_tag` (`tag_id`),
  KEY `fk_product_slider` (`slider_id`),
  CONSTRAINT `fk_product_brand` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  CONSTRAINT `fk_product_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `fk_product_slider` FOREIGN KEY (`slider_id`) REFERENCES `slider` (`id`),
  CONSTRAINT `fk_product_tag` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.product: ~10 rows (approximately)
REPLACE INTO `product` (`id`, `qty`, `price`, `discount`, `category_id`, `brand_id`, `tag_id`, `slider_id`, `name`, `shortdescription`, `sku`, `image_path`, `content`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 321, 20, 13, 1, 1, 1, 31, 'aos khoac', 'aos khoa event sieu cap', '0123', '25.png', '<p>hqweuhasiduahfbiasdbsadjasd</p>', NULL, NULL, NULL, NULL),
	(2, 3534, 123, 123, 2, 3, 2, 39, 'asdasd', '123', '123', '40.png', '<p>123123</p>', NULL, NULL, NULL, NULL),
	(3, 45, 100, 123, 2, 2, 2, 36, '2222', 'ádasas', '01232', '42.png', '<p>ádasdad</p>', NULL, NULL, NULL, NULL),
	(4, 123246, 123123, 123123, 1, 1, 1, 31, '123123', '123123', '123123', '32.png', '<p>123123</p>', NULL, NULL, NULL, NULL),
	(6, 333333333, 123123, 1123, 2, 1, 1, 40, '123123123123', '123213', '123123', '', '<p>ádasd</p>', NULL, NULL, NULL, NULL),
	(7, 0, 111, 111, 1, 1, 1, 40, '111111', '111', '111', '', '<p>111</p>', NULL, NULL, NULL, NULL),
	(8, 0, 222, 222, 1, 1, 3, 30, '222', '222', '222', 'not file', '<p>222</p>', NULL, NULL, NULL, NULL),
	(9, 0, 333, 333, 2, 2, 3, 27, '333', '3333', '333', '', '<p>3333</p>', NULL, NULL, NULL, NULL),
	(11, 0, 55, 55, 2, 1, 2, 27, '555', '55', '55', '', '<p>555</p>', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.product_detail
CREATE TABLE IF NOT EXISTS `product_detail` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `product_id` bigint NOT NULL,
  `color_id` bigint NOT NULL,
  `size_id` bigint NOT NULL,
  `qty` int NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_productdetail_size` (`size_id`),
  KEY `fk_productdetail_color` (`color_id`),
  KEY `fk_productdetail_product` (`product_id`),
  CONSTRAINT `fk_productdetail_color` FOREIGN KEY (`color_id`) REFERENCES `color` (`id`),
  CONSTRAINT `fk_productdetail_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_productdetail_size` FOREIGN KEY (`size_id`) REFERENCES `size` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.product_detail: ~9 rows (approximately)
REPLACE INTO `product_detail` (`id`, `product_id`, `color_id`, `size_id`, `qty`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 2, 1, 3, 30, NULL, NULL, NULL, NULL),
	(2, 3, 2, 4, 40, NULL, NULL, NULL, NULL),
	(3, 2, 1, 2, 3123, NULL, NULL, NULL, NULL),
	(4, 2, 4, 1, 123, NULL, NULL, NULL, NULL),
	(5, 4, 2, 1, 123123, NULL, NULL, NULL, NULL),
	(7, 4, 4, 2, 123, NULL, NULL, NULL, NULL),
	(9, 1, 4, 8, 321, NULL, NULL, NULL, NULL),
	(10, 3, 2, 3, 5, NULL, NULL, NULL, NULL),
	(11, 2, 1, 1, 12, NULL, NULL, NULL, NULL),
	(12, 2, 2, 1, 123, NULL, NULL, NULL, NULL),
	(13, 2, 4, 2, 123, NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.role: ~2 rows (approximately)
REPLACE INTO `role` (`id`, `name`, `code`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'user', 'user', NULL, NULL, NULL, NULL),
	(2, 'admin', 'admin', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.size
CREATE TABLE IF NOT EXISTS `size` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.size: ~7 rows (approximately)
REPLACE INTO `size` (`id`, `name`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'S', NULL, NULL, NULL, NULL),
	(2, 'M', NULL, NULL, NULL, NULL),
	(3, 'L', NULL, NULL, NULL, NULL),
	(4, 'XL', NULL, NULL, NULL, NULL),
	(5, 'XXL', NULL, NULL, NULL, NULL),
	(7, '36', NULL, NULL, NULL, NULL),
	(8, '37', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.slider
CREATE TABLE IF NOT EXISTS `slider` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `image` varchar(255) NOT NULL,
  `content` text NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.slider: ~12 rows (approximately)
REPLACE INTO `slider` (`id`, `name`, `image`, `content`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(26, 'asdasdasdasd', '31.png', '<p>sadasdasdasd</p>', NULL, NULL, 'khadz', NULL),
	(27, 'asdasdasd', '25.png', '<p>asdasdsad</p>', NULL, NULL, 'khadz', NULL),
	(28, 'Nguyễn Minh Kha', '1.png', '<p>asdasdasd</p>', NULL, NULL, 'khadz', NULL),
	(30, 'Nguyễn Minh Khasss', '41.png', '<p>asdasdasd</p>', NULL, NULL, 'khadz', NULL),
	(31, 'a', '1.png', '<p>asdasd</p>', NULL, NULL, 'khadz', NULL),
	(33, 'asdasd123', 'not file', '<p>asdasd</p>', NULL, NULL, 'khadz', NULL),
	(35, 'Nguyễn Minh Khaaasdss', '33.png', '<p>asdasd</p>', NULL, NULL, 'khadz', NULL),
	(36, 'aasdaa', 'tra_tao.jpg', '<p>asdasdasd</p>', NULL, NULL, 'khadz', NULL),
	(38, 'asdasdasdasasdadasdadas', 'poster-TN.png', '<p>asdasdasdsad</p>', NULL, NULL, 'khadz', NULL),
	(39, 'Nguyễn Minhasd asdasd ', '32.png', '<p>asdaasdasdasdasd</p>', NULL, NULL, 'khadz', 'khadzzz'),
	(40, 'Nguyễn Minhasdasd', '33.png', '<p>asdasdasd</p>', NULL, NULL, 'khadz', 'khadzzz'),
	(41, 'asdasdasdasdsadasd', 'tra_cam_dao.jpg', '<p>asdasdasd</p>', NULL, NULL, 'khadz', NULL);

-- Dumping structure for table javaweb.tag
CREATE TABLE IF NOT EXISTS `tag` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.tag: ~6 rows (approximately)
REPLACE INTO `tag` (`id`, `name`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'Clothing', NULL, NULL, NULL, NULL),
	(2, 'Jean', NULL, NULL, NULL, NULL),
	(3, 'Accessories', NULL, NULL, NULL, NULL),
	(4, 'Shoes', NULL, NULL, NULL, NULL),
	(5, 'HandBag', NULL, NULL, NULL, NULL);

-- Dumping structure for table javaweb.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `fullname` varchar(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_id` bigint NOT NULL,
  `status` int NOT NULL,
  `createddate` timestamp NULL DEFAULT NULL,
  `modifieddate` timestamp NULL DEFAULT NULL,
  `createdby` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `modifiedby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table javaweb.user: ~1 rows (approximately)
REPLACE INTO `user` (`id`, `email`, `fullname`, `username`, `password`, `role_id`, `status`, `createddate`, `modifieddate`, `createdby`, `modifiedby`) VALUES
	(1, 'kha@gmail.com', 'kha nguyen', 'kha', '123', 1, 1, '2023-09-29 10:40:47', '2023-09-29 10:40:48', NULL, NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
