USE [master]
GO
/****** Object:  Database [QuanLyDKHP3]    Script Date: 08-Jan-21 8:15:02 AM ******/
CREATE DATABASE [QuanLyDKHP3]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyDKHP3', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyDKHP3.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'QuanLyDKHP3_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\QuanLyDKHP3_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [QuanLyDKHP3] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyDKHP3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyDKHP3] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyDKHP3] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyDKHP3] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyDKHP3] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyDKHP3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyDKHP3] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyDKHP3] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyDKHP3] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyDKHP3] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyDKHP3] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyDKHP3] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [QuanLyDKHP3]
GO
/****** Object:  Table [dbo].[ChuyenNganh]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ChuyenNganh](
	[maChuyenNganh] [varchar](15) NOT NULL,
	[tenChuyenNganh] [nvarchar](50) NOT NULL,
	[maKhoa] [varchar](15) NOT NULL,
 CONSTRAINT [PK_ChuyenNganh] PRIMARY KEY CLUSTERED 
(
	[maChuyenNganh] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CT_LopHocPhan]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CT_LopHocPhan](
	[maLopHocPhan] [varchar](15) NOT NULL,
	[maGiangVien] [varchar](15) NOT NULL,
	[hinhThuc] [nvarchar](15) NULL,
	[thu] [nvarchar](10) NULL,
	[tietHoc] [nvarchar](15) NULL,
	[maPhong] [varchar](15) NOT NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
 CONSTRAINT [PK_CT_LopHocPhan_1] PRIMARY KEY CLUSTERED 
(
	[maLopHocPhan] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[GiangVien]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[GiangVien](
	[maGiangVien] [varchar](15) NOT NULL,
	[tenGiangVien] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDIenThoai] [varchar](15) NULL,
	[maChuyenNganh] [varchar](15) NOT NULL,
 CONSTRAINT [PK_GiangVien] PRIMARY KEY CLUSTERED 
(
	[maGiangVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[HocPhan]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[HocPhan](
	[maHocPhan] [varchar](15) NOT NULL,
	[tenMonHoc] [nvarchar](50) NULL,
	[hocKy] [int] NULL,
	[soTinChi] [int] NULL,
	[batBuoc] [bit] NULL,
	[hocPhanYeuCau] [nvarchar](15) NULL,
	[maKhoa] [varchar](15) NULL,
 CONSTRAINT [PK_HocPhan] PRIMARY KEY CLUSTERED 
(
	[maHocPhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KetQuaHocTap]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KetQuaHocTap](
	[maSinhVien] [varchar](15) NOT NULL,
	[maHocPhan] [varchar](15) NOT NULL,
	[maLopHocPhan] [varchar](15) NULL,
	[diemThuongKy] [float] NULL,
	[diemGiuaKy] [float] NULL,
	[diemCuoiKy] [float] NULL,
	[diemTongKet] [float] NULL,
	[xepLoai] [varchar](5) NULL,
 CONSTRAINT [PK_KetQuaHocTap] PRIMARY KEY CLUSTERED 
(
	[maSinhVien] ASC,
	[maHocPhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[KetQuaHocTap_audits]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[KetQuaHocTap_audits](
	[_id] [int] IDENTITY(1,1) NOT NULL,
	[maSinhVien] [varchar](15) NULL,
	[maHocPhan] [varchar](15) NULL,
	[diemThuongKy] [float] NULL,
	[diemGiuaKy] [float] NULL,
	[diemCuoiKy] [float] NULL,
	[diemTongKet] [float] NULL,
	[xepLoai] [varchar](5) NULL,
	[thoiGianCapNhat] [datetime] NULL,
	[phuongThuc] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Khoa]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Khoa](
	[maKhoa] [varchar](15) NOT NULL,
	[tenKhoa] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Khoa] PRIMARY KEY CLUSTERED 
(
	[maKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LopHocPhan]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LopHocPhan](
	[maLopHocPhan] [varchar](15) NOT NULL,
	[tenLopHocPhan] [nvarchar](50) NULL,
	[maHocPhan] [varchar](15) NULL,
	[lopTinChi] [nvarchar](10) NULL,
	[siSoToiDa] [int] NULL,
	[siSoDangKy] [int] NULL,
	[trangThai] [nvarchar](20) NULL,
	[namHoc] [nvarchar](15) NULL,
	[nguoiMoLop] [varchar](15) NULL,
 CONSTRAINT [PK_LopHocPhan] PRIMARY KEY CLUSTERED 
(
	[maLopHocPhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[LopSinhVien]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[LopSinhVien](
	[maLop] [varchar](15) NOT NULL,
	[tenLop] [nvarchar](50) NOT NULL,
	[maChuyenNganh] [varchar](15) NOT NULL,
 CONSTRAINT [PK_LopSinhVien] PRIMARY KEY CLUSTERED 
(
	[maLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[NhanVienPDT]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NhanVienPDT](
	[maNhanVien] [varchar](15) NOT NULL,
	[tenNhanVien] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](5) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [varchar](15) NULL,
	[tenDangNhap] [varchar](50) NOT NULL,
 CONSTRAINT [PK_NhanVienPDT] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhieuDangKy]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhieuDangKy](
	[maLopHocPhan] [varchar](15) NOT NULL,
	[maSinhVien] [varchar](15) NOT NULL,
	[ngayDangKy] [date] NULL,
	[hocKy] [int] NULL,
	[namHoc] [nvarchar](15) NULL,
 CONSTRAINT [PK_PhieuDangKy] PRIMARY KEY CLUSTERED 
(
	[maLopHocPhan] ASC,
	[maSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PhongHoc]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PhongHoc](
	[maPhong] [varchar](15) NOT NULL,
	[tenPhong] [varchar](10) NULL,
	[dayNha] [char](1) NULL,
	[loaiPhong] [nvarchar](20) NULL,
 CONSTRAINT [PK_PhongHoc] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[SinhVien](
	[maSinhVien] [varchar](15) NOT NULL,
	[tenSinhVien] [nvarchar](50) NOT NULL,
	[maLop] [varchar](15) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [varchar](15) NULL,
	[tenDangNhap] [varchar](50) NOT NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[maSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 08-Jan-21 8:15:02 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenDangNhap] [varchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[loaiTaiKhoan] [int] NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'CNTT', N'Công nghệ thông tin', N'CNTT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'HTTT', N'Hệ thống thông tin', N'CNTT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'KeT', N'Kế Toán', N'KT-KT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'KHMT', N'Khoa học máy tính', N'CNTT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'KiT', N'Kiểm Toán', N'KT-KT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'KTPM', N'Kỹ thuật phần mềm', N'CNTT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'KTXD', N'Kỹ thuật xây dựng', N'KTXD')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'LLCT', N'Lý luận chính trị', N'LLCT')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'NNA', N'Ngôn ngữ Anh', N'NNA')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'QTDVDL-TM', N'Quản trị dịch vụ du lịch và lữ hành', N'QTDVDL-LK')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'QTKD', N'Quản trị kinh doanh', N'QTKD')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'QTKS', N'Quản trị khách sạn', N'QTDVDL-LK')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'QTNH-DVAU', N'Quản trị nhà hàng và dịch vụ ăn uống', N'QTDVDL-LK')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'TCDN', N'Tài chính doanh nghiệp', N'TC-NH')
INSERT [dbo].[ChuyenNganh] ([maChuyenNganh], [tenChuyenNganh], [maKhoa]) VALUES (N'TCNH', N'Tài chính ngân hàng', N'TC-NH')
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP001', N'GV10003', N'Lý thuyết', N'Thứ tư', N'7 - 9', N'PH005', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP001', N'GV10003', N'Thực hành', N'Thứ tư', N'10 - 12', N'PH010', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP002', N'GV002', N'Lý thuyết', N'Thứ ba', N'10 - 12', N'PH005', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP002', N'GV002', N'Thực hành', N'Thứ năm', N'4 - 6', N'PH012', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP003', N'GV10006', N'Lý thuyết', N'Thứ bảy', N'4 - 6', N'PH008', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP004', N'GV001', N'Lý thuyết', N'Thứ hai', N'1 - 3', N'PH001', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP004', N'GV001', N'Thực hành', N'Thứ ba', N'1 - 3', N'PH009', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP005', N'GV002', N'Lý thuyết', N'Thứ ba', N'4 - 6', N'PH004', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP005', N'GV002', N'Thực hành', N'Thứ bảy', N'1 - 3', N'PH012', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP006', N'GV002', N'Lý thuyết', N'Chủ nhật', N'1 - 3', N'PH002', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP007', N'GV10013', N'Lý thuyết', N'Thứ tư', N'10 - 12', N'PH006', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP008', N'GV10011', N'Lý thuyết', N'Thứ hai', N'1 - 3', N'PH002', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP009', N'GV10011', N'Lý thuyết', N'Thứ hai', N'4 - 6', N'PH002', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP010', N'GV001', N'Lý thuyết', N'Thứ hai', N'10 - 12', N'PH006', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP011', N'GV10015', N'Lý thuyết', N'Thứ sáu', N'7 - 9', N'PH007', CAST(N'2020-07-01' AS Date), CAST(N'2020-12-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP012', N'GV10017', N'Lý thuyết', N'Thứ năm', N'7 - 9', N'PH003', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP013', N'GV10006', N'Lý thuyết', N'Thứ hai', N'10 - 12', N'PH007', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP014', N'GV10007', N'Lý thuyết', N'Thứ ba', N'10 - 12', N'PH008', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP015', N'GV10016', N'Lý thuyết', N'Thứ sáu', N'7 - 9', N'PH004', CAST(N'2021-01-15' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP016', N'GV10016', N'Lý thuyết', N'Thứ tư', N'10 - 12', N'PH007', CAST(N'2021-01-15' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP017', N'GV10011', N'Lý thuyết', N'Thứ bảy', N'7 - 9', N'PH005', CAST(N'2021-01-01' AS Date), CAST(N'2021-05-01' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP500', N'GV10003', N'Lý thuyết', N'Thứ hai', N'1 - 3', N'PH001', CAST(N'2021-01-15' AS Date), CAST(N'2021-05-15' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP501', N'GV10004', N'Lý thuyết', N'Thứ tư', N'10 - 12', N'PH006', CAST(N'2021-01-16' AS Date), CAST(N'2021-05-16' AS Date))
INSERT [dbo].[CT_LopHocPhan] ([maLopHocPhan], [maGiangVien], [hinhThuc], [thu], [tietHoc], [maPhong], [ngayBatDau], [ngayKetThuc]) VALUES (N'LHP501', N'GV10004', N'Thực hành', N'Thứ tư', N'10 - 12', N'PH011', CAST(N'2021-01-16' AS Date), CAST(N'2021-05-16' AS Date))
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV001', N'Nguyễn Văn A', CAST(N'1970-01-01' AS Date), N'Nam', N'HCM', N'0123456789', N'KTPM')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV002', N'Trằn Thị B', CAST(N'1975-01-01' AS Date), N'Nữ', N'HCM', N'0123456321', N'KTPM')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10003', N'Bùi Văn Sĩ', CAST(N'1989-12-02' AS Date), N'Nam', N'111 Bùi Văn Sĩ, p15, Bình Thạnh, HCM', N'08571524', N'KTPM')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10004', N'Đỗ Duy Hưng', CAST(N'1990-10-20' AS Date), N'Nữ', N'34 Phan Văn Trị, p1, Gò Vấp, HCM', N'09541524', N'KTPM')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10005', N'Hồ Văn Huê', CAST(N'1975-01-02' AS Date), N'Nữ', N'1087 Lê Đức Thọ, p16,Gò Vấp , HCM', N'012456241', N'HTTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10006', N'Phạm Hoàng Kha', CAST(N'1969-06-02' AS Date), N'Nữ', N'32 Quang Trung, p12, Bình Tân, Bến Tre', N'096541524', N'CNTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10007', N'Trần Văn Linh', CAST(N'1989-12-12' AS Date), N'Nam', N'95 Nguyễn Ảnh Thủ, Quận 5, Hồ Chí Minh', N'0967542334', N'CNTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10008', N'Trần Thị Minh Khoa', CAST(N'1990-12-15' AS Date), N'Nữ', N'98 Lê Lợi, Liên Chiểu, Đà Nẵng', N'0986523365', N'CNTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10009', N'Võ Quang Hoàng Khang', CAST(N'1988-03-05' AS Date), N'Nam', N'73 Lê Lai, Gò Vấp, Hồ Chí Minh', N'0965446612', N'CNTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10010', N'Bùi Công Trường', CAST(N'1989-09-09' AS Date), N'Nam', N'77 Bà Triệu, Quận 8, Hồ Chí Minh', N'0943223471', N'CNTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10011', N'Phạm Thái Khanh', CAST(N'1990-12-15' AS Date), N'Nam', N'23 Trường Sa, Liên Chiểu, Đà Nẵng', N'098574323', N'HTTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10012', N'Nguyễn Thị Hạnh', CAST(N'1989-12-12' AS Date), N'Nữ', N'77 Lê Lợi, Biên Hòa, Đồng Nai', N'0965743212', N'HTTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10013', N'Nguyễn Như Hoa', CAST(N'1990-12-15' AS Date), N'Nữ', N'95 Nguyễn Ảnh Thủ, Quận 5, Hồ Chí Minh', N'0976589768', N'HTTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10014', N'Trần Văn Linh', CAST(N'1989-07-02' AS Date), N'Nam', N'88 Trường Chinh, Liên Chiểu, Đồng Nai', N'0567843221', N'HTTT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10015', N'Nguyễn Chí Kiên', CAST(N'1989-12-12' AS Date), N'Nam', N'77 Võ Văn Kiệt, Quận 8, Hồ Chí Minh', N'0967543234', N'KHMT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10016', N'Đặng Quang Vinh', CAST(N'1987-03-07' AS Date), N'Nam', N'45 Võ Văn Linh, Tân Phú, Hồ Chí Minh', N'0967624888', N'KHMT')
INSERT [dbo].[GiangVien] ([maGiangVien], [tenGiangVien], [ngaySinh], [gioiTinh], [diaChi], [soDIenThoai], [maChuyenNganh]) VALUES (N'GV10017', N'Nguyễn Thị Trúc Ly', CAST(N'1989-12-12' AS Date), N'Nữ', N'77 Trường Sa, Quận 8, Hồ Chí Minh', N'0987698643', N'KHMT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP001', N'Nhập môn lập trình', 1, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP002', N'Nhập môn tin học', 1, 2, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP003', N'Cấu trúc rời rạc', 2, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP004', N'Kỹ thuật lập trình', 2, 3, 1, N'HP001', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP005', N'Kỹ năng phát triển nghề nghiệp', 2, 2, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP006', N'Hệ thống máy tính', 2, 4, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP007', N'Lý thuyết đồ thị', 2, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP008', N'Cấu trúc dữ liệu và giải thuật', 1, 4, 1, N'HP001', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP009', N'Mạng máy tính', 1, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP010', N'Lập trình hướng đối tượng', 1, 4, 1, N'HP001', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP011', N'Những vấn đề xã hội và nghề nghiệp', 1, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP012', N'Quy hoạch tuyến tính', 1, 2, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP013', N'Phương pháp tính', 1, 2, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP014', N'Thống kê máy tính & ứng dụng', 2, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP015', N'Phân tích thiết kế hệ thống', 2, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP016', N'Hệ cơ sở dữ liệu', 2, 4, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP017', N'Hệ thống và công nghệ web', 2, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP018', N'Lập trình hướng sự kiện Java', 2, 4, 0, N'HP010', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP019', N'Lập trình hướng sự kiện .NET', 2, 4, 0, N'HP010', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP020', N'Nhập môn an toàn thông tin', 1, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP021', N'Công nghệ phần mềm', 1, 3, 1, N'HP010', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP022', N'Phát triển ứng dụng', 1, 4, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP023', N'Kiến trúc và cài đặt hệ quản trị CSDL', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP024', N'Hệ quản trị cơ sở dữ liệu', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP025', N'Trí tuệ nhân tạo', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP026', N'Lập trình phân tán Java', 1, 3, 0, N'HP018', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP027', N'Lập trình phân tán .NET', 1, 3, 0, N'HP019', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP028', N'Kiến trúc và thiết kế phần mềm', 2, 4, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP029', N'Đảm bảo chất lượng và kiểm thử phần mềm', 2, 4, 1, N'HP021', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP030', N'Kiến trúc hướng dịch vụ và điện toán đám mây', 2, 4, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP031', N'Lập trình WWW', 2, 4, 0, N'HP017', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP032', N'Xây dựng phần mềm', 1, 3, 1, N'HP021', N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP033', N'Công nghệ mới trong phát triển ứng dụng CNTT', 1, 3, 1, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP034', N'Tương tác người máy', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP035', N'Công nghệ thương mại điện tử', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP036', N'Quản lý dự án CNTT', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP037', N'Lập trình cho thiết bị di động', 1, 4, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP038', N'Phân tích thiết kế giải thuật', 1, 3, 0, NULL, N'CNTT')
INSERT [dbo].[HocPhan] ([maHocPhan], [tenMonHoc], [hocKy], [soTinChi], [batBuoc], [hocPhanYeuCau], [maKhoa]) VALUES (N'HP039', N'Quản lý vòng đời ứng dụng', 1, 4, 0, NULL, N'CNTT')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV001', N'HP001', N'LHP001', 10, 10, 10, 10, N'A')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV001', N'HP003', N'LHP006', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV001', N'HP004', N'LHP004', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13001', N'HP001', N'LHP001', 5, 5, 5, 5, N'C')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13002', N'HP001', N'LHP001', 3, 3, 3, 3, N'D')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13002', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13002', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13002', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13003', N'HP001', N'LHP001', 6, 6, 6, 6, N'C')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13003', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13003', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13003', N'HP007', N'LHP016', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13004', N'HP001', N'LHP001', 7, 7, 7, 7, N'B')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13004', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13004', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13004', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13004', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13005', N'HP001', N'LHP001', 8, 8, 8, 8, N'A')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13005', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13005', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13005', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13005', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13006', N'HP001', N'LHP001', 5, 5, 5, 5, N'C')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13006', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13006', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13006', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13006', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13007', N'HP001', N'LHP001', 7, 7, 7, 7, N'B')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13007', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13007', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13007', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13007', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13008', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13008', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13008', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13008', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13009', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13009', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13009', N'HP007', N'LHP016', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13010', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13010', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13010', N'HP007', N'LHP016', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13011', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13011', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13011', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13011', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13012', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13012', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13012', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13012', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13013', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13013', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13013', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13013', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13014', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13014', N'HP005', N'LHP014', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13014', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13014', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13015', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13015', N'HP005', N'LHP014', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13015', N'HP007', N'LHP016', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13016', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13016', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13016', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13016', N'HP007', N'LHP015', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13017', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13017', N'HP005', N'LHP013', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV13017', N'HP006', N'LHP007', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV999', N'HP001', N'LHP001', 9, 9, 9, 9, N'A')
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV999', N'HP003', N'LHP012', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[KetQuaHocTap] ([maSinhVien], [maHocPhan], [maLopHocPhan], [diemThuongKy], [diemGiuaKy], [diemCuoiKy], [diemTongKet], [xepLoai]) VALUES (N'SV999', N'HP004', N'LHP004', NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'CNTT', N'Công nghệ thông tin')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'KT-KT', N'Kế toán - Kiểm toán')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'KTXD', N'Kỹ thuật xây dựng')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'LLCT', N'Lý luận chính trị')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'NNA', N'Ngôn ngữ Anh')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'QTDVDL-LK', N'Quản trị dịch vụ du lịch và lữ hành')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'QTKD', N'Quản trị kinh doanh')
INSERT [dbo].[Khoa] ([maKhoa], [tenKhoa]) VALUES (N'TC-NH', N'Tài chính - Ngân hàng')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP001', N'Nhập môn lập trình', N'HP001', N'DHTH13A', 30, 18, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP002', N'Nhập môn lập trình', N'HP001', N'DHTH13B', 30, 0, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP003', N'Nhập môn tin học', N'HP002', N'DHTH13', 35, 25, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP004', N'Kỹ thuật lập trình', N'HP004', N'DHTH13A', 30, 1, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP005', N'Kỹ thuật lập trình', N'HP004', N'DHTH13B', 30, 1, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP006', N'Cấu trúc rời rạc', N'HP003', N'DHTH13', 1, 1, N'Chấp nhận mở lớp', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP007', N'Hệ thống máy tính', N'HP006', N'DHTH13', 45, 12, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP008', N'Mạng máy tính', N'HP009', N'DHTH13A', 30, 15, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP009', N'Mạng máy tính', N'HP009', N'DHTH13B', 30, 0, N'Chờ hủy lớp', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP010', N'Những vấn đề xã hội và nghề nghiệp', N'HP011', N'DHTH13', 30, 19, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP011', N'Quy hoạch tuyến tính', N'HP012', N'DHTH13A', 30, 30, N'Đã khóa', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP012', N'Cấu trúc rời rạc', N'HP003', N'DHTH13A', 30, 17, N'Chấp nhận mở lớp', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP013', N'Kỹ năng phát triển nghề nghiệp', N'HP005', N'DHTH13A', 30, 14, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP014', N'Kỹ năng phát triển nghề nghiệp', N'HP005', N'DHTH13B', 30, 2, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP015', N'Lý thuyết đồ thị', N'HP007', N'DHTH13A', 35, 10, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP016', N'Lý thuyết đồ thị', N'HP007', N'DHTH13B', 35, 4, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP017', N'Cấu trúc rời rạc', N'HP003', N'DHTH13B', 30, 0, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP500', N'Hệ cơ sở dữ liệu', N'HP016', N'DHKTPM13', 35, 0, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopHocPhan] ([maLopHocPhan], [tenLopHocPhan], [maHocPhan], [lopTinChi], [siSoToiDa], [siSoDangKy], [trangThai], [namHoc], [nguoiMoLop]) VALUES (N'LHP501', N'Hệ cơ sở dữ liệu', N'HP016', N'DHKTPM13A', 30, 0, N'Chờ đăng ký', N'2020 - 2021', N'NV999')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT13A', N'Đại học công nghệ thông tin 13A', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT13B', N'Công nghệ thông tin 13B', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT13C', N'Công nghệ thông tin 13C', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT14A', N'Công nghệ thông tin 14A', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT14B', N'Công nghệ thông tin 14B', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHCNTT14C', N'Công nghệ thông tin 14C', N'CNTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT13A', N'Hệ thống thông tin 13A', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT13B', N'Hệ thống thông tin 13B', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT13C', N'Hệ thống thông tin 13C', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT14A', N'Hệ thống thông tin 14A', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT14B', N'Hệ thống thông tin 14B', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHHTTT14C', N'Hệ thống thông tin 14C', N'HTTT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT13A', N'Khoa học máy tính 13A', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT13B', N'Khoa học máy tính 13B', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT13C', N'Khoa học máy tính 13C', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT14A', N'Khoa học máy tính 14A', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT14B', N'Khoa học máy tính 14B', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKHMT14C', N'Khoa học máy tính 14C', N'KHMT')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM13A', N'Đại học kỹ thuật phần mềm 13A', N'KTPM')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM13B', N'Đại học kỹ thuật phần mềm 13B', N'KTPM')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM13C', N'Kỹ thuật phần mềm 13C', N'KTPM')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM14A', N'Kỹ thuật phần mềm 14A', N'KTPM')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM14B', N'Kỹ thuật phần mềm 14B', N'KTPM')
INSERT [dbo].[LopSinhVien] ([maLop], [tenLop], [maChuyenNganh]) VALUES (N'DHKTPM14C', N'Kỹ thuật phần mềm 14C', N'KTPM')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10001', N'Lê Thị Lan', CAST(N'1989-10-20' AS Date), N'Nữ', N'20 Nguyễn Oanh, Gò Vấp', N'01234543212', N'NV10001')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10002', N'Hoàng Văn Tâm', CAST(N'1990-11-20' AS Date), N'Nam', N'54 Phan Văn Trị, Gò Vấp', N'09765437687', N'NV10002')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10003', N'Đặng Văn Tú', CAST(N'1989-11-23' AS Date), N'Nam', N'34 Lê Văn Khương, Quận 12', N'0983452687', N'NV10003')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10004', N'Bùi Phương Thảo', CAST(N'1990-11-12' AS Date), N'Nữ', N'23 Tân Thới Hiệp, Quận 3', N'09765437687', N'NV10004')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10005', N'Nguyễn Thanh Nhã', CAST(N'1988-05-03' AS Date), N'Nam', N'77 Lê Lợi, Gò Vấp', N'09765437687', N'NV10005')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10006', N'Nguyễn Việt Khải', CAST(N'1990-09-20' AS Date), N'Nam', N'54 Nguyễn Trãi, Quận 5', N'09765437687', N'NV10006')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10007', N'Nguyễn Ngọc Khánh Hà', CAST(N'1989-09-23' AS Date), N'Nữ', N'67 Lê Văn Khương, Quận 4', N'09765437687', N'NV10007')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10008', N'Nguyễn Thị Thanh Thư', CAST(N'1987-10-20' AS Date), N'Nữ', N'54 Phan Văn Trị, Gò Vấp', N'09765437687', N'NV10008')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10009', N'Nguyễn Hoàng Khang', CAST(N'1990-08-20' AS Date), N'Nam', N'66 Nguyễn Huệ, Quận 5', N'09765437687', N'NV10009')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV10010', N'Trần Thanh Đạt', CAST(N'1990-03-20' AS Date), N'Nam', N'22 Lê Lợi, Gò Vấp', N'09765437687', N'NV10010')
INSERT [dbo].[NhanVienPDT] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'NV999', N'Lục Gia Anh', CAST(N'1998-07-17' AS Date), N'Nam', N'HCM', N'0111444777', N'tester')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV001', CAST(N'2020-06-03' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13001', CAST(N'2020-06-16' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13002', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13003', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13004', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13005', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13006', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV13007', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP001', N'SV999', CAST(N'2020-06-01' AS Date), 1, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP004', N'SV999', CAST(N'2021-01-08' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP005', N'SV001', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP006', N'SV001', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13002', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13004', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13005', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13006', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13007', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13008', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13011', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13012', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13013', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13014', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13016', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP007', N'SV13017', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13002', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13003', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13004', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13005', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13006', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13007', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13008', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13009', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13010', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13011', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13012', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13013', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13014', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13015', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13016', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV13017', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP012', N'SV999', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13002', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13003', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13004', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13005', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13006', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13007', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13008', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13009', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13010', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13011', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13012', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13013', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13016', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP013', N'SV13017', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP014', N'SV13014', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP014', N'SV13015', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13004', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13005', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13006', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13007', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13008', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13011', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13012', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13013', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13014', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP015', N'SV13016', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP016', N'SV13003', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP016', N'SV13009', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP016', N'SV13010', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhieuDangKy] ([maLopHocPhan], [maSinhVien], [ngayDangKy], [hocKy], [namHoc]) VALUES (N'LHP016', N'SV13015', CAST(N'2021-01-07' AS Date), 2, N'2020 - 2021')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH001', N'A1.1', N'A', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH002', N'A1.2', N'A', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH003', N'A1.3', N'A', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH004', N'A1.4', N'A', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH005', N'B1.1', N'B', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH006', N'B1.2', N'B', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH007', N'B1.3', N'B', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH008', N'B1.4', N'B', N'Lý thuyết')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH009', N'C1.1', N'C', N'Thực hành')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH010', N'C1.2', N'C', N'Thực hành')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH011', N'C1.3', N'C', N'Thực hành')
INSERT [dbo].[PhongHoc] ([maPhong], [tenPhong], [dayNha], [loaiPhong]) VALUES (N'PH012', N'C1.4', N'C', N'Thực hành')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV001', N'Nguyễn Văn A', N'DHKTPM13A', CAST(N'1999-01-01' AS Date), N'Nam', N'HCM', N'0111444777', N'SV001')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13001', N'Đỗ Quyết Kiều Quang', N'DHKTPM13A', CAST(N'1996-05-25' AS Date), N'Nam', N'11 Đào Duy Từ, p1, Phú Nhuận, HCM', N'012452222', N'SV13001')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13002', N'Nguyễn Hữu Trí', N'DHKTPM13A', CAST(N'1996-05-15' AS Date), N'Nam', N'34 Phạm Văn Đồng, p21, Bình Chánh, HCM', N'065822566', N'SV13002')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13003', N'Trần Thanh Hiếu', N'DHKTPM13A', CAST(N'1996-11-25' AS Date), N'Nam', N'55 Phạm Đình Chính, p12, Bình Phước, Hooc Môn', N'012514524', N'SV13003')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13004', N'La Văn Lừa', N'DHKTPM13A', CAST(N'1997-12-05' AS Date), N'Nữ', N'324 Quang Trung, p12, Bình Tân, HCM', N'01632566', N'SV13004')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13005', N'Hồ Văn Hiếu', N'DHKHMT13A', CAST(N'1998-03-05' AS Date), N'Nam', N'324 Trần Thuật, p12, Phú Nhuận, HCM', N'03895241', N'SV13005')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13006', N'Dương Kiều Bá', N'DHKHMT13A', CAST(N'1998-12-05' AS Date), N'Nữ', N'111 Bùi Văn Sĩ, p15, Bình Thạnh, HCM', N'0124652466', N'SV13006')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13007', N'Phạm Thành Khoa', N'DHKHMT13A', CAST(N'1999-03-03' AS Date), N'Nam', N'34 Thích Bửu Đăng, p1, Gò Vấp, HCM', N'0965915401', N'SV13007')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13008', N'Nuyễn Thị Thu Trinh', N'DHKHMT13A', CAST(N'1999-11-15' AS Date), N'Nữ', N'1087 Lê Đức Thọ, p16,Gò Vấp , HCM', N'0124956324', N'SV13008')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13009', N'Lục Gia Anh', N'DHKTPM13A', CAST(N'1999-05-05' AS Date), N'Nam', N'34 Lê Lợi, p1, Gò Vấp, HCM', N'0124555666', N'SV13009')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13010', N'Nguyễn Phước Nguyên Ân', N'DHHTTT13C', CAST(N'1999-07-01' AS Date), N'Nam', N'34 Quang Trang, p17, Gò Vấp, HCM', N'015412666', N'SV13010')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13011', N'Võ Ngọc Thu Thủy', N'DHKTPM13A', CAST(N'1999-05-25' AS Date), N'Nữ', N'40 Nam Cao, Liên Chiểu, Đà Nẵng', N'0393456176', N'SV13011')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13012', N'Võ Ngọc Tú Oanh', N'DHKTPM13A', CAST(N'1999-06-26' AS Date), N'Nữ', N'35 Nguyễn Lương Bằng, Hòa Thắng, Buôn Ma Thuột', N'0393987176', N'SV13012')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13013', N'Nguyễn Quang Huy', N'DHKTPM13A', CAST(N'1999-08-17' AS Date), N'Nam', N'40 Bà Triệu, Tân Sơn,Đồng Nai', N'03934554768', N'SV13013')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13014', N'Nguyễn Thanh Hải', N'DHKTPM13A', CAST(N'1999-09-06' AS Date), N'Nam', N'128 Nguyễn Oanh, Thủ Đức, Hồ Chí Minh', N'0164357245', N'SV13014')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13015', N'Nguyễn Tấn Đạt', N'DHKTPM13A', CAST(N'1999-07-15' AS Date), N'Nam', N'376 Nguyễn Kiệm, Gò Vấp, Hồ Chí Minh', N'0986932567', N'SV13015')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13016', N'Trần Thanh Long', N'DHKTPM13B', CAST(N'1999-04-12' AS Date), N'Nam', N'12 Nguyễn Văn Bảo, Gò Vấp, Hồ Chí Minh', N'0938691236', N'SV13016')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13017', N'Trần Nhật Duy', N'DHKTPM13B', CAST(N'1999-09-08' AS Date), N'Nam', N'09 Nguyễn Thanh Bình, Tam Kỳ, Quảng Ngãi', N'0973285461', N'SV13017')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13018', N'Đặng Văn Luân', N'DHKTPM13B', CAST(N'1999-11-29' AS Date), N'Nam', N'56 Bà Triệu, Tân Bình, Hồ Chí Minh', N'0393456176', N'SV13018')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13019', N'Trần An An', N'DHKTPM13B', CAST(N'1999-11-02' AS Date), N'Nữ', N'75 Bà Triệu, Liên Chiểu, Đà Nẵng', N'0939561923', N'SV13019')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13020', N'Nguyễn Thị Quỳnh Anh', N'DHKTPM13C', CAST(N'1999-05-25' AS Date), N'Nữ', N'37 Nguyễn Thái Sơn, Quận 12, Hồ Chí Minh', N'0861239828', N'SV13020')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13021', N'Lương Thanh Nhất', N'DHHTTT13C', CAST(N'1999-07-01' AS Date), N'Nam', N'34 Nơ Trang Long, Phú Nhuận, Hồ Chí Minh', N'0986549832', N'SV13021')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13022', N'Võ Ngọc Diệu Thùy', N'DHHTTT13C', CAST(N'1999-07-12' AS Date), N'Nữ', N'309 Nguyễn Thanh Bình, Tam Kỳ, Quảng Ngãi', N'0973285461', N'SV13022')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13023', N'Huỳnh Huy Hoàng', N'DHHTTT13C', CAST(N'1999-04-05' AS Date), N'Nam', N'76 Nguyễn Kiệm, Gò Vấp, Hồ Chí Minh', N'0876538133', N'SV13023')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13024', N'Đặng Thị Loan', N'DHHTTT13C', CAST(N'1999-09-09' AS Date), N'Nữ', N'7 Bùi Văn Là, Quận 8, Hồ Chí Minh', N'0548276548', N'SV13024')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13025', N'Trần Nguyên Bình', N'DHHTTT13C', CAST(N'1999-04-05' AS Date), N'Nam', N'32 Lý Thường Kiệt, Tam Kỳ, Quảng Ngãi', N'0934528911', N'SV13025')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13026', N'Nguyễn Sơn Tàu', N'DHHTTT13C', CAST(N'1999-07-07' AS Date), N'Nam', N'76 Nguyễn Kiệm, Gò Vấp, Hồ Chí Minh', N'0975475264', N'SV13026')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13027', N'Huỳnh Chí Hùng', N'DHHTTT13C', CAST(N'1999-04-05' AS Date), N'Nam', N'84 Lê Văn Sỹ, Tân Phú, Hồ Chí Minh', N'0966435641', N'SV13027')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13028', N'Bùi Bảo Trân', N'DHHTTT13C', CAST(N'1999-09-14' AS Date), N'Nữ', N'876 Lê Thị Hồng, Thủ Đức, Hồ Chí Minh', N'0743543287', N'SV13028')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13029', N'Bùi Phương Thảo', N'DHHTTT13C', CAST(N'1999-04-12' AS Date), N'Nữ', N'76 Nguyễn Kiệm, Gò Vấp, Hồ Chí Minh', N'0876538133', N'SV13029')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13030', N'Nguyễn Ngọc Khánh Hà', N'DHHTTT13C', CAST(N'1999-04-05' AS Date), N'Nữ', N'76 Nguyễn Kiệm, Gò Vấp, Hồ Chí Minh', N'0538342724', N'SV13030')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13031', N'Nguyễn Thanh Thư', N'DHHTTT13A', CAST(N'1999-04-05' AS Date), N'Nữ', N'32 Nguyễn Lương Bằng, Quận 7, Hồ Chí Minh', N'0864325773', N'SV13031')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13032', N'Nguyễn Gia Hưng', N'DHHTTT13A', CAST(N'1999-03-02' AS Date), N'Nam', N'3 Nguyễn Văn Bảo, Gò Vấp, Hồ Chí Minh', N'0965428791', N'SV13032')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13033', N'Nguyễn Văn Nghĩa', N'DHHTTT13A', CAST(N'1999-04-05' AS Date), N'Nam', N'32 Nguyễn Lương Bằng, Hòa Thắng, Buôn Ma Thuột', N'0864325773', N'SV13033')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13034', N'Lê Thông', N'DHHTTT13A', CAST(N'1999-09-01' AS Date), N'Nam', N'09 Nguyễn Thanh Bình, Tam Kỳ, Quảng Ngãi', N'0965431871', N'SV13034')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13035', N'Nguyễn Thanh Nhã', N'DHHTTT13A', CAST(N'1999-07-02' AS Date), N'Nam', N'09 Nam Cao, Tam Kỳ, Quảng Ngãi', N'0471852791', N'SV13035')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13036', N'Đỗ Thúy Hà', N'DHCNTT13A', CAST(N'1999-07-02' AS Date), N'Nữ', N'7 Bùi Văn Là, Quận 8, Hồ Chí Minh', N'0876538133', N'SV13036')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13037', N'Nguyễn Trường Giang', N'DHCNTT13A', CAST(N'1999-09-09' AS Date), N'Nam', N'08 Trường Chinh, Phú Nhuận, Hồ Chí Minh', N'0912376419', N'SV13037')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13038', N'Nguyễn Minh Hảo', N'DHCNTT13A', CAST(N'1999-07-17' AS Date), N'Nam', N'09 Lê Trọng Tấn, Tân Phú, Hồ Chí Minh', N'0876538133', N'SV13038')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13039', N'Nguyễn Hoàng Hữu', N'DHCNTT13A', CAST(N'1999-09-13' AS Date), N'Nam', N'567 Nguyễn Trãi, Quận 3, Hồ Chí Minh', N'0721386265', N'SV13039')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV13040', N'Nguyễn Quang Linh', N'DHCNTT13A', CAST(N'1999-07-20' AS Date), N'Nam', N'72 Hồng Bàng, Quận 3, Hồ Chí Minh', N'0654256309', N'SV13040')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14001', N'Hồ Kim Quế', N'DHHTTT13C', CAST(N'1998-09-05' AS Date), N'Nữ', N'34 Phan Văn Trị, p1, Gò Vấp, HCM', N'0965874666', N'SV14001')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14002', N'Đố Văn Nhớ', N'DHHTTT13C', CAST(N'1999-07-05' AS Date), N'Nữ', N'32 Quang Trung, p12, Bình Tân, Bến Tre', N'01632566', N'SV14002')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14003', N'Đặng Thị Hà Thu', N'DHHTTT14C', CAST(N'1997-12-05' AS Date), N'Nữ', N'34 Phạm Văn Đồng, p1, Bình Tân, HCM', N'01632566', N'SV14003')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14004', N'Nguyễn Thị Hoàng Khánh', N'DHHTTT14C', CAST(N'2000-01-01' AS Date), N'Nữ', N'24 Phạm Văn Bảo, p1, Gò Vấp, HCM', N'016352566', N'SV14004')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14005', N'Lê Minh Nhật', N'DHKTPM14B', CAST(N'2000-06-21' AS Date), N'Nam', N'35 Lê Trọng Tấn, Quận 5, Hồ Chí Minh', N'0542146833', N'SV14005')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14006', N'Trần Duy Mạnh', N'DHHTTT14B', CAST(N'2000-03-18' AS Date), N'Nam', N'95 Nguyễn Ảnh Thủ, Quận 5, Hồ Chí Minh', N'0956533427', N'SV14006')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14007', N'Hứa Minh Đạt', N'DHHTTT14B', CAST(N'2000-09-03' AS Date), N'Nam', N'72 Võ Văn Kiệt, Quận 7, Hồ Chí Minh', N'0953824511', N'SV14007')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14008', N'Lâm Vỹ Dạ', N'DHHTTT14B', CAST(N'2000-02-02' AS Date), N'Nữ', N'85 Nguyễn Văn Linh, Liên Chiểu, Đà Đẵng', N'0542865488', N'SV14008')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14009', N'Ninh Dương Lan Ngọc', N'DHHTTT14A', CAST(N'2000-07-15' AS Date), N'Nữ', N'23 Bà Triệu, Quận 3, Hồ Chí Minh', N'0945321933', N'SV14009')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14010', N'Ngô Kiến Huy', N'DHHTTT14A', CAST(N'2000-07-06' AS Date), N'Nam', N'6546 Võ Văn Linh, Liên Chiểu, Đà Nẵng', N'0957643578', N'SV14010')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14011', N'Ngô Chí Kiên', N'DHCNTT14A', CAST(N'2000-09-03' AS Date), N'Nam', N'88 Trường Sa, Quận 5, Hồ Chí Minh', N'0953824511', N'SV14011')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV14012', N'Ngô Thừa Hân', N'DHCNTT14A', CAST(N'2000-03-20' AS Date), N'Nữ', N'77 Tân Cương, Quận 4, Hồ Chí Minh', N'0954225324', N'SV14012')
INSERT [dbo].[SinhVien] ([maSinhVien], [tenSinhVien], [maLop], [ngaySinh], [gioiTinh], [diaChi], [soDienThoai], [tenDangNhap]) VALUES (N'SV999', N'Lục Gia Anh', N'DHKTPM13A', CAST(N'1998-07-17' AS Date), N'Nam', N'HCM', N'0123456789', N'tester')
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'admin', N'1', 1)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10001', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10002', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10003', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10004', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10005', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10006', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10007', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10008', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10009', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'NV10010', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV001', N'1', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV002', N'1', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13001', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13002', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13003', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13004', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13005', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13006', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13007', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13008', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13009', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13010', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13011', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13012', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13013', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13014', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13015', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13016', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13017', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13018', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13019', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13020', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13021', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13022', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13023', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13024', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13025', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13026', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13027', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13028', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13029', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13030', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13031', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13032', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13033', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13034', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13035', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13036', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13037', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13038', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13039', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV13040', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14001', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14002', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14003', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14004', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14005', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14006', N'333', 3)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14007', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14008', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14009', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14010', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14011', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'SV14012', N'333', 2)
INSERT [dbo].[TaiKhoan] ([tenDangNhap], [matKhau], [loaiTaiKhoan]) VALUES (N'tester', N'1', 0)
ALTER TABLE [dbo].[ChuyenNganh]  WITH CHECK ADD  CONSTRAINT [FK_ChuyenNganh_Khoa] FOREIGN KEY([maKhoa])
REFERENCES [dbo].[Khoa] ([maKhoa])
GO
ALTER TABLE [dbo].[ChuyenNganh] CHECK CONSTRAINT [FK_ChuyenNganh_Khoa]
GO
ALTER TABLE [dbo].[CT_LopHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_CT_LopHocPhan_GiangVien] FOREIGN KEY([maGiangVien])
REFERENCES [dbo].[GiangVien] ([maGiangVien])
GO
ALTER TABLE [dbo].[CT_LopHocPhan] CHECK CONSTRAINT [FK_CT_LopHocPhan_GiangVien]
GO
ALTER TABLE [dbo].[CT_LopHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_CT_LopHocPhan_LopHocPhan] FOREIGN KEY([maLopHocPhan])
REFERENCES [dbo].[LopHocPhan] ([maLopHocPhan])
GO
ALTER TABLE [dbo].[CT_LopHocPhan] CHECK CONSTRAINT [FK_CT_LopHocPhan_LopHocPhan]
GO
ALTER TABLE [dbo].[CT_LopHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_CT_LopHocPhan_PhongHoc] FOREIGN KEY([maPhong])
REFERENCES [dbo].[PhongHoc] ([maPhong])
GO
ALTER TABLE [dbo].[CT_LopHocPhan] CHECK CONSTRAINT [FK_CT_LopHocPhan_PhongHoc]
GO
ALTER TABLE [dbo].[GiangVien]  WITH CHECK ADD  CONSTRAINT [FK_GiangVien_ChuyenNganh] FOREIGN KEY([maChuyenNganh])
REFERENCES [dbo].[ChuyenNganh] ([maChuyenNganh])
GO
ALTER TABLE [dbo].[GiangVien] CHECK CONSTRAINT [FK_GiangVien_ChuyenNganh]
GO
ALTER TABLE [dbo].[HocPhan]  WITH CHECK ADD  CONSTRAINT [FK_HocPhan_Khoa] FOREIGN KEY([maKhoa])
REFERENCES [dbo].[Khoa] ([maKhoa])
GO
ALTER TABLE [dbo].[HocPhan] CHECK CONSTRAINT [FK_HocPhan_Khoa]
GO
ALTER TABLE [dbo].[KetQuaHocTap]  WITH CHECK ADD  CONSTRAINT [FK_KetQuaHocTap_HocPhan] FOREIGN KEY([maHocPhan])
REFERENCES [dbo].[HocPhan] ([maHocPhan])
GO
ALTER TABLE [dbo].[KetQuaHocTap] CHECK CONSTRAINT [FK_KetQuaHocTap_HocPhan]
GO
ALTER TABLE [dbo].[KetQuaHocTap]  WITH CHECK ADD  CONSTRAINT [FK_KetQuaHocTap_LopHocPhan] FOREIGN KEY([maLopHocPhan])
REFERENCES [dbo].[LopHocPhan] ([maLopHocPhan])
GO
ALTER TABLE [dbo].[KetQuaHocTap] CHECK CONSTRAINT [FK_KetQuaHocTap_LopHocPhan]
GO
ALTER TABLE [dbo].[KetQuaHocTap]  WITH CHECK ADD  CONSTRAINT [FK_KetQuaHocTap_SinhVien] FOREIGN KEY([maSinhVien])
REFERENCES [dbo].[SinhVien] ([maSinhVien])
GO
ALTER TABLE [dbo].[KetQuaHocTap] CHECK CONSTRAINT [FK_KetQuaHocTap_SinhVien]
GO
ALTER TABLE [dbo].[LopHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_LopHocPhan_HocPhan] FOREIGN KEY([maHocPhan])
REFERENCES [dbo].[HocPhan] ([maHocPhan])
GO
ALTER TABLE [dbo].[LopHocPhan] CHECK CONSTRAINT [FK_LopHocPhan_HocPhan]
GO
ALTER TABLE [dbo].[LopHocPhan]  WITH CHECK ADD  CONSTRAINT [FK_LopHocPhan_NhanVienPDT] FOREIGN KEY([nguoiMoLop])
REFERENCES [dbo].[NhanVienPDT] ([maNhanVien])
GO
ALTER TABLE [dbo].[LopHocPhan] CHECK CONSTRAINT [FK_LopHocPhan_NhanVienPDT]
GO
ALTER TABLE [dbo].[LopSinhVien]  WITH CHECK ADD  CONSTRAINT [FK_LopSinhVien_ChuyenNganh] FOREIGN KEY([maChuyenNganh])
REFERENCES [dbo].[ChuyenNganh] ([maChuyenNganh])
GO
ALTER TABLE [dbo].[LopSinhVien] CHECK CONSTRAINT [FK_LopSinhVien_ChuyenNganh]
GO
ALTER TABLE [dbo].[NhanVienPDT]  WITH CHECK ADD  CONSTRAINT [FK_NhanVienPDT_TaiKhoan] FOREIGN KEY([tenDangNhap])
REFERENCES [dbo].[TaiKhoan] ([tenDangNhap])
GO
ALTER TABLE [dbo].[NhanVienPDT] CHECK CONSTRAINT [FK_NhanVienPDT_TaiKhoan]
GO
ALTER TABLE [dbo].[PhieuDangKy]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDangKy_LopHocPhan] FOREIGN KEY([maLopHocPhan])
REFERENCES [dbo].[LopHocPhan] ([maLopHocPhan])
GO
ALTER TABLE [dbo].[PhieuDangKy] CHECK CONSTRAINT [FK_PhieuDangKy_LopHocPhan]
GO
ALTER TABLE [dbo].[PhieuDangKy]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDangKy_SinhVien] FOREIGN KEY([maSinhVien])
REFERENCES [dbo].[SinhVien] ([maSinhVien])
GO
ALTER TABLE [dbo].[PhieuDangKy] CHECK CONSTRAINT [FK_PhieuDangKy_SinhVien]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_LopSinhVien] FOREIGN KEY([maLop])
REFERENCES [dbo].[LopSinhVien] ([maLop])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_LopSinhVien]
GO
ALTER TABLE [dbo].[SinhVien]  WITH CHECK ADD  CONSTRAINT [FK_SinhVien_TaiKhoan] FOREIGN KEY([tenDangNhap])
REFERENCES [dbo].[TaiKhoan] ([tenDangNhap])
GO
ALTER TABLE [dbo].[SinhVien] CHECK CONSTRAINT [FK_SinhVien_TaiKhoan]
GO
USE [master]
GO
ALTER DATABASE [QuanLyDKHP3] SET  READ_WRITE 
GO
