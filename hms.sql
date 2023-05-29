-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2023 at 04:56 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AID` int(10) NOT NULL,
  `admin_mail` varchar(200) NOT NULL,
  `admin_password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AID`, `admin_mail`, `admin_password`) VALUES
(1, 'admin@hotel.mail.com', 'hotel@dmin');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `UID` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `user_mail` varchar(200) NOT NULL,
  `user_password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`UID`, `username`, `user_mail`, `user_password`) VALUES
(2, 'sithmaka', 'sithmaka@mail.com', 'sithmaka123'),
(3, 'nimesha', 'nimesha@mail.com', 'nimesh123'),
(8, 'user1', 'user1@mail.com', 'user123');

-- --------------------------------------------------------

--
-- Table structure for table `deluxeroom`
--

CREATE TABLE `deluxeroom` (
  `RoomID` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `room_no` varchar(5) NOT NULL,
  `ac_status` varchar(10) NOT NULL,
  `room_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `deluxeroom`
--

INSERT INTO `deluxeroom` (`RoomID`, `type`, `room_no`, `ac_status`, `room_status`) VALUES
(1, 'Deluxe', 'RD1', 'With', 'Booked'),
(2, 'Deluxe', 'RD2', 'Without', 'Available');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `usermail` varchar(200) NOT NULL,
  `role` varchar(10) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`usermail`, `role`, `password`) VALUES
('admin@hotel.mail.com', 'admin', 'hotel@dmin'),
('recep12@hotel.mail.com', 'reception', 'recep1'),
('user1@mail.com', 'customer', 'user123');

-- --------------------------------------------------------

--
-- Table structure for table `reception`
--

CREATE TABLE `reception` (
  `RID` int(11) NOT NULL,
  `r_mail` varchar(200) NOT NULL,
  `r_password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `reception`
--

INSERT INTO `reception` (`RID`, `r_mail`, `r_password`) VALUES
(1, 'recep12@hotel.mail.com', 'recep1'),
(5, 'recep4@hotel.mail.com', 'recep4321'),
(6, 'recep5@hotel.mail.com', 'recep5');

-- --------------------------------------------------------

--
-- Table structure for table `singleroom`
--

CREATE TABLE `singleroom` (
  `RoomID` int(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  `room_no` varchar(5) NOT NULL,
  `ac_status` varchar(10) NOT NULL,
  `room_status` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `singleroom`
--

INSERT INTO `singleroom` (`RoomID`, `type`, `room_no`, `ac_status`, `room_status`) VALUES
(1, 'Single', 'R1', 'With', 'Available'),
(2, 'Single', 'R2', 'Without', 'Booked');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AID`),
  ADD UNIQUE KEY `admin_mail` (`admin_mail`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `user_mail` (`user_mail`);

--
-- Indexes for table `deluxeroom`
--
ALTER TABLE `deluxeroom`
  ADD PRIMARY KEY (`RoomID`),
  ADD UNIQUE KEY `room_no` (`room_no`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD UNIQUE KEY `usermail` (`usermail`);

--
-- Indexes for table `reception`
--
ALTER TABLE `reception`
  ADD PRIMARY KEY (`RID`),
  ADD UNIQUE KEY `r_mail` (`r_mail`);

--
-- Indexes for table `singleroom`
--
ALTER TABLE `singleroom`
  ADD PRIMARY KEY (`RoomID`),
  ADD UNIQUE KEY `room_no` (`room_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `deluxeroom`
--
ALTER TABLE `deluxeroom`
  MODIFY `RoomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `reception`
--
ALTER TABLE `reception`
  MODIFY `RID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `singleroom`
--
ALTER TABLE `singleroom`
  MODIFY `RoomID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
