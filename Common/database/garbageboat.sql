-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 23, 2020 at 12:11 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `garbageboat`
--

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE `credentials` (
  `serial_id` bigint(20) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_no` int(10) NOT NULL,
  `account_level` tinyint(4) NOT NULL DEFAULT '0',
  `verification_level` tinyint(4) NOT NULL DEFAULT '0',
  `token` text,
  `token_key` varchar(20) DEFAULT NULL,
  `token_iv` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `credentials`
--

INSERT INTO `credentials` (`serial_id`, `email_id`, `mobile_no`, `account_level`, `verification_level`, `token`, `token_key`, `token_iv`) VALUES
(1, 'omkar.prayag@gmail.com', 1234567890, 0, 0, NULL, NULL, NULL),
(2, 'sankalp.pol@gmail.com', 1234567890, 0, 0, NULL, NULL, NULL),
(3, 'rushi.kale@gmail.com', 1234567890, 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `latencytest`
--

CREATE TABLE `latencytest` (
  `testid` bigint(20) NOT NULL,
  `sendtime` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `latencytest`
--

INSERT INTO `latencytest` (`testid`, `sendtime`) VALUES
(1, 15432199);

-- --------------------------------------------------------

--
-- Table structure for table `testtable`
--

CREATE TABLE `testtable` (
  `serial_id` bigint(20) NOT NULL,
  `stringdata` text NOT NULL,
  `intdata` int(11) NOT NULL,
  `floatdata` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `testtable`
--

INSERT INTO `testtable` (`serial_id`, `stringdata`, `intdata`, `floatdata`) VALUES
(1, 'hello world', 500, 5.4),
(2, 'hello world', 500, 5.4),
(3, 'hello world', 500, 5.4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `credentials`
--
ALTER TABLE `credentials`
  ADD PRIMARY KEY (`serial_id`),
  ADD UNIQUE KEY `email_id` (`email_id`);

--
-- Indexes for table `latencytest`
--
ALTER TABLE `latencytest`
  ADD PRIMARY KEY (`testid`);

--
-- Indexes for table `testtable`
--
ALTER TABLE `testtable`
  ADD PRIMARY KEY (`serial_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `credentials`
--
ALTER TABLE `credentials`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `latencytest`
--
ALTER TABLE `latencytest`
  MODIFY `testid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `testtable`
--
ALTER TABLE `testtable`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
