-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 11, 2019 at 07:48 AM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `packersandmovers`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `serial_id` int(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `src_pin` int(255) NOT NULL,
  `dst_pin` int(255) NOT NULL,
  `src_add` varchar(255) NOT NULL,
  `dst_add` varchar(255) NOT NULL,
  `distance` int(255) NOT NULL,
  `truck_size` varchar(255) NOT NULL,
  `truck_cost` int(255) NOT NULL,
  `total_cost` int(255) NOT NULL,
  `day` int(255) NOT NULL,
  `month` int(255) NOT NULL,
  `year` int(255) NOT NULL,
  `hours` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`serial_id`, `email`, `src_pin`, `dst_pin`, `src_add`, `dst_add`, `distance`, `truck_size`, `truck_cost`, `total_cost`, `day`, `month`, `year`, `hours`) VALUES
(1, NULL, 410206, 431005, 'mumbai', 'aurangabad', 343, 'Medium(2 ton)', 2000, 8860, 8, 8, 1998, 22),
(2, NULL, 410206, 431005, 'mumbai', 'satara parisar', 10, 'XXXL(25 ton)', 20000, 22000, 4, 12, 2019, 22),
(3, 'sankalp@gmail.com', 410206, 431005, 'mumbai', 'aurangabad', 343, 'Large(4 ton)', 3000, 13290, 8, 8, 1998, 22);

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE `credentials` (
  `serial_id` bigint(255) NOT NULL,
  `email_id` varchar(255) NOT NULL,
  `password` text NOT NULL,
  `user_type` varchar(20) NOT NULL DEFAULT 'user',
  `status` varchar(20) NOT NULL DEFAULT 'unverified',
  `name` varchar(255) DEFAULT NULL,
  `mobile` int(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `pincode` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credentials`
--

INSERT INTO `credentials` (`serial_id`, `email_id`, `password`, `user_type`, `status`, `name`, `mobile`, `country`, `pincode`) VALUES
(1, 'omkar@gmail.com', '$2y$10$mDoXCg12Cj9VlJ5tuVCuSu6Yp3hYuOocWS1wpXxMAwM3AyZbnJX6K', 'admin', 'verified', NULL, NULL, NULL, NULL),
(2, 'nitesh@gmail.com', '$2y$10$gpoMUEe6zrtt4nC4KwNFYumaTr8eY75LTdtLXX1y7MakQ9na4NHoe', 'admin', 'verified', NULL, NULL, NULL, NULL),
(3, 'sankalp@gmail.com', '$2y$10$ZR4Cuwn0JT9FE1jO33FUvet0Fq/6LeP5eoPsVhQTnGmeGXcSzxr1C', 'admin', 'verified', NULL, NULL, NULL, NULL),
(4, 'ishwar@gmail.com', '$2y$10$UosF.xKixTqIROVq9wxDV.bbNHbIOlLw601xCJq5E9tpQiAh3L/jy', 'user', 'verified', NULL, NULL, NULL, NULL),
(5, 'hjfj@ojsfh.cdfj', 'dfouiaehf', 'user', 'unverified', 'adsda', 9479457, 'iafiaue', 59645),
(6, 'sakdf@fea56.f', 'jefae', 'user', 'unverified', 'afa', 96646, 'jhaf', 5634),
(7, 'wdafef@frg.g', 'dsadw', 'user', 'unverified', 'awdw', 68776, 'efwfew', 273);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`serial_id`);

--
-- Indexes for table `credentials`
--
ALTER TABLE `credentials`
  ADD PRIMARY KEY (`serial_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `serial_id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `credentials`
--
ALTER TABLE `credentials`
  MODIFY `serial_id` bigint(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
