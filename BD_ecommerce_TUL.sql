-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-04-2021 a las 01:15:14
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ecommerce`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cart`
--

CREATE TABLE `cart` (
  `id` varchar(46) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `product_id` varchar(43) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id`, `category_name`, `description`, `image_url`, `status`) VALUES
(1, 'Electronics', 'Area Electronics', 'IMAGE URL', NULL),
(2, 'Consoles', 'Consoles', 'IMAGE URL', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order`
--

CREATE TABLE `order` (
  `id` varchar(46) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `session-id` varchar(255) DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `status` varchar(46) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `order`
--

INSERT INTO `order` (`id`, `created_date`, `session-id`, `total_price`, `user_id`, `status`) VALUES
('85ca8c40-ca4d-4129-b760-84f9f34a5593', '2021-04-12 22:09:13', '8', 4600, 23, '38c1a58d-d435-4bf1-a1ba-0c82d5dc7f16'),
('f871dc6c-4e00-4b7f-8cdd-101f1defc7eb', '2021-04-12 22:20:39', '8', 1600, 23, '777a1a58d-d435-4bf1-a1ba-0c82d5dc7f1'),
('06069ff9-4c89-42ea-8729-d96577a8ffb2', '2021-04-12 23:00:13', '8', 1300, 23, '777a1a58d-d435-4bf1-a1ba-0c82d5dc7f1'),
('72128bf9-2c37-477a-a53a-b3e9790caec0', '2021-04-13 18:12:08', '8', 2500, 23, '777a1a58d-d435-4bf1-a1ba-0c82d5dc7f1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orderitems`
--

CREATE TABLE `orderitems` (
  `order_item_id` varchar(46) NOT NULL,
  `created_date` datetime DEFAULT NULL,
  `order_id` varchar(46) NOT NULL,
  `price` double DEFAULT NULL,
  `product_id` varchar(46) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `orderitems`
--

INSERT INTO `orderitems` (`order_item_id`, `created_date`, `order_id`, `price`, `product_id`, `quantity`, `status`) VALUES
('8b113dcd-369b-4e8e-af60-f1eefb2c5ecc', '2021-04-12 22:09:13', '85ca8c40-ca4d-4129-b760-84f9f34a5593', 100, '4b852323-ac8a-471b-9593-d3519cffabd2', 1, NULL),
('c2071406-d494-4262-9bff-f694e432ca76', '2021-04-12 22:09:13', '85ca8c40-ca4d-4129-b760-84f9f34a5593', 1500, '39390d56-064c-4894-bd52-5d5c0b4c5eb2', 3, NULL),
('7ef3ec97-172a-4f5e-81a2-e50cefc328ed', '2021-04-12 22:20:39', 'f871dc6c-4e00-4b7f-8cdd-101f1defc7eb', 1500, '39390d56-064c-4894-bd52-5d5c0b4c5eb2', 1, NULL),
('03e5cf63-b1bc-47d2-ba88-a336c20ae954', '2021-04-12 22:20:39', 'f871dc6c-4e00-4b7f-8cdd-101f1defc7eb', 100, '4b852323-ac8a-471b-9593-d3519cffabd2', 1, NULL),
('8df61570-fec4-4e2d-9085-a3237f90b02e', '2021-04-12 23:00:13', '06069ff9-4c89-42ea-8729-d96577a8ffb2', 1300, '66311618-9932-477d-a585-2d84497c3396', 1, NULL),
('e92243e1-2871-4a7d-a96d-eb59f9e118d0', '2021-04-13 18:12:08', '72128bf9-2c37-477a-a53a-b3e9790caec0', 2500, 'c7435903-35fe-4da2-8a9a-5ce60857c74e', 1, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `products`
--

CREATE TABLE `products` (
  `id` varchar(46) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `sku` varchar(36) DEFAULT NULL,
  `category_id` bigint(20) NOT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `products`
--

INSERT INTO `products` (`id`, `description`, `name`, `price`, `sku`, `category_id`, `status`) VALUES
('4b852323-ac8a-471b-9593-d3519cffabd2', 'Atari 2000', 'Atari 2000', 100, 'CSAT-25-A89', 1, ''),
('39390d56-064c-4894-bd52-5d5c0b4c5eb2', 'Sony PS4', 'Sony PS4', 1500, 'GFD-ASD-48', 1, ''),
('264142dd-7883-4c3d-b228-9243a026148a', 'Sony PS5', 'Sony PS5', 2500, 'TOM-25-A87', 2, ''),
('c7435903-35fe-4da2-8a9a-5ce60857c74e', 'XBOX Series', 'XBOX Series', 2500, 'JMT-25-N88', 2, ''),
('66311618-9932-477d-a585-2d84497c3396', 'Nintendo Switch', 'Nintendo Switch', 1300, 'NTY-25-N89', 2, ''),
('c3fed4bf-b1d8-4063-968a-5af000fbc815', 'Family', 'Family', 350, 'FMY-25-N89', 2, NULL),
('1b31ecbb-b62e-40a5-afbd-541adde730bb', 'OTHERS', 'OTHERS', 80, 'KMY-25-N89', 2, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tokens`
--

CREATE TABLE `tokens` (
  `id` int(11) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tokens`
--

INSERT INTO `tokens` (`id`, `token`, `created_date`, `user_id`, `status`) VALUES
(23, 'f4c3c2e9-f82a-4137-a174-de197428cd8b', '2021-04-12 10:05:17', 23, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `status` varchar(46) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`, `role`, `status`) VALUES
(23, 'asdf@asdf.com', 'dsih', 'jisci', 'A545F9A48DF4BE512630CC53CEE1916B', 'user', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3weixb4hpcmv5xc73lxe4762i` (`product_id`);

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrby37m01iggqlorjvht8k44q7` (`user_id`);

--
-- Indices de la tabla `orderitems`
--
ALTER TABLE `orderitems`
  ADD PRIMARY KEY (`order_item_id`),
  ADD KEY `FK15fsn9m5tgpf6tivke8lp4ynl` (`order_id`),
  ADD KEY `FKflf70r9f12003lo4fn2e5eue5` (`product_id`);

--
-- Indices de la tabla `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- Indices de la tabla `tokens`
--
ALTER TABLE `tokens`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2dylsfo39lgjyqml2tbe0b0ss` (`user_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categories`
--
ALTER TABLE `categories`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `tokens`
--
ALTER TABLE `tokens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
