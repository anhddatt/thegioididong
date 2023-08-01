CREATE DATABASE ShoppingShop2
GO
USE ShoppingShop2
GO

CREATE TABLE Accounts(
	username varchar(30) PRIMARY KEY,
	password varchar(30),
	fullname nvarchar(30),
	email varchar(30),
	photo varchar(100),
)
GO
CREATE TABLE Roles(
	id varchar(10) PRIMARY KEY,
	name nvarchar(50),
)
GO
CREATE TABLE AccountRoles(
	id int identity(1,1) PRIMARY KEY,
	username varchar(30),
	role varchar(10),
	FOREIGN KEY (username) references Accounts(username),
	FOREIGN KEY (role) references Roles(id)
)
GO



INSERT INTO Accounts
VALUES('NV001','123',N'Nguyễn A','abc@gmail.com','',1)
GO
CREATE TABLE Category(
	id varchar(4) PRIMARY KEY,
	name nvarchar(50),
)
GO
INSERT INTO Category
VALUES('DM01',N'Điện Thoại'),('DM02',N'Máy tính bảng'),('DM03',N'Laptop'),('DM04',N'Smartwatch')

CREATE TABLE Products(
	id int IDENTITY(1,1) PRiMARY KEY,
	name nvarchar(50),
	image varchar(50),
	price float,
	quantity int,
	category_id varchar(4),
	FOREIGN KEY (category_id) REFERENCES Category (id)
)

INSERT INTO Products
VALUES
(N'OPPO Find N2 Flip 5G','OpFN2F.png',19990000,10,'DM01'),
(N'Samsung Galaxy A14 4G','SsA14.png',4490000,10,'DM01'),
(N'Vivo V27e','VvV27e.png',8690000,10,'DM01'),
(N'iPad 9 WiFi 64GB','Ipad9.png',7990000,10,'DM02'),
(N'iPad 10 WiFi','Ipad10.png',11190000,10,'DM02'),
(N'iPad Pro M1 11 inch WiFi 2TB (2021)','iPM12021.png',44990000,10,'DM02'),
(N'Samsung Galaxy Tab S7 FE 4G','SsTabS7.png',13990000,10,'DM02'),
(N'Samsung Galaxy Tab A7 Lite','SsTabA7.png',4490000,10,'DM02'),
(N'Acer Aspire 7 Gaming A715 42G R05G R5 5500U','AAA715.png',14990000,10,'DM03'),
(N'Asus TUF Gaming F15 FX506LHB i5 10300H','AsTuf.png',15490000,10,'DM03'),
(N'Lenovo Ideapad Gaming 3 15IHU6 i5 11320H','LeG3.png',16990000,10,'DM03'),
(N'MSI Gaming GF63 Thin 11SC i5 11400H (664VN)','MSIGF73.png',15990000,10,'DM03'),
(N'HP Gaming VICTUS 15 fa0111TX i5 12500H (7C0R4PA)','HPVT15.png',24290000,10,'DM03'),
(N'Samsung Galaxy Watch5 40mm dây silicone','SsGW5.png',5990000,10,'DM04'),
(N'Apple Watch SE 2022 40mm viền nhôm dây silicone','ApWSE2022.png',5990000,10,'DM04'),
(N'Amazfit Bip 3 44.12mm dây silicone','AmaB3.png',890000,10,'DM04'),
(N'Xiaomi Watch S1 46.5mm dây da','XMWs1.png',4490000,10,'DM04'),
(N'Garmin Forerunner 255 45.6mm dây silicone','GMF255.png',8990000,10,'DM04')

GO
CREATE TABLE Orders(
	id int identity(1,1) PRIMARY KEY,
	username varchar(30),
	createdate date,
	address nvarchar(200),
	status int,
	total float,
	FOREIGN KEY (username) references Accounts(username)
)
GO
CREATE TABLE Orderdetails(
	id INT IDENTITY(1,1) PRIMARY KEY,
	price float,
	orderid int,
	productid int,
	quantity int,
	FOREIGN KEY (orderid) references Orders(id),
	FOREIGN KEY (Productid) references Products (id)
)

