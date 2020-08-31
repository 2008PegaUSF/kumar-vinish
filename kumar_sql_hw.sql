-- 1. SQL Queries
--- 1.1 Select
---- selects EmployeeId, LastName, and Email from Employee Table when employee's last name is King
select "EmployeeId", "LastName", "Email" 
from "Employee" 
where "LastName" = 'King';

---- selects City and State from Employee table when employee's first name is Andrew and the ReportsTo value is null
select "City", "State" 
from "Employee" 
where "FirstName" = 'Andrew' and "ReportsTo" is null;

--- 1.2 Sub-queries: Select in a Select
---- selects all records from Album table, second select statement used to specify only records where composer is AC/DC using ArtistId table due to ArtistId being used as foreign key for Album table
select * from "Album" 
where "ArtistId" 
in (select "ArtistId" 
	from "Artist" 
	where "Name" = 'AC/DC');

--- 1.3 Order by 
---- selects Title from album table and sorts in descending alphabetical order (Z-A)
select "Title" 
from "Album" 
order by "Title" desc;

---- selects FirstName from customer table and sorts in ascending alphabetical order (A-Z) by City
select "FirstName" 
from "Customer" 
order by "City" asc;

--- 1.6 Like
---- selects all records from Invoice table where billing address starts with T
select * from "Invoice" 
where "BillingAddress" 
like 'T%';

--- 1.7 Between
---- selects all records from Invoice table where Total value is between 15 and 50
select * from "Invoice" 
where "Total" 
between 15 and 50;

---- selects all records from employee table for employees hired between 6/1/2003 and 3/1/2004
select * from "Employee" 
where "HireDate" 
between '2003-06-01 00:00:00' and '2004-03-01 00:00:00';

-- 2 DML Statements
--- 2.1 Insert into
---- inserts Potato Music genre into Genre table with GenreId 26
insert into "Genre" 
values (26, 'Potato Music');
---- inserts French Fry genre into Genre table with GenreId 27
insert into "Genre" 
values (27, 'French Fry Music');

---- inserts new employee Vinish Kumar into Employee table with EmployeeId 9
insert into "Employee" 
values (9, 'Kumar', 'Vinish', 'IT Staff', 5, '1998-06-12 00:00:00', '2020-08-29 00:00:00', '123 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (123) 456-7890', '+1 (098) 765-4321', 'sample@email.com');
---- inserts new employee Adam Bloom into Employee table with EmployeeId 10
insert into "Employee" 
values (10, 'Bloom', 'Adam', 'IT Staff', 5, '1998-09-18 00:00:00', '2020-09-18 00:00:00', '321 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (321) 654-0987', '+1 (890) 567-1234', 'sample2@email.com');

---- inserts new customer Vinish Kumar into Customer table with CustomerId 60
insert into "Customer" 
values (60, 'Kumar', 'Vinish', 'Revature', '123 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (123) 456-7890', '+1 (098) 765-4321', 'sample@email.com', 4);
---- inserts new customer Adam Bloom into Customer table with CustomerId 61
insert into "Customer" 
values (61, 'Bloom', 'Adam', 'Revature', '321 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (321) 654-0987', '+1 (890) 567-1234', 'sample2@email.com', 4);

--- 2.2 Update
---- updates customer with name Aaron Mitchell in Customer table and changes name to Robert Walter
update "Customer" 
set "FirstName" = 'Robert', "LastName" = 'Walter' 
where "FirstName" = 'Aaron' and "LastName" = 'Mitchell';

---- updates artist with name Creedence Clearwater Revival in Artist table and changes name to CCR
update "Artist" 
set "Name" = 'CCR' 
where "Name" = 'Creedence Clearwater Revival';

--- 2.3 Delete
---- drops foreign key constraint from Invoice table to allow for customers to be deleted from Customer table, constraint formerly would not allow customers to be removed
alter table "Invoice" 
drop constraint "FK_InvoiceCustomerId";
---- deletes customer with name Robert Walter from Customer table
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';
---- foreign key constraint added back manually after deletion

