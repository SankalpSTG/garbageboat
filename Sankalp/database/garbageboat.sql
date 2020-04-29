-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2020 at 08:45 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
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
-- Table structure for table `admin_credentials`
--

CREATE TABLE `admin_credentials` (
  `serial_id` int(11) NOT NULL,
  `email_address` varchar(50) NOT NULL,
  `password` text NOT NULL,
  `admin_type` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin_credentials`
--

INSERT INTO `admin_credentials` (`serial_id`, `email_address`, `password`, `admin_type`) VALUES
(1, 'sankalppolk123@gmail.com', '$2y$10$UipHMffeHkxjMM.lAH2oSunUfEPOdrpKkMeyuvRRGMx7gzM9M.q1q', NULL),
(2, 'pallavikamble264@gmail.com', '$2y$10$UWeEeDEihnxaS0twXaWDoeB1rdGj225N6QijiixS0w8pWt8xx7nEu', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `credentials`
--

CREATE TABLE `credentials` (
  `serial_id` bigint(20) NOT NULL,
  `email_id` varchar(50) NOT NULL,
  `mobile_no` int(10) NOT NULL,
  `account_level` tinyint(4) NOT NULL DEFAULT 0,
  `verification_level` tinyint(4) NOT NULL DEFAULT 0,
  `token` text DEFAULT NULL,
  `token_key` varchar(20) DEFAULT NULL,
  `token_iv` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
-- Table structure for table `maintenance_schedules`
--

CREATE TABLE `maintenance_schedules` (
  `serial_id` bigint(20) NOT NULL,
  `day` tinyint(4) NOT NULL,
  `month` tinyint(4) NOT NULL,
  `year` tinyint(4) NOT NULL,
  `boat_id` bigint(20) NOT NULL,
  `maintenance_costs` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `projects`
--

CREATE TABLE `projects` (
  `serial_id` bigint(20) NOT NULL,
  `credential_id` bigint(20) NOT NULL,
  `project_name` varchar(25) NOT NULL,
  `project_description` varchar(200) NOT NULL,
  `location_lat` text NOT NULL,
  `location_lng` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `running_numbers`
--

CREATE TABLE `running_numbers` (
  `serial_id` bigint(20) NOT NULL,
  `keyname` varchar(30) NOT NULL,
  `running_number` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `running_numbers`
--

INSERT INTO `running_numbers` (`serial_id`, `keyname`, `running_number`) VALUES
(3, 'random_images', 1000),
(4, 'profile_images', 1019),
(5, 'other_images', 1000);

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

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `serial_id` bigint(20) NOT NULL,
  `company_name` varchar(50) NOT NULL,
  `logo_url` text DEFAULT NULL,
  `pincode` int(11) NOT NULL,
  `address` varchar(255) NOT NULL,
  `location_lat` text DEFAULT NULL,
  `location_lng` text DEFAULT NULL,
  `credential_id` bigint(20) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_credentials`
--
ALTER TABLE `admin_credentials`
  ADD PRIMARY KEY (`serial_id`),
  ADD UNIQUE KEY `email_address` (`email_address`);

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
-- Indexes for table `maintenance_schedules`
--
ALTER TABLE `maintenance_schedules`
  ADD PRIMARY KEY (`serial_id`);

--
-- Indexes for table `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`serial_id`);

--
-- Indexes for table `running_numbers`
--
ALTER TABLE `running_numbers`
  ADD PRIMARY KEY (`serial_id`),
  ADD UNIQUE KEY `keyname` (`keyname`);

--
-- Indexes for table `testtable`
--
ALTER TABLE `testtable`
  ADD PRIMARY KEY (`serial_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`serial_id`),
  ADD UNIQUE KEY `credential_id` (`credential_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin_credentials`
--
ALTER TABLE `admin_credentials`
  MODIFY `serial_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `credentials`
--
ALTER TABLE `credentials`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `latencytest`
--
ALTER TABLE `latencytest`
  MODIFY `testid` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `maintenance_schedules`
--
ALTER TABLE `maintenance_schedules`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `projects`
--
ALTER TABLE `projects`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `running_numbers`
--
ALTER TABLE `running_numbers`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `testtable`
--
ALTER TABLE `testtable`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
