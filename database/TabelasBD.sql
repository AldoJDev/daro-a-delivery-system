CREATE TABLE Warehouse (
    id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    name NVARCHAR(MAX) NOT NULL,
    city NVARCHAR(MAX) NOT NULL,
    state NVARCHAR(MAX) NOT NULL,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL
);

CREATE TABLE Driver (
    id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    warehouse_id UNIQUEIDENTIFIER NULL, -- Alteração aqui
    name NVARCHAR(MAX) NOT NULL,
    shift_start TIME  NOT NULL,
    shift_end TIME  NOT NULL,
    break_start TIME  NOT NULL,
    break_end TIME  NOT NULL,
    speed FLOAT NOT NULL,
    CONSTRAINT FK_Driver_Warehouse FOREIGN KEY (warehouse_id) REFERENCES Warehouse (id)
);

CREATE TABLE Customer (
    id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    name NVARCHAR(MAX) NOT NULL,
    city NVARCHAR(MAX) NOT NULL,
    state NVARCHAR(MAX) NOT NULL,
    latitude FLOAT NOT NULL,
    longitude FLOAT NOT NULL
);

CREATE TABLE Analyst (  /*Usuario*/
	id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY, 
	username NVARCHAR(10) NOT NULL,
	password NVARCHAR(8) NOT NULL,
)

CREATE TABLE Orders (
    id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    warehouse_id UNIQUEIDENTIFIER NOT NULL,
    customer_id UNIQUEIDENTIFIER NOT NULL,
    created_at DATETIME2 NOT NULL, --O tipo DATETIME2 � capaz de armazenar data e hora completas
    estimated_delivery_date DATETIME2 NOT NULL, --O tipo DATETIME2 � capaz de armazenar data e hora completas
    status NVARCHAR(MAX) NOT NULL,
    CONSTRAINT FK_Orders_Warehouse FOREIGN KEY (warehouse_id) REFERENCES Warehouse (id),
    CONSTRAINT FK_Orders_Customer FOREIGN KEY (customer_id) REFERENCES Customer (id)
);

USE [BD23121]
GO

/****** Object:  Table [dbo].[Route]    Script Date: 14/06/2024 10:11:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Route](
	[id] [uniqueidentifier] NOT NULL,
	[date_now] [date] NULL,
	[latitude] [float] NULL,
	[longitude] [float] NULL,
	[order_route] [int] NULL,
	[driver_id] [uniqueidentifier] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Route]  WITH CHECK ADD  CONSTRAINT [FK_RouteDriver] FOREIGN KEY([driver_id])
REFERENCES [dbo].[Driver] ([id])
GO

ALTER TABLE [dbo].[Route] CHECK CONSTRAINT [FK_RouteDriver]
GO





SELECT * FROM Warehouse
SELECT * FROM Driver
SELECT * FROM Orders
SELECT * FROM Customer
SELECT * FROM Route