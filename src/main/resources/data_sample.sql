-- =============================================
-- SCRIPT DỮ LIỆU MẪU - KICKS SHOE SHOP
-- Chạy sau khi Spring Boot đã tạo bảng (ddl-auto=update)
-- =============================================

-- Xóa dữ liệu cũ (nếu có)
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE product_images;
TRUNCATE TABLE product_sizes;
TRUNCATE TABLE reviews;
TRUNCATE TABLE order_items;
TRUNCATE TABLE orders;
TRUNCATE TABLE cart_items;
TRUNCATE TABLE carts;
TRUNCATE TABLE products;
TRUNCATE TABLE categories;
TRUNCATE TABLE users;
SET FOREIGN_KEY_CHECKS = 1;

-- =============================================
-- 1. CATEGORIES
-- =============================================
INSERT INTO categories (id, name) VALUES
(1, 'Nike'),
(2, 'Adidas'),
(3, 'Converse'),
(4, 'New Balance'),
(5, 'Puma');

-- =============================================
-- 2. PRODUCTS (15 sản phẩm với hình ảnh Unsplash)
-- =============================================
INSERT INTO products (id, name, brand, price, description, image, category_id) VALUES
-- NIKE (category 1)
(1, 'Nike Air Force 1 Low', 'Nike', 110.00,
 'Một trong những đôi giày biểu tượng nhất mọi thời đại. Thiết kế đế bọc khí trứ danh và chất liệu da cao cấp.',
 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80', 1),

(2, 'Nike Air Max 270', 'Nike', 150.00,
 'Đơn vị đệm khí Max Air lớn nhất từ trước đến nay ở góc nhìn phía sau. Cực kỳ thoải mái cho cả ngày dài.',
 'https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?w=800&q=80', 1),

(3, 'Nike React Infinity Run', 'Nike', 160.00,
 'Được thiết kế để giảm nguy cơ chấn thương khi chạy bộ. Đệm React êm ái và ổn định tuyệt vời.',
 'https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?w=800&q=80', 1),

(4, 'Nike Dunk Low Retro', 'Nike', 100.00,
 'Huyền thoại bóng rổ thập niên 80 trở lại với phong cách đường phố hiện đại. Item must-have của mọi sneakerhead.',
 'https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?w=800&q=80', 1),

-- ADIDAS (category 2)
(5, 'Adidas Ultra Boost 22', 'Adidas', 180.00,
 'Công nghệ Boost đột phá mang lại cảm giác bước đệm hoàn hảo. Phù hợp cho cả chạy bộ và street style.',
 'https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=800&q=80', 2),

(6, 'Adidas Stan Smith', 'Adidas', 80.00,
 'Đôi giày tennis cổ điển biến thành biểu tượng thời trang. Tối giản, sạch sẽ và bất diệt theo thời gian.',
 'https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?w=800&q=80', 2),

(7, 'Adidas Superstar', 'Adidas', 90.00,
 'Ba sọc Adidas huyền thoại và mũi vỏ sò đặc trưng. Từ sân bóng rổ đến đường phố, Superstar luôn là lựa chọn số 1.',
 'https://images.unsplash.com/photo-1551107696-a4b0c5a0d9a2?w=800&q=80', 2),

(8, 'Adidas NMD R1', 'Adidas', 130.00,
 'Sự kết hợp hoàn hảo giữa công nghệ Boost và thiết kế hiện đại. Nhẹ nhàng, thoải mái và cực kỳ phong cách.',
 'https://images.unsplash.com/photo-1597045566677-8cf032ed6634?w=800&q=80', 2),

-- CONVERSE (category 3)
(9, 'Converse Chuck Taylor All Star', 'Converse', 55.00,
 'Đôi giày cổ điển nhất lịch sử. Hơn 100 năm tuổi nhưng vẫn luôn trendy và được yêu thích bởi mọi thế hệ.',
 'https://images.unsplash.com/photo-1547036967-23d11aacaee0?w=800&q=80', 3),

(10, 'Converse Chuck 70 Hi', 'Converse', 85.00,
 'Phiên bản nâng cấp của Chuck Taylor với chất liệu cao cấp hơn và đế dày ôm chân tốt hơn.',
 'https://images.unsplash.com/photo-1494496195158-c3bc26b74f56?w=800&q=80', 3),

-- NEW BALANCE (category 4)
(11, 'New Balance 574', 'New Balance', 90.00,
 'Mẫu giày chạy từ năm 1988 được tái sinh thành biểu tượng văn hóa đường phố. Phom đẹp và cực kỳ thoải mái.',
 'https://images.unsplash.com/photo-1539185441755-769473a23570?w=800&q=80', 4),

(12, 'New Balance 990v5', 'New Balance', 185.00,
 'Made in USA. Đỉnh cao của sự thoải mái và chất lượng Mỹ. Được nhiều celeb và fashionista toàn cầu yêu thích.',
 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80', 4),

(13, 'New Balance 327', 'New Balance', 100.00,
 'Lấy cảm hứng từ giày chạy thập niên 70 với phần đế N độc đáo. Retro nhưng cực kỳ hiện đại.',
 'https://images.unsplash.com/photo-1552346154-21d32810baa3?w=800&q=80', 4),

-- PUMA (category 5)
(14, 'Puma Suede Classic', 'Puma', 70.00,
 'Biểu tượng thời trang đường phố từ năm 1968. Chất liệu suede mềm mại và đế thấp cổ điển.',
 'https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=800&q=80', 5),

(15, 'Puma RS-X', 'Puma', 110.00,
 'Thiết kế chunky táo bạo với hệ thống Running System độc quyền. Bước vào thời trang dad-shoe siêu hot.',
 'https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?w=800&q=80', 5);

-- =============================================
-- 3. PRODUCT IMAGES (ảnh phụ)
-- =============================================
INSERT INTO product_images (product_id, image_url) VALUES
(1, 'https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?w=800&q=80'),
(1, 'https://images.unsplash.com/photo-1600185365483-26d7a4cc7519?w=800&q=80'),
(2, 'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80'),
(2, 'https://images.unsplash.com/photo-1539185441755-769473a23570?w=800&q=80'),
(5, 'https://images.unsplash.com/photo-1606107557195-0e29a4b5b4aa?w=800&q=80'),
(9, 'https://images.unsplash.com/photo-1494496195158-c3bc26b74f56?w=800&q=80');

-- =============================================
-- 4. PRODUCT SIZES (sizes từng sản phẩm)
-- =============================================
-- Mỗi sản phẩm có đủ size từ 38-44
INSERT INTO product_sizes (product_id, size, stock_quantity) VALUES
-- Nike Air Force 1
(1,'38',15),(1,'39',20),(1,'40',25),(1,'41',30),(1,'42',20),(1,'43',10),(1,'44',5),
-- Nike Air Max 270
(2,'38',10),(2,'39',15),(2,'40',20),(2,'41',20),(2,'42',15),(2,'43',8),(2,'44',3),
-- Nike React Infinity
(3,'38',8),(3,'39',12),(3,'40',18),(3,'41',18),(3,'42',12),(3,'43',6),(3,'44',2),
-- Nike Dunk Low
(4,'38',20),(4,'39',25),(4,'40',30),(4,'41',30),(4,'42',25),(4,'43',15),(4,'44',8),
-- Adidas Ultra Boost
(5,'38',10),(5,'39',15),(5,'40',20),(5,'41',20),(5,'42',12),(5,'43',6),(5,'44',3),
-- Adidas Stan Smith
(6,'38',30),(6,'39',35),(6,'40',40),(6,'41',40),(6,'42',30),(6,'43',20),(6,'44',10),
-- Adidas Superstar
(7,'38',25),(7,'39',30),(7,'40',35),(7,'41',35),(7,'42',25),(7,'43',12),(7,'44',6),
-- Adidas NMD R1
(8,'38',12),(8,'39',18),(8,'40',22),(8,'41',22),(8,'42',16),(8,'43',8),(8,'44',4),
-- Converse Chuck Taylor
(9,'36',20),(9,'37',25),(9,'38',30),(9,'39',30),(9,'40',25),(9,'41',20),(9,'42',10),
-- Converse Chuck 70
(10,'36',15),(10,'37',20),(10,'38',25),(10,'39',25),(10,'40',20),(10,'41',15),(10,'42',8),
-- New Balance 574
(11,'38',15),(11,'39',20),(11,'40',25),(11,'41',25),(11,'42',20),(11,'43',10),(11,'44',5),
-- New Balance 990v5
(12,'38',8),(12,'39',12),(12,'40',15),(12,'41',15),(12,'42',10),(12,'43',5),(12,'44',2),
-- New Balance 327
(13,'38',20),(13,'39',25),(13,'40',28),(13,'41',28),(13,'42',20),(13,'43',10),(13,'44',5),
-- Puma Suede
(14,'38',20),(14,'39',25),(14,'40',30),(14,'41',30),(14,'42',20),(14,'43',12),(14,'44',6),
-- Puma RS-X
(15,'38',15),(15,'39',20),(15,'40',25),(15,'41',25),(15,'42',18),(15,'43',10),(15,'44',5);

-- =============================================
-- 5. USERS MẪU (mật khẩu đã được hash BCrypt)
-- password: "123456" cho tất cả tài khoản mẫu
-- =============================================
INSERT INTO users (id, username, password, role, full_name, email, phone) VALUES
(1, 'admin', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGga31lW', 'ADMIN', 'Admin', 'admin@kicks.vn', '0901234567'),
(2, 'testuser', '$2a$10$EixZaYVK1fsbw1ZfbX3OXePaWxn96p36WQoeG6Lruj3vjPGga31lW', 'USER', 'Người Dùng Mẫu', 'test@kicks.vn', '0912345678');

-- =============================================
-- 6. REVIEWS MẪU
-- =============================================
INSERT INTO reviews (product_id, user_id, rating, comment, created_at) VALUES
(1, 2, 5, 'Giày đẹp lắm, đi rất êm chân! Mình rất hài lòng với chất lượng da.', NOW()),
(1, 2, 4, 'Đẹp nhưng hơi chật ở đầu ngón chân, nên chọn size lớn hơn nửa số.', NOW()),
(5, 2, 5, 'Ultra Boost đỉnh thật sự! Chạy bộ mà như đi trên mây.', NOW()),
(9, 2, 5, 'Chuck Taylor không bao giờ lỗi mốt. Classic nhất thế giới!', NOW());

SELECT 'Dữ liệu mẫu đã được chèn thành công!' AS message;
