create database QLBanDT
on primary
( 
	name ='QLBanDT_data',
	filename='G:\HQT&CSDL\DataBase\QLBanDT_data.mdf',
	size=5MB,
	maxsize=50MB,
	filegrowth=10%
)
	log on
(
	name ='QLBanDT_log',
	filename='G:\HQT&CSDL\DataBase\QLBanDT_log.ldf',
	size=5MB,
	maxsize=50MB,
	filegrowth=10%
)
use QLBanDT
create table NhaSanXuat
(
	MaNSX varchar(10) not null primary key,
	TenNSX nvarchar(50) not null
	)
create table DienThoai
(
	MaDT varchar(10) not null primary key,
	TenDT Nvarchar(50) not null,
	MaNSX varchar(10) not null foreign key (MaNSX) references NhaSanXuat(MaNSX),
	CauHinh Nvarchar(100)  null
)
create Table KhachHang
(
	MaKH varchar(12) primary key not null,
	TenKH Nvarchar(50) null,
	DiaChi Nvarchar(50) null,
	SDT varchar(11) null
)
create table HoaDon
(
	MaHD varchar(20) primary key not null,
	MaKH varchar(12) foreign key (MaKH) references KhachHang(MaKH),
	MaDT varchar(10) foreign key (MaDT) references DienThoai(MaDT),
	MaNV varchar(12) foreign key (MaNV) references NhanVien(MaNV)
)
create table CTHoaDon
(
	MaCTHD varchar(20) primary key not null,
	MaHD varchar(20) foreign key (MaHD) references HoaDon(MaHD),
	SoLuong int not null,
	DonGia money  null,
	
)
create table NhanVien
(
	MaNV varchar(12) primary key not null,
	TenNV nvarchar(20) not null,
	NgaySinh date  null,
	Diachi nvarchar(50) null
	)
alter table DienThoai
Add Gia money 