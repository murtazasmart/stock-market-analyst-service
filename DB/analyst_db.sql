-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2018 at 03:04 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `analyst_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `event_tab`
--

CREATE TABLE `event_tab` (
  `event_id` int(5) NOT NULL,
  `event_name` varchar(30) NOT NULL,
  `type` varchar(20) NOT NULL,
  `round` int(3) NOT NULL,
  `entity` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_tab`
--

INSERT INTO `event_tab` (`event_id`, `event_name`, `type`, `round`, `entity`) VALUES
(1, '', '', 0, ''),
(2, 'ProfitWarning', 'stock', 1, 'Virtusa'),
(3, 'ProfitWarning', 'stock', 2, 'Virtusa'),
(4, 'ProfitWarning', 'stock', 3, 'Virtusa');

-- --------------------------------------------------------

--
-- Table structure for table `recommendation_tab`
--

CREATE TABLE `recommendation_tab` (
  `rec_time` varchar(2) NOT NULL,
  `type` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `action` varchar(4) NOT NULL,
  `duration` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recommendation_tab`
--

INSERT INTO `recommendation_tab` (`rec_time`, `type`, `name`, `action`, `duration`) VALUES
('1', 'stock', '99x', 'sell', 3),
('1', 'sector', 'Technology', 'buy', 5),
('1', 'stock', '99x', 'sell', 3),
('1', 'sector', 'Technology', 'buy', 5);

-- --------------------------------------------------------

--
-- Table structure for table `trend_tab`
--

CREATE TABLE `trend_tab` (
  `trend_id` int(10) NOT NULL,
  `turn` int(3) NOT NULL,
  `sector` varchar(100) NOT NULL,
  `stock` varchar(100) NOT NULL,
  `price_def` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trend_tab`
--

INSERT INTO `trend_tab` (`trend_id`, `turn`, `sector`, `stock`, `price_def`) VALUES
(13, 2, 'testSEMEra', 'testST', '5'),
(14, 2, 'testSEMEra', 'testST', '5'),
(15, 2, 'testSEMEra', 'testST', '5'),
(16, 2, 'testSEMEra', 'testST', '5'),
(17, 2, 'testSEMEra', 'testST', '5'),
(18, 2, 'testSEMEra', 'testST', '5'),
(19, 2, 'testSEMEra', 'testST', '5'),
(20, 2, 'testSEMEra', 'testST', '5'),
(21, 2, 'testSEMEra', 'testST', '5'),
(22, 2, 'testSEMEra', 'testST', '5'),
(23, 2, 'testSEMEra', 'testST', '5'),
(24, 2, 'testSEMEra', 'testST', '5'),
(25, 1, 'xx', 'Business', '1'),
(26, 2, 'xx', 'Business', '-1'),
(27, 3, 'xx', 'Business', '0'),
(28, 4, 'xx', 'Business', '-1'),
(29, 5, 'xx', 'Business', '0'),
(30, 6, 'xx', 'Business', '0'),
(31, 7, 'xx', 'Business', '0'),
(32, 8, 'xx', 'Business', '-1'),
(33, 9, 'xx', 'Business', '0'),
(34, 10, 'xx', 'Business', '1'),
(35, 1, 'xx', 'Virtusa', '-2'),
(36, 2, 'xx', 'Virtusa', '1'),
(37, 3, 'xx', 'Virtusa', '2'),
(38, 4, 'xx', 'Virtusa', '2'),
(39, 5, 'xx', 'Virtusa', '0'),
(40, 6, 'xx', 'Virtusa', '2'),
(41, 7, 'xx', 'Virtusa', '-1'),
(42, 8, 'xx', 'Virtusa', '2'),
(43, 9, 'xx', 'Virtusa', '-1'),
(44, 10, 'xx', 'Virtusa', '-1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `event_tab`
--
ALTER TABLE `event_tab`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `trend_tab`
--
ALTER TABLE `trend_tab`
  ADD PRIMARY KEY (`trend_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `event_tab`
--
ALTER TABLE `event_tab`
  MODIFY `event_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `trend_tab`
--
ALTER TABLE `trend_tab`
  MODIFY `trend_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
