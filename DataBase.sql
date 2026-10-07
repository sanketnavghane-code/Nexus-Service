show databases;
create database dbprojectdata;

create table dbprojectdata.tblCountry(CountryID int not null primary key auto_increment,CountryName varchar(50));
select * from dbprojectdata.tblCountry;

create table dbprojectdata.tblState(StateID int not null primary key auto_increment,StateName varchar(50), CountryID int, foreign key(CountryID) references dbprojectdata.tblCountry(CountryID));
select * from dbprojectdata.tblState;

create table dbprojectdata.tblDistrict(DistrictID int not null primary key auto_increment,DistrictName varchar(50),StateID int,foreign key(StateID) references dbprojectdata.tblState(StateID));
select * from dbprojectdata.tblDistrict;
describe dbprojectdata.tblDistrict;

create table dbprojectdata.tblTaluka(TalukaID int not null primary key auto_increment,TalukaName varchar(50),DistrictID int,foreign key(DistrictID) references dbprojectdata.tblDistrict(DistrictID));
select * from dbprojectdata.tblTaluka;

create table dbprojectdata.tblVillage(VillageID int not null primary key auto_increment,VillageName varchar(50),TalukaID int,foreign key(TalukaID) references dbprojectdata.tblTaluka(TalukaID));
select * from dbprojectdata.tblVillage;

SET FOREIGN_KEY_CHECKS = 0;
update dbprojectdata.tblState set CountryID=1 where StateID=5;
SET FOREIGN_KEY_CHECKS = 1;
