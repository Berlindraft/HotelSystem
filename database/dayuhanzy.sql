-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: May 19, 2024 at 03:14 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dayuhanzy`
--

-- --------------------------------------------------------

--
-- Table structure for table `admindb`
--

CREATE TABLE `admindb` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admindb`
--

INSERT INTO `admindb` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `password`) VALUES
(18, 'raymund', 'zyron', '321', '123123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `bookingdb`
--

CREATE TABLE `bookingdb` (
  `bookingId` int(11) NOT NULL,
  `guestId` int(11) NOT NULL,
  `roomNumber` int(11) NOT NULL,
  `checkinDate` date NOT NULL,
  `checkoutDate` date NOT NULL,
  `payment` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bookingdb`
--

INSERT INTO `bookingdb` (`bookingId`, `guestId`, `roomNumber`, `checkinDate`, `checkoutDate`, `payment`) VALUES
(1, 1, 101, '2024-05-09', '2024-05-18', 250.00),
(2, 2, 102, '2024-05-09', '2024-05-18', 350.00),
(3, 3, 103, '2024-05-09', '2024-05-18', 400.00),
(4, 4, 201, '2024-05-10', '2024-05-18', 300.00),
(5, 5, 202, '2024-05-10', '2024-05-18', 280.00),
(6, 6, 203, '2024-05-10', '2024-05-18', 320.00),
(7, 7, 301, '2024-05-11', '2024-05-18', 370.00),
(8, 8, 302, '2024-05-11', '2024-05-18', 420.00),
(9, 9, 303, '2024-05-11', '2024-05-18', 390.00),
(10, 10, 401, '2024-05-11', '2024-05-18', 380.00),
(11, 10, 101, '0000-00-00', '0000-00-00', 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `guestcat`
--

CREATE TABLE `guestcat` (
  `guestId` int(11) NOT NULL,
  `adults` int(11) NOT NULL,
  `children` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guestcat`
--

INSERT INTO `guestcat` (`guestId`, `adults`, `children`) VALUES
(1, 2, 1),
(2, 1, 0),
(3, 2, 2),
(4, 1, 1),
(5, 3, 0),
(6, 2, 3),
(7, 2, 1),
(8, 1, 0),
(9, 2, 2),
(10, 2, 1);

-- --------------------------------------------------------

--
-- Table structure for table `guestdb`
--

CREATE TABLE `guestdb` (
  `guestId` int(11) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `prefixName` varchar(25) DEFAULT NULL,
  `suffixName` varchar(25) DEFAULT NULL,
  `contactNumber` varchar(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `guestdb`
--

INSERT INTO `guestdb` (`guestId`, `firstName`, `lastName`, `prefixName`, `suffixName`, `contactNumber`, `email`, `address`) VALUES
(1, 'raymnd', 'abella', '', '', '123456', 'gmail', NULL),
(2, 'raymudn', 'abelal', '', '', '123456', 'gmail', NULL),
(3, 'raymund', 'abella', '', '', '123456', 'gmail', NULL),
(4, 'zy', 'ron', '', '', 'Phone', 'Email Address', NULL),
(5, 'raymund zyron', 'abella', 'Prefix', 'Suffix', '09090909', 'zyron.gmail', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `newbookingdb`
--

CREATE TABLE `newbookingdb` (
  `bookingId` int(11) NOT NULL,
  `guestId` int(11) DEFAULT NULL,
  `paymentId` int(11) DEFAULT NULL,
  `roomNumber` int(11) DEFAULT 0,
  `checkinDate` date DEFAULT NULL,
  `checkoutDate` date DEFAULT NULL,
  `adults` int(255) DEFAULT NULL,
  `children` int(255) DEFAULT NULL,
  `AddOption1` varchar(11) DEFAULT NULL,
  `AddOption2` varchar(11) DEFAULT NULL,
  `AddOption3` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `newbookingdb`
--

INSERT INTO `newbookingdb` (`bookingId`, `guestId`, `paymentId`, `roomNumber`, `checkinDate`, `checkoutDate`, `adults`, `children`, `AddOption1`, `AddOption2`, `AddOption3`) VALUES
(1, 1, 1, 115, '2024-05-17', '2024-05-19', 1, 1, 'Yes', 'Yes', NULL),
(2, 2, 2, 115, '2024-05-17', '2024-05-19', 1, 1, 'Yes', NULL, 'Yes'),
(3, 3, 3, 115, '2024-05-17', '2024-05-19', 1, 1, 'Yes', 'Yes', NULL),
(4, 4, 4, 113, '2024-05-17', '2024-05-18', 0, 0, 'Yes', NULL, 'Yes'),
(5, 5, 5, 115, '2024-05-19', '2024-05-20', 0, 0, 'Yes', 'Yes', NULL),
(6, 6, 6, 107, '2024-05-17', '2024-05-18', 0, 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paymentdb`
--

CREATE TABLE `paymentdb` (
  `paymentId` int(11) NOT NULL,
  `guestId` int(11) DEFAULT NULL,
  `paymentDate` date DEFAULT NULL,
  `paymentAmount` decimal(10,2) DEFAULT NULL,
  `paymentMethod` varchar(50) DEFAULT NULL,
  `cardNumber` varchar(50) DEFAULT NULL,
  `cardExpiration` varchar(50) DEFAULT NULL,
  `cardName` varchar(50) DEFAULT NULL,
  `cardCvv` varchar(50) DEFAULT NULL,
  `gcashNumber` varchar(50) DEFAULT NULL,
  `gcashName` varchar(50) DEFAULT NULL,
  `cashReceived` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `paymentdb`
--

INSERT INTO `paymentdb` (`paymentId`, `guestId`, `paymentDate`, `paymentAmount`, `paymentMethod`, `cardNumber`, `cardExpiration`, `cardName`, `cardCvv`, `gcashNumber`, `gcashName`, `cashReceived`) VALUES
(1, 1, '2024-05-18', 8500.00, 'Gcash', NULL, NULL, NULL, NULL, '123456', 'raymund', NULL),
(2, 2, '2024-05-18', 8600.00, 'Gcash', NULL, NULL, NULL, NULL, '123456', 'raymubn', NULL),
(3, 3, '2024-05-18', 8500.00, 'Gcash', NULL, NULL, NULL, NULL, '123456', 'asdfdgh', NULL),
(4, 4, '2024-05-18', 3600.00, 'Gcash', NULL, NULL, NULL, NULL, '123', '123', NULL),
(5, 5, '2024-05-19', 1000.00, 'Gcash', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(6, 6, '2024-05-19', 10000.00, 'Gcash', NULL, NULL, NULL, NULL, 'gcash number', 'gcash name', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `roomdb`
--

CREATE TABLE `roomdb` (
  `roomNumber` int(11) NOT NULL DEFAULT 0,
  `roomType` varchar(25) NOT NULL,
  `roomStatus` varchar(25) DEFAULT NULL,
  `roomUpdate` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `roomdb`
--

INSERT INTO `roomdb` (`roomNumber`, `roomType`, `roomStatus`, `roomUpdate`) VALUES
(0, 'Lounge', 'Available', 'Clean'),
(101, 'Deluxe', 'Available', 'Clean'),
(102, 'Deluxe', 'Available', 'Clean'),
(103, 'Deluxe', 'Available', 'Clean'),
(104, 'Deluxe', 'Available', 'Clean'),
(105, 'Deluxe', 'Available', 'Clean'),
(106, 'Deluxe', 'Available', 'Clean'),
(107, 'Premier', 'Available', 'Clean'),
(108, 'Premier', 'Available', 'Clean'),
(109, 'Premier', 'Available', 'Clean'),
(110, 'Premier', 'Available', 'Clean'),
(111, 'Executive', 'Available', 'Clean'),
(112, 'Executive', 'Available', 'Clean'),
(113, 'Executive', 'Available', 'Clean'),
(114, 'Presidential', 'Available', 'Clean'),
(115, 'Presidential', 'Available', 'Clean'),
(201, 'Deluxe', 'Available', 'Clean'),
(202, 'Deluxe', 'Available', 'Clean'),
(203, 'Deluxe', 'Available', 'Clean'),
(204, 'Deluxe', 'Available', 'Clean'),
(205, 'Deluxe', 'Available', 'Clean'),
(206, 'Deluxe', 'Available', 'Clean'),
(207, 'Premier', 'Available', 'Clean'),
(208, 'Premier', 'Available', 'Clean'),
(209, 'Premier', 'Available', 'Clean'),
(210, 'Premier', 'Available', 'Clean'),
(211, 'Executive', 'Available', 'Clean'),
(212, 'Executive', 'Available', 'Clean'),
(213, 'Executive', 'Available', 'Clean'),
(214, 'Presidential', 'Available', 'Clean'),
(215, 'Presidential', 'Available', 'Clean'),
(301, 'Deluxe', 'Available', 'Clean'),
(302, 'Deluxe', 'Available', 'Clean'),
(303, 'Deluxe', 'Available', 'Clean'),
(304, 'Deluxe', 'Available', 'Clean'),
(305, 'Deluxe', 'Available', 'Clean'),
(306, 'Deluxe', 'Available', 'Clean'),
(307, 'Premier', 'Available', 'Clean'),
(308, 'Premier', 'Available', 'Clean'),
(309, 'Premier', 'Available', 'Clean'),
(310, 'Premier', 'Available', 'Clean'),
(311, 'Executive', 'Available', 'Clean'),
(312, 'Executive', 'Available', 'Clean'),
(313, 'Executive', 'Available', 'Clean'),
(314, 'Presidential', 'Available', 'Clean'),
(315, 'Presidential', 'Available', 'Clean');

-- --------------------------------------------------------

--
-- Table structure for table `testdb`
--

CREATE TABLE `testdb` (
  `bookingId` int(11) NOT NULL,
  `guestId` int(11) DEFAULT NULL,
  `roomNumber` int(11) DEFAULT NULL,
  `adults` int(11) DEFAULT NULL,
  `children` int(11) DEFAULT NULL,
  `checkinDate` date DEFAULT NULL,
  `checkoutDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `testdb`
--

INSERT INTO `testdb` (`bookingId`, `guestId`, `roomNumber`, `adults`, `children`, `checkinDate`, `checkoutDate`) VALUES
(7, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 1, 101, 1, 2, '2024-05-07', '2024-05-09'),
(9, 1, 101, 2, 2, '2024-05-06', '2024-05-07'),
(10, 0, 0, 4, 5, '2024-05-01', '2024-05-16'),
(11, 0, 0, 2, 2, '2024-05-06', '2024-05-14'),
(12, 0, 0, 1, 1, '2024-05-29', '2024-05-13'),
(13, 0, 0, 0, 0, '2024-05-14', '2024-05-14'),
(14, 0, 0, 0, 0, '2024-05-14', '2024-05-12'),
(15, 0, 0, 0, 0, '2024-05-07', '2024-05-08'),
(16, 0, 0, 0, 0, '2024-05-07', '2024-05-08'),
(17, 0, 0, 0, 0, '2024-05-07', '2024-05-08'),
(18, 0, 0, 0, 0, '2024-05-07', '2024-05-08'),
(19, 0, 0, 0, 0, '2024-05-07', '2024-05-08'),
(20, 0, 0, 0, 0, '2024-05-07', '2024-05-07'),
(21, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(22, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(23, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(24, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(25, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(26, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(27, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(28, 0, 0, 0, 0, '2024-05-08', '2024-05-09'),
(29, 0, 0, 0, 0, '2024-05-08', '2024-05-12'),
(30, 0, 0, 1, 1, '2024-05-09', '2024-05-10'),
(31, 0, 0, 1, 3, '2024-05-09', '2024-05-10'),
(32, 0, 0, 2, 2, '2024-05-09', '2024-05-10'),
(33, 0, 0, 0, 0, '2024-05-11', '2024-05-12'),
(34, 0, 0, 1, 2, '2024-05-11', '2024-05-12'),
(35, 0, 0, 0, 0, '2024-05-11', '2024-05-12'),
(36, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(37, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(38, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(39, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(40, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(41, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(42, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(43, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(44, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(45, 0, 0, 0, 0, '2024-05-11', '2024-05-11'),
(46, 0, 0, 0, 0, '2024-05-11', '2024-05-11');

-- --------------------------------------------------------

--
-- Table structure for table `typedb`
--

CREATE TABLE `typedb` (
  `roomType` varchar(25) NOT NULL,
  `roomName` varchar(50) NOT NULL,
  `roomDescription` varchar(255) NOT NULL,
  `roomPrice` decimal(10,0) NOT NULL,
  `roomCapacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `typedb`
--

INSERT INTO `typedb` (`roomType`, `roomName`, `roomDescription`, `roomPrice`, `roomCapacity`) VALUES
('Deluxe', 'Deluxe Room', 'Basic room with essential amenities', 100, 2),
('Executive', 'Executive Suite Room', 'Luxurious suite with separate living area', 200, 4),
('Lounge', 'Lounge', 'Standby Room', 0, 100),
('Premier', 'Premier Room', 'Spacious room with additional amenities', 150, 2),
('Presidential', 'Presidential Suite Room', 'Premium suite with luxury amenities', 250, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admindb`
--
ALTER TABLE `admindb`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `bookingdb`
--
ALTER TABLE `bookingdb`
  ADD PRIMARY KEY (`bookingId`),
  ADD KEY `bookingdb_ibfk_1` (`guestId`),
  ADD KEY `bookingdb_ibfk_2` (`roomNumber`);

--
-- Indexes for table `guestcat`
--
ALTER TABLE `guestcat`
  ADD KEY `guestId` (`guestId`);

--
-- Indexes for table `guestdb`
--
ALTER TABLE `guestdb`
  ADD PRIMARY KEY (`guestId`);

--
-- Indexes for table `newbookingdb`
--
ALTER TABLE `newbookingdb`
  ADD PRIMARY KEY (`bookingId`),
  ADD UNIQUE KEY `bookingId` (`bookingId`);

--
-- Indexes for table `paymentdb`
--
ALTER TABLE `paymentdb`
  ADD PRIMARY KEY (`paymentId`),
  ADD KEY `bookingId` (`guestId`);

--
-- Indexes for table `roomdb`
--
ALTER TABLE `roomdb`
  ADD PRIMARY KEY (`roomNumber`),
  ADD KEY `roomdb_ibfk_1` (`roomType`);

--
-- Indexes for table `testdb`
--
ALTER TABLE `testdb`
  ADD PRIMARY KEY (`bookingId`);

--
-- Indexes for table `typedb`
--
ALTER TABLE `typedb`
  ADD PRIMARY KEY (`roomType`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admindb`
--
ALTER TABLE `admindb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `guestdb`
--
ALTER TABLE `guestdb`
  MODIFY `guestId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `newbookingdb`
--
ALTER TABLE `newbookingdb`
  MODIFY `bookingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `paymentdb`
--
ALTER TABLE `paymentdb`
  MODIFY `paymentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `testdb`
--
ALTER TABLE `testdb`
  MODIFY `bookingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `guestcat`
--
ALTER TABLE `guestcat`
  ADD CONSTRAINT `guestcat_ibfk_1` FOREIGN KEY (`guestId`) REFERENCES `bookingdb` (`guestId`);

--
-- Constraints for table `roomdb`
--
ALTER TABLE `roomdb`
  ADD CONSTRAINT `roomdb_ibfk_1` FOREIGN KEY (`roomType`) REFERENCES `typedb` (`roomType`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
