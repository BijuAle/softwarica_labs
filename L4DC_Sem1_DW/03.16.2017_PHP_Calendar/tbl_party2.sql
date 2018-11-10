-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2017 at 04:45 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_childrenparty4u`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_party2`
--

CREATE TABLE `tbl_party2` (
  `party_id` int(11) NOT NULL,
  `type` varchar(100) NOT NULL,
  `book_date` date NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_party2`
--

INSERT INTO `tbl_party2` (`party_id`, `type`, `book_date`, `user_id`) VALUES
(1, 'Pirate', '2017-03-31', 1),
(2, 'Bear', '2017-04-21', 4),
(3, 'Star Wars', '2017-05-18', 1),
(4, 'Bear', '2017-06-24', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_party2`
--
ALTER TABLE `tbl_party2`
  ADD PRIMARY KEY (`party_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_party2`
--
ALTER TABLE `tbl_party2`
  MODIFY `party_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