-- 3. sql functions
--- 3.1 system defined functions
---- selects and displays current time
select current_time;

---- selects and displays length of names from MediaType table
select length("Name") from "MediaType";

--- 3.2 system defined aggregate functions
---- prints average of all values from Total column in Invoice table
select avg("Total") from "Invoice";

---- prints largest value from UnitPrice column in Track Table
select max("UnitPrice") from "Track";

--- 3.3 user defined functions
---- creates function to return average price of items from InvoiceLine table
create or replace function avg_invoiceline()
	returns decimal as $$
	select avg("UnitPrice") from "InvoiceLine";
$$ language sql;
select avg_invoiceline();

---- creates function to return first name and last name of all employees with BirthDate after 12/31/1968 using alphabetical sorting of birth date values, out statements in parentheses specify which column values to print from Employee table
create or replace function employee_born_after_1968(out FirstName text, out LastName text)
	returns setof record as $$
	select "FirstName", "LastName" from "Employee" where "BirthDate" > '1968-12-31 00:00:00';
$$ language sql;
select * from employee_born_after_1968();

-- 4. triggers
--- 4.1 after insert trigger
---- creates trigger that occurs after new employee record is inserted into Employee table that sets employee's phone number 867-5309
create or replace function number_after_insert()
	returns trigger as $$
	begin
		update "Employee" 
		set "Phone" = '867-5309'
		where "EmployeeId" = new."EmployeeId";
		return new;
	end;
$$ language plpgsql;

create trigger insert_employee
after insert on "Employee"
for each row 
execute function number_after_insert();

insert into "Employee" 
values (11, 'Ingle', 'Ike', 'IT Staff', 5, '1998-09-18 00:00:00', '2020-09-18 00:00:00', '321 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (321) 654-0987', '+1 (890) 567-1234', 'sample2@email.com');

---- creates trigger that occurs before insert and sets company value to Revature in customer table
create or replace function company_before_insert()
	returns trigger as $$
	begin
		if(TG_OP = 'INSERT') then
			new."Company" = 'Revature';
		end if;
	return new;
	end;
$$ language plpgsql

create trigger insert_customer
before insert on "Customer"
for each row
execute function company_before_insert();

insert into "Customer" 
values (62, 'Ingle', 'Ike', 'NotRevature', '321 Potato Place', 'French Fry City', 'PO', 'Mashed States of Potato', '12345', '+1 (321) 654-0987', '+1 (890) 567-1234', 'sample2@email.com', 4);

-- 5. Joins
--- 5.1 inner
---- inner join that prints table of first names and invoice ids from records found in both Customer table and Invoice table
select "FirstName", "InvoiceId" from "Customer" c 
inner join "Invoice" i 
on c."CustomerId" = i."CustomerId";

---- full outer join that combines all records from Customer table and Invoice table regardless of overlap and prints full name, invoice id, and total
select "FirstName", "LastName", "InvoiceId", "Total" from "Customer" c 
full join "Invoice" i 
on c."CustomerId" = i."CustomerId";

---- right join that prints all records from Artist and matching records from Album, printing out artist name and title
select "Name", "Title" from "Album" a 
right join "Artist" a2 
on a."ArtistId" = a2."ArtistId";

---- cross join that combines records from Album table and Artist table and sorts in ascending order by artist name
select * from "Album" 
cross join "Artist"
order by "Name";

---- self join on Employee table that matches employees by ReportsTo value
select e."FirstName", e."LastName", e."ReportsTo", e."Title", e2."FirstName", e2."LastName", e2."Title"
from "Employee" as e 
join "Employee" as e2 
on e."ReportsTo" = e2."EmployeeId";

-- 6. set operations
--- 6.1 union
---- union query to find unique records of full name and phone number for all customers and employees
select "LastName", "FirstName", "Phone" from "Customer"
union
select "LastName", "FirstName", "Phone" from "Employee";

---- except all query to find all records of city, state, and postal code from Customer and Employee tables, except all ensures that duplicates are not repeated in return
select "City", "State", "PostalCode" from "Customer"
except all
select "City", "State", "PostalCode" from "Employee";