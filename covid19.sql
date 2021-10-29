-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2021 at 11:25 PM
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
-- Database: `covid19`
--

-- --------------------------------------------------------

--
-- Table structure for table `guideline`
--

CREATE TABLE `guideline` (
  `guide_id` int(11) NOT NULL,
  `guide_color` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `guide_detail` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `guide_risk` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `guideline`
--

INSERT INTO `guideline` (`guide_id`, `guide_color`, `guide_detail`, `guide_risk`) VALUES
(1, 'ไม่มีความเสี่ยง', 'แนะนำให้ป้องกันตัวโดยการใส่แมสทุกครั้งที่ออกจากบ้านหรือใกล้ชิดผู้คน ฉีดแอลกอฮอล์ทุกการสัมผัสในที่ต่างๆ ไม่ไปพื้นที่สุ่มเสี่ยงหรือที่ที่มีคนเยอะ', ''),
(2, 'อาจมีความเสี่ยง', 'แนะนำให้สำรวจตนเองทุกวัน กักตัวไม่น้อบกว่า 5 วันเพื่อดูอาการ หลีกเลี่ยงการเจอผู้คน ใส่แมสป้องกันตนเองและผู้อื่นอย่างเคร่งครัด', 'หากยังมีอาการอยู่ภายใน 5 วันให้ซื้อชุดตรวจตามร้านขายยาใกล้บ้านมาทดลองตรวจด้วยตนเอง หากตรวจพบเชื้อให้โทรแจ้ง รพหรือกู้ภัยเพื่อเข้าทำการรักษาโดยเร็ว'),
(3, 'มีความเสี่ยงสูง', '', 'แนะนำให้ซื้อชุดตรวจมาทดลองตรวจด้วยตนเองทันทีหรือโทรแจ้งสายด่วนโควิด 1669 หรือ 1330 และแยกตัวออกห่างคนใกล้ชิดทันทีไม่รับประทานอาหารร่วมกับผู้อื่นเด็ดขาด');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `f_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `l_name` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `f_name`, `l_name`, `username`, `password`) VALUES
(1, 'แมว', 'เหมียว', 'admin', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `vaccine`
--

CREATE TABLE `vaccine` (
  `vac_id` int(11) NOT NULL,
  `vac_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `vac_detail` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `side_effects` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `efficiency` float NOT NULL,
  `range_age` int(11) NOT NULL,
  `disease1` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `disease2` varchar(256) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `vaccine`
--

INSERT INTO `vaccine` (`vac_id`, `vac_name`, `vac_detail`, `side_effects`, `efficiency`, `range_age`, `disease1`, `disease2`) VALUES
(1, 'Sinovac', 'วัคซีน‘Sinovac’มีประสิทธิภาพการป้องกันการติดเชื้ออยู่ที่ 51%  และยืนยันป้องกันอาการป่วยรุนแรงและเสียชีวิต 100 เปอร์เซ็นต์', 'อาจมีอาการปวดเมื่อยเนื้อตัวมีไข้มีอักเสบบริเวณที่ฉีดหรืออาเจียน', 50.4, 2, 'ผู้ที่มีภูมิคุ้มกันบกพร่อง', 'ผู้ที่มีประวัติภูมิแพ้อย่างรุนแรง เช่น แพ้อาหาร แพ้โลหะ'),
(2, 'Sinopharm', 'ประสิทธิภาพในการป้องกันการติดเชื้อไวรัส: 78.1-79.34% ประสิทธิภาพในการลดอาการรุนแรงถึงชีวิต: 100%', 'อาจมีอาการปวดเมื่อยเนื้อตัวมีไข้มีอักเสบบริเวณที่ฉีดหรืออาเจียน', 79.3, 2, 'ห้ามฉีดในผู้ที่มีอาการแพ้ส่วนประกอบของวัคซีน', 'ห้ามฉีดในผู้ที่อาหารภูมิแพ้อย่างรุนแรง'),
(3, 'Moderna', 'หลังจากฉีดเข็มแรกไปแล้ว 14 วัน จะมีประสิทธิภาพในการป้องกันประมาณ 50.8% หลังจากฉีดเข็มที่ 2 ไปแล้วประมาณ 2 สัปดาห์ จะมีประสิทธิภาพในการป้องกันได้ประมาณ 92.1%', 'อาจมีอาการหนาวสั่น เป็นไข้มีอาการอ่อนเพลีย มีอาการปวดหัว', 94.5, 2, 'ผู้ที่มีประวัติแพ้สารโพลีเอธิลีน ไกคอล (Polyethylene glycol: PEG)', ''),
(4, 'AstraZeneca', 'หลังฉีดเข็มแรก 30 วัน ผู้ใช้วัคซีนมีภูมิคุ้มกันถึง 96.7% ลดอัตราการแพร่เชื้อไวรัสโคโรน่า-สูงถึง 63.0% หลังฉีดเข็มแรก 3 สัปดาห์', 'มีอาการเจ็บบริเวณที่ฉีดมีอาการปวดศรีษะและอ่อนเพลียมีอาการปวดกล้ามเนื้อครั่นเนื้อครั่นตัวมีอาการไข้หนาวสั่น', 62, 2, 'ไม่มีโรคประจำตัวขั้นรุนแรงที่ไม่สามารถควบคุมโรคได้ ได้แก่ โรคความดัน โรคมะเร็ง โรคหัวใจและหลอดเลือด โรคทางเดินหายใจเรื้อรัง กลุ่มโรคระบบประสาท กลุ่มโรคเบาหวานและโรคอ้วน', 'ไม่มีประวัติแพ้ยา'),
(5, 'Pizer', 'หลังจากฉีดวัคซีนไฟเซอร์เข็มที่ 2 แล้ว จะมีประสิทธิภาพในการป้องกันโรคโควิด 19 สูงถึง 91.3% ในช่วง 7 วันถึง 6 เดือนหลังฉีด', 'มีไข้หนาวสั่นปวดศีรษะปวดกล้ามเนื้อปวดข้อต่อท้องเสียอ่อนเพลีย', 95, 2, '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `guideline`
--
ALTER TABLE `guideline`
  ADD PRIMARY KEY (`guide_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `vaccine`
--
ALTER TABLE `vaccine`
  ADD PRIMARY KEY (`vac_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `guideline`
--
ALTER TABLE `guideline`
  MODIFY `guide_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `vaccine`
--
ALTER TABLE `vaccine`
  MODIFY `vac_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
