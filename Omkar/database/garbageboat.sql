-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 01, 2020 at 08:35 PM
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

--
-- Dumping data for table `credentials`
--

INSERT INTO `credentials` (`serial_id`, `email_id`, `mobile_no`, `account_level`, `verification_level`, `token`, `token_key`, `token_iv`) VALUES
(1, 'KxUGYCOzkN@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(2, 'B6dWnZvH2T@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(3, 'JLmfTCAH4G@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(4, 'yL1CB1iPGl@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(5, 'MvKN2UnwAi@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(6, 'BsPoUHO0Oh@email.com', 1606338024, 0, 0, NULL, NULL, NULL),
(7, 'rkZFdNarig@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(8, '55zOXoFy3U@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(9, 'q5WUAGKebL@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(10, 'pjT3sUM7S3@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(11, 'eFUCgJ0RSm@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(12, 'FapbYxRkjH@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(13, 'DZNQrFIAyE@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(14, 'dpvdwFHEwp@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(15, 'vdfCq8AhXN@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(16, 'rQvtQbA38Z@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(17, 'zOIpjnuPHI@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(18, '05LheMcuUg@email.com', 642569424, 0, 0, NULL, NULL, NULL),
(19, '820BOQK7rw@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(20, 'Ud3y97USXk@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(21, 'eAeNnK7Srp@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(22, 'DNmP6HTFNY@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(23, '6m9Ti4Zsni@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(24, 'GkXTp7GziS@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(25, '1S2K6OxUiM@email.com', 1459718492, 0, 0, NULL, NULL, NULL),
(26, 'MSUi2xo8s0@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(27, 'r9uGhJDU4m@email.com', 1499910432, 0, 0, NULL, NULL, NULL),
(28, 'ajNbxPK44T@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(29, 'VRxHqejzBK@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(30, 'L1x5WImxQn@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(31, 'OrAQiqgwEi@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(32, 'ze4Tluadwp@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(33, 'TIDqqaMVZo@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(34, 'Sw0olsc6MH@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(35, 'GC1rqZObVw@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(36, 'DHu64Ovcx1@email.com', 1475464575, 0, 0, NULL, NULL, NULL),
(37, 'Z4ws8QsS59@email.com', 1251564669, 0, 0, NULL, NULL, NULL),
(38, 'zaqquLO7rN@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(39, 'ZmBcWYmmtk@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(40, 'okl1I0sFch@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(41, '2UZ1AfowDh@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(42, 'Goudoa6tDV@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(43, 'RnkXfsri4G@email.com', 1710744148, 0, 0, NULL, NULL, NULL),
(44, '4fyEcZjCct@email.com', 1720453564, 0, 0, NULL, NULL, NULL),
(45, 'uHNExrpXia@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(46, 'mjc8HmLTOi@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(47, 'Kqq247Y2Yf@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(48, 'X4hHP3sLJb@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(49, 'OPnQ5oF6Hx@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(50, 'Wyn5NkcDov@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(51, 'ShJoTPD4hX@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(52, 'XpRlOBL0Br@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(53, 'S4ZKcDmPM1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(54, 'u8QzPQzaiz@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(55, 'BDsoakBDB3@email.com', 2078339867, 0, 0, NULL, NULL, NULL),
(56, 'pWzEi0vWGv@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(57, 'VX3b1DCRBQ@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(58, '9YDASrpocC@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(59, 'ZRYCIBhJKy@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(60, 'RP5GbK2RSx@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(61, '5ZhBkvDBGF@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(62, 'DbQ1QFv2wd@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(63, '4w8XKjsxYm@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(64, 'j8ze5DCDi0@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(65, 'fw6eYmY9Si@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(66, 'DIyk3E4nY0@email.com', 1461477047, 0, 0, NULL, NULL, NULL),
(67, '5YvQc4NAEz@email.com', 609658509, 0, 0, NULL, NULL, NULL),
(68, 'pnQJ0OlZys@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(69, 'XxGnLGpkFm@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(70, 'aPR4OUUHXS@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(71, 'lkGa22K8ud@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(72, 'etfrs1ixVR@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(73, 'oUcouDAvIw@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(74, '8z4XSJjfYY@email.com', 1034115320, 0, 0, NULL, NULL, NULL),
(75, '787kkmhhBu@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(76, 'fOCbKoUSKW@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(77, 'WLmMs0hbWM@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(78, 'PLLCxcj6gT@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(79, 'wNKxvGc2F3@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(80, 'ou51TnVj4G@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(81, 'tOiolDUylU@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(82, 'iLJQ8Y8aRA@email.com', 1080099514, 0, 0, NULL, NULL, NULL),
(83, 'Aluzy8hVQA@email.com', 1906771613, 0, 0, NULL, NULL, NULL),
(84, '7DDWUR6Tj9@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(85, 'Ynl9N9ZoCZ@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(86, 'fOULwwsS8N@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(87, 'OUXFtuT152@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(88, 'QN8qSZWRPU@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(89, 'aArQP4WTHW@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(90, '4a8QyspOIA@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(91, 'ovmdnINcH8@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(92, 'PID0ELE9xF@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(93, '1MBUkfaeVY@email.com', 1182292444, 0, 0, NULL, NULL, NULL),
(94, 'AyEYovDPR6@email.com', 368682001, 0, 0, NULL, NULL, NULL),
(95, 'Id2ZSQy74R@email.com', 1400900086, 0, 0, NULL, NULL, NULL),
(96, 'htacNOWFkW@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(97, 'ROeEuNElEH@email.com', 204263311, 0, 0, NULL, NULL, NULL),
(98, 'WbMllwcVrV@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(99, 'tYmmtRnpQF@email.com', 843101509, 0, 0, NULL, NULL, NULL),
(100, 'KntXIucajK@email.com', 359914332, 0, 0, NULL, NULL, NULL),
(101, 'kJHSORs4vL@email.com', 2147483647, 0, 0, NULL, NULL, NULL);

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
-- Dumping data for table `users`
--

INSERT INTO `users` (`serial_id`, `company_name`, `logo_url`, `pincode`, `address`, `location_lat`, `location_lng`, `credential_id`, `password`) VALUES
(1, 'B56egWl', NULL, 942909, 'CtNbnU0sYm8l', NULL, NULL, 1, '$2y$10$sXiAjavJIteoGMrFSqovmO.OOvfBQSP3hTCEYtukjPtcoPf9XFl.O'),
(2, 'FPp7r75', NULL, 989926, 'PK5NYIUzsmh0', NULL, NULL, 2, '$2y$10$Dfd23/pZTM8IOEXpmMlJU.TnXB0BFBYfABhqMxR2zLrWOkBeVGwFq'),
(3, 'uAg0ebi', NULL, 633209, 'ZrqaQwOCmvv3', NULL, NULL, 3, '$2y$10$/jo1Del9Wx1VGsWQvsOHEOPQFl/ruYbeDbki1102T3ADB4ApkOXqq'),
(4, 'l75LQ0C', NULL, 190146, 'aZufQAh4XSmB', NULL, NULL, 4, '$2y$10$aij0pMxHrq9w/fy6ZpODQOtAdgZKts75CuUQqc0vqDh3ap6dls1Jy'),
(5, 'myOCywG', NULL, 955626, '9tdTSNBqUKpw', NULL, NULL, 5, '$2y$10$5q2ISQvLbg3yw608FLX3o.UwfC/1kw292p1S5VFP1ammSmxxfrc5.'),
(6, 'sJxtwO5', NULL, 813178, '7eKAIAcpL1Ja', NULL, NULL, 6, '$2y$10$O0ZdSrx7dTcePCfo97jQpOBYNq.0hJbZzRNlabyRgJxjVlHv5aZ7a'),
(7, 'uSdzK2v', NULL, 687095, 'Tv3UKwZ1INkB', NULL, NULL, 7, '$2y$10$AFqiyUaFFVHXd4NVvgKX/..LNll1Gz/8NTz7HJcF.TSDpezpSHsI.'),
(8, 'TS1wrT9', NULL, 42525, '3we41J5H6s8G', NULL, NULL, 8, '$2y$10$O8RHC6eaRGqWOas1xQFbQO/BdncWaXZF9MDIKt3UtXQkNokPk6JMq'),
(9, 'CBIqf4V', NULL, 88409, '4RMrxCh9fdyf', NULL, NULL, 9, '$2y$10$vekl9btXgRtZmWAAIVi50eDtZIRGsghgOPEA3XwcbIgPVfeM9lFP2'),
(10, 'cuUrtay', NULL, 375859, 'e6ROUBVmrNrH', NULL, NULL, 10, '$2y$10$dtp5xORGLHRt0ppSk6fC9eZ4nIZyV7QUMWvSSuayBaJXs0sypHctG'),
(11, 'ywekRy4', NULL, 983113, 'jK12dYpC8YXA', NULL, NULL, 11, '$2y$10$vW2fDMRzXSOc9Dpm8tguDeLOOrp0VkjzcVMBGHTS2gvlyR8aZTUX6'),
(12, 'a6sNfym', NULL, 250569, 'NxRdOvvVJYDb', NULL, NULL, 12, '$2y$10$5KOR6/I5qqDM.qtW2cYtresMWAo9omJ9urnsu1IumT7do.BlR6rWi'),
(13, 'HoLxiti', NULL, 689532, 'Wxi9Pk1iosmf', NULL, NULL, 13, '$2y$10$cjN2.C6qydnhe1PuogvMUuCgFMWLp7j/pwgzjp7h0YqFVt2J.suKG'),
(14, 'XwjqVqo', NULL, 248521, 'HY4fk4x8WrOM', NULL, NULL, 14, '$2y$10$iscZ7vKuUyL2DrHgAptJsewwc5yni/Z1GrkS2umDp/P9Ln5VZDK0O'),
(15, 'cPsXkV7', NULL, 690577, 'z3CobAhVveJM', NULL, NULL, 15, '$2y$10$MDPL55/ZeLW9xT4ffklGfOoT8lhIGaLMMPXbFgFvCMqeDh/2m0iZS'),
(16, 'lTOWNVo', NULL, 740636, 'GTOGEAZQ7OzX', NULL, NULL, 16, '$2y$10$N8BiDs9tcBnkxbDlVX2YxOTmZeadnVTKI65we10zpmWOdMQzlMOTS'),
(17, 'aVXsXhF', NULL, 744852, 'Riv9sP0pu9Pz', NULL, NULL, 17, '$2y$10$KI33oO6pSmfTwFnLcrEAPOkJBkBaJkzzexwdfoYgeXGNMKa4VvpXC'),
(18, 've1z7dn', NULL, 239370, 's3i2Grep3bUR', NULL, NULL, 18, '$2y$10$7iDFOCrD6MoLXBj2RGVtxORT6jzwu6aMZOib1Q5AfeW68zEsjwHna'),
(19, 'PuipSOM', NULL, 850797, 'H6YXnNmSYwEz', NULL, NULL, 19, '$2y$10$A0KLA.gV.nXtOoHdE29FwOFi1zu1kv/SWyZrP/cmfAL9TMMhBFb.a'),
(20, 'LWvaUHC', NULL, 224999, '1bXzofg65sbO', NULL, NULL, 20, '$2y$10$.t//F4SqLZeX/IR1G.dqduvYZs/A/ejR0WMIlEWf3DUluuXgx8zE2'),
(21, 'l1USpl6', NULL, 321192, 'lUjAZetcToFr', NULL, NULL, 21, '$2y$10$ruVBdruGBQWOXXrrUnehweFff.gJYrgb9Ev342ZMdKdeO7lt8ncGe'),
(22, 'bvIOgme', NULL, 425275, 'rXrt2Px4ZJ3c', NULL, NULL, 22, '$2y$10$TTraoUsd72a4repafAo1LuboMVdPIauPRwTHbwO2TJzVDg1cTUiHe'),
(23, '6br2s7M', NULL, 610946, 'Fhap916k2Ete', NULL, NULL, 23, '$2y$10$VN.Uq3C9mQp8ClHa8ERI/.5K.IlbBdUnwqBPIfhg2tNzQo1b/12Su'),
(24, 'fIsfwqT', NULL, 525050, 'PZf6pMvOKLgy', NULL, NULL, 24, '$2y$10$dlAOPRALfLfS5Ea9ArIVV.x2EgjcHJyaxqg0CaQv5CjweLHaRdDxq'),
(25, 'VFxcI0d', NULL, 58815, '6a9pEpFOIMhB', NULL, NULL, 25, '$2y$10$w.zFBm9icpu8KqheqZrsB.io4nYEXaghhq9ncYi2J8HFfE61yFP.e'),
(26, 'r8ZByqQ', NULL, 578542, 'XynvTqBIlD3o', NULL, NULL, 26, '$2y$10$sWtC1yqnA.5f51aRwBOD4.qFcTyR9PwY0wMfsGx7T.pvt55bis4Sm'),
(27, 'jD2nLjk', NULL, 68268, 'NGGKAEwO0Ac0', NULL, NULL, 27, '$2y$10$VAswU5NL425Mw1/ZtHzwxe1j0Zj2QBOUoa3xnjrMx0OL61vtaqecy'),
(28, 'vGzpWxf', NULL, 323890, 'ndbFBjrRms83', NULL, NULL, 28, '$2y$10$Xp.XGGvmSMOQUTF.5sKoPuFLjaiP9gx4Y/0Ji4ktjCtpmvptfoKXO'),
(29, '93H8yJg', NULL, 738259, '6HiE5MOaxD4A', NULL, NULL, 29, '$2y$10$SbJg9QfgOyY8LYK9YuhL4eVh75yAoIUDXztFXFP9Si6fpKGbosQZ2'),
(30, 'LcAFbfK', NULL, 420496, 'DBEblJWpwqLU', NULL, NULL, 30, '$2y$10$3de7x0At0J59ca8AQUhanuNf5fO8AI4c/d0Kj4izDGzNzAwDGnVpW'),
(31, 'je8dwZ2', NULL, 533495, 'jDC0PSogptek', NULL, NULL, 31, '$2y$10$ZjYQFzzbiQXJEZkNjtHeVeVLo1oTp.cK./akeRGLgHkuIcGOT23jS'),
(32, 'lXhDske', NULL, 130184, 'ORogiHNpvssU', NULL, NULL, 32, '$2y$10$R3P/6Z1.KFcTa3SajMzij.zDxDk6v9xMCodF7ujE3vxkXUvZvGgku'),
(33, 'bMg7Gep', NULL, 818109, 'ZJP0XLyvZoXc', NULL, NULL, 33, '$2y$10$Vssu6m/cXWDYXlUL/C0vbO7GH5yRUodZcvZOQ74eZqzxHWmPqepHu'),
(34, 'iK8NYhV', NULL, 751968, 'gT7J1XcQe2vb', NULL, NULL, 34, '$2y$10$jsJ6ONYqsYhERErXlkc6weqJavsbhqa7jrUu9evUuszvlMtHJ7JVe'),
(35, '01WBCVu', NULL, 896203, 'EcXM954r3iYf', NULL, NULL, 35, '$2y$10$Ivnl9pt6rR1CavBxzXG3QeZkmGPLgZHS7wRZf0x4zv91yGMM8Xm5O'),
(36, 'dD53DaQ', NULL, 890297, 'zp7L5A3cdLdR', NULL, NULL, 36, '$2y$10$i73EPhliNE0s7lRBupMpbOiizmH7aK2s0soqwXAYXlHe9khquF9cW'),
(37, 'VyV59Gm', NULL, 556864, 'BZOfWZXppLDK', NULL, NULL, 37, '$2y$10$3MT5n1bwK3qiyaX7AAlGJuux2W5/bWjGLMqtYHRv6tz6eGmd6LNhi'),
(38, 'AuqZBr3', NULL, 217801, '3bkcOrPkqUSH', NULL, NULL, 38, '$2y$10$IUO2XfP0rU/5q9Z6XFUlP.3Dcr/II1ICPtoS3mm93cPgaRhyePLdC'),
(39, '2UytVsQ', NULL, 849686, 'LFJJPq2ONvk7', NULL, NULL, 39, '$2y$10$lLncTOdh9qBFWi7y2JVKxOXKHo9Ifc2TnjajeRrUZKgBYr9e9EnRS'),
(40, 'Pb5uxSo', NULL, 159442, 'LGgJ0QOxO0hE', NULL, NULL, 40, '$2y$10$Ke80xB0lP17t3UimBh/U1eTQ6RPk5PnAlpmq/ow/ZEWaGDgAkRHTe'),
(41, 'ZUgU8RT', NULL, 639143, 'UJQIs9l17BEu', NULL, NULL, 41, '$2y$10$iZyG2MMjmV8TaktWWV05cuwHcosgOVgGbhl3Jb1FcEbE.Xx6adYH.'),
(42, 'RfuRdBz', NULL, 215627, 'RuAtrAgAWbbl', NULL, NULL, 42, '$2y$10$jU8prGI9wFn299XOMWTCQO5rchiXmOj7YoIrLGLB7uRWwz9KM5Qx6'),
(43, 'uhwwTd5', NULL, 37288, 'hm8UB3g0aapE', NULL, NULL, 43, '$2y$10$VN.tnKFgGasaYwBW/gk3OeSBkY16mzSCOVQSVxHjOHaZy2OExFz0e'),
(44, 'ai0zRl8', NULL, 541402, '0UY4bDWe8xbx', NULL, NULL, 44, '$2y$10$8Vj0T4TyDJMvUhFKwNgnHO4TuWkO4/70IwxA1uKb28.x9f8pmsv4y'),
(45, 'uWMYW68', NULL, 360405, 'Ujrn2HVsDhNM', NULL, NULL, 45, '$2y$10$RM7i253sPSMDgPio1Icpz.2ip2U8xMEkfDZ2uJ48rDqgXOcIf7CHC'),
(46, 'h41Yep8', NULL, 73324, 'dipqTpMcZdz4', NULL, NULL, 46, '$2y$10$Y1EtYE0OcMKF3qwhWVATh.Focj8IUYqNzcvlD3ysunF7BpIVKbmGO'),
(47, '8GwtQIc', NULL, 452657, 'WdUvPTZ5x2wa', NULL, NULL, 47, '$2y$10$c5jb4y03e5jblVqE3zPveOLIq4HY.lftCgE/H1dz19ujHbwUXdpQW'),
(48, 'gLIa3LM', NULL, 201217, '9zdgiLkDbiRW', NULL, NULL, 48, '$2y$10$1anO5n1iBOFy6A2ZJtvFTOXUI7rc0CbEMrGGuKqGQWtYEKNBRvHdu'),
(49, 'RVIUmmn', NULL, 494198, 'xhQ44tSSHbT1', NULL, NULL, 49, '$2y$10$5iDx02MAO3I3EJWSspwgFuO0A6YZY2oBIXoQ1B6RvGtg6MPsiF3Cu'),
(50, 'tMuAthk', NULL, 251184, 'eBcSFm7GZbc7', NULL, NULL, 50, '$2y$10$oMbnGbDBoxRUMkYT0blwrOjAuuWpdKD0VI6j2OrJJPUxSaq3llqbO'),
(51, 'KbIm4GT', NULL, 332624, 'WDaJtzn5Kd8S', NULL, NULL, 51, '$2y$10$kuda03lDnovL1j4dfpbcB.jElcCv0njHuko0nJGSYCbw04nChllH6'),
(52, '1mJG0C5', NULL, 590773, 'ILPOwK48LNZI', NULL, NULL, 52, '$2y$10$b73daY7OnTMwsRTQ1xa5IO3A8.vgmiBecomOo5LIsg/35/gWwYzTi'),
(53, 'IXj3xAL', NULL, 190273, 'DnbzRo32FYam', NULL, NULL, 53, '$2y$10$uyUPDuh6RLYC/YuO0Gn.peVmXBK9/Iq0j1kYDWEe/EQUncSKfl0gy'),
(54, '0jNBtMw', NULL, 871825, '1vxs6sDbNvbu', NULL, NULL, 54, '$2y$10$zhEYU9BKlSb02Ay98oyL4uj4QRatMXU3TtLSYkDqxi98hDynDLuQS'),
(55, 'YsinKev', NULL, 444779, 'DWCzRA60NbVh', NULL, NULL, 55, '$2y$10$u2wK9PSxm3a9mwkECYxCkuVGRafwN45lzZuYOD6PrcGEz/.Rz9Rvq'),
(56, 'xlzE0lr', NULL, 228947, 'RrVNhHSH322F', NULL, NULL, 56, '$2y$10$6XN03nc6.x/wBvBHFU/QqudBOANpSX4F28Sr8now4nIupIxT6xUui'),
(57, 'uK8D6Dm', NULL, 808128, 'V3pvoJ0xgk1Y', NULL, NULL, 57, '$2y$10$Yg/SpRelnviECAHFFPla8unNa9iXrffAG4.K9FnXT3MRM0jyabu96'),
(58, '5L4qnrD', NULL, 94123, 'dK4C09AYaiFP', NULL, NULL, 58, '$2y$10$BjQ.l2NCLmd0myEfJ6Qbm.Z4Jo9EFB7CDdv0eXY0baBED.dRFURkG'),
(59, 'PULVWaf', NULL, 288548, 'lu767ZuA0pL2', NULL, NULL, 59, '$2y$10$4xrOUIA.T.yGQnrX3wMAoez4XVrTXzILcxbSgh0IbsTfmT/zNoQzO'),
(60, '0oKFAJ6', NULL, 5052, 'xedGfJbEk0l3', NULL, NULL, 60, '$2y$10$Iyp56n8pqo7vNc5eljINqeszWP/jt9hokAuuspktnEsaJSgQ8pow2'),
(61, 'OQAHY4h', NULL, 154434, 'YvHdZwnu0tlL', NULL, NULL, 61, '$2y$10$NObaMZ0qt5RXeSkVRqB/Uu7ceWCKxJuUHnsEV/kxbkJkg213uzpsa'),
(62, 'RKGo2Dl', NULL, 352100, '3Y0nT0B1LNlX', NULL, NULL, 62, '$2y$10$uC804dHk7yONXFb9oAFqPeRCbhJ3B4MH92c9AkB8BqNkRB75YSWy2'),
(63, '2fiDcbM', NULL, 226164, 'ulAB0kvDZJFN', NULL, NULL, 63, '$2y$10$z7buPpZs0WIOlMNkne3gqOFf7cVM1V3JmXxz9AmXy4iyUbGQLOAzm'),
(64, 'gGbfl0B', NULL, 603770, 'xgYGqec9Z67O', NULL, NULL, 64, '$2y$10$jiLmALb41AtlyeM4aebIeusLRfVuyb8RwG8Ts2bf8nSsQycSHmF.G'),
(65, 'bJK0uBN', NULL, 672857, 'MRTy1WKQ1BLe', NULL, NULL, 65, '$2y$10$kYLkUPjB1PjvEWClOc3.v.06hYrx31/0ph6rXkEEusPA.0eW1/WDq'),
(66, '5eiN3hd', NULL, 57096, 'K0gZqbDtmUVA', NULL, NULL, 66, '$2y$10$rfIyOqnlxNCfIktIbRGbWuLV2whUw30Wbj0Zcdh6665kiJedv3Kom'),
(67, '9fHDodR', NULL, 59194, '0NlHfBS9mPey', NULL, NULL, 67, '$2y$10$ox37UIzoxVKGuEzB4N3JtuJsuLaXQN5jHvZb1TaukGKPn81iMhWQy'),
(68, 'xq2WgyQ', NULL, 682109, '9FCu01ZZzXli', NULL, NULL, 68, '$2y$10$35x0Yk0ybNpojVBsy.Xvaubo1PnC8zvftCIRGz1E74O9Gd.h9J16.'),
(69, '2hRmqYE', NULL, 957048, 't0KXaIzx3CVR', NULL, NULL, 69, '$2y$10$qssVx3Hxj6SYmqPL7JnhnOQ9vv0H88C2Y3IoeaSZtCPYdQiRnvDUS'),
(70, '5fEZJP4', NULL, 724006, 'ZxywSroCUPqS', NULL, NULL, 70, '$2y$10$.PTBo7wgOOE9u1odPVw4SeLdU0HfLQ4ptBBxhg4vfyHRtp2H5Lshu'),
(71, 'ycmBOGw', NULL, 796438, '612hqkDmMKLa', NULL, NULL, 71, '$2y$10$CarBRkmKIHhDEllIej7vx.0wRemBK8bVAF60a2iftd8H.DsPJLXm2'),
(72, 'B9HmiGw', NULL, 795254, 'rkJkeuBN0jVj', NULL, NULL, 72, '$2y$10$tAJmJ1zz3PcBc3cwM4DDBuGkatpZozN3t6IBs/FiHptUJS1hPNsrO'),
(73, 'yOHBh6j', NULL, 829772, 'sY6ay3L08GeJ', NULL, NULL, 73, '$2y$10$iq5b2RqwnYBoWqRo0vFQwux7n2i31IylNAweCBHZWR/.qdeAJUwvK'),
(74, 'igFu3Ab', NULL, 715701, 'BlbMS0yeN1mg', NULL, NULL, 74, '$2y$10$q2D6JEYwk3c6Wevhex9NwuwkZL7J6W3Upt1mzETWa.k11fAswMdgi'),
(75, 'BbsVfZP', NULL, 427557, 'uMAMCorvmwgH', NULL, NULL, 75, '$2y$10$l2ZCL5vb4AGK1rRSvn0Epu4xpG/QaBZznKwYUiWD9YSM3zXq7sMAy'),
(76, 'w69uQoX', NULL, 801219, 'CppsgrKOAIyy', NULL, NULL, 76, '$2y$10$LzMi5Hbr.9p31t.eJV13ZeIBtLLlat3TXSoo09gl1juXz0ztwVRSu'),
(77, 'tSQw9tZ', NULL, 266907, 'uf23CHgIpyn5', NULL, NULL, 77, '$2y$10$oam0R5jZtxyacbU2GWTjruGXytZPPs5Xd0n5ixPOy3.iTIFbggFd.'),
(78, 'xYSlPme', NULL, 314665, 'qi5iSV5cUdfy', NULL, NULL, 78, '$2y$10$CMdI3GtdONYt4gkcgl/YhOFNG.5tMaHuzay3SSlq9N6Bw/30ZFeNa'),
(79, 'A0EWXKX', NULL, 941116, 'OhSN67ZvdNBT', NULL, NULL, 79, '$2y$10$eYa36UMbL4qDw9xd3tJ2yO1ddKyocENUNmbpXejZtVIxIzI0iqxwW'),
(80, 'N0rwsHF', NULL, 702702, 'WkgjrdenCZ1V', NULL, NULL, 80, '$2y$10$.qu4qLpHjlGzAkpB/PJszernmZa0z/jVy9bWHjcoPAw9ItwtTUsLG'),
(81, 'RE9lTkS', NULL, 899554, 'qdnb4UOAABrL', NULL, NULL, 81, '$2y$10$BkaobBMQaEm8DoE0md8Lfu9jmCeNy4uJhy3ZfVkZ3nueUrxfQ4Vl6'),
(82, 'HWeQ7jN', NULL, 23593, 'ONfz8QKm1GbC', NULL, NULL, 82, '$2y$10$9yGR8nK1k3chKFwqYpmKPu6INdRpoYYFzeGn3vD5v18hEHU3zA4Fa'),
(83, 'e8kXKGv', NULL, 810179, 'JFsKrmpPGAY6', NULL, NULL, 83, '$2y$10$tzvmIV5HbKt2vfhN8cLpy./9.ffmrX9kP56GeJJOduUSD8trGo2cS'),
(84, 'I6puaal', NULL, 306587, 'NRKcVR6UMmhy', NULL, NULL, 84, '$2y$10$gpJDk0krsGPkeJsCAV2ZPeMzehUG6cLv4uN6/9TQnkHDDJmc3SZBu'),
(85, 'SE01Jjl', NULL, 473898, '1jHwxlhudc2g', NULL, NULL, 85, '$2y$10$ZyEslWKebDwQA9cmD5qVr./ytMW74GJKtriGL7BBmDTy2DBp6XwkO'),
(86, 'u2UCUNt', NULL, 929254, 'YOCm3VnYRhvN', NULL, NULL, 86, '$2y$10$988f.orVF6KKUGbTkXNx3.R4btF2tcNeUeYNB2suThBYbU6u5IHBy'),
(87, 'LAua4Uk', NULL, 374704, 'lhnnUcbsm0xi', NULL, NULL, 87, '$2y$10$KN16AalelVtxA5qEAztfxuuxNPvcJk/DT1jT3cKrfnZhis/ZoGcNi'),
(88, 'QCdDgUv', NULL, 794527, 'n1ncCRUdbE3d', NULL, NULL, 88, '$2y$10$oXOU2oijls94xYc14znOyOb5V2nVBFV3vG9Vf8UdoZ9lREWHQmGD.'),
(89, '8KF7hIF', NULL, 422204, 'KaBkFqjYgYv2', NULL, NULL, 89, '$2y$10$PfrJdQRXuKhWCq02c9OZ3uAFYdYXdE5d1Zhp7sO97Hqc66gA9k5Ry'),
(90, 'b15rDIy', NULL, 320854, 'kMHdudOxXt9U', NULL, NULL, 90, '$2y$10$PBwUrQAjucxT.NSPmA//8u.gnalXAL/cZ9y3AL1kc0yHUuFhVOnpm'),
(91, '8QWfmNt', NULL, 633580, 'aBYjusdD3cA0', NULL, NULL, 91, '$2y$10$C3UVLwKN2CvspCgTipvVd.MD7.V4BXxGJdQlM13fs2n8JzCJRXL2q'),
(92, 'phUHuaj', NULL, 913802, 'aZxvdoBP59rU', NULL, NULL, 92, '$2y$10$ZgvhC./ChwvfoX6..5Iwh.h0Cz9PvzIkU.id6aM3WyBEb91mcrS/y'),
(93, 'RRktJnE', NULL, 414496, 'd5ZPPWf1eesE', NULL, NULL, 93, '$2y$10$Kft4fmYhe9WuCkQ7Xg9l3ekNDn3pueFK7Y9EhxnSaG0Fc7e.hl8cW'),
(94, 'O7oK7Rk', NULL, 149706, 'CBAAnj1fS3xO', NULL, NULL, 94, '$2y$10$Hj9F.3ggsaXGbJ4SVai3iOJ5d1Fp/LG2VInP95RJ/ADDq3EQu3EQq'),
(95, 'FqQnaR5', NULL, 216962, 'L5VgxYBZdmTn', NULL, NULL, 95, '$2y$10$htdIFIZJHlptpYUpYnCF9OL3Yd5komQuMIaAxsGosnPcOoKlrnbxy'),
(96, 'Qi5nGv8', NULL, 486584, 'AMf2OePpQYtt', NULL, NULL, 96, '$2y$10$ybHGu5He7XLgkfdl2WcD5OEe9xUIKKi0yvH8raiBzrR2MJ1v/s32C'),
(97, 'Di74RDA', NULL, 376106, 'dzO95OMp9NiD', NULL, NULL, 97, '$2y$10$ATpWC0DGFwIv6DH8yRXI3O5ROfmvl0VtkceNKnTwTTySxDx1DpQLC'),
(98, 'lC1BnEL', NULL, 837145, 'dJT9No2umvvF', NULL, NULL, 98, '$2y$10$JRt4Ja5Qg/8CnAC6dIpMxejchdJFL918jmnqQ4g3PsrCdPA8jfbc2'),
(99, 'CyIFCeL', NULL, 36468, 'ZSkVaYNPA5U4', NULL, NULL, 99, '$2y$10$KoqrumPFmZWEYuyJZo07y.TEgZFtmzOTjL5MiFTSyYv5FZHLmrPcy'),
(100, 'XSIkZcb', NULL, 316401, 'tKBELRMnPm6m', NULL, NULL, 100, '$2y$10$P557F0Dt2adstZiAY2jgSe3G5bLTf4E2qxKCbpmraqWI8UX66mVqy'),
(101, 'BiOsox9', NULL, 467363, '2u4iaH6i8hnd', NULL, NULL, 101, '$2y$10$nRyev6nEaBXld0XkDqBzauHwXMTk.vRJjUOczavS24e0VSnaASsDO');

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
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

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
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
