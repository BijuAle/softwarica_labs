-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 19, 2017 at 02:07 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soft_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_soft`
--

CREATE TABLE `tbl_soft` (
  `id` int(11) NOT NULL,
  `un` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_soft`
--

INSERT INTO `tbl_soft` (`id`, `un`, `phone`) VALUES
(1, 'Test', '989898'),
(2, 'Test', '998'),
(3, 'Test', '998'),
(4, 'Test', '998'),
(5, '', ''),
(6, 'a', 'a'),
(7, 'a', 'a'),
(8, 'a', 'a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_soft`
--
ALTER TABLE `tbl_soft`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_soft`
--
ALTER TABLE `tbl_soft`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
