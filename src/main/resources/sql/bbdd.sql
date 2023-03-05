-- Host: localhost
-- Generation Time:
-- Server version:
-- PHP Version:


SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Empresa`
--
USE `Empresa`;

--
-- Drop tables if they already exist
--
DROP TABLE IF EXISTS `products`;

--
-- Table structure for table `products`
--
CREATE TABLE IF NOT EXISTS `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `products`
--
INSERT INTO `products` ( `name`, `price`) VALUES
( 'Lechugas', '3.42'),
( 'Tomates', '5.31'),
( 'Peras', '6.89');