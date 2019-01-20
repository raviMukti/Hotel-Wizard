-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 20, 2019 at 01:09 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hotel`
--

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `order_id` int(3) UNSIGNED NOT NULL,
  `tanggal_checkin` date NOT NULL,
  `tanggal_checkout` date NOT NULL,
  `lama_inap` int(11) NOT NULL,
  `nama_tamu` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(6) NOT NULL,
  `jenis_identitas` varchar(10) NOT NULL,
  `nomor_identitas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`order_id`, `tanggal_checkin`, `tanggal_checkout`, `lama_inap`, `nama_tamu`, `jenis_kelamin`, `jenis_identitas`, `nomor_identitas`) VALUES
(2, '2019-01-09', '2019-01-12', 3, 'Entis', 'Pria', 'KTP', '123'),
(3, '2019-01-10', '2019-01-14', 4, 'Iman', 'Pria', 'KTP', '456');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(3) UNSIGNED NOT NULL,
  `nama` varchar(15) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `nama`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`order_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `order_id` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(3) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
