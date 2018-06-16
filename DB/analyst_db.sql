-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2018 at 07:52 AM
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
(44, 'ProfitWarning', 'stock', 1, 'Virtusa'),
(45, 'ProfitWarning', 'stock', 2, 'Virtusa'),
(46, 'ProfitWarning', 'stock', 3, 'Virtusa');

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
('1', 'stock', 'WSO2', 'BUY', 1),
('1', 'stock', 'WSO2', 'SELL', 4),
('1', 'stock', 'WSO2', 'BUY', 5),
('1', 'stock', 'WSO2', 'BUY', 6),
('1', 'stock', 'WSO2', 'BUY', 7),
('1', 'stock', 'WSO2', 'BUY', 8),
('1', 'stock', 'WSO2', 'SELL', 9);

-- --------------------------------------------------------

--
-- Table structure for table `trend_tab`
--

CREATE TABLE `trend_tab` (
  `trend_id` int(10) NOT NULL,
  `turn` int(3) NOT NULL,
  `sector` varchar(100) NOT NULL,
  `stock` varchar(100) NOT NULL,
  `price` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trend_tab`
--

INSERT INTO `trend_tab` (`trend_id`, `turn`, `sector`, `stock`, `price`) VALUES
(175, 1, 'Technology', 'WSO2', '1'),
(176, 2, 'Technology', 'WSO2', '2'),
(177, 3, 'Technology', 'WSO2', '0'),
(178, 4, 'Technology', 'WSO2', '0'),
(179, 5, 'Technology', 'WSO2', '-1'),
(180, 6, 'Technology', 'WSO2', '1'),
(181, 7, 'Technology', 'WSO2', '2'),
(182, 8, 'Technology', 'WSO2', '2'),
(183, 9, 'Technology', 'WSO2', '1'),
(184, 10, 'Technology', 'WSO2', '-2');

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
  MODIFY `event_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT for table `trend_tab`
--
ALTER TABLE `trend_tab`
  MODIFY `trend_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=185;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
