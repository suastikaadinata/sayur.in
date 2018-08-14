-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 18, 2018 at 09:19 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sayurin`
--

-- --------------------------------------------------------

--
-- Table structure for table `chatting`
--

CREATE TABLE `chatting` (
  `id` int(10) UNSIGNED NOT NULL,
  `pengirim_id` int(10) UNSIGNED NOT NULL,
  `penerima_id` int(10) UNSIGNED NOT NULL,
  `pesan` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `sayur_id` int(10) UNSIGNED NOT NULL,
  `jumlah` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `order` tinyint(1) NOT NULL DEFAULT '0',
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `isDeliver` tinyint(1) NOT NULL DEFAULT '0',
  `kode_belanja` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_resets_table', 1),
(3, '2018_05_12_031558_create_sayur_table', 1),
(4, '2018_05_12_031825_create_keranjang_table', 1),
(5, '2018_05_12_032202_create_pembayaran_table', 1),
(6, '2018_05_12_032618_create_pengiriman_table', 1),
(7, '2018_05_12_034504_create_chatting_table', 1),
(8, '2016_06_01_000001_create_oauth_auth_codes_table', 2),
(9, '2016_06_01_000002_create_oauth_access_tokens_table', 2),
(10, '2016_06_01_000003_create_oauth_refresh_tokens_table', 2),
(11, '2016_06_01_000004_create_oauth_clients_table', 2),
(12, '2016_06_01_000005_create_oauth_personal_access_clients_table', 2),
(13, '2018_07_17_015017_create_sayurmobile_table', 3);

-- --------------------------------------------------------

--
-- Table structure for table `oauth_access_tokens`
--

CREATE TABLE `oauth_access_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `client_id` int(11) NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_access_tokens`
--

INSERT INTO `oauth_access_tokens` (`id`, `user_id`, `client_id`, `name`, `scopes`, `revoked`, `created_at`, `updated_at`, `expires_at`) VALUES
('00e6368500ca27d09a325391ecb5a6e7ecf94d68fb582ec877bd4900ffc691ad6eea7c71cca6e978', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:54:33', '2018-07-11 00:54:33', '2019-07-11 07:54:33'),
('01b63d915293fd9f1d422b412163493a8fb235fd02d5288499e6e630d317eb7782d43ad81426c7c4', 7, 3, 'sayurin', '[]', 0, '2018-07-13 20:46:56', '2018-07-13 20:46:56', '2019-07-14 03:46:56'),
('0472d1d0b585b4ccded897aaa84615e45059e4fc898f4e99c07db3f00c7192e7541b1a54005f0458', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:45:02', '2018-07-16 00:45:02', '2019-07-16 07:45:02'),
('066c95746a1421af77259dc879d0b642f0c4178a809c554ee57c6b6e10a59765b46edbe2380d78b8', 1, 3, 'sayurin', '[]', 0, '2018-07-16 20:18:01', '2018-07-16 20:18:01', '2019-07-17 03:18:01'),
('08a1d194e4969046dbf9ec47147ea3ea5a8ea1687a64b440335daa7693c2bf3bb90ad1860f1ff46a', 1, 3, 'sayurin', '[]', 0, '2018-07-13 01:04:37', '2018-07-13 01:04:37', '2019-07-13 08:04:37'),
('08ddf3ad19c945cf311fd36468605d8e6df6d6a05f782567e7691aebc82608b1c1a61b7bc91464f7', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:17:22', '2018-07-12 00:17:22', '2019-07-12 07:17:22'),
('08e38ea37a00a9ae6543a645ae002b1b2b391f7a5e01037154069d4cf2abda9b9e82d064ccc14599', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:25:51', '2018-07-12 00:25:51', '2019-07-12 07:25:51'),
('0bc850900fe6c9ef6da732a0a3e95a1fc4acdb72c985bc68c274b3774fa2ad083e761a3993d91a5c', 1, 3, 'sayurin', '[]', 0, '2018-07-12 02:05:23', '2018-07-12 02:05:23', '2019-07-12 09:05:23'),
('0c77ffa8105c8eeb53fd06b57b3dd7c2b944b49d2e6496629c4bedb639d5af0e148b269b7f66d926', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:51:15', '2018-07-13 20:51:15', '2019-07-14 03:51:15'),
('0e06fec5042a714b7df57599f2dd715db843818d6fd868946007aad920ed2b921bccf46686608c93', 1, 3, 'sayurin', '[]', 0, '2018-07-15 20:39:00', '2018-07-15 20:39:00', '2019-07-16 03:39:00'),
('1035d51a05d84c161c6727b2800de00c0a0ab77aabc772286f32c67f03d45170b73dc082634b5437', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:01:18', '2018-07-12 00:01:18', '2019-07-12 07:01:18'),
('1271aefad88c291ef58bc0df087226e71d5f5d70b8c7b43810c80b35b211e44ebcf8e8bcb1287687', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:34:28', '2018-07-13 20:34:28', '2019-07-14 03:34:28'),
('13ab778b1d4926239e491cdc32d6b6d100e581c2fb5f1cf598542abf0b3a8308b4fd99e09b5ce750', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:13:51', '2018-07-12 00:13:51', '2019-07-12 07:13:51'),
('13c5d03cc2f22980fd84d6abb152ae64e6250682a3930fa6711ca6bf95a5e5a83e6c7f3b24d18b83', 7, 3, 'sayurin', '[]', 0, '2018-07-12 00:08:04', '2018-07-12 00:08:04', '2019-07-12 07:08:04'),
('153d042d5e914669ac2c0a811c052328efa797cfd0ca739a618ca703a278c47d7e513bbdcc37b2ac', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:47:25', '2018-07-13 20:47:25', '2019-07-14 03:47:25'),
('1616a94bbbed6f9a2e0d5932652382100902899bc57f44cd7b53954152f17c06ab5f1f71ccae82be', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:18:31', '2018-07-12 00:18:31', '2019-07-12 07:18:31'),
('16ef22fb9d9ab46d20855f4920625dd95bde5420ff0246e90229a78a4ce61128bb8bedbffc17cb53', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:00:27', '2018-07-12 20:00:27', '2019-07-13 03:00:27'),
('17c9bb7e92bf483ee3a9ed9f1f98ec295e5110bfb8be553788120dc1a79ba25aa99ac5569a7f3c0b', 1, 5, 'sayurin', '[]', 0, '2018-07-16 23:57:13', '2018-07-16 23:57:13', '2019-07-17 06:57:13'),
('1803831ac6ce922ec915043d150abc55e505241b5a59696462c88d7f1276f4e89f1cf9fdf77834d1', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:14:47', '2018-07-13 20:14:47', '2019-07-14 03:14:47'),
('18499d4908a856907e444a22d5da3aac53d4909d45871da1bb08e9da101e2e0793d7f5f5c53fc421', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:54:17', '2018-07-11 23:54:17', '2019-07-12 06:54:17'),
('1b6b35cc6fba6733b623b8c9f7f1278d5e419553851149cd2fbd0e07982905557befaf4160957ff3', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:46:31', '2018-07-12 01:46:31', '2019-07-12 08:46:31'),
('2098a109b7593b938fe9917968b64b43a792bff448a3e20dc268a29bde7b562e6ea4a9b670fa84e0', 5, 1, 'MyApp', '[]', 0, '2018-07-01 20:13:00', '2018-07-01 20:13:00', '2019-07-02 03:13:00'),
('243a187cc3a9974e218d3cf267fdcc1fbb3cf9a385cf38601f913518c5e014c2f8b04cb7c2ef554c', 1, 3, 'sayurin', '[]', 0, '2018-07-12 02:13:47', '2018-07-12 02:13:47', '2019-07-12 09:13:47'),
('24e83fd7a3550d126adc5d4372159ea94e363930788bf4149bcd070b564ccb954142074c741cabcd', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:50:20', '2018-07-12 01:50:20', '2019-07-12 08:50:20'),
('285b3f5b334f0426e87f7be5cd420bab6fb52a2a2df92e118a595e27bdaeadab8d44936c1d507178', 7, 3, 'sayurin', '[]', 0, '2018-07-12 02:14:07', '2018-07-12 02:14:07', '2019-07-12 09:14:07'),
('28e3996ea030255baeadd9fb4de711b9e194175466e07e2107986af1f20635a1a67eba781eccf842', 1, 3, 'sayurin', '[]', 0, '2018-07-16 20:18:02', '2018-07-16 20:18:02', '2019-07-17 03:18:02'),
('2a5ef009506da66374b36b6d01e27618b6fd04dd50071ced77e11d90330c13249ca6e6793d33d984', 1, 3, 'sayurin', '[]', 0, '2018-07-12 02:13:47', '2018-07-12 02:13:47', '2019-07-12 09:13:47'),
('2c3a320573da0065b0ac3098174850dd5f83bce24614d2181ee33333e451c39e0c9e0ef58a6ebf11', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:09:53', '2018-07-13 20:09:53', '2019-07-14 03:09:53'),
('2c87cdf5c6aead90757e1a4b31892e2ef2e5ffc653d28faeb39d07d1a0e4359af35bf768aee002a8', 1, 3, 'sayurin', '[]', 0, '2018-07-10 23:07:32', '2018-07-10 23:07:32', '2019-07-11 06:07:32'),
('305d865dd73091773bd0600a5302b854e8d27aba30d829f36bc286c0298f101aceaabb4d2e94b322', 10, 5, 'sayurin', '[]', 0, '2018-07-17 01:48:51', '2018-07-17 01:48:51', '2019-07-17 08:48:51'),
('327488609e339edf1d1cb95c21e907fb5025fb6367c028a1b4b471cb8a15993c4abc7986cfdd404c', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:39:42', '2018-07-12 01:39:42', '2019-07-12 08:39:42'),
('33817d570ee2f699dcbed7af93d2e8eaa4479d78ffca9a936ee042fa27b72bfe32971604dfd28ffc', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:09:34', '2018-07-12 00:09:34', '2019-07-12 07:09:34'),
('3545e3c129b186650ada12301a8ba113ce6973f3c5e755b2b3ec2a8ed4bf40529d4c1ad1744d80f2', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:11:30', '2018-07-16 00:11:30', '2019-07-16 07:11:30'),
('38ec9a2497ea26516512d5727db67235089f0e94a2efdfd2c2f5f3d575f9f4b5941dbc957244264a', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:33:48', '2018-07-12 00:33:48', '2019-07-12 07:33:48'),
('3a3f2ac68d815f082b28cc1acc4f397550b81f464715960ac107d61c4d98176664361e1b4c16dbaa', 1, 3, 'sayurin', '[]', 0, '2018-07-13 21:32:44', '2018-07-13 21:32:44', '2019-07-14 04:32:44'),
('3a63e827988fe710ab84f91db4fbce0b159ae5c80f88b170f31c494f79735904c53bedd61ab9dacc', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:55:39', '2018-07-11 23:55:39', '2019-07-12 06:55:39'),
('3b1d1d2ad882ccb6a32ce11d1eae1b1f9b920aadfb949d886b4061e56555b5df8632c09b079fa689', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:56:32', '2018-07-11 23:56:32', '2019-07-12 06:56:32'),
('3e7c2ddeee3d885a57d10169155251c150dc39badc6fcdaffc1a86426f363f2fe7c09c5c766df129', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:07:29', '2018-07-13 20:07:29', '2019-07-14 03:07:29'),
('3f8f8ec75b7197641396e5a53e2ef2832735f97d54089685362e3521459238be07b8819517a5ca3d', 1, 3, 'sayurin', '[]', 0, '2018-07-11 21:09:53', '2018-07-11 21:09:53', '2019-07-12 04:09:53'),
('3ff6f0399a36a1770d93ef58861ba2a59724ce7d996d0ab70d95d1ae0045e5bbae4abd44681bb011', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:17:36', '2018-07-13 20:17:36', '2019-07-14 03:17:36'),
('415c1efa780c1c7a38e7a7ffb2f24be6583c1d5aa277dd9b81ad71e7f49c9e4509e8927117a2e15e', 7, 3, 'sayurin', '[]', 0, '2018-07-12 20:48:52', '2018-07-12 20:48:52', '2019-07-13 03:48:52'),
('420060e2889a80db3e74785e7aac8090b15e836618b8e2e7c35e01fca7680f283c673829fb487635', 1, 3, 'sayurin', '[]', 0, '2018-07-11 21:15:09', '2018-07-11 21:15:09', '2019-07-12 04:15:09'),
('43012f54a6f07056661d66ca4280ca5399d5352508c47869acb7f89eafdbccc52797b86278a83d25', 1, 3, 'sayurin', '[]', 0, '2018-07-15 21:18:57', '2018-07-15 21:18:57', '2019-07-16 04:18:57'),
('435c850c870682c85fef2ef8e26b8998622c1a266376929cb4c9ca082e9dfb3951998952983c6ab7', 1, 3, 'sayurin', '[]', 0, '2018-07-13 21:11:02', '2018-07-13 21:11:02', '2019-07-14 04:11:02'),
('455a0ea2aaa32a7c75b4be07aefd57b2171229e0e6950b27d9de21b8ac8968eb69a2ad93f0527993', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:47:35', '2018-07-11 00:47:35', '2019-07-11 07:47:35'),
('4654450366a011e63d55aab4dd411cc8ec664b069f188f470e38ceed2e6d89bd7f1cb24965f9601a', 1, 5, 'sayurin', '[]', 0, '2018-07-17 01:44:44', '2018-07-17 01:44:44', '2019-07-17 08:44:44'),
('47a21e16013c9a4839572e6c5b53b4776a39717657629f567c8fe2430df2f93fe9818ec76ff6d100', 7, 3, 'sayurin', '[]', 0, '2018-07-12 20:07:43', '2018-07-12 20:07:43', '2019-07-13 03:07:43'),
('47c3aef39ee72709598fd994c40b14ba766b0bc1261c4de72adc1e7f1bf2418d7ebb28b92c59808d', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:11:22', '2018-07-12 00:11:22', '2019-07-12 07:11:22'),
('488e3def0178c53e845532a94cd9f60eb6cff61236ac127a34ba57a48d8f55f987deaf0fa4663d0e', 1, 5, 'sayurin', '[]', 0, '2018-07-17 01:49:51', '2018-07-17 01:49:51', '2019-07-17 08:49:51'),
('48c4a4aec9e51640f47fa08bdb5696c7f068fb457d4377f06ede7bf1cdaef0235b7024417d9b12f9', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:39:41', '2018-07-11 01:39:41', '2019-07-11 08:39:41'),
('4917922b6d12f67bae7076caab1ddfe32e501712d4eabcdce6b641e8affe098340b9fdba84bded88', 1, 5, 'sayurin', '[]', 0, '2018-07-16 22:59:37', '2018-07-16 22:59:37', '2019-07-17 05:59:37'),
('495dade8683ece54fbfd6e6bdd57111c65649093c2d77d1b1078c5ccd3b91712396a7b54715bcc62', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:37:26', '2018-07-11 01:37:26', '2019-07-11 08:37:26'),
('497c8b756b4cc514e3473d563b17676080c8d5e3cc5dd062f0fec9b8734d5473d37cbb51a8a45631', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:21:56', '2018-07-15 23:21:56', '2019-07-16 06:21:56'),
('4a936621a516da9dd54a5cb3cf8a35a745ba52a85ddce7f50100caee6145e188d41580a3b68bdb43', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:52:28', '2018-07-12 00:52:28', '2019-07-12 07:52:28'),
('4abef21b2583f8cd752558c142504f03e813d2dffad296f308c4abbf0816b52d09c076fb8e5351a1', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:27:19', '2018-07-12 00:27:19', '2019-07-12 07:27:19'),
('4c59c0cbd82b0bd2cc7bb226d5710d35f705326a60cdcdcbc294b12aff563b905840dc59bfcea85a', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:23:30', '2018-07-15 23:23:30', '2019-07-16 06:23:30'),
('4d0f82d2d2b55602026db5b6076f680f5d55978cfaf8cfd36523700495e9c7bab189fc464525f848', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:29:26', '2018-07-15 23:29:26', '2019-07-16 06:29:26'),
('4debd645a8cdd76b72c2c8c738d0a98cb2f1cce1e708c0ff5feef00053e6d1a0621b386127879546', 1, 3, 'sayurin', '[]', 0, '2018-07-12 02:01:44', '2018-07-12 02:01:44', '2019-07-12 09:01:44'),
('5355ee6a536e35929595cb45a4c68380a0a9bd8e0352d122ec56171b8e09e415747b35ea484f1ece', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:34:08', '2018-07-16 00:34:08', '2019-07-16 07:34:08'),
('545a6809f498c1be2648967fe0b6aba2a47366c5c911542c2eea38724f24b74da059d434da31f505', 7, 3, 'sayurin', '[]', 0, '2018-07-12 00:03:24', '2018-07-12 00:03:24', '2019-07-12 07:03:24'),
('56ebddc3aeb409e9a47613d7a1db74791d1574d618db69033d7b5a6d10e6622696663bca5f95d5c6', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:11:37', '2018-07-11 01:11:37', '2019-07-11 08:11:37'),
('578c2329de484c5e567762a79d98aba34bec1d083f21f2baf7e757f5ffc419808599b95623a8d6ac', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:12:50', '2018-07-13 20:12:50', '2019-07-14 03:12:50'),
('58c2d4babab1be816ce847a2116d8b3ded98f3e0a5e739cd1dd1cf3d8bb756990dd37aedf8ebbcf8', 1, 3, 'sayurin', '[]', 0, '2018-07-12 23:20:04', '2018-07-12 23:20:04', '2019-07-13 06:20:04'),
('5a2e5c005d238404cccf7169ba8a76cbbe0868d5b62892deafb9c90d35c6938ac4188e73ea74ef8f', 1, 5, 'sayurin', '[]', 0, '2018-07-17 01:44:43', '2018-07-17 01:44:43', '2019-07-17 08:44:43'),
('5a64de4ed3909e190c786060893c6ded09c502d2cfe0a18755525dd1f2420273e3ac7693485b36aa', 1, 3, 'sayurin', '[]', 0, '2018-07-10 23:15:59', '2018-07-10 23:15:59', '2019-07-11 06:15:59'),
('5d033fd3ad3ffc4b124b84171c21fa56a38d755b1929c47ecef34ff6f1c0c1e5411c2f4a1b678dd7', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:44:12', '2018-07-11 00:44:12', '2019-07-11 07:44:12'),
('5d41193863c0d4029546586425d4ddb23cfe309a571323859263efb27e530c95fac3fa403d5abc40', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:17:44', '2018-07-15 23:17:44', '2019-07-16 06:17:44'),
('5d75577d357373cb4732bb294e06e5787676e80553730ef9e4c390303e38f80ba9564e8551141815', 1, 3, 'sayurin', '[]', 0, '2018-07-16 02:01:44', '2018-07-16 02:01:44', '2019-07-16 09:01:44'),
('5e72f4893c7df78b058789110a8f914b8db0ce889c2a7874a024e50567c5ea32492dd5b92b70d321', 1, 3, 'sayurin', '[]', 0, '2018-07-12 23:33:10', '2018-07-12 23:33:10', '2019-07-13 06:33:10'),
('5eb13c613a1d15ae871b0902d3fd496b45676bff1c402f60f96d697ec7fc0fac9d77b5aebbc57f0b', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:37:31', '2018-07-12 01:37:31', '2019-07-12 08:37:31'),
('61e6903143a27eb6293bfb8b199e5a021d450da320317b4aea4d838e7ff0cf683b469fb33e4d0498', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:56:01', '2018-07-11 00:56:01', '2019-07-11 07:56:01'),
('638dc1957259ce187d2bcb273226df9d4d04c3b1b935125f8806ad8ebbf64fd2fc9e06261e531eef', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:43:18', '2018-07-11 23:43:18', '2019-07-12 06:43:18'),
('63d9bdc46b64ac524cb3609a75b334db4d88765a71aa1aa2b18f6f2c5f6470120691f9dc132566a7', 1, 5, 'sayurin', '[]', 0, '2018-07-16 23:18:00', '2018-07-16 23:18:00', '2019-07-17 06:18:00'),
('67583393435acdfd45e66396e92e1b7e7d1bcc3135dc1c65d668ecb180a91afc61250f75951b5bb9', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:31:56', '2018-07-16 00:31:56', '2019-07-16 07:31:56'),
('67c4827bcbd29426766535ca931891328437e400caffce53d541d2a47ba1fad38e7c90ec91717daa', 7, 3, 'sayurin', '[]', 0, '2018-07-11 23:46:37', '2018-07-11 23:46:37', '2019-07-12 06:46:37'),
('69bf72b84902bb68041ed8d0e2e439b36668f083aaeed4887c9c0d8e1dd34a26414d44f5a818d84d', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:10:48', '2018-07-13 20:10:48', '2019-07-14 03:10:48'),
('6a8263b981a843a0c270e547a996fa799ead71111c40915ff888867b864370e6c34b85893710334d', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:54:38', '2018-07-11 00:54:38', '2019-07-11 07:54:38'),
('6bffb6ecdaec8a69ac11a5ff2f14a4a69329ef6db4484a87ec9f5c960dbf8a74bb0fe576e6ca2f5b', 1, 5, 'sayurin', '[]', 0, '2018-07-16 22:53:35', '2018-07-16 22:53:35', '2019-07-17 05:53:35'),
('6eac2f1318bf4ce505d91d18ada8d69056f7afd0301399185caf4f964965ab1803a50c28c55c7838', 9, 5, 'sayurin', '[]', 0, '2018-07-17 01:48:02', '2018-07-17 01:48:02', '2019-07-17 08:48:02'),
('6fd36511b66987ec9586c3786678e8cc3566fd7a200d1adeda65363918b7162fe4c80ce634f855ba', 1, 3, 'sayurin', '[]', 0, '2018-07-12 23:20:04', '2018-07-12 23:20:04', '2019-07-13 06:20:04'),
('7052a8f36db93fc1c9a3f969b0d04898557405e772543f894860efc9e47b0055348f2591af3c738d', 1, 3, 'sayurin', '[]', 0, '2018-07-16 02:06:54', '2018-07-16 02:06:54', '2019-07-16 09:06:54'),
('71a3ac0f75f8e2cbfeb81d866a977565cd50c2b53f0d17be22b249a2eccda2dcb558d4b1e1f59d3b', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:54:40', '2018-07-12 01:54:40', '2019-07-12 08:54:40'),
('71d7fa00e5bb5f0dc50eead6895ac36e67a018df6058df46db193e3c3c83d9eb8353a1a9024b2f63', 1, 5, 'sayurin', '[]', 0, '2018-07-16 23:06:38', '2018-07-16 23:06:38', '2019-07-17 06:06:38'),
('7ab2772d1314475fa7a0d4f4079d2a95ae06f081da3b17b978bd7f9cc29487d5bd6a4493699e82b1', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:31:26', '2018-07-11 01:31:26', '2019-07-11 08:31:26'),
('7b26d2c0ce9614f85e426ba502a504a4137e1f6187d47deec5b1f43c5b46cd13ada142ed95dd5251', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:32:32', '2018-07-15 23:32:32', '2019-07-16 06:32:32'),
('7c0ead99df0829e7b1d64fbbdbb6aa3dcc88313c5b4e5579988145a33b0e8c8f6adc84b08814a562', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:18:28', '2018-07-15 23:18:28', '2019-07-16 06:18:28'),
('7d3a793fae0228d5b71283a040b300d0511974d465ca593b97aaa782e45c26887045f49752831fdb', 7, 3, 'sayurin', '[]', 0, '2018-07-12 20:11:40', '2018-07-12 20:11:40', '2019-07-13 03:11:40'),
('7da4c5737b20906a079e118a004f1010717e911b52f89f4cca4782219d38c463277b6d31673697d9', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:06:14', '2018-07-15 23:06:14', '2019-07-16 06:06:14'),
('802a51ff0f556d6f679b248b7fe1bd7afb110bf6f697b70589e189b59bf699efc574671105d21b59', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:08:22', '2018-07-13 20:08:22', '2019-07-14 03:08:22'),
('8315d4772c872a8f32cc432e98b08844f0ea8897d297d140e1dc1f1a362c7906ee72b9160d80f29a', 1, 3, 'sayurin', '[]', 0, '2018-07-16 01:50:43', '2018-07-16 01:50:43', '2019-07-16 08:50:43'),
('837857e13f3961d76ecf40e4e2b6a50e2b967ba310720a3fec0d8a485aa6fcf9d504724ed97c10e5', 1, 3, 'sayurin', '[]', 0, '2018-07-12 23:23:49', '2018-07-12 23:23:49', '2019-07-13 06:23:49'),
('848977ce4daf4be63f3408c04845136a901a1285e409bf3864bcfbe3a779d1b6f08b75bce95944e8', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:06:32', '2018-07-11 01:06:32', '2019-07-11 08:06:32'),
('8a66b16c520f1ed15387416f5fb9c6f4af13eeff276c0478f4b252e6c51bff5ee1498e404a1cb575', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:25:14', '2018-07-15 23:25:14', '2019-07-16 06:25:14'),
('8b9d89ce8420befb3044e6b6ba22e58005208310d8d826ba693e95813fc537e75c8a356ead62e588', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:00:27', '2018-07-12 20:00:27', '2019-07-13 03:00:27'),
('8bc10e81e864a3cd7a69f65014c055e78fc1307dfa7994eff3bb74973fbad9680ea0080cab7887e6', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:53:50', '2018-07-12 01:53:50', '2019-07-12 08:53:50'),
('8d7c3ed88a9766aac467168c544ed835924a4be5c5976634c2675d6f815e8fbdbe128fa7bade352b', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:59:38', '2018-07-11 23:59:38', '2019-07-12 06:59:38'),
('8dfbbb724ad7c6b52ae742b707ad308cfafbef4ddc4e8b71b3b6b1293a2a345b54f689ee3e96ef50', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:48:38', '2018-07-12 01:48:38', '2019-07-12 08:48:38'),
('8f6c1bc7f4c49654313ef162172f6d4c77751a9aadc62ab8e105eb7899fbc8d08ed3a457f858cf7b', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:49:31', '2018-07-12 20:49:31', '2019-07-13 03:49:31'),
('905727fec930b2c5e3147f0d8ebb212f80d0bb4a811d680caaac3b6f77465ed694e7c9bdabbd69c7', 1, 3, 'sayurin', '[]', 0, '2018-07-15 21:03:50', '2018-07-15 21:03:50', '2019-07-16 04:03:50'),
('907430cf998b5e6e79e445f03e028aea036e9f8bcff4da9a1a1c1f06a26029173037808471d94798', 8, 5, 'sayurin', '[]', 0, '2018-07-16 23:14:25', '2018-07-16 23:14:25', '2019-07-17 06:14:25'),
('90c757d3812be94dde3bd971dba64dcad085477b2ef107886116e11d9f7a10c7dafb94db7ac511bb', 1, 3, 'sayurin', '[]', 0, '2018-07-11 23:43:18', '2018-07-11 23:43:18', '2019-07-12 06:43:18'),
('956cf5703403d2a29bdc393fbf33163b884391b2635bd47f08a6143aae4fe9d8cebdc979fdee3525', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:05:56', '2018-07-12 20:05:56', '2019-07-13 03:05:56'),
('98600701d153932e1cac72b88d641c8e90c95eba3f0a8d2e77b2cc151631f5fb0b8c52e629e5d3c2', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:07:30', '2018-07-13 20:07:30', '2019-07-14 03:07:30'),
('99dbc605c773f4af895c78b187425541c2e0d094d35428e94a1b11419a14b1f3cebe20bb339cdfa4', 1, 3, 'sayurin', '[]', 0, '2018-07-15 21:16:04', '2018-07-15 21:16:04', '2019-07-16 04:16:04'),
('99e0e49621ec3c7855bc15bdd96f2592bc95fb96500731b90cd78243b086ac27ca14fd88c44a8c18', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:10:15', '2018-07-15 23:10:15', '2019-07-16 06:10:15'),
('9b9c40005e02c5580fe7486e8f2e2a2c134aa3c0418b3710c4a0e86b331966247b47116fa2ba0964', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:32:12', '2018-07-12 00:32:12', '2019-07-12 07:32:12'),
('9ed6a3e3c4d0c5a1da385abac63771830fe40c199c65c22f312d55336d93e5d64cd54695c293e0eb', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:47:54', '2018-07-11 01:47:54', '2019-07-11 08:47:54'),
('9f311e2e39e4ebb5e54b8688fbabdb71d86615ce7b1892a356ba8c5dc5d1eed54cd5688159080141', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:47:54', '2018-07-11 01:47:54', '2019-07-11 08:47:54'),
('a19bde617665e80d247985ce04eb8fe456c9fd0efcf10231f33708105a6fe7ad89787b033d52a275', 1, 3, 'sayurin', '[]', 0, '2018-07-12 02:14:48', '2018-07-12 02:14:48', '2019-07-12 09:14:48'),
('a2dcb57ae685a250176678109e55da230b6f2547433c5710f5e3d9692279f650d8c13460c0bc7370', 6, 3, 'sayurin', '[]', 0, '2018-07-11 00:25:15', '2018-07-11 00:25:15', '2019-07-11 07:25:15'),
('a4cb0c9df7c6a7c0e3a452803047e55e811d60dc5b7f8b9846aa9e438f8cb852d3a0a3aaafedd136', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:24:04', '2018-07-13 20:24:04', '2019-07-14 03:24:04'),
('a539cbb12e4139f21dee023783ca23e1fc08175b5a721c9e50ca890f1cbcdb167a3764bc44e8f96a', 7, 3, 'sayurin', '[]', 0, '2018-07-12 23:41:49', '2018-07-12 23:41:49', '2019-07-13 06:41:49'),
('a726db844cf651e3e1579d3afbbebd2f2c4dc6577478b234d39f9fc23fa3bfbec789734b4c6e0c54', 1, 3, 'sayurin', '[]', 0, '2018-07-15 21:11:28', '2018-07-15 21:11:28', '2019-07-16 04:11:28'),
('a9b7e0739ed976a77ed89c0648eaa7f262cf62c932f122f69d28c7378797cd41c3dd651b4cf3701b', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:47:21', '2018-07-11 00:47:21', '2019-07-11 07:47:21'),
('abc60ed88c83f751a5910abbd5819d83c1a53c19229dd76d53b5df214744284a242564944baeb28d', 1, 3, 'sayurin', '[]', 0, '2018-07-11 21:21:00', '2018-07-11 21:21:00', '2019-07-12 04:21:00'),
('acc57b3d095392ca50fd752dbe83136777824e4ab4e1e1eab7d7a2a62b61945ea00cba05eed62150', 6, 3, 'sayurin', '[]', 0, '2018-07-11 00:25:15', '2018-07-11 00:25:15', '2019-07-11 07:25:15'),
('ad1a14b04c4f31b9794e0657b94cb669185e9c8cc2abde3a562243d87811dd53e34291ff914c48b0', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:44:12', '2018-07-11 00:44:12', '2019-07-11 07:44:12'),
('ad879e36a3d22c54b96adc5332c06b207eef6a03ca5e28566ca4630bc4733259b1b09de9818a948e', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:48:43', '2018-07-11 00:48:43', '2019-07-11 07:48:43'),
('af89becd37ac697368b682f205f395ad1fa903ffac59483a99a49d641bcef737993200d8966529e8', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:08:25', '2018-07-15 23:08:25', '2019-07-16 06:08:25'),
('b17ad1efc395d2ecab913c3f883b73e423a03f543c16c981e638ee47d37d79b9ab22bdb7bab62ad3', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:43:04', '2018-07-12 01:43:04', '2019-07-12 08:43:04'),
('b2d6442efc3ef8342b133ee036b3a2ab886c5d1eb45077141dca9704043228a80b3458c4feeedd06', 1, 3, 'sayurin', '[]', 0, '2018-07-16 20:26:07', '2018-07-16 20:26:07', '2019-07-17 03:26:07'),
('b3a83108344ea3719634fb53c1f50a0820d82449ea4c9316a979c25ee389d8e30ca73f03b2d56f41', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:47:51', '2018-07-11 00:47:51', '2019-07-11 07:47:51'),
('b46f93c97b62e08c6fd8d9ce9443250eb01bdd2d7d7532179495f2a73e18e203222b6c084cd0a33e', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:44:02', '2018-07-15 23:44:02', '2019-07-16 06:44:02'),
('b50770497b86e4d11672163a07596e1e59efbb8503c6128892fbe77c5f3aab9691ed2fa9854340ec', 1, 5, 'sayurin', '[]', 0, '2018-07-17 00:13:26', '2018-07-17 00:13:26', '2019-07-17 07:13:26'),
('b6c60a8d990b4bd0abec3a52cfce00613f5f7479cd89de0ac11be10b978469bd93e33c00a287c3ca', 1, 3, 'sayurin', '[]', 0, '2018-07-16 01:58:58', '2018-07-16 01:58:58', '2019-07-16 08:58:58'),
('b8d00bde1ad1d0f04e5abb62947174ef3293a48924c96d1b2714d577bbf09acf5f6a578fa184c8d0', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:06:14', '2018-07-15 23:06:14', '2019-07-16 06:06:14'),
('bccf7e85b8c0a16ca544ac95e2c4d2572bbd3f6ac7fe0c60fdf93c8af3e08f79a97c4d3a0ae90dd9', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:16:36', '2018-07-16 00:16:36', '2019-07-16 07:16:36'),
('bcd3ead30b9a8bd56410a667a26196a025e840597f7fa921ccede734653151adf50aa66ca2448b07', 1, 3, 'sayurin', '[]', 0, '2018-07-11 21:09:53', '2018-07-11 21:09:53', '2019-07-12 04:09:53'),
('beef0a49325c4cc9671cad8aa2c989154623ef351a933dad4c5ee8214aca1428d16122e1b9101a8b', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:43:08', '2018-07-12 01:43:08', '2019-07-12 08:43:08'),
('c117280056d3780d4184f975c0a48d41db2aa6024b7c527ffc85cd73eb25788490c95b3c7fa096c8', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:42:56', '2018-07-12 00:42:56', '2019-07-12 07:42:56'),
('c25d52087f6b118e57d82dcc298db03cba35ce31e2c5df2be66d5535beadd3fd6d915dfb241ee81c', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:03:12', '2018-07-12 20:03:12', '2019-07-13 03:03:12'),
('c2f129ab229f9151e412188f25e02fceedb94fb85334ddc441ced2e9cef29d8fe1864be69ea90638', 7, 5, 'sayurin', '[]', 0, '2018-07-16 23:09:37', '2018-07-16 23:09:37', '2019-07-17 06:09:37'),
('c5d69b6e6b4b8ff2a3a397f672cef8540ad5aced8460004a5708867bfc9b7add628cc6b3cb680438', 1, 3, 'sayurin', '[]', 0, '2018-07-16 01:19:07', '2018-07-16 01:19:07', '2019-07-16 08:19:07'),
('c6e480fed7a3f667b5996071d0ad688debe64d1c964f12e5884f64a15a1634ead04daf80a4c28be8', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:32:58', '2018-07-16 00:32:58', '2019-07-16 07:32:58'),
('c8426d36aaaf15a767b68cba6b0f63985fbf7d48277263e691ad7140ecf8df3916f4bbf77ef06923', 1, 5, 'sayurin', '[]', 0, '2018-07-17 00:08:25', '2018-07-17 00:08:25', '2019-07-17 07:08:25'),
('cbc1215944d6e920417192a63dd03277281e6f5e06aded31d439e70b56d52263c9b667405fe287f0', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:30:41', '2018-07-12 20:30:41', '2019-07-13 03:30:41'),
('d0a81d33aad09772df92b504b2010eec49339ed70fa0d260dd110d2b76ac3a9aa4562696b99eb7f4', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:45:27', '2018-07-12 01:45:27', '2019-07-12 08:45:27'),
('d2ac28a0b4023dfbc9bb9ce8a4dc53e673899ab6ff538a529ca16e1bb5916ad6b88138cdce541f37', 1, 3, 'sayurin', '[]', 0, '2018-07-16 01:18:52', '2018-07-16 01:18:52', '2019-07-16 08:18:52'),
('d36a20d4498a5a5488949f6a20900dd3e43f1521befb49b6ba430cc7d2020994906c3837e2f78fad', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:00:13', '2018-07-11 01:00:13', '2019-07-11 08:00:13'),
('d42b5a207a968e6082d42d8bece3fc2876678e8c086773edfdcdecab215a3f07cbbd38cdedca5312', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:00:11', '2018-07-11 01:00:11', '2019-07-11 08:00:11'),
('d481359d0d46b5355224d432c40a2367e11ee7c249da17fec562103ae9a330a046777a1228450b12', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:20:41', '2018-07-15 23:20:41', '2019-07-16 06:20:41'),
('d4ca9918f16a393e19731a243c48b2d6eb3df64ae2a1591890ac173bed26c896510dab28c7858954', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:32:12', '2018-07-12 20:32:12', '2019-07-13 03:32:12'),
('d69f7e882a32b942f4de5065b2862ea80755a1d28b92e7a7881a7046ce4346e4d7ae890808f8f646', 1, 3, 'sayurin', '[]', 0, '2018-07-15 21:01:48', '2018-07-15 21:01:48', '2019-07-16 04:01:48'),
('d8e2b5d754111bb72a6ade001152b05a1a92f5b5d0114c83c5d898eb6c23a49d8cad483761ba0e94', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:47:43', '2018-07-12 01:47:43', '2019-07-12 08:47:43'),
('dc86f7c71b34e637288cce019f063aea229c8c6baa7ac7ea1c178d06b9761b367dc078b90c09188a', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:43:58', '2018-07-12 01:43:58', '2019-07-12 08:43:58'),
('dc99aa0543b22ef263c0ab4ad19f998bdcb06174299508ce08ecece1da89ee21fb3d96387d6349b2', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:01:59', '2018-07-12 20:01:59', '2019-07-13 03:01:59'),
('ddcfc1637ec0f4abd0cfbfcb409b8459a15ef46f0fb2b77bdb8b3b4723bad50e1423bb115e9f8949', 7, 3, 'sayurin', '[]', 0, '2018-07-11 01:02:09', '2018-07-11 01:02:09', '2019-07-11 08:02:09'),
('de08815682d36a2d31cb0b33edcfcdb21d9e047e77babe0a0c665879ea07f96f7893f6a72c91bc6c', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:27:02', '2018-07-13 20:27:02', '2019-07-14 03:27:02'),
('e15f584724de50bac23f8648bed4de51a6621204bcb56728a62a7930e7b1b062b1d9fc8794e953ce', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:13:48', '2018-07-12 20:13:48', '2019-07-13 03:13:48'),
('e301104acebd196f384ee084b2256638dc7f934a8553b55ca508bd67791f371a11ada0d70675025f', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:49:43', '2018-07-12 01:49:43', '2019-07-12 08:49:43'),
('e3038d40b8ddb5da7d56f196231f9eee90f159c950035ba2a08e94e36518a2ce814af97c35010b80', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:19:06', '2018-07-12 00:19:06', '2019-07-12 07:19:06'),
('e37be1ecdc6da4bfa79c942bfe4118cf0c5c6860ebc552115e75563f8abdc3605a33fd0ac794415f', 1, 3, 'sayurin', '[]', 0, '2018-07-10 23:17:51', '2018-07-10 23:17:51', '2019-07-11 06:17:51'),
('e58722fed8b3402eccc598910364d0e340e35ae0da63f227051d92c53773c662ed91d0da7f5f4ddf', 1, 3, 'sayurin', '[]', 0, '2018-07-12 01:59:22', '2018-07-12 01:59:22', '2019-07-12 08:59:22'),
('e5f009295b2ea42080a85c2e658a570f16e83945607718b4d153d28bce13ef5a35e61e63514c98fb', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:58:53', '2018-07-15 23:58:53', '2019-07-16 06:58:53'),
('e60a62bd1319332e5c72475ec3807eb6b435f43d7955dcd503122291defbc5bf1fdb154f84bfe41c', 1, 3, 'sayurin', '[]', 0, '2018-07-15 20:39:00', '2018-07-15 20:39:00', '2019-07-16 03:39:00'),
('e616d7b2ea1a6ee74703db06e77421197d326b9e4d8f9248727cb548e944637e39f1ef53680d6c4d', 7, 3, 'sayurin', '[]', 0, '2018-07-11 00:47:21', '2018-07-11 00:47:21', '2019-07-11 07:47:21'),
('e630018547449c1a4950326e8f1197a7f3cb83c0838300a616e051a560b04546a382b72e14d5f84f', 1, 3, 'sayurin', '[]', 0, '2018-07-11 21:13:18', '2018-07-11 21:13:18', '2019-07-12 04:13:18'),
('e707e5b3a30681e400156e9b697f951f9106bb4248cd30ddea8ef778cac85df1e47c301729b35763', 1, 3, 'sayurin', '[]', 0, '2018-07-16 01:54:29', '2018-07-16 01:54:29', '2019-07-16 08:54:29'),
('e98ef87f0ce7267638065742bc4019e93d5b0832946cccd1cbe9000c33ffce8cd4c5b9ff5d6a5ef2', 1, 3, 'sayurin', '[]', 0, '2018-07-15 23:11:33', '2018-07-15 23:11:33', '2019-07-16 06:11:33'),
('ee775d4da27228ce4a75f9391c1b21d6e308d99e68e8f871c176eaa5beca071efbd930d76e581eee', 7, 3, 'sayurin', '[]', 0, '2018-07-12 00:05:28', '2018-07-12 00:05:28', '2019-07-12 07:05:28'),
('ef550763cfae96b161a7085e16e9fe43717c61068134731891db118fc68950c1b985fad0a95bd307', 7, 3, 'sayurin', '[]', 0, '2018-07-12 20:08:54', '2018-07-12 20:08:54', '2019-07-13 03:08:54'),
('f2c3be59a9aeaa82d2d838a6a4c35abc9d260160da2022e333e056fa950abbbddbe4136b87b0859c', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:35:58', '2018-07-13 20:35:58', '2019-07-14 03:35:58'),
('f615472a6c5614a4ce170883c0e2a8791350b0783239b7dcba75ceb7a607df524a74ce1779b98f4b', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:31:21', '2018-07-13 20:31:21', '2019-07-14 03:31:21'),
('f653cf1e88896ee1cd0c11e36fc6a9a7169717eb40e09e8fcf87636f19753a8561d208716300ac82', 1, 3, 'sayurin', '[]', 0, '2018-07-12 20:24:27', '2018-07-12 20:24:27', '2019-07-13 03:24:27'),
('f7d4aff6d5e97058f547f3ffad8ea79abeed4308ab2d58e57dc54a1c2ec288e92664959429da1221', 1, 3, 'sayurin', '[]', 0, '2018-07-13 20:43:05', '2018-07-13 20:43:05', '2019-07-14 03:43:05'),
('f834fc9157e7a16c0445e9903d24906b7490d409140c72a6060102612bf76bee90a45156fd106894', 7, 3, 'sayurin', '[]', 0, '2018-07-11 23:47:32', '2018-07-11 23:47:32', '2019-07-12 06:47:32'),
('f9d6d2f89ff5bca508b5022b5c3abfb5faf65ab973baffec593d6c337a3e12cc02867becce41b1b9', 1, 5, 'sayurin', '[]', 0, '2018-07-17 00:14:33', '2018-07-17 00:14:33', '2019-07-17 07:14:33'),
('fbad3fcd4521c0d88bd2fd1682c4b74be23c18a6d75335472ff17fc06dc862dc8816dd50a31a09c8', 1, 3, 'sayurin', '[]', 0, '2018-07-16 00:07:59', '2018-07-16 00:07:59', '2019-07-16 07:07:59'),
('fc245788643e37a16dd7187f8027528824c0d983c58480ef96760f923e78b6001d91c6b4a4755aa5', 1, 3, 'sayurin', '[]', 0, '2018-07-12 00:53:12', '2018-07-12 00:53:12', '2019-07-12 07:53:12'),
('fe4a880a516effc9d6d252026d2ffee40a980d52c7a78e8896ac86b3b7f6be398ea357f4d9f1c958', 1, 5, 'sayurin', '[]', 0, '2018-07-16 23:36:26', '2018-07-16 23:36:26', '2019-07-17 06:36:26');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_auth_codes`
--

