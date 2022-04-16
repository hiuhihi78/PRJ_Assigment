select  orderID, customerID,t.name ,date, amout, paid, t.username,t.displayname 
from (
     select ROW_NUMBER() over (order by orderID asc) as number,*
     from Orders join Customer on Orders.customerID = Customer.personID
     join Person on Person.id = Customer.personID
     join Account on Account.username = Orders.seller
     )t
--where (1=1)
where (1=1)
and  t.number >= ((? - 1) * ?) + 1 and t.number <= ? * ?
--and t.orderID = 37
--and t.customerID = ?
--nd t.name like '%Hieu%' 
--and t.date > ? 
--and t.date <= ?
--and t.username like '%?%'

select count(*)
from Orders

select * from Orders join Customer on Orders.customerID = Customer.personID join Person on Person.id = Customer.personID
where Person.name like '%%'

select	*
from Orders join Customer on Customer.personID = Orders.customerID
			join Person on Person.id = Customer.personID
			join Order_Product on Orders.orderID = Order_Product.orderID
			 left join Product on Order_Product.productID = Product.id
where Orders.orderID = 30


select Orders.orderID, Person.id, Person.name, Orders.date, Orders.seller, Orders.paid, Orders.amout,
Product.name, Order_Product.quantity, Order_Product.discount,Order_Product.sellprice
from Orders join Customer on Customer.personID = Orders.customerID
			join Person on Person.id = Customer.personID
			join Order_Product on Orders.orderID = Order_Product.orderID
			 left join Product on Order_Product.productID = Product.id
where Orders.orderID = ?