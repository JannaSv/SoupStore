delete from Ingredient_Ref;
delete from Soup;
delete from Soup_Order;


delete from Ingredient;
insert into Ingredient (id, name, type)
			values ('CH', 'курица', 'MEAT');
insert into Ingredient (id, name, type)
			values ('PR', 'свинина', 'MEAT');
insert into Ingredient (id, name, type)
			values ('PT', 'картофель', 'VEGGIES');
insert into Ingredient (id, name, type)
			values ('CB', 'капуста', 'VEGGIES');
insert into Ingredient (id, name, type)
			values ('CR', 'морковь', 'VEGGIES');
insert into Ingredient (id, name, type)
			values ('ND', 'вермишель', 'CEREAL');
insert into Ingredient (id, name, type)
			values ('RC', 'рис', 'CEREAL');
insert into Ingredient (id, name, type)
			values ('SC', 'сметана', 'SAUCE');
insert into Ingredient (id, name, type)
			values ('TM', 'томатный соус', 'SAUCE');
insert into Ingredient (id, name, type)
			values ('CL', 'чили', 'SPICE');

			