CREATE TABLE `oauth_auth_codes` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `client_id` int(11) NOT NULL,
  `scopes` text COLLATE utf8mb4_unicode_ci,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `oauth_clients`
--

CREATE TABLE `oauth_clients` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `secret` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `redirect` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `personal_access_client` tinyint(1) NOT NULL,
  `password_client` tinyint(1) NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_clients`
--

INSERT INTO `oauth_clients` (`id`, `user_id`, `name`, `secret`, `redirect`, `personal_access_client`, `password_client`, `revoked`, `created_at`, `updated_at`) VALUES
(1, NULL, 'Sayurin Personal Access Client', 'UsptlHYnpC7TeBlTKTJY99GA1ISjR13iEUujObgW', 'http://localhost', 1, 0, 0, '2018-07-01 20:12:29', '2018-07-01 20:12:29'),
(2, NULL, 'Sayurin Password Grant Client', 'UgURmjphOZfgNxBOoaihbzBCm1OSyO5S993FvYZB', 'http://localhost', 0, 1, 0, '2018-07-01 20:12:29', '2018-07-01 20:12:29'),
(3, NULL, 'Sayurin Personal Access Client', 'hAUDI912BL5PP0invQh2TnGvMocuGlfX6cggauLy', 'http://localhost', 1, 0, 0, '2018-07-10 23:07:21', '2018-07-10 23:07:21'),
(4, NULL, 'Sayurin Password Grant Client', 'eNKBoqsAhn7OqNqMo22FSWGyLihXO0SH7IoDl60G', 'http://localhost', 0, 1, 0, '2018-07-10 23:07:22', '2018-07-10 23:07:22'),
(5, NULL, 'Sayurin Personal Access Client', 'w8otdscYId9R2MrMO1P294lMGbDvAW4up4JYfv1d', 'http://localhost', 1, 0, 0, '2018-07-16 22:48:48', '2018-07-16 22:48:48'),
(6, NULL, 'Sayurin Password Grant Client', 'kPsgNK36B6BYGM0kZqpWey2WP7ixl99NjMeWiUrN', 'http://localhost', 0, 1, 0, '2018-07-16 22:48:48', '2018-07-16 22:48:48');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_personal_access_clients`
--

