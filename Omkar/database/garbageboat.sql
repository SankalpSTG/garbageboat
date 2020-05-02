-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 02, 2020 at 10:00 AM
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
-- Table structure for table `boats`
--

CREATE TABLE `boats` (
  `serial_id` bigint(20) NOT NULL,
  `pet_name` varchar(20) NOT NULL,
  `registration_number` bigint(20) NOT NULL,
  `type` varchar(10) NOT NULL,
  `credential_id` bigint(20) DEFAULT NULL,
  `simulator_device_id` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(34, 'sankikul@gmail.com', 2147483647, 1, 0, NULL, NULL, NULL),
(35, 'polskii@gmail.com', 2147483647, 0, 0, NULL, NULL, NULL),
(36, 'Q4dC1wAzxd@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(37, 'ddjIzihVtM@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(38, 'prWHqmgsTm@email.com', 1344290974, 0, 0, NULL, NULL, NULL),
(39, 'DBAEE5DoGL@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(40, 'cjfHV244EL@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(41, 'HtLTYKG3yR@email.com', 53841200, 0, 0, NULL, NULL, NULL),
(42, 'ScRfE1hPc4@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(43, '5YWMrWMogk@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(44, 'HVZQLwJKkG@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(45, 'zY233qDnPx@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(46, 'tGVLuy7m0K@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(47, 'HnkCSvm5Wb@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(48, 'WPh02RmxTX@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(49, 'YgOVPdWGsI@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(50, 'NMvWnlSeg0@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(51, 'Jge6yC8AVR@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(52, 'QJ3kBxgeIL@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(53, 's0MnWmRujH@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(54, '6sAG67hkcs@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(55, 'ELT0urZ5qR@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(56, '0vR3Uy68Ay@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(57, 'Bl0e9oDBNE@email.com', 951508086, 0, 0, NULL, NULL, NULL),
(58, 'z7KWbEdpHT@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(59, 'oJbDehAyCa@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(60, 'ibf3zft7Cj@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(61, 'pN1yeBCgn5@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(62, 'p4zc3hP2Gl@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(63, 'mjv86g8S9d@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(64, 'BAdzO5emM3@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(65, '8oN3FyZ9C1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(66, 'yJ2Yv6t14s@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(67, 'MZVxvO3CTC@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(68, 'Fabu7T0Ozm@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(69, 'crE66VKtmB@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(70, 'Z7EOzh3Vb6@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(71, 'EzkffHS3NH@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(72, 'gfSKJV8xBC@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(73, 'GtmY3SZQtc@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(74, 'bM7Fa1tdq1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(75, '2F2gxZMsd5@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(76, 'iHZcIEV2rS@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(77, 'ODr99lI6fS@email.com', 129235930, 0, 0, NULL, NULL, NULL),
(78, 'wuvXNAJsOH@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(79, 'Nh26PxJhm1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(80, 'cWDznyRTEA@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(81, 'gAAoAtUuHW@email.com', 218648293, 0, 0, NULL, NULL, NULL),
(82, 'vYyE9rHLIB@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(83, 'ADfs7jH7ha@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(84, '7oKJP3IorJ@email.com', 413041029, 0, 0, NULL, NULL, NULL),
(85, 'tjueopjlDd@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(86, 'DVW0EIObk9@email.com', 331019608, 0, 0, NULL, NULL, NULL),
(87, 'YuNsiSSWo1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(88, 'PefobkaSiz@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(89, '0u706kFyRj@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(90, '7KhG2t2dOe@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(91, 'aZ6iBsAeQ9@email.com', 1235893412, 0, 0, NULL, NULL, NULL),
(92, 'M6Dwznj4JM@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(93, 'pnwoI25bCD@email.com', 1544556103, 0, 0, NULL, NULL, NULL),
(94, 'D5Em1oHd6z@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(95, 'aFCtxzANIR@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(96, 'wyMzbda25K@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(97, 'xunqUCzRd4@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(98, 'PaO3W7CnIT@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(99, 'Vc3BUG7k3Q@email.com', 521015258, 0, 0, NULL, NULL, NULL),
(100, 'M9xLPISRv3@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(101, 'Q4MOCJ0f6D@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(102, 'q7YCWrfXav@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(103, 'bGS2T1MQPj@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(104, 'vWeJd47HTV@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(105, 'abwuOkPA1b@email.com', 69533556, 0, 0, NULL, NULL, NULL),
(106, '7bNcRPXYKS@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(107, 'wuqoUslFKP@email.com', 504185700, 0, 0, NULL, NULL, NULL),
(108, 'js5zDehwf4@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(109, 'lLjoQdugoC@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(110, '8hfSX9AD4Q@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(111, 'IxQwryDL7j@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(112, 'vfky3mNklG@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(113, 'BuPgfodVvg@email.com', 798934574, 0, 0, NULL, NULL, NULL),
(114, 'rOENNa6fJc@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(115, 'nx7gEUdtIX@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(116, 'g8Z5rnI4rl@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(117, 'UmL24HVtaP@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(118, '0D9TaSS9lP@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(119, 'tmr6R30KiK@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(120, 'eLUlhBmihh@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(121, '660XrfA1C8@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(122, 'gfBO3musZO@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(123, 'IC6V3o4nEY@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(124, 'khvFxxhau2@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(125, '6Qs0N8uodP@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(126, 'EKVirj6tO1@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(127, '8ZjRgbXofA@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(128, '90H5HdhzDd@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(129, 'vieNcJMrMd@email.com', 920532007, 0, 0, NULL, NULL, NULL),
(130, 'lUrJN7vhXQ@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(131, '6cbETDtZ2F@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(132, 'MdZdSKls5R@email.com', 600833907, 0, 0, NULL, NULL, NULL),
(133, 'xgrERURzcj@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(134, 'BorR3RSltL@email.com', 2147483647, 0, 0, NULL, NULL, NULL),
(135, '4bUWIq694q@email.com', 37902147, 0, 0, NULL, NULL, NULL),
(136, 'ef8dScJ04H@email.com', 2147483647, 0, 0, NULL, NULL, NULL);

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
-- Table structure for table `problems_submitted`
--

CREATE TABLE `problems_submitted` (
  `serial_id` bigint(20) NOT NULL,
  `credential_id` bigint(20) NOT NULL,
  `category` text NOT NULL,
  `problem` varchar(255) NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `problems_submitted`
--

INSERT INTO `problems_submitted` (`serial_id`, `credential_id`, `category`, `problem`, `description`) VALUES
(1, 1, 'suggestion', 'php', 'Don\\\'t ask silly doubts');

-- --------------------------------------------------------

--
-- Table structure for table `problem_solutions`
--

CREATE TABLE `problem_solutions` (
  `serial_id` bigint(20) NOT NULL,
  `problem_id` bigint(20) NOT NULL,
  `solution_header` varchar(255) NOT NULL,
  `solution_description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `problem_solutions`
--

INSERT INTO `problem_solutions` (`serial_id`, `problem_id`, `solution_header`, `solution_description`) VALUES
(1, 35, 'wnrfbvvbvjub', 'd;cmnjecendcnelconaec'),
(2, 35, 'wnrfbvvbvjub', 'd;cmnjecendcnelconaec'),
(3, 35, 'fkjwnjnvj', 'mcijici'),
(4, 35, 'ehdfuehwchwec', 'duheqcecb\\n\\nw'),
(5, 35, 'ehdfuehwchscanjsncjnwec', 'duhnducqich\\n\\nw'),
(6, 35, 'ehdfuehwchscanjsncjn,SCnacncnwec', 'duhnducqich SC Jbcj\\n\\nw'),
(7, 35, 'ehdfuehwchscanjsncjn,SCnacncnwec', 'mcsaca\\nw'),
(8, 35, 'CNJNSCJSANCJVC\\n', 'mcsaca\\nw'),
(9, 35, 'CNJNSCJx jNADC JNJC NSJCNSANCJVC\\n', 'x jx jscnJsnJnx\\nw');

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
  `location_lng` text NOT NULL,
  `is_anonymous` tinyint(1) NOT NULL DEFAULT 0
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
(4, 'profile_images', 1021),
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
(35, 'pompchomo', 'profilepic/1020.jpg', 666666, 'golululu', '19.026795006582017', '73.09539746493103', 34, '$2y$10$lE8A2dmxiNyJz786SdvmT.qF8Syq282.whR0qUG71uEj2sHlZ4owC'),
(36, 'polskii aviation', 'profilepic/1021.jpg', 400017, 'mumbai, Maharashtra, india', '19.037324358621944', '73.10208488255739', 35, '$2y$10$0aNaIcWt371o0jS/8xtD9eNJnIgXvPgUB.24G7NS3FShn1ObP89xy'),
(37, 'akyFXay', NULL, 802899, 'Bc1HtlRVlQHT', NULL, NULL, 36, '$2y$10$zc1/tDQ5iNgYiWr61zYxwOC5qAKxZlB8tD0z8vFD/SsSOTamZoEUe'),
(38, 'vzmoMNH', NULL, 512990, '8gCkPshhfsoE', NULL, NULL, 37, '$2y$10$3JDtxq2a60MFD.fy83gROu1WHorrMbp5mombd7PDzPAazLL5mMipS'),
(39, 'CJBUL2t', NULL, 477618, 'T7qkTmYDjqFY', NULL, NULL, 38, '$2y$10$0notD7QBaVeFINByydlHWuhCKk.0dF81rvITbucQD2fwzeJwGxyoa'),
(40, 'M2A4yXf', NULL, 935138, 'd5s3GWGcoPe4', NULL, NULL, 39, '$2y$10$SYJQ89nGrFPQ8Awwkf.yeePeq6z4WfTztY6RZ9.UGxk9i68cXLG9W'),
(41, 'OsDQsHM', NULL, 582303, 'v7OnXVd6Dcxv', NULL, NULL, 40, '$2y$10$xb4Lskl19xr/gRGEd0x1dOsm5lWTOq7X6HRASyIshxBFBZy51vBnW'),
(42, 'uvdIPGH', NULL, 114746, 'RM5ftl3dxTxW', NULL, NULL, 41, '$2y$10$rH8L97CsIoGFqB0mGn3KF.l00w/8bzvA1c1Pk/xtoz9AfIqulO4UC'),
(43, '7qZqJ76', NULL, 815383, 'Z7O5PEgNcfti', NULL, NULL, 42, '$2y$10$UfCzTD1sFqW1F3yONWw1luwYbjCJ2f3rJSgN9AFcMs5wSw3n69IHa'),
(44, 'oRhOCdH', NULL, 515662, 'm5QP0MWTi0k9', NULL, NULL, 43, '$2y$10$4d7kJfmN53LVW.WqpBOBc.AjEXc2kbanMR5.AYtnDpc6EQasmU/kq'),
(45, 'ddAKnEo', NULL, 927476, 'AjCp5KyWuqaq', NULL, NULL, 44, '$2y$10$VgqeWtc6yLuweTW60.l54.vdEs4j82R2A56Pqyw/1blJjzPiXfmEe'),
(46, 'p1QPDn5', NULL, 871892, 'rEl17mbQ3Awy', NULL, NULL, 45, '$2y$10$pngP7ZYDTOLt40JTrvyL1.4LgVrnFJ92XWYtXxDQfHYyJEJfcYENa'),
(47, 'zuk1Oao', NULL, 430957, 'ZbEdVqd6eNJ2', NULL, NULL, 46, '$2y$10$q0oaTWF4g4FT3h8ChC1ho.obrplL6inP9tQzOXoC4x1Ly2qX7E9E6'),
(48, 'KouuerE', NULL, 716385, 'vmG0crHTHnJA', NULL, NULL, 47, '$2y$10$pEsQy5deczS1/BMa9QBDxepD6dgxdTOUHV3vRYQ604hNxS9fI1UHe'),
(49, '2mbRrNg', NULL, 18782, 'zmXAxtXhsD8f', NULL, NULL, 48, '$2y$10$01S6buoVXN3weKvTdhBKeOHEE4OUqnnL6L7aMVVhp41L0tm3n9LMS'),
(50, '18jxlEa', NULL, 762086, 'ERafY2WRSSVQ', NULL, NULL, 49, '$2y$10$32ZIO/cAOyzmQBUu.gjUG.ESQL/Yb1bjJOfHLB8RVIMIfwMiqG.5W'),
(51, 'ZYf88pV', NULL, 845268, 'XY6guKeonEcr', NULL, NULL, 50, '$2y$10$jVqH2ptDp36gWIIqNWFWhOjD4LHejT/D6pV3JLqjaA70NZHOJcHR2'),
(52, 'vhVnaEq', NULL, 462379, '02csHPScvCRU', NULL, NULL, 51, '$2y$10$8Hiht4pcGU5Su5I6YSrN1uXPJ4ISN3IrGg7dJdBgqf/6wbAFTyjdu'),
(53, 'uvtgPGq', NULL, 347519, 'DFqlPG7o8kZR', NULL, NULL, 52, '$2y$10$3CtkA7CSt9v9msZq4v0f2eau1lblXkIZZiQEdz0u3ZdkYmUaA5m96'),
(54, 'Cl5eoCh', NULL, 372075, 'oBtnw0ta2Hlo', NULL, NULL, 53, '$2y$10$deiWoN13VNK1NH/6L1uP2u7.FNWAZNl9i8ryfur0PZeK0eueiUnMW'),
(55, 'IN68KGF', NULL, 649221, 'RAcj4u4eOwBL', NULL, NULL, 54, '$2y$10$SmB1FRki2thETdiniTFIsOkqtApxWLlqLpSWSys8BwwY8H3Pualrq'),
(56, 'dVjav4n', NULL, 645865, 'IAuOruaMxFHT', NULL, NULL, 55, '$2y$10$wBx2jHMxmOzBHFR60tMOMOSogwnk4FQkgafPRwoa95qwdnZ5Fz/GW'),
(57, 'gmMDPhv', NULL, 183256, 'OiTHj0O6aN2W', NULL, NULL, 56, '$2y$10$Ssa4Ly8i1nPFTNlTR6mXTeJqufG83vCzB8Sa6tTUVmlBFZkg9gTCW'),
(58, 'BCCATxV', NULL, 622860, 'CmN5daTGuojH', NULL, NULL, 57, '$2y$10$TESFhsaWM2GMBThLH7FOOeuofui7ZFYTqCTvZMOIex6gGWqvBWJQu'),
(59, 'SWkm7mD', NULL, 574489, 'uzSMlI6Y8ivC', NULL, NULL, 58, '$2y$10$Cwv9Jc.OTljWk4GRyVjQReYjGsfk/WSes5WmTALceYsoT0mxPC34i'),
(60, 'Gir8e2Q', NULL, 323317, '6eKriFiiPMXs', NULL, NULL, 59, '$2y$10$IX47Gs.c1akl568uE91gOeRIIc6Uk6fKCghd.D9OUguR.9jDW0y0O'),
(61, 'hK5mbUZ', NULL, 104751, 'LcWiEHxjmn3k', NULL, NULL, 60, '$2y$10$qIjkP7f/RaipS4GSFwLJseZEk6/6pzRMgg83WQ9pXzSGPS3dVdhQe'),
(62, 'CwrK4yU', NULL, 796010, 'XyNKSVOhKRWG', NULL, NULL, 61, '$2y$10$yzPaec64FQ7tLlxzp.L4nOQc1s0ofGlE8ZK7pCwZ5PZzpTXRvG4YO'),
(63, '5UjmCaT', NULL, 117597, 'ScALRoJ4Ebdy', NULL, NULL, 62, '$2y$10$m9VffmodFKLqsU8W.e1TX.Gh5SITRQrEgxVQgxQPoQCQNm2Vdwp/i'),
(64, '3orbswD', NULL, 31645, 'zE7XkuWdrJhq', NULL, NULL, 63, '$2y$10$ASkEa7sDDxYlSGR/R/oU7OAT6Oj.40H2BTb5nQTnyG5zowvsrDjt.'),
(65, '46asHCd', NULL, 766235, '77gZxcul0wyt', NULL, NULL, 64, '$2y$10$MFsoYahnlYD/xIdLaZRZMOgrn7eOQO/sZaVzHFm1UurkgFKqlFKyy'),
(66, 'KmE0aTM', NULL, 790717, 'OqEyGnC0mZrR', NULL, NULL, 65, '$2y$10$IgeQTlbzUjQVRAPIntVKF.ad38luNG3N.UtCSgsqN1yqYnRMcdKLe'),
(67, 'ANsKK99', NULL, 771943, 'aK4MTcEA2u86', NULL, NULL, 66, '$2y$10$zngvUmpuaNLWvzRb50IouO/S5KPqT/357awaaLpE8zSiKdyggMG.S'),
(68, 'd2H4781', NULL, 531926, '5hR1fSzDoYGr', NULL, NULL, 67, '$2y$10$GHiQEGGafisvriGaeux9Weq05qVR.k61CzYk82WmeHF0H5GLbLfLa'),
(69, 'n1hYdmS', NULL, 925182, '5akHIsep6XR5', NULL, NULL, 68, '$2y$10$cSH53ryOf.6jZ9lFh4QbIeOmibGBz1LAgKPjqje12lkWPGJBIQRYi'),
(70, 'tDaTYUk', NULL, 520986, 'WGNIufrNpCoP', NULL, NULL, 69, '$2y$10$4wKIuR72GoZYMWS7W4c0r.PwKB/GuwX.ufYMd/uLTYbLuu15YDp7a'),
(71, 'WOrckSB', NULL, 769671, 'V41zF5MPiids', NULL, NULL, 70, '$2y$10$Q.WS./.0jrmTjI8butvwi.Qc3GJkXC7AaItVcW/k6h5JaOugyfHgW'),
(72, 'MiyjpAc', NULL, 331757, 'cpnPrHCL6fkP', NULL, NULL, 71, '$2y$10$1azoTFgGXC5FZnSTs.olMO.DRKEBgOF7s6uW19p1C7U0X85fTqtoa'),
(73, 'jmCtmRE', NULL, 616938, 'pdvHog85ajfh', NULL, NULL, 72, '$2y$10$AlLk5RUUeHWzkdWXQmp6befFPwNA2KD2PXN.3OtghHmMNmQDOEyCW'),
(74, 'W5zZxmV', NULL, 407799, 'Qzcb3lYpD8lk', NULL, NULL, 73, '$2y$10$wkc6Zg6SB/ptqhF9ZvlP2O1Yw1m0m72b9cBJWq.2BBWWw.1Sw2nIq'),
(75, 'EN3At7q', NULL, 129514, 'fMDL33212xXw', NULL, NULL, 74, '$2y$10$vYJbnB9zQRFAPlqaOXV0/uygnl2J43Zubtk8/RTwOzDgtcCSl//be'),
(76, 'l82APGR', NULL, 238972, 'EdPeDJGnYX2V', NULL, NULL, 75, '$2y$10$Yx1ySBe87IcUYa5hGtHOFeS12TCjOE.b8BfFhZ318jcG3761ZPUoO'),
(77, 'iYe5CEH', NULL, 278986, 'SN1WdwaAGbZZ', NULL, NULL, 76, '$2y$10$T48e.miroWeCXZMhdTsg5.8oWIVNVhdzBhKRVVW/Ng8218WAXo6Uy'),
(78, 'WzzMQKJ', NULL, 972529, 'GkWTblLZMoiu', NULL, NULL, 77, '$2y$10$iprcYkyBTllDA6PTuqsr9uErLOgVCul78mQh9Xj437Y/uYriCIf26'),
(79, 'P6QesYU', NULL, 908798, 'O2yL1gmjyYU3', NULL, NULL, 78, '$2y$10$GnH0nStCxl53pomc16J3PeetUGBgEZrkyPUMess/cqOmO26fbvaJ6'),
(80, 'FPvq3Qy', NULL, 365296, 'MlLFK5gQNhrR', NULL, NULL, 79, '$2y$10$fc0xgIUZ8mGppgqioKrgRO9g0A0lrtYKFuxpYE67kTpq8bbWWOJQ6'),
(81, 'db5ERmX', NULL, 273907, 'MIu5pQfmXQp9', NULL, NULL, 80, '$2y$10$H5AQY5EN2RifDaRSngTn3.DocTQOZ//sBSrARq6ZYrpH3ja35NuZ.'),
(82, 'Us5qp6t', NULL, 255373, 'AQktxnBJznWO', NULL, NULL, 81, '$2y$10$6mOOAzkY/Y2RsAIjjMbFMujGX4FbLmWW/QkTT5t97QavSWwb8sxuu'),
(83, '5tsJL3v', NULL, 238774, 'q1MfLAmiaohn', NULL, NULL, 82, '$2y$10$BcbH4s4iLr7zj6dQpBxtd.Idp5U0066FkHHpVJ2oWe.FzhxbAtg4a'),
(84, 'dtLi2XW', NULL, 821782, 'IJLn9I54BbC7', NULL, NULL, 83, '$2y$10$v6YdZ9Ho2/JMGm7pNv/cvuIw.6.0QMc2KjXto3SGnvRxtwEodKEh.'),
(85, 'cfaDQpS', NULL, 862721, 'aAH5hb2vbta1', NULL, NULL, 84, '$2y$10$qTFwdTfXQIJj6Emdqqat.uoxCDJJ1aF7JikdT5UILEefnB0xy3ckq'),
(86, 'HPyIdsh', NULL, 370866, 'JPWDjukQctzJ', NULL, NULL, 85, '$2y$10$E9rfsbhvdRrxzWTqDkDPgeNsMqLiFLHS6Bgt7NLQN8MnwyZ7d86g.'),
(87, 'uY7tcli', NULL, 816189, 'LY7TUCeMBsRy', NULL, NULL, 86, '$2y$10$kgm8uNYfHpH0VyQYYx1a0uyvRJ67m84TJz6WaFNbKAgRVg/fX7OY.'),
(88, '4qscunJ', NULL, 825290, 'KABHYMCBIkOy', NULL, NULL, 87, '$2y$10$lnMGNPGshpf.TlpUwOZRXeTJSwcDiVLmfhsxkll4FB70TQgzyner.'),
(89, 'v6F9Izb', NULL, 530935, 's0hwbgfYV4O7', NULL, NULL, 88, '$2y$10$RuaiamINkcFMErxqHebc8eV8UUA8u5LevWuuca3XSulmD1uOq0/4y'),
(90, 'R9GpSBL', NULL, 547536, 'rUmBqIoQQJdo', NULL, NULL, 89, '$2y$10$YrkrKr6lnoTAN9duj6TRvubZmwIASeCWBpqpZEWhdHrT38vIxjDl.'),
(91, 'PkPoy2g', NULL, 208494, 'JiaFGpz43p2z', NULL, NULL, 90, '$2y$10$p/0UQUigj1OjYQbtEmJ9Ye/h7R3KrzQF08gcOZHYp1cWihCC7ZTnG'),
(92, '9xDQn1l', NULL, 131353, 'fVUFS1WyPW6N', NULL, NULL, 91, '$2y$10$skTzS8A3zALwx0YeUpIDFORONWnaiLm4YWw1zTMf8t9cQcC2y1jZ6'),
(93, 'k9pY9mr', NULL, 757559, 'SXm27oieegN8', NULL, NULL, 92, '$2y$10$R4e.XkLmrHptvfdlfwn6FOXPAunyCIgSyXIuaOh9wtr/uFku61uXO'),
(94, 'KoODcD6', NULL, 998286, 'xqxvMFCnb4oy', NULL, NULL, 93, '$2y$10$vp42luxrVJZk2n6Em21oyuJxhYKWqSS8LHho9atlURwgn1JAD5euy'),
(95, '4KClMGQ', NULL, 756133, 'upeSSifUDdhW', NULL, NULL, 94, '$2y$10$k3ovyvRjNJV1vqpZPf1wc.e0kcY19vCZjbasSFFHSSIMVFm1npttO'),
(96, 'xw7bOrQ', NULL, 155940, 'keY5xhrbzwUu', NULL, NULL, 95, '$2y$10$XGCzaiZxQPcMVE5R6kWSZeLiMp5CcDnHNbhrLsEM3D2SUxDRXdxk.'),
(97, 'OSMJy2h', NULL, 129749, '6Yjj7PIN6vgH', NULL, NULL, 96, '$2y$10$OuiRU0cXXpIWUssbSH/BXuuU7st1CVOVhRh8rxjD.tUQ44iHmUoMG'),
(98, 'VEL5oOq', NULL, 662958, 'zyMpus6GTrFN', NULL, NULL, 97, '$2y$10$ZGxHh3.W8qyMPpzGE2xfTONGxR.4pU1XERSdQO.g7OixVym1DBUh2'),
(99, 'QrR3Rto', NULL, 768500, 'eyuhWnqvfCDy', NULL, NULL, 98, '$2y$10$VG4J0ctBatqf2KEieVe5F.sbcnBFJ/PL.zptQIn9f3fjrbQRFSMJO'),
(100, 'zjefbMT', NULL, 868331, 'L96dPqNhZ7JZ', NULL, NULL, 99, '$2y$10$H1ljIPF56GygilbOZw87DesG1AdrQAa3TCRugdLITLAazh1BvWS3e'),
(101, 'YuGWZyQ', NULL, 106402, 'MrJEsmBknNZY', NULL, NULL, 100, '$2y$10$CDhJqD5AEVuTgD.lt62DoOsL1gKEwWoO/1Lclrup7cdxFuvl8D7Hy'),
(102, 'uhTgsWm', NULL, 539746, 'lT2XsWSr6M7n', NULL, NULL, 101, '$2y$10$LQx/r8y1rp.duTTNgkYy/eWa7YIsAfMv.TJOiWWOfENexl9kYOYxC'),
(103, 'ULq3B65', NULL, 509540, '6mdcwqLQ4iHK', NULL, NULL, 102, '$2y$10$BYv/FJ9Zf0K464PvkwZhHOu./ZiwIpqjRgOWyPRkAxfG/YG0F.lNi'),
(104, 'msedzhm', NULL, 282515, 'm8aVq2VT7NJU', NULL, NULL, 103, '$2y$10$XGAcYnNDTI9/gvG66ePbaOb1AIA9ZptyP8PqT4wuqOsH0LokJAVCO'),
(105, 'Z1fykMF', NULL, 883275, 'NLCHsK2a9Bkq', NULL, NULL, 104, '$2y$10$iD39EAQWYv9EoG9jcvkkq.OEsdJimNo9FJN5qHk/Lch6kSbPkHZGS'),
(106, '7yzdFy4', NULL, 355218, 'KZ7jzQukBNnr', NULL, NULL, 105, '$2y$10$Ld5R7z6AoMQKhghlZZQ3WOlduPxDj5BGwqY4dXTllB0MoYYRKn0KK'),
(107, 'IdgovpN', NULL, 205984, 'VTTWHB0IjMxA', NULL, NULL, 106, '$2y$10$Sd1nj3lVrymlTzfqwmYtQOlS6pwvYKfmVEn20eRslN98z4wn3xBva'),
(108, '2IWuqnX', NULL, 284264, 'TPKhdJv5vjxf', NULL, NULL, 107, '$2y$10$2kvJLqnGl.cgTP25KKC6OurTmxj10IP5ri0oZU7j56dPMw7AvOFqm'),
(109, '5clLZAh', NULL, 644519, 'Em0WyMfUDqan', NULL, NULL, 108, '$2y$10$TXTyhPV1pTDTJ.6OIIL03egIGlypQ1seGD0wwae.u71aOcQ7V2PBG'),
(110, 'FxTzZgB', NULL, 696770, 'oz6Eob59Nqox', NULL, NULL, 109, '$2y$10$lzr8KDbYHdexs0SMmsDoOekUtnx546VLcapPnWHysVRR6XC4c3scu'),
(111, 'eSSomwO', NULL, 357431, 'zne7MnpWo2Jp', NULL, NULL, 110, '$2y$10$y6rM08gWQ/5F9RaKjtS9v.MWtj.7IouPJwMd2RMHKoq3ryqi/yrs6'),
(112, 'BbKTMB6', NULL, 746031, 'ju4B6SBWkJv0', NULL, NULL, 111, '$2y$10$w75IhammgeE07gb9iCZgBeMxUvCHfXni0TW3d95ZgpZqzN4Tw1K4S'),
(113, '1cs6AEz', NULL, 299127, '5WbrwWRq7dz5', NULL, NULL, 112, '$2y$10$vICP4TgHZxwdwpmA17/qlemVYx7lPMgePsKz2S51eSn9.sEhxt8zW'),
(114, 'RXGAhaO', NULL, 82361, 'Fd95Qv6wCjyQ', NULL, NULL, 113, '$2y$10$3YVEZIgQuUuDW.AbhaQrsONG5Bwe.UtZgYQWviKtE5xaqqNQlVNPq'),
(115, 'aCc8o5u', NULL, 356214, 'QNTylvfX6rVY', NULL, NULL, 114, '$2y$10$B3kBDlqdwwIF8Rtymq9WFucjLaLXlWQdfiMH9s3XKuJuL0IwxXtDm'),
(116, 'Orydljh', NULL, 612085, 'drU1davASJ3d', NULL, NULL, 115, '$2y$10$qhXgTXWrPL5KlyMTWnSfvOFl9P6LJ0rTEXLOTXcwDnL9je760osJa'),
(117, '7zdeyhl', NULL, 980953, 'eZpyu5Llgof1', NULL, NULL, 116, '$2y$10$WMzYEezwc9POZ3h5xTjpr./Zv7zZAWal5x29Plh3p5uc3/mnxh.hy'),
(118, 'bGyb5nb', NULL, 195146, 'SxMxbGhVFeCW', NULL, NULL, 117, '$2y$10$6064Pren1VxbZUSicFLlkOakl8EcR6shYD3cHu3JKLDzT41K6WyTu'),
(119, 'VoGum3p', NULL, 897277, 'cuynBSmznEvI', NULL, NULL, 118, '$2y$10$mlv7/puWUUa2TUBZKVjpKuLJW2cXJbu87c1Sz846tgq.fTwc.zyPS'),
(120, 'KdEoHWk', NULL, 504042, '5HGyllgDt8Nx', NULL, NULL, 119, '$2y$10$.MsQ0iqXBL2BjF8WikNi0eA8ADOsups85zxaGvw6pazs0/n23/d5C'),
(121, 'fiEJceZ', NULL, 17654, 'OPsmccjqKVUy', NULL, NULL, 120, '$2y$10$Fvns31kPqFyFlhywJSU4qelD04Sn5ggYeDO6kOEuOzJFa/P01JUhK'),
(122, 'vvSAqxa', NULL, 574257, 'yTIgTOLOtLzX', NULL, NULL, 121, '$2y$10$P5tc8t1AOc0kMIfDASrUFePCuvjJmPIldvGxGiHWcbhXHdeezsqv.'),
(123, 'dRQKyKY', NULL, 130550, '8LVfaTlURA15', NULL, NULL, 122, '$2y$10$aV5vAoIxC6zZYlhOimW2qOONaAdU8yPtZYQES6vfuWjCwqBMv3Nz2'),
(124, '8xO6Vdn', NULL, 388266, 'qiVkj2VjL8D0', NULL, NULL, 123, '$2y$10$1gwrMbqAFep.iU6T8SH33.1VD3FriDV1bKBdkp24VbjDvm9t3q6xa'),
(125, 'aKO8rWT', NULL, 558869, '3ONL3Q8syAgY', NULL, NULL, 124, '$2y$10$Re1ZL9JYtA2sBAndzOaKuugC6ZGEXWNLiPe.fbYqUkj/s/KwbcKMa'),
(126, 'YCeljUw', NULL, 260505, '66sLOMZCIohO', NULL, NULL, 125, '$2y$10$LBM1ccCtbXd3iMWofGkh3.k9lEfnSbMjIo4Fa89T41Skmhptli1z6'),
(127, 'f6jl5i3', NULL, 714220, 'UlHSW5rnjRV5', NULL, NULL, 126, '$2y$10$osex6z1.57jb.N961WspxuJJYkOrQr3xD5/PL4w5bNOL3NEGDAYE2'),
(128, 'MNgtzgI', NULL, 724213, 'dxSj6ZqXo2Ze', NULL, NULL, 127, '$2y$10$DS7v/0D4p4h3VKvJjBCviOpunXL3.jSnq5ylLOBqcV41WgKyUBqiK'),
(129, 'y7pgXIT', NULL, 604159, '8s2VTjxrGhH8', NULL, NULL, 128, '$2y$10$LvzVMRGYNnE3G9tXwTtzeO15gZdjKPs/Ytz6eD1SJLn.wKu5cM2ju'),
(130, 'FgFHvBR', NULL, 12491, 'UH0QidbGFEQS', NULL, NULL, 129, '$2y$10$duLxegHDuhGkYAoGoxqe3edbwCLfWGxmXMJ9T4.UVaw4YQbfcdn16'),
(131, 'fCD7jhN', NULL, 10154, 'YTAFBap0QO5I', NULL, NULL, 130, '$2y$10$sO/AIIuqQX5Xzf1SxwXNhes8AjLymk1UkOLomE457jJrmVuB73VTm'),
(132, 'vTKbQFB', NULL, 97706, 'GejTD3V4DK2e', NULL, NULL, 131, '$2y$10$IUB5EKe.Vl72ztcKg3UgSOkiBc4YscC.ZNBR4QZUwiEYZa0IdNaxC'),
(133, 't0HiYpt', NULL, 32036, 'roX2YIRPkC7L', NULL, NULL, 132, '$2y$10$3B20ehKsFw5IRjmjA467KeeYgiFQZnwlfgUTTzjGkvxkuQ9J6VhJC'),
(134, 'eIMQ9lg', NULL, 523863, 'XTpbPRxpp0fB', NULL, NULL, 133, '$2y$10$HSjVKinXfGpy7X/6V7IssutK2aWvXwjlh7iL/4QXvMDu1Hd/aIY5.'),
(135, 'voNXDjx', NULL, 333005, '5njpnuARGUac', NULL, NULL, 134, '$2y$10$NSkl7wOrZxNMe8EyN3R8Y.0t06tEJEtGVjJVRSr/Effy4S/GbnbhO'),
(136, '8pE7XNh', NULL, 486147, 'lsxNYjUVVUss', NULL, NULL, 135, '$2y$10$cVdRDIB4PJwJVobg4o/x6.T93.jkXibdBeK0yajt.jBu6rbJhx6J2'),
(137, 'o7ReAUl', NULL, 980773, 'OfMter1JTj5t', NULL, NULL, 136, '$2y$10$xE0Qq4ZvtBXZfDHnAt72Gerl7h21W/18ER2przNZmSyrahP.hU6E.');

-- --------------------------------------------------------

--
-- Table structure for table `user_feedback`
--

CREATE TABLE `user_feedback` (
  `serial_id` bigint(20) NOT NULL,
  `credential_id` bigint(20) NOT NULL,
  `header` varchar(80) NOT NULL,
  `description` text NOT NULL,
  `rating` double NOT NULL,
  `category` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_feedback`
--

INSERT INTO `user_feedback` (`serial_id`, `credential_id`, `header`, `description`, `rating`, `category`) VALUES
(11, 35, 'dsdasd', 'adsasdsa', 2, 'App User Interfacing'),
(12, 35, 'hello', 'asdasd', 3.5, 'App User Interfacing');

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
-- Indexes for table `boats`
--
ALTER TABLE `boats`
  ADD PRIMARY KEY (`serial_id`),
  ADD UNIQUE KEY `internet_id` (`registration_number`);

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
-- Indexes for table `problems_submitted`
--
ALTER TABLE `problems_submitted`
  ADD PRIMARY KEY (`serial_id`);

--
-- Indexes for table `problem_solutions`
--
ALTER TABLE `problem_solutions`
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
-- Indexes for table `user_feedback`
--
ALTER TABLE `user_feedback`
  ADD PRIMARY KEY (`serial_id`);

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
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=137;

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
-- AUTO_INCREMENT for table `problems_submitted`
--
ALTER TABLE `problems_submitted`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `problem_solutions`
--
ALTER TABLE `problem_solutions`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

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
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=138;

--
-- AUTO_INCREMENT for table `user_feedback`
--
ALTER TABLE `user_feedback`
  MODIFY `serial_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
