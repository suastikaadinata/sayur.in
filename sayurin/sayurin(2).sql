-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 12, 2018 at 09:40 PM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

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
-- Table structure for table `cart_transaksi`
--

CREATE TABLE `cart_transaksi` (
  `id` int(10) UNSIGNED NOT NULL,
  `transaksi_id` int(10) UNSIGNED NOT NULL,
  `sayur_id` int(10) UNSIGNED NOT NULL,
  `jumlah_sayur` int(11) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `cart_transaksi`
--

INSERT INTO `cart_transaksi` (`id`, `transaksi_id`, `sayur_id`, `jumlah_sayur`, `total_harga`, `created_at`, `updated_at`) VALUES
(3, 2, 1, 2, 8000, '2018-08-23 00:37:36', '2018-08-23 00:37:36'),
(4, 2, 2, 2, 6000, '2018-08-23 00:37:36', '2018-08-23 00:37:36'),
(5, 3, 1, 2, 8000, '2018-08-29 22:55:12', '2018-08-29 22:55:12'),
(6, 3, 2, 2, 7000, '2018-08-29 22:55:12', '2018-08-29 22:55:12'),
(7, 4, 1, 2, 8000, '2018-09-12 19:24:55', '2018-09-12 19:24:55'),
(8, 4, 2, 2, 6000, '2018-09-12 19:24:55', '2018-09-12 19:24:55');

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
  `jumlah_sayur` int(11) NOT NULL DEFAULT '0',
  `total_harga` int(11) NOT NULL,
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
(5, '2018_05_12_032202_create_pembayaran_table', 1),
(6, '2018_05_12_032618_create_pengiriman_table', 1),
(7, '2018_05_12_034504_create_chatting_table', 1),
(8, '2016_06_01_000001_create_oauth_auth_codes_table', 2),
(9, '2016_06_01_000002_create_oauth_access_tokens_table', 2),
(10, '2016_06_01_000003_create_oauth_refresh_tokens_table', 2),
(11, '2016_06_01_000004_create_oauth_clients_table', 2),
(12, '2016_06_01_000005_create_oauth_personal_access_clients_table', 2),
(13, '2018_07_17_015017_create_sayurmobile_table', 2),
(25, '2018_05_12_031825_create_keranjang_table', 6),
(26, '2018_08_07_060953_create_transaksi_table', 7),
(27, '2018_08_14_015419_create_cart_transaksi_table', 7);

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
('03f64002716a965e676770134cfdeeccdcc7172d325f8c34f713e29eff689a77972ac0d952bdc96c', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:29:41', '2018-09-08 08:29:41', '2019-09-08 15:29:41'),
('0c0b44e719703d3898997a595d9dfe00585a855c8de3c657d4acf650b1a774a9d3a3c57eee778e31', 1, 1, 'sayurin', '[]', 0, '2018-08-08 07:55:07', '2018-08-08 07:55:07', '2019-08-08 14:55:07'),
('18a656b831fd1d815100d252d8674262b981772710cbb4db445f1b14d5a28859dde9984f2823fbb1', 1, 1, 'sayurin', '[]', 0, '2018-09-07 07:43:05', '2018-09-07 07:43:05', '2019-09-07 14:43:05'),
('19266309b657859bcce50c454785f7bd52f039ddcd727b73e41492241ad7e106baa7fd4556c79d7f', 2, 1, 'sayurin', '[]', 0, '2018-09-07 07:39:47', '2018-09-07 07:39:47', '2019-09-07 14:39:47'),
('1a2cf5af579d6e08f366107ccd47ed648b71abe90d096615ec479cdb3dfc74ad5f1f6a6de745ff18', 1, 1, 'sayurin', '[]', 0, '2018-09-08 09:15:43', '2018-09-08 09:15:43', '2019-09-08 16:15:43'),
('26a998a392b0d20e433e54339b2122a4ffaa2b417399160662d18570c139459eedc1bb448b1b4ac1', 1, 1, 'sayurin', '[]', 0, '2018-08-06 10:01:30', '2018-08-06 10:01:30', '2019-08-06 17:01:30'),
('2842468d4ace7e7f248fcead5acddbea06ef1f614d1097f1ac078ee0fda7de13c1ddf1468ce47341', 1, 1, 'sayurin', '[]', 0, '2018-09-07 07:35:52', '2018-09-07 07:35:52', '2019-09-07 14:35:52'),
('2933268d6d89011346ee4a33768083e4f958e0d881a7d7df459edc59216bbb80a11895f29030fa70', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:58:21', '2018-09-07 15:58:21', '2019-09-07 22:58:21'),
('31d3911556071ae0f52c1103491d07737274bd3fbc9d98d857f252b92e02788e9168eb6b5ae31db7', 1, 1, 'sayurin', '[]', 0, '2018-09-08 00:57:39', '2018-09-08 00:57:39', '2019-09-08 07:57:39'),
('36ec19d5306cb73b04ae8aeffdc778b43728e4de34a20cceb62772b2bc31fa21a3c359730bd042b8', 1, 1, 'sayurin', '[]', 0, '2018-09-07 07:35:52', '2018-09-07 07:35:52', '2019-09-07 14:35:52'),
('3a792810d859c9bdf4bf94d9d8d5950759840e5520323a2e8b107571436fcb85830381804b98c9df', 1, 1, 'sayurin', '[]', 0, '2018-09-08 01:22:25', '2018-09-08 01:22:25', '2019-09-08 08:22:25'),
('47f6c20e339d52e939b4e4277d6cbb792dd9d194f20a46c97d5e21d473a14a12c9d390a6d5580a14', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:43:53', '2018-09-08 08:43:53', '2019-09-08 15:43:53'),
('48035c312c4e5ed2fc7e0768c7a7acffaf15076c0b839d8ac20ae5d3372737e872b78ec95cfdac4e', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:45:14', '2018-09-08 08:45:14', '2019-09-08 15:45:14'),
('5101e894b30b84bbac2c0fbdb27cfbea3ee13b7355a268ad61160e106fb6b7e14e776a5c1406d14f', 1, 1, 'sayurin', '[]', 0, '2018-09-07 16:01:17', '2018-09-07 16:01:17', '2019-09-07 23:01:17'),
('62ad493b147224805a03a53c147564505ce8bea30a4f25fbbaca3eaeb9aff43be92b87f5f583a405', 1, 1, 'sayurin', '[]', 0, '2018-08-08 07:59:31', '2018-08-08 07:59:31', '2019-08-08 14:59:31'),
('752a2102725fb6f2c52f49f6e37787342a99bdb86328f31f51e95a59da72a2a489eeb79100c5d651', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:43:39', '2018-09-07 15:43:39', '2019-09-07 22:43:39'),
('7840c4449f01483b4b71e4dd4b77678e6c0071e0e6eff63704f33d6ca86a146bb324ff81e504a303', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:46:28', '2018-09-08 08:46:28', '2019-09-08 15:46:28'),
('7dfa43fa436aab15f6a199945f887e67d783df26ecb15e72076553abce655cbd9b18c6ce6c8821f0', 1, 1, 'sayurin', '[]', 0, '2018-08-08 10:37:57', '2018-08-08 10:37:57', '2019-08-08 17:37:57'),
('8e1cf071fd49d84f71ed060515c71d4a321c6c2e2b6d9fa808c3d7b0ab969429d8b122a279b29129', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:56:02', '2018-09-08 08:56:02', '2019-09-08 15:56:02'),
('8e929a3480555a001119895142e1e7e612353dd58bfeb514eb6bd5af8cce6a2e7df57dae6aaee3b2', 1, 1, 'sayurin', '[]', 0, '2018-09-08 09:38:07', '2018-09-08 09:38:07', '2019-09-08 16:38:07'),
('98226531ad4460a5894ee37be66a0c211e6dc17ed36fa7db1b60fca5edd9f703aa984f06ec19d601', 1, 1, 'sayurin', '[]', 0, '2018-09-08 01:14:19', '2018-09-08 01:14:19', '2019-09-08 08:14:19'),
('9951d72eb701de61d46b0dc8323fc81bbbda7545547b179c4ff9f24757888f67fd474bfa102f1c6c', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:56:24', '2018-09-07 15:56:24', '2019-09-07 22:56:24'),
('9f3345072a5e989570ebb21c7a737f244e956d79de85e8aa963373da94b892af22a724f4cc6e2d0e', 1, 1, 'sayurin', '[]', 0, '2018-09-07 07:36:47', '2018-09-07 07:36:47', '2019-09-07 14:36:47'),
('a566edc9192dffbb547dc53e19618d942d46d8b463ec8be454c27516670b8863725eaf2d45e77b9d', 1, 1, 'sayurin', '[]', 0, '2018-08-06 10:12:24', '2018-08-06 10:12:24', '2019-08-06 17:12:24'),
('a6f95614f672c8e691c9de8c121cb2cf222af3afd99e14132be13f25d750ebb8b84b772c0d9c0526', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:51:07', '2018-09-07 15:51:07', '2019-09-07 22:51:07'),
('b133f10183e80b417ae9db3a4f31211b55e1f200d0989588a5ce4caff22482948577c93d64957797', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:56:04', '2018-09-07 15:56:04', '2019-09-07 22:56:04'),
('c1641488f0d732270a6fbf3d1b2619ae47dd9fef40185db98a9b519d092337f75f1c990fe3710a10', 1, 1, 'sayurin', '[]', 0, '2018-09-07 07:55:41', '2018-09-07 07:55:41', '2019-09-07 14:55:41'),
('c2917ecb6844a6b0fd626bdaf8e6e6fa4e933169e128c0ccdc67d40362b37bd88c7f696dda60bba4', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:40:56', '2018-09-08 08:40:56', '2019-09-08 15:40:56'),
('c536ef48dab7f177de434083e45f6d766e0c2c52b89ba88addc1a1f89abea09f18a46456b34631c7', 1, 1, 'sayurin', '[]', 0, '2018-09-08 09:37:33', '2018-09-08 09:37:33', '2019-09-08 16:37:33'),
('cabaf3dc4e53cbc2de904d2c10f36010432733ff75f87033b009c0a75493e15a34076d6b94fe042c', 1, 1, 'sayurin', '[]', 0, '2018-09-07 16:07:16', '2018-09-07 16:07:16', '2019-09-07 23:07:16'),
('d209f5ef693370f6ea485727ba569984bd5eef357f405ec802298e373a2a2694b7c12ca16c528517', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:29:42', '2018-09-08 08:29:42', '2019-09-08 15:29:42'),
('d38d1dce9f07509f40123b9f36634a3ec8b1c7738d71862d5116a65be4a2a9352e9846722dcc091a', 1, 1, 'sayurin', '[]', 0, '2018-09-07 15:38:16', '2018-09-07 15:38:16', '2019-09-07 22:38:16'),
('d793e97d7062da15224a18a06b03063cfcfe7f7fd55efe6df73ceb53bf42776b7cb742095c6f2b0e', 1, 1, 'sayurin', '[]', 0, '2018-09-08 01:26:15', '2018-09-08 01:26:15', '2019-09-08 08:26:15'),
('d7aa67ea0f981c4d51c8573374ad2b1bff562b394b4cb05738ed7c1b32aff7fd0edcf44f7287df07', 1, 1, 'sayurin', '[]', 0, '2018-09-08 08:34:30', '2018-09-08 08:34:30', '2019-09-08 15:34:30'),
('dbc59ebdd166999f538e2b97a9f9c4e55eeafbb2e66718afed9c5763f3d035727d8a9cfe275438c1', 1, 1, 'sayurin', '[]', 0, '2018-08-07 01:04:42', '2018-08-07 01:04:42', '2019-08-07 08:04:42'),
('e221be61d178c08ccd618b7be6bd17ba6512803a9192761e376db9c598c514d92a719d86a8127fd1', 1, 1, 'sayurin', '[]', 0, '2018-09-08 01:28:38', '2018-09-08 01:28:38', '2019-09-08 08:28:38'),
('e4cf435b6d6abddc3a1526151c45ecdbd493a3ea916e3fa92832c939df2add30d5977fb56e56b7dc', 2, 1, 'sayurin', '[]', 0, '2018-09-08 09:44:14', '2018-09-08 09:44:14', '2019-09-08 16:44:14'),
('fe56bf85a316c10e66a0e2d781ad8f2fe960409a8b706b097e1d1f05f1a0a307d102ebbd9a1e218b', 1, 1, 'sayurin', '[]', 0, '2018-09-08 00:57:39', '2018-09-08 00:57:39', '2019-09-08 07:57:39');

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
(1, NULL, 'Sayurin Personal Access Client', 'BDL82nOfOuXqnIQW0sPaNdk3FWNZCJk3D6bl7GKw', 'http://localhost', 1, 0, 0, '2018-08-06 08:22:05', '2018-08-06 08:22:05'),
(2, NULL, 'Sayurin Password Grant Client', 'mriRFJfahTjCURE0KYt6I5YMQPZqysjGGn8LDWHJ', 'http://localhost', 0, 1, 0, '2018-08-06 08:22:06', '2018-08-06 08:22:06');

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
(1, 1, '2018-08-06 08:22:06', '2018-08-06 08:22:06');

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

--
-- Dumping data for table `sayur`
--

INSERT INTO `sayur` (`id`, `nama`, `jumlah`, `berat`, `harga`, `foto`, `created_at`, `updated_at`) VALUES
(7, 'Bayam 2', 3, 4, 3000, 'sayur/NWPD8pqfUKRdG1IIkpUuxS28GDDM2hpP6v58Oo0l.png', '2018-08-06 10:10:56', '2018-08-06 10:10:56');

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
(1, 'Bayam', 10, 1, 4000, 'sayur/owl59swNnER0rr8vudb5w1tPYiZaUsUHQxwXCT3i.png', '2018-08-07 01:08:07', '2018-08-07 01:08:07'),
(2, 'Wortel', 2, 2, 3000, 'sayur/QNYWNzeTVi7asnVsYapboVI2TItdnQl6cWZehUt2.jpeg', '2018-08-07 01:08:12', '2018-08-07 01:08:12');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(10) UNSIGNED NOT NULL,
  `user_id` int(10) UNSIGNED NOT NULL,
  `alamat` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_transaksi` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0',
  `metode_transaksi` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `waktu_pengiriman` varchar(191) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `user_id`, `alamat`, `status_transaksi`, `metode_transaksi`, `waktu_pengiriman`, `created_at`, `updated_at`) VALUES
(2, 2, 'Jalan sawojajar', '2', 'COD', '8 agustus 2018 jam 7-9', '2018-08-23 00:37:36', '2018-08-23 00:41:47'),
(3, 2, 'Jalan sawojajar', '2', 'COD', '8 agustus 2018 jam 7-9', '2018-08-29 22:55:11', '2018-08-29 22:55:11'),
(4, 2, 'Jalan sawojajar', '0', 'COD', '8 agustus 2018 jam 7-9', '2018-09-12 19:24:55', '2018-09-12 19:24:55');

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
(1, 'suastikadinata', 'suastikaadinata@gmail.com', '0851112222', '$2y$10$TYVQWdegvScWVekFzVCq5ubGyOuOJSM59pmEZMwqWEOnJLOQTa8cy', 'user/user-icon.png', 'admin', 'NenQ4FSwkTdLGNVgeG3wtQxUT1F4ld0oyWFLNlaTiMGnhMc8JmaC2s2x7ttH', '2018-06-02 04:15:41', '2018-06-02 04:15:41'),
(2, 'adinata baru 2', 'adinata@gmail.com', '1234', '$2y$10$ndjO8uPbBQ8LS5EAPe6xXe2ZPJlEfOj3QH4W.UXojk6b5YX6AYAc2', 'user/w7q31xggkdgiwurevg1z.png', 'user', 'm6O5XUL5osVNAqym5X42NuRx9kyeLNYfpVKP4El5PLZ7GatvX7NiaPVJE1hz', '2018-06-02 05:49:31', '2018-08-06 10:12:04');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart_transaksi`
--
ALTER TABLE `cart_transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cart_transaksi_transaksi_id_foreign` (`transaksi_id`),
  ADD KEY `cart_transaksi_sayur_id_foreign` (`sayur_id`);

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
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaksi_user_id_foreign` (`user_id`);

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
-- AUTO_INCREMENT for table `cart_transaksi`
--
ALTER TABLE `cart_transaksi`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `oauth_clients`
--
ALTER TABLE `oauth_clients`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `oauth_personal_access_clients`
--
ALTER TABLE `oauth_personal_access_clients`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `sayurmobile`
--
ALTER TABLE `sayurmobile`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart_transaksi`
--
ALTER TABLE `cart_transaksi`
  ADD CONSTRAINT `cart_transaksi_sayur_id_foreign` FOREIGN KEY (`sayur_id`) REFERENCES `sayurmobile` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `cart_transaksi_transaksi_id_foreign` FOREIGN KEY (`transaksi_id`) REFERENCES `transaksi` (`id`) ON DELETE CASCADE;

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
  ADD CONSTRAINT `keranjang_sayur_id_foreign` FOREIGN KEY (`sayur_id`) REFERENCES `sayurmobile` (`id`) ON DELETE CASCADE,
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

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_user_id_foreign` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