CREATE TABLE `oauth_personal_access_clients` (
  `id` int(10) UNSIGNED NOT NULL,
  `client_id` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `oauth_personal_access_clients`
--

INSERT INTO `oauth_personal_access_clients` (`id`, `client_id`, `created_at`, `updated_at`) VALUES
(1, 1, '2018-07-01 20:12:29', '2018-07-01 20:12:29'),
(2, 3, '2018-07-10 23:07:21', '2018-07-10 23:07:21'),
(3, 5, '2018-07-16 22:48:48', '2018-07-16 22:48:48');

-- --------------------------------------------------------

--
-- Table structure for table `oauth_refresh_tokens`
--

CREATE TABLE `oauth_refresh_tokens` (
  `id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `access_token_id` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `revoked` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `password_resets`
--

CREATE TABLE `password_resets` (
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `token` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `jenis` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kode` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `total_harga` int(10) UNSIGNED NOT NULL,
  `foto_transaksi` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `isDeliver` tinyint(1) NOT NULL DEFAULT '0',
  `kode_belanja` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengiriman`
--

CREATE TABLE `pengiriman` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `pembayaran_id` int(10) UNSIGNED NOT NULL,
  `alamat` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sayur`
--

CREATE TABLE `sayur` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jumlah` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `foto` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sayurmobile`
--

CREATE TABLE `sayurmobile` (
  `id` int(10) UNSIGNED NOT NULL,
  `nama` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jumlah` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `foto` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `sayurmobile`
--

INSERT INTO `sayurmobile` (`id`, `nama`, `jumlah`, `berat`, `harga`, `foto`, `created_at`, `updated_at`) VALUES
(1, 'bayam', 2, 1, 12000, 'sayur/kR4yMybzHI4LEDM5jygMhWU1PF9K6masnjPGaX3F.jpeg', '2018-07-16 23:07:35', '2018-07-16 23:07:35'),
(2, 'coba', 1, 1, 1000, 'sayur/4JMhJY4jJAmcNnRuIzzcizuE5JQ9QN6kC2wky9r8.jpeg', '2018-07-16 23:47:44', '2018-07-16 23:47:44');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nomor_telepon` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `foto` varchar(191) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tipe` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `nomor_telepon`, `password`, `foto`, `tipe`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'suastikadinata', 'suastikaadinata@gmail.com', '0851112222', '$2y$10$TYVQWdegvScWVekFzVCq5ubGyOuOJSM59pmEZMwqWEOnJLOQTa8cy', NULL, 'admin', 'e6cvRpPwzIkhAf8QsPTbsNsN765RPoeLr1yEysYZ1ueuslswcsTtwGIYqv33', '2018-06-02 04:15:41', '2018-06-02 04:15:41'),
(2, 'adinata', 'adinata@gmail.com', '0851112222', '$2y$10$ndjO8uPbBQ8LS5EAPe6xXe2ZPJlEfOj3QH4W.UXojk6b5YX6AYAc2', NULL, 'user', 'm6O5XUL5osVNAqym5X42NuRx9kyeLNYfpVKP4El5PLZ7GatvX7NiaPVJE1hz', '2018-06-02 05:49:31', '2018-06-02 05:49:31'),
(3, 'nigelerico', 'nigelerico1@gmail.com', '081233816776', '$2y$10$sxmMfd1BZ/9CUoKOMSEaMujJBJEPYRS4QjZx9rDH2M0EXi8pVdGli', NULL, 'admin', NULL, '2018-07-01 20:09:46', '2018-07-01 20:09:46'),
(5, 'nigelerico2', 'nigelerico2@gmail.com', '081233816776', '$2y$10$TaOkO7iieaq0CiRxaw9i8uCXEkmyd1uzoGdkPFpZMP2Abdf86pLle', NULL, 'admin', NULL, '2018-07-01 20:12:59', '2018-07-01 20:12:59'),
(7, 'nigelerico', 'erico@yahoo.com', '12345678', '$2y$10$Jg0wAheLiAhBac2EjRsdA.TGdx2DDMHB0CuIHQDqGxem.XFv.T2jC', NULL, 'user', NULL, '2018-07-11 00:42:41', '2018-07-11 00:42:41'),
(8, 'selvi', 'selvi@gmail.com', '123456', '$2y$10$50ePCEJJvrt9nOcs.Adb7OfieFrghy5NNpwEmIkYb8xylD90IDg2W', NULL, 'user', NULL, '2018-07-16 23:13:09', '2018-07-16 23:13:09'),
(9, 'nigel', 'nigel@gmail.com', '98234124', '$2y$10$qsABg8LCHVUb4W3IJfS.6e7QXbTbOgS1rgUMtqxkMm4FovfiQiNKe', NULL, 'user', NULL, '2018-07-17 01:47:23', '2018-07-17 01:47:23'),
(10, 'pangestu', 'pangestu@yahoo.com', '123234345', '$2y$10$q1PNkcvXu/ms7nhjwvfu0uQLw/4Lq4oWcU2V5YYBLbR.SVPk0kPbe', NULL, 'user', NULL, '2018-07-17 01:48:33', '2018-07-17 01:48:33');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chatting`
--
ALTER TABLE `chatting`
  ADD PRIMARY KEY (`id`),
  ADD KEY `chatting_pengirim_id_foreign` (`pengirim_id`),
  ADD KEY `chatting_penerima_id_foreign` (`penerima_id`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id`),
  ADD KEY `keranjang_user_id_foreign` (`user_id`),
  ADD KEY `keranjang_sayur_id_foreign` (`sayur_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_access_tokens`
--
ALTER TABLE `oauth_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_access_tokens_user_id_index` (`user_id`);

--
-- Indexes for table `oauth_auth_codes`
--
ALTER TABLE `oauth_auth_codes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `oauth_clients`
--
ALTER TABLE `oauth_clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_clients_user_id_index` (`user_id`);

--
-- Indexes for table `oauth_personal_access_clients`
--
ALTER TABLE `oauth_personal_access_clients`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_personal_access_clients_client_id_index` (`client_id`);

--
-- Indexes for table `oauth_refresh_tokens`
--
ALTER TABLE `oauth_refresh_tokens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `oauth_refresh_tokens_access_token_id_index` (`access_token_id`);

--
-- Indexes for table `password_resets`
--
ALTER TABLE `password_resets`
  ADD KEY `password_resets_email_index` (`email`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pembayaran_user_id_foreign` (`user_id`);

--
-- Indexes for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pengiriman_user_id_foreign` (`user_id`),
  ADD KEY `pengiriman_pembayaran_id_foreign` (`pembayaran_id`);

--
-- Indexes for table `sayur`
--
ALTER TABLE `sayur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sayurmobile`
--
ALTER TABLE `sayurmobile`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `users_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chatting`
--
ALTER TABLE `chatting`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `keranjang`
--
ALTER TABLE `keranjang`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `oauth_clients`
--
ALTER TABLE `oauth_clients`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `oauth_personal_access_clients`
--
ALTER TABLE `oauth_personal_access_clients`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pengiriman`
--
ALTER TABLE `pengiriman`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sayur`
--
ALTER TABLE `sayur`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sayurmobile`
--
ALTER TABLE `sayurmobile`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chatting`
--
ALTER TABLE `chatting`
  ADD CONSTRAINT `chatting_penerima_id_foreign` FOREIGN KEY (`penerima_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `chatting_pengirim_id_foreign` FOREIGN KEY (`pengirim_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_sayur_id_foreign` FOREIGN KEY (`sayur_id`) REFERENCES `sayur` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `keranjang_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `pengiriman`
--
ALTER TABLE `pengiriman`
  ADD CONSTRAINT `pengiriman_pembayaran_id_foreign` FOREIGN KEY (`pembayaran_id`) REFERENCES `pembayaran` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `pengiriman_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